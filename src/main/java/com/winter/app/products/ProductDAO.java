package com.winter.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;



@Repository
public class ProductDAO {
	
//	private ProductDTO pD;
	
	@Autowired
	private SqlSession sqlSession;
	private final String namespace="com.winter.app.products.ProductDAO.";
	
	
//	public ProductDAO() {
//		this.pD = new ProductDTO();
//	}

	//상품목록
	//URL METHOD, PRAMITTER
	//URL: /product/list
	//method : get
	//parameter:
			
	public List<ProductDTO> getList() throws Exception {
		
		return sqlSession.selectList(namespace+"getList");
		
	}
	
	//디테일
	//URL: /product/list
	//method : get
	//parameter: productNum
	
//	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
//		Connection con = DBConnector.getConnetor();
//		String sql = "SELECT * FROM PRODUCT WHERE PRODUCTNUM = ?";
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setLong(1, productDTO.getProductNum());
//		ResultSet rs = ps.executeQuery();
//		
//		pD = null;
//		if(rs.next()) {
//			pD = new ProductDTO();
//			pD.setProductNum(rs.getLong("productNum"));
//			pD.setProductName(rs.getString("productName"));
//			pD.setProductContents(rs.getString("productContents"));
//			pD.setProductRate(rs.getDouble("productRate"));
//			pD.setProductJumsu(rs.getDouble("productJumsu"));
//		}
//		return pD;				
//	}
	
	//디테일
	//URL: /product/list
	//method : get
	//parameter: productNum
	
	
	public int doAdd(ProductDTO productDTO) {
		
		return 0;
	}

		
	public int doUpdate(ProductDTO productDAO) {
	
		return 0;
		
	}
	
	
	public int doDelect(ProductDTO productDTO) {
	
		return 0;
		
	}
	
}
