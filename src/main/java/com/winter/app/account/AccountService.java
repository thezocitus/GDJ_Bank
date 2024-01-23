package com.winter.app.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	
	
	public int addAccount(AccountDTO accountDTO) {
		
		Long accountNum = System.currentTimeMillis();
		accountDTO.setAccountNum(accountNum);
		
		return accountDAO.addAccount(accountDTO);
				
	}
	
	
	public List<AccountDTO> getList(AccountDTO accountDTO) {
		
		
		List<AccountDTO> ar = accountDAO.getList(accountDTO);		
		
		
		return ar;
		
	}
	
	
}
