package com.winter.app.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Component
public class AuthenticationInterCepter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		System.out.println("인증용");
		if(obj!=null) {
			return true;
		}else {
			//redirect
			//response.sendRedirect("../member/login");
			
			//forwording
			request.setAttribute("msg", "로그인 필요");
			request.setAttribute("path", "../member/login");
			RequestDispatcher v = request.getRequestDispatcher("/WEB-INF/views/commons/result.jsp");
			v.forward(request, response);
			
			
			return false;
		}
	}
}
