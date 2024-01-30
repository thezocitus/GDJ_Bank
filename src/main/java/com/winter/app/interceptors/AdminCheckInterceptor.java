package com.winter.app.interceptors;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.winter.app.member.MemberDTO;
import com.winter.app.member.role.RoleDTO;

@Component
public class AdminCheckInterceptor extends HandlerInterceptorAdapter{

	
	//contoller 진입전
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		 List<RoleDTO> ar = memberDTO.getRoleDTOs();
		 System.out.println("AdminCheckInterceptor Activated");
		 for(RoleDTO r:ar) {
			 
			 if(r.getRoleName().equals("ROLE_ADMIN")) {
				 return true;
			 }
		 }
		
		 request.setAttribute("msg", "관리자만 가능");
		 request.setAttribute("path", "/");
		 RequestDispatcher view = request.getRequestDispatcher("/WEP-INF/views/commens/result.jsp");
		 view.forward(request, response);
			 return false;		 
		 
	}
	
	//contoller 에서 나갈때
	
	//Jsp 랜더링후 
	
	
}
