package com.winter.app.products;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Pager;

@Service
public class ProductService {
		
		@Autowired
		private ProductDAO productDAO;
	
		@Autowired
		private ServletContext servletContext;
		
		//list
		public List<ProductDTO> getList(Pager pager) throws Exception {
			pager.makeRow();
			Long totalcount = productDAO.getTotal(); 
			List<ProductDTO> ar = this.productDAO.getList(pager);
			pager.makeNum(totalcount);			
			
			return ar;
		}
		
		public int add(ProductDTO productDTO, MultipartFile file) throws Exception {
			
			int result = productDAO.add(productDTO);
			//1. 어디에 저장할 것 인가??
			
			String path = servletContext.getRealPath("/resources/upload");

			System.out.println(path);
						
			File f = new File(path,"products");
			
			
			if(!f.exists()) {
				f.mkdir();
			}
			System.out.println(file);
			//2. 저장할 파일명으로 저장할 것인가??
			
				//a.시간 이용
			Calendar ca = Calendar.getInstance();
			String fileName= ca.getTimeInMillis()+"_"+file.getOriginalFilename();
			System.out.println(fileName);
						
			//b. UUID
			fileName=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
			System.out.println(fileName);
			//3. 파일을 저장
			// a.FileCopyUtils 클래스 이용
			f = new File(f, fileName);
			FileCopyUtils.copy(file.getBytes(),f);
			//4. DB에 정보 저장
			ProductFileDTO dto = new ProductFileDTO();
			dto.setFileName(fileName);
			dto.setOrigName(file.getOriginalFilename());
			dto.setProductNum(productDTO.getProductNum());
			result = productDAO.addFile(dto);
			return result;
//					productDAO.add(productDTO);
			
			
			
			
		}
}
