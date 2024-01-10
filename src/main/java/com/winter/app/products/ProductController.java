package com.winter.app.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.util.Pager;

@Controller
@RequestMapping("/products/*")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public void getList(Pager pager, Model model) throws Exception{
		 List<ProductDTO> ar = productService.getList(pager);
		 model.addAttribute("list",ar);	 
		 
	}
	
	@RequestMapping(value = "add")
	public String add() {
		
		return "products/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(ProductDTO productDTO, Model model, MultipartFile photo)  throws Exception {
		
		System.out.println(photo+"photo");
		
		int result = this.productService.add(productDTO, photo);
		
		String msg="등록 실패";
		if(result > 0) {
			msg="등록 성공";
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("path","./list");
		
		
		return "commons/result";
		
		
	}
						
	//디테일
	//URL: /product/detail
	//method : get
	//parameter: productNum
//	@RequestMapping(value="detail", method = RequestMethod.GET)
//	public String getDetail(Long productNum, Model model) throws Exception {
//		ProductDTO productDTO = new ProductDTO();		
//		productDTO.setProductNum(productNum);		
//		productDTO = productDAO.getDetail(productDTO);
//				
//		model.addAttribute("DTO", productDTO);		
//		return "product/detail";
//	}
}
