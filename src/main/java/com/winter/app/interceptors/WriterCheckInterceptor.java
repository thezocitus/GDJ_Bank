package com.winter.app.interceptors;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.notice.NoticeDAO;
import com.winter.app.board.qna.QnaDAO;
import com.winter.app.member.MemberDTO;

@Component
public class WriterCheckInterceptor extends HandlerInterceptorAdapter{


	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private QnaDAO qnaDAO;
	
	
	
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//			throws Exception {
//		// TODO Auto-generated method stub
//		String path = request.getRequestURI();
//		
//		path.substring(0, path.lastIndexOf("/"));
//		
//		//num
//		Long n = Long.parseLong(request.getParameter("boardNum"));
//		
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setBoardNum(n);
//				
//		if(path.equals("/qna")) {
//			qnaDAO.getDetail(null);
//		}else {
//			noticeDAO.getDetail(null);
//		}
//		
//		//
//		
//		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
//		
//		if(boardDTO.getBoardWriter().equals(memberDTO.getUserName())) {
//			return true;
//		}else {
//			RequestDispatcher v = request.getRequestDispatcher("WEB-INF/views/commons.result.jp");
//
//					modelAndView.addObject("msg", "작성자만 수정할 수 있습니다.");
//					modelAndView.addObject("path","./list");
//					modelAndView.setViewName("commons/result");
//					return false;
//		}

//		
//	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
				
		
		String method = request.getMethod();
		
		if(method.toUpperCase().equals("POST")) {
			return;
		}
		
		
		Map<String, Object> map = modelAndView.getModel();
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String k = it.next();
			System.out.println(k);
			System.out.println(map.get(k));
			
		}
		
		System.out.println(modelAndView.getViewName()); 
		
		
		BoardDTO boardDTO =(BoardDTO) map.get("boardDTO");
		
		//로그인 정보
		
		MemberDTO memberDTO = (MemberDTO)request.getSession();
		
		if(!boardDTO.getBoardWriter().equals(memberDTO.getUserName())) {
			
			modelAndView.addObject("msg", "작성자만 수정할 수 있습니다.");
			modelAndView.addObject("path","./list");
			modelAndView.setViewName("commons/result");
			
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
