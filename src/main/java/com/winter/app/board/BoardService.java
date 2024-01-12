package com.winter.app.board;

import java.util.List;

public interface BoardService {	
	
	//list
	public List<BoardDTO> getList() throws Exception;
	
	//detail
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;

	//add
	public int setAdd(BoardDTO boardDTO ) throws Exception;
	
	//update
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	
}
