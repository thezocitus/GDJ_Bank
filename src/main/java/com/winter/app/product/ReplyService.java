package com.winter.app.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;

@Service
public class ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	
	
	public int setReply(ReplyDTO replyDTO) throws Exception{
		
		return replyDAO.setReply(replyDTO);
		
	}
	
	
	public List<ReplyDTO> getList(Pager pager, ProductDTO productDTO)throws Exception{
		pager.setPage(5L);
		pager.makeRow();
		Map<String, Object> map = new HashMap<String, Object>();
		pager.makeNum(replyDAO.getTotalCount(productDTO));
		map.put("pager", pager);
		map.put("productDTO", productDTO);
		return replyDAO.getList(map);
	}
	
}
