package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
		
		@Autowired
		private ProductDAO productDAO;
	
		//list
		public List<ProductDTO> getList() throws Exception {
			List<ProductDTO> ar = this.productDAO.getList();
			
			return ar;
		}
}
