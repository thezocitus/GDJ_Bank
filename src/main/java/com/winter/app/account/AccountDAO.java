package com.winter.app.account;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.winter.app.account.AccountDAO.";
	

	
	
	public int addAccount(AccountDTO accountDTO) {
		
		return sqlSession.insert(NAMESPACE+"addAccount", accountDTO);
		
	}
	

	public List<AccountDTO> getList(AccountDTO accountDTO){
		
		return sqlSession.selectList(NAMESPACE+"getList", accountDTO);
		
	}
	
}
