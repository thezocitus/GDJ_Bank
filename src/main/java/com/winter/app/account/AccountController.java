package com.winter.app.account;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.board.BoardDTO;
import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;
import com.winter.app.product.ProductService;
import com.winter.app.util.Pager;


@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private ProductService productService;
	
	
	
	
	@GetMapping("list")
	public void getList(AccountDTO accountDTO, Model model, HttpSession session) {
	
	MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
	accountDTO.setUserName(memberDTO.getUserName());	
	List<AccountDTO> ar = accountService.getList(accountDTO);
	
	model.addAttribute("list", ar);
	
	}

//	ADD
	@GetMapping("add")
	public String addAccount(ProductDTO productDTO, Model model) {
		
		productDTO = productService.detail(productDTO);
		
		model.addAttribute("dto",productDTO);
		return "/account/add";
	}
	@PostMapping("add")
	public String addAccount(AccountDTO accountDTO, ProductDTO productDTO, HttpSession session, Model model) {
				
		productDTO = productService.detail(productDTO);
		accountDTO.setProductNum(productDTO.getProductNum());		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		accountDTO.setUserName(memberDTO.getUserName());
		
		int result = accountService.addAccount(accountDTO);
					
		String msg = "계좌개설에 실패하였습니다.";
		if(result>0) {
			
			msg="계좌가 개설되었습니다";
					
		}		
		
		model.addAttribute("msg",msg);
		model.addAttribute("path","/");
		
		return "commons/result";
		
	}
	
	
	
	
}
