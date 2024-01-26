package com.winter.app.wishlist;


import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.account.AccountDTO;
import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;
import com.winter.app.util.Pager;



@Controller
@RequestMapping("/wishlist/*")
public class WishListController {

	
	@Autowired
	private WishListService wishListService;
	
//	public void test(HttpServletRequest request, Long productNum,AccountDTO accountDTO) {
//		String n = request.getParameter("productNum");
//	}
//	
	@GetMapping("add")
	public String addWishList(AccountDTO accountDTO, HttpSession session,Model model) {
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
				
		accountDTO.setUserName(memberDTO.getUserName());		
		int result = wishListService.addWishList(accountDTO);
				
		model.addAttribute("result",result);
		
		
		
		return "commons/ajaxResult";
				
	}
	
	@GetMapping("list")
	public void getList(MemberDTO memberDTO, HttpSession session, Model model, Pager pager) {
		
		memberDTO = (MemberDTO)session.getAttribute("member");
		List<ProductDTO> ar = wishListService.getList(pager,memberDTO);
		System.out.println(ar.size());
		model.addAttribute("list", ar);
		
	}
	
	@PostMapping("delete")
	public String setDelete(Long [] productNum, HttpSession session, Model model) {
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
		
		int result = wishListService.setDelete(productNum, memberDTO);
	
		
		model.addAttribute("result", result);
		
		return "commons/ajaxResult";
	}
	
}
