package com.winter.app.wishlist;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.account.AccountDTO;
import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;
import com.winter.app.util.Pager;

@Service
public class WishListService {

		@Autowired
		private WishListDAO wishListDAO;
		
		
		public int addWishList(AccountDTO accountDTO) {
			
			return wishListDAO.addWishList(accountDTO);
			
		}
	
	
		public List<ProductDTO> getList(Pager pager,MemberDTO memberDTO){
			
			Map<String, Object> map = new HashMap<String, Object>();
			pager.makeRow();
			map.put("pager", pager);
			map.put("memberDTO", memberDTO);
			Long totalCount = wishListDAO.getTotalCount(memberDTO);
			pager.makeNum(totalCount);
			
					
			return wishListDAO.getList(map);			
			
		}
		
		public int setDelete(Long [] productNum, MemberDTO memberDTO) {
			
//		    String userName = memberDTO.getUserName();
		    Map<String, Object> map = new HashMap<String, Object>();
			map.put("nums", productNum);
			map.put("memberDTO", memberDTO);
		    
//		    for(Long p :productNum) {
//				System.out.println(p);
//				AccountDTO accountDTO = new AccountDTO();
//				accountDTO.setProductNum(p);
//				accountDTO.setUserName(userName);
//				map.put("accountDTO", accountDTO);
//			}
			
			
			return wishListDAO.setDelete(map);
		
		}
}


