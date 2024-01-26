package com.winter.app.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.member.MemberDTO;
import com.winter.app.util.Pager;

@Service
public class AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	
	
	public int addAccount(AccountDTO accountDTO) {
		
		Long accountNum = System.currentTimeMillis();
		accountDTO.setAccountNum(accountNum);
		
		return accountDAO.addAccount(accountDTO);
				
	}
	
	
	public List<AccountDTO> getList(Pager pager,AccountDTO accountDTO) throws Exception{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		pager.makeRow();
		map.put("pager", pager);
		map.put("accountDTO", accountDTO);			
//		pager.makeNum(totalCount);
		
		return accountDAO.getList(map);
		
	}
	
	
}
