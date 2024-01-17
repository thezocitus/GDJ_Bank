package com.winter.app.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Pager;

public interface BoardService {	
	
	//list
	public List<BoardDTO> getList(Pager pager) throws Exception;
	
	//detail
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

	//add
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception;
	
	//update
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception;
	
	//delete
	public int setDelete(BoardDTO boardDTO) throws Exception; 
}
