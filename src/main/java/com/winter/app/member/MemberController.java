package com.winter.app.member;


import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.account.AccountDTO;

import oracle.jdbc.proxy.annotation.Post;



@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	
	
	
	
	
	@GetMapping("idCheck")
	public String getIdCheck(MemberDTO memberDTO, Model model) throws Exception {
	 	memberDTO = memberService.getDetail(memberDTO);	 
	 
	 	int result=0;
	 	if(memberDTO == null) {
	 		result = 1;
	 	}
	 	
	 	model.addAttribute("result", result);
	 	
		return "commons/ajaxResult";
	}
	
	
	//Join
	
	@GetMapping("join")
	public String join() {		
		return "member/join";		
	}
	
	@PostMapping("join")
	public String join(MemberDTO memberDTO, MultipartFile attach, Model model) throws Exception{
		
		int result = memberService.join(memberDTO,attach);
		
		String msg = "가입 GG";
		
		if(result > 0) {
			msg="웰컴 투 멍멍";
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("path","/");
		
		
		return "commons/result";
		
	}
	
	@GetMapping("agreement")
	public void setAgreement() {
		
	}
	
	
	
//member
	
	//login
	@GetMapping("login")
	public void getLogin() {
		
	}
	
	@PostMapping("login")
	public String getLogin(MemberDTO memberDTO, HttpSession session, Model model) {
		
		memberDTO = memberService.getLogin(memberDTO);
		
		String result = "redirect:../";	
		
		if(memberDTO == null) {
			model.addAttribute("msg","ID 또는 PASSWORD 확인하세요");
			result = "member/login";
			
		}				
						
		//requst.getSesstion();
		session.setAttribute("member",memberDTO);
		
		return result;
		
	}
	
	//logout
	
	@GetMapping("logout")
	public String getLogout(HttpSession session) {
	
		//	session.setAttribute("member", session);
		//  session.removeAttribute("member");
		//  session.removeAttribute("member");
		session.invalidate();
		
		return "redirect:../";
			
	}
	
	
	@GetMapping("mypage")
	public String getMemberDetail(HttpSession session, Model model) {
		
		MemberDTO mem =(MemberDTO)session.getAttribute("member");		
		mem = memberService.getDetail(mem);
		model.addAttribute("member", mem);
		System.out.println(mem.getAvatarDTO().getFileName()+"12312");
		return "member/mypage";
		
	}
	
	/*
	 * @GetMapping("mypage") public void getMemberDetail(HttpSession session, Model
	 * model) {
	 * 
	 * MemberDTO memberDTO = (MemberDTO)session.getAttribute("member"); memberDTO =
	 * memberService.getDetail(memberDTO); model.addAttribute("member",memberDTO);
	 * 
	 * }
	 */
	
	
	//update
	@GetMapping("update")
	public  void setUpdate()throws Exception{}
	/*
	 * @PostMapping("update") public void setUpdate(HttpSession session, Model
	 * model) { MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
	 * memberDTO = memberService.getDetail(memberDTO);
	 * model.addAttribute("member",memberDTO);
	 * 
	 * }
	 */
	
	@PostMapping("update")
	public String setUpdate(MemberDTO memberDTO, HttpSession session,Model model) {		
	
		MemberDTO mem = (MemberDTO)session.getAttribute("member");
		memberDTO.setUserName(mem.getUserName());
		memberDTO.setAvatarDTO(mem.getAvatarDTO());
		session.setAttribute("member", mem);
		int result = memberService.setUpdate(memberDTO);		
		
		return "redirect:./";
	}
	
}
