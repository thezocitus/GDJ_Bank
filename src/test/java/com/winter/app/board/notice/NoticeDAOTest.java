package com.winter.app.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.board.BoardDTO;
import com.winter.app.util.Pager;

public class NoticeDAOTest extends MyTest{
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	
	@Test
	public void test() throws Exception {
		this.setAddTest();	
	}
	
	
	
	public void getListTest()throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		
		List<BoardDTO> ar = noticeDAO.getList(pager);
		
		assertNotEquals(0, ar.size());		
		
	}

	public void setAddTest() throws Exception {
		
	
		for(int i = 0; i<30; i++) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setBoardName("Tommy :"+ i*3);
			boardDTO.setBoardWriter("nullpoint Eception :" + i*7);
			boardDTO.setBoardContents("null"+i*i*i*i*i*i*i*50);
			 noticeDAO.setAdd(boardDTO);
		}
		
		Pager pager = new Pager();
		pager.makeRow();
		
		List<BoardDTO> ar = noticeDAO.getList(pager);
		
		assertNotEquals(5,ar.size());
		
		
		
		
	}
	
}
