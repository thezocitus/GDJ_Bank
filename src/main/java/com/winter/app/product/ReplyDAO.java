package com.winter.app.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {

	
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.winter.app.product.ReplyDAO.";
	
	public int setDelete(ReplyDTO replyDTO) {
		
		return sqlSession.delete(NAMESPACE+"setDelete", replyDTO);
		
	}
	
	public int setReply(ReplyDTO replyDTO) {
		
		return sqlSession.insert(NAMESPACE+"setReply", replyDTO);
	}
	
	public List<ReplyDTO> getList(Map<String, Object> map){
		
		return sqlSession.selectList(NAMESPACE+"getList", map);
	}
	
	public Long getTotalCount(ProductDTO productDTO) {
		
		return sqlSession.selectOne(NAMESPACE+"getTotalCount", productDTO);
	}
	
	
}
