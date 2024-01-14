package com.winter.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Pager;


@Controller
@RequestMapping("/product/*")
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
		
		return "product/add";
	}
	
	@RequestMapping(value = "detail")
	public String getDetail(ProductDTO productDTO, Model model){
		
		productDTO = productService.detail(productDTO);
		
		model.addAttribute("dto",productDTO);
		
		return "product/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(ProductDTO productDTO, Model model, MultipartFile[] attach)  throws Exception {
		
		System.out.println(attach + " : attach.controller.add");
		
		int result = this.productService.add(productDTO, attach);
		
		
		String msg="등록 실패";
		if(result > 0) {
			msg="등록 성공";
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("path","./list");
		
		
		return "commons/result";
		
		
	}
	
}
