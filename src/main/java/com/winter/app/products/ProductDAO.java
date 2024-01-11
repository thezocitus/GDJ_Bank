package com.winter.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.Pager;



@Repository
public class ProductDAO {
	
//	private ProductDTO pD;
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.winter.app.products.ProductDAO.";
	
	
//	public ProductDAO() {
//		this.pD = new ProductDTO();
//	}

	//상품목록
	//URL METHOD, PRAMITTER
	//URL: /product/list
	//method : get
	//parameter:
	public int add(ProductDTO productDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"add", productDTO);
		
	}
	
	public int addFile(ProductFileDTO productFileDTO){
		
		return sqlSession.insert(NAMESPACE+"addFile", productFileDTO);
		
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) {
		return sqlSession.selectOne(NAMESPACE+"getDetail", productDTO);
	}
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getList", pager);
		
	}
	
	public List<ProductFileDTO> getFileList(ProductDTO productDTO) throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"getFileList", productDTO);
	}
	
	public Long getTotal() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getTotal");
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
	
	
	public int delect(ProductDTO productDTO) {
				
		return sqlSession.delete(NAMESPACE+"delete", productDTO);
		
	}

		
	public int doUpdate(ProductDTO productDAO) {
	
		return 0;
		
	}
	
	

	
}
