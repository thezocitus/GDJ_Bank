package com.winter.app.wishlist;

import static org.junit.Assert.*;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.account.AccountDTO;


public class WishListTestDAO extends MyTest{
	@Autowired
	private WishListDAO wishListDAO;
	
	
	@Test
	public void test() {
		this.setAdd();
	}
	
	
	public void setAdd(){
		
		
		int result=0;
		
		for(int i = 0 ; i < 80 ; i++) {
			AccountDTO accountDTO = new AccountDTO();
			
			accountDTO.setUserName("a");
			accountDTO.setProductNum(105L+i);
			wishListDAO.addWishList(accountDTO); 
			System.out.println(result);
			result++;		
		}
		
		System.out.println(result);
		assertNotNull(result);
		
	}
	

}
