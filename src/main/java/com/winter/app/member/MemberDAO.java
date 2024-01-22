package com.winter.app.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.winter.app.member.MemberDAO.";
	
	public int join(MemberDTO memberDTO) {		
		
		return sqlSession.insert(NAMESPACE+"join",memberDTO);
		
	}

	public int setFileAdd(AvatarDTO memberFileDTO) {
		
		return sqlSession.insert(NAMESPACE+"setFileAdd", memberFileDTO);			
				
		
	}
	
	public MemberDTO getDetail(MemberDTO memberDTO) {
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", memberDTO);
	}
	
	
	public int setUpdate(MemberDTO memberDTO) {
		
		return sqlSession.update(NAMESPACE+"setUpdate", memberDTO);
		
	}
	
}
