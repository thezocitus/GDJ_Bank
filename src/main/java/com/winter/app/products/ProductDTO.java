package com.winter.app.products;

import java.util.List;

public class ProductDTO {

	private Long productNum; 
	private String productName;
	private String productContents;
	private Double productRate;
	private Double productJumsu;
	private List<ProductFileDTO> ProductFileDTOs;
	
	public List<ProductFileDTO> getProductFileDTOs() {
		return ProductFileDTOs;
	}
	public void setProductFileDTOs(List<ProductFileDTO> productFileDTOs) {
		ProductFileDTOs = productFileDTOs;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductContents() {
		return productContents;
	}
	public void setProductContents(String productContents) {
		this.productContents = productContents;
	}
	public Double getProductRate() {
		return productRate;
	}
	public void setProductRate(Double productRate) {
		this.productRate = productRate;
	}
	public Double getProductJumsu() {
		return productJumsu;
	}
	public void setProductJumsu(Double productJumsu) {
		this.productJumsu = productJumsu;
	}
	
}
