package com.winter.app.account;

import java.sql.Date;

import com.winter.app.member.MemberDTO;
import com.winter.app.product.ProductDTO;

public class AccountDTO {
	
	private Long accountNum;
	private Long accountPw;
	private Date accountDate;
	private Long accountBlance;
	private Long productNum;
	private String userName;
	
	private ProductDTO productDTO;
	
	
	
	
	
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public Long getAccountPw() {
		return accountPw;
	}
	public void setAccountPw(Long accountPw) {
		this.accountPw = accountPw;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public Long getAccountBlance() {
		return accountBlance;
	}
	public void setAccountBlance(Long accountBlance) {
		this.accountBlance = accountBlance;
	}
	
	
}
