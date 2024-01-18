package com.winter.app.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.member.MemberDTO;
import com.winter.app.util.Pager;



@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	@Qualifier("qnaService")
	private BoardService boardService;
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	@ModelAttribute("bbs")
	public Integer getKind() {
		return 1;
	}
	
	
	
	
	//update
	@GetMapping("update")
	public String setUpdate(BoardDTO boardDTO, Model model)throws Exception{
		
		boardDTO = boardService.getDetail(boardDTO);		
		model.addAttribute("boardDTO", boardDTO);
		
		return "/board/update";
		
	}
	
	@PostMapping("update")
	public String setUpdate(BoardDTO boardDTO, MultipartFile[] attachs)throws Exception{
		
		int result= boardService.setUpdate(boardDTO, attachs);
		
		String msg = "수정 실패";
		
		if(result>0) {
			msg = "수정 성공";
		}
		
		return "redirect:./list";
		
	}
	
	
	//delete
	@PostMapping("delete")
	public String setDelete(QnaDTO boardDTO)throws Exception{
		boardDTO.setFlag(1);
		int result = qnaService.setDelete(boardDTO);
		
		
		
		return "redirect:./list";
		
	}
	
	
	
	//reply
	
	@GetMapping("reply")
	public String setReply(BoardDTO boardDTO, Model model , HttpSession session) {
		
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		boardDTO.setBoardWriter(memberDTO.getUserName());
		
		
		System.out.println(boardDTO.getBoardNum());
			
		model.addAttribute("boardDTO", boardDTO);
		
		
		return "board/reply";
	}
	
	@PostMapping("reply")
	public String setReply(QnaDTO qnaDTO) throws Exception {
		
			
		int result = qnaService.setReply(qnaDTO);
		
		
		return  "redirect:./list";
	}
	
			
	//list
	@GetMapping("list")
	public String getList(Pager pager, Model model) throws Exception{
		
		List<BoardDTO> ar = boardService.getList(pager);
		
		model.addAttribute("list",ar);	
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	//detail
	@GetMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception {
		
		boardDTO = boardService.getDetail(boardDTO);
		System.out.println(boardDTO.getBoardName());
		model.addAttribute("boardDTO", boardDTO);
		
		return "/board/detail";
	}
	
	//insert
	@GetMapping("add")
	public String setAdd() {
		
		return "./board/add";
		
	}
	
	
	//add
	@PostMapping("add")
	public String setAdd(BoardDTO boardDTO, MultipartFile[] attachs, HttpSession session) throws Exception {		
		
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		boardDTO.setBoardWriter(memberDTO.getUserName());
		
		
		System.out.println(attachs);
		
		int result = boardService.setAdd(boardDTO,attachs);
		
		return "redirect:./list";
		
	}
	
	
	
}
