package com.winter.app.product;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.member.MemberDTO;
import com.winter.app.util.Pager;



@Controller
@RequestMapping("/reply/*")
public class ReplyControllor {
	
	@Autowired
	private ReplyService replyService;
	
	
	@PostMapping("add")
	public String setReply(ReplyDTO replyDTO,ProductDTO productDTO, HttpSession session,Pager pager,Model model) throws Exception{
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		System.out.println(memberDTO.getUserName());
		int result = replyService.setReply(replyDTO);
		
		
		List<ReplyDTO> arReply = replyService.getList(pager,productDTO);
		model.addAttribute("path","./list");
		model.addAttribute("replyList", arReply);
		
		
		return "product/ajaxReply";
	}
	

	@GetMapping("list")
	public String getList(ProductDTO productDTO, Model model, Pager pager) throws Exception{
		
		List<ReplyDTO> ar = replyService.getList(pager,productDTO);
		model.addAttribute("replyList", ar);
		
		return "product/ajaxReply";
		
	}
	

}
