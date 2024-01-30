package com.winter.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.winter.app.member.MemberDTO;
import com.winter.app.util.Pager;



//@Controller
@RestController
@RequestMapping("/reply/*")
public class ReplyControllor {
	
	@Autowired
	private ReplyService replyService;
	
	
	
	@PostMapping("update")
	@ResponseBody
	public int setUpdate(ReplyDTO replyDTO) throws Exception{
		
		System.out.println(replyDTO.getReplyContents());
		
		int result = replyService.setUpdate(replyDTO);
		
		return result;
	}
	
	@PostMapping("delete")
	public Map<String, Object> setDelete(Pager pager, ReplyDTO replyDTO, ProductDTO productDTO) throws Exception{
		
		replyService.setDelete(replyDTO);
		List<ReplyDTO> arReply = replyService.getList(pager, productDTO);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pager", pager);
		map.put("datas", arReply);
		
		return map;
		
	}
	
	
	
	
	@PostMapping("add")
	@ResponseBody
	public Map<String, Object> setReply(ReplyDTO replyDTO,ProductDTO productDTO, HttpSession session,Pager pager,Model model) throws Exception{
		MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
		replyDTO.setUserName(memberDTO.getUserName());
		System.out.println(memberDTO.getUserName());
		int result = replyService.setReply(replyDTO);
		
		
		List<ReplyDTO> arReply = replyService.getList(pager,productDTO);
//		model.addAttribute("path","./list");
//		model.addAttribute("replyList", arReply);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("datas", arReply);
		map.put("pager", pager);
		
		return map;
	}
	

	@GetMapping("list")
	@ResponseBody
	public Map<String, Object> getList(ProductDTO productDTO, Model model, Pager pager) throws Exception{
		
		List<ReplyDTO> ar = replyService.getList(pager,productDTO);
//		model.addAttribute("replyList", ar);
//		model.addAttribute("pager", pager);
		
//		Map<(String, Object> map = new HashMap<K, V>()
		
		
//		model.addAttribute("list", ar);
//		model.addAttribute("pager", pager);	
		// [
		//  {"userName":"???", "contents:???", "date":???},
		//  {"userName":"???", "contents:???", "date":???},
		//  {"userName":"???", "contents:???", "date":???},		//]
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("datas", ar);
		map.put("pager", pager);
		
		return map;

		
	}
	

}
