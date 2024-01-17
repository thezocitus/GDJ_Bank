package com.winter.app.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;
import com.winter.app.util.Pager;

import oracle.net.aso.b;


@Repository("qna")
public class QnaDAO implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.winter.app.board.qna.QnaDAO.";
	
	
	//lIST
	
	@Override
	public Long getTotalCount(Pager pager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.makeRow();
		

		return sqlSession.selectList(NAMESPACE+"getList",pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getDetail",boardDTO);
	}

	//insert
	
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		
		System.out.println("DAO");
		
		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}

	public int setFileAdd(BoardFileDTO boardFileDTO) {
		
		return sqlSession.insert(NAMESPACE+"setFileAdd", boardFileDTO);
	}
	
	
	//update
	
	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}
	
	
//delete
	
	
	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE+"setDelete", boardDTO);
	}
	
	public List<BoardFileDTO> getFileList(BoardDTO boardDTO){
		
		return sqlSession.selectList(NAMESPACE+"getFileList", boardDTO);
		
	}
	
	public int setFileDelete(BoardDTO boardDTO){
		
		return sqlSession.delete(NAMESPACE+"setFileDelete",boardDTO);
	}
//reply	
	public int setReplyUpdate(QnaDTO qnaDTO) {
		
		
		return sqlSession.update(NAMESPACE+"setReplyUpdate", qnaDTO);
	
	}
	
	public int setReplyAdd(QnaDTO qnaDTO) {
		
		return sqlSession.insert(NAMESPACE+"setReplyAdd", qnaDTO);
		
	}
	
}
