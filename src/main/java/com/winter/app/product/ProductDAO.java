package com.winter.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.app.util.Pager;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession;	
	private final String NAMESPACE="com.winter.app.products.ProductDAO.";
	
	
	
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
	
	
	
	public int delete(ProductDTO productDTO) {
				
		return sqlSession.delete(NAMESPACE+"delete", productDTO);
		
	}
	
}
