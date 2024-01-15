package com.winter.app.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.qna.QnaDAO;
import com.winter.app.util.Pager;

public class QnaDAOTest extends MyTest{
	
	@Autowired
	private QnaDAO qnaDAO;
	
	
	
	@Test
	public void test() throws Exception {
		this.getListTest();	
	}
	
	
	
	public void getListTest()throws Exception{
		Pager pager = new Pager();
		pager.makeRow();
		
		List<BoardDTO> ar = qnaDAO.getList(pager);
		
		assertNotEquals(0, ar.size());		
		
	}

}
