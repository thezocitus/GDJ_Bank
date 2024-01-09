package com.winter.app.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;

@Service
public class ProductService {
		
		@Autowired
		private ProductDAO productDAO;
	
		//list
		public List<ProductDTO> getList(Pager pager) throws Exception {
			pager.makeRow();
			Long totalcount = productDAO.getTotal(); 
			List<ProductDTO> ar = this.productDAO.getList(pager);
			pager.makeNum(totalcount);			
			
			return ar;
		}
		
		public int add(ProductDTO productDTO) throws Exception {
			
			return productDAO.add(productDTO);
			
		}
}
