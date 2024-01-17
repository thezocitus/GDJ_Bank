package com.winter.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	@Qualifier("noticeService")
	private BoardService boardService;
	
	
	
	@ModelAttribute ("board")//공통으로 model에 담아야 할 정보
	public String getBoard() {
		return "notice";
	}
	
	@ModelAttribute("bbs")
	public Integer getKind() {
		return 0;
	}
	
	
	
	
	
	
	//UPDATE
	@GetMapping("update")
	public String setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		
		
		boardDTO = boardService.getDetail(boardDTO);
		model.addAttribute("boardDTO",boardDTO);		
		
		return "board/update";
	}
	
	@PostMapping("update")
	public String setUpdate(BoardDTO boardDTO, MultipartFile[] attachs ) throws Exception {
		
		int result = boardService.setUpdate(boardDTO, attachs);
	
		return "redirect:./list";
	}
	
		
	//DELETE
	@PostMapping("delete")
	public String setDelete(BoardDTO boardDTO) throws Exception{	
		
		
		int result = boardService.setDelete(boardDTO);
		
		return "redirect:./list";
	}
	
	
		
	//LIST
//	@RequestMapping(value = "list", method = RequestMethod.GET)
	
	@GetMapping("list")
	public String getList(Pager pager,Model model) throws Exception{
		
		List<BoardDTO> ar = boardService.getList(pager);
		model.addAttribute("list",ar);		
		
		return "/board/list";
		
	}
	
	//detail
	@GetMapping("detail")
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception {
		
		boardDTO  = boardService.getDetail(boardDTO);
		
		model.addAttribute("boardDTO", boardDTO);		
		
		
		
		return "board/detail";
		
	}
	
	//insert
	@GetMapping("add")
	public String setAdd() {
		
		return "board/add";	
		
	}
	
	@PostMapping("add")
	public String setAdd(BoardDTO boardDTO, MultipartFile [] attachs) throws Exception {
		
		int result = boardService.setAdd(boardDTO, attachs);
		
		
		return "redirect:./list";	
		
	}
	
	
	
	
	
}
