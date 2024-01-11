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


import com.winter.app.util.FileManager;
import com.winter.app.util.Pager;

@Service
public class ProductService {
		
		@Autowired
		private ProductDAO productDAO;
		
		@Autowired
		private FileManager fileManager;
		
	
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
		
		
		public ProductDTO detail(ProductDTO productDTO) {
			
			return productDAO.getDetail(productDTO);
			
		}
		
		public int add(ProductDTO productDTO, MultipartFile [] file) throws Exception {
			
			int result = productDAO.add(productDTO);
			//1. 어디에 저장할 것 인가??
			
			String path = servletContext.getRealPath("/resources/upload/products");

			System.out.println(path);
			
			
			//4. DB에 정보 저장
			for(MultipartFile f : file) {
				
				String fileName = fileManager.fileSave(path, f); 				
				ProductFileDTO dto = new ProductFileDTO();
				dto.setFileName(fileName);
				dto.setOrigName(f.getOriginalFilename());
				dto.setProductNum(productDTO.getProductNum());		
				result = productDAO.addFile(dto);
			}
						
			return result;
//					productDAO.add(productDTO);				
		}
		
		public void delete(ProductDTO productDTO) throws Exception {
			
			//1. 파일 이름 가져오기
			List<ProductFileDTO> ar = productDAO.getFileList(productDTO);
			
			//2.DB에서 지우기
			int result = productDAO.delect(productDTO);
			
			//3.저장소에서 지우기 // FileManager사용
			
			String path = servletContext.getRealPath("/resources/upload/products");
			for(ProductFileDTO f : ar) {
				f.getFileName();
				fileManager.fileDelete(path, f.getFileName());
				
			}
			
			
		}
			
}
