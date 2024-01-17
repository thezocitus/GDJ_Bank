package com.winter.app.product;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
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

		System.out.println(path + "  :  service.add");
		
			
		
		
		//4. DB에 정보 저장
		for(MultipartFile f : file) {
			
			System.out.println(f + " service b");
			if(f.isEmpty()) {
				System.out.println(f + " service a");
				continue;
			}
				
			
			String fileName = fileManager.fileSave(path, f); 				
			ProductFileDTO dto = new ProductFileDTO();
			dto.setFileName(fileName);
			dto.setOrigName(f.getOriginalFilename());
			dto.setProductNum(productDTO.getProductNum());		
			result = productDAO.addFile(dto);
		}
					
		return result;
//				productDAO.add(productDTO);				
	}
	
	public void delete(ProductDTO productDTO) throws Exception {
		

		List<ProductFileDTO> ar = productDAO.getFileList(productDTO);
		
		int result = productDAO.delete(productDTO);
		
		
		String path = servletContext.getRealPath("/resources/upload/products");
		for(ProductFileDTO f : ar) {
			f.getFileName();
			fileManager.fileDelete(path, f.getFileName());
			
		}
		
		
	}
	
	
}
