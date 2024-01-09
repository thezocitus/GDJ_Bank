package com.winter.app;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.products.ProductDAO;
import com.winter.app.products.ProductDTO;


public class ProductDAOTest extends MyTest {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void addtest() throws Exception {
		ProductDTO productDTO = new ProductDTO();
		int result = 0;
		for(int i = 0; i < 100 ; i++) {
			productDTO.setProductNum(100L+i);
			productDTO.setProductName("hell");
			productDTO.setProductContents("EHVEN");
			productDTO.setProductRate(2.0);
			productDTO.setProductJumsu(5.0);

			System.out.println(productDTO.getProductNum());
	
			result= productDAO.add(productDTO);
			System.out.println(result);
		}
			
	}
	
//	
//	public void getListTest () {
//		
//		Pager pager = new Pager();
//			
//		
//	}
//	
}
