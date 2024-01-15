package com.winter.app.board;

import java.util.List;

import com.winter.app.util.Pager;

public interface BoardDAO {

	
		//totalCount
		public Long getTotalCount()throws Exception;
		
		//list
		public List<BoardDTO> getList(Pager pager)throws Exception;
		
		//detail
		public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
		
		//add
		public int setAdd(BoardDTO boardDTO)throws Exception;
		
		//update
		public int setUpdate(BoardDTO boardDTO)throws Exception;
		
		//delete
		public int setDelete(BoardDTO boardDTO)throws Exception;

	
	
}
