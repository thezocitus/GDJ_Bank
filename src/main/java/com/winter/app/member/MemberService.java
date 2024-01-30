package com.winter.app.member;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.qna.QnaDAO;
import com.winter.app.util.FileManager;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private ServletContext servletContext;
	
	
	
	
	
	
	
	
	//ADD
	
	public int join(MemberDTO memberDTO, MultipartFile avatar) throws Exception {
		int result=0;
		result = memberDAO.join(memberDTO);
		
		if(avatar.isEmpty()) {
			return result;
		}
		System.out.println(avatar.getName());
		String path = servletContext.getRealPath("/resources/upload/member");
		
		String fileName = fileManager.fileSave(path, avatar);
		
		AvatarDTO avatarDTO = new AvatarDTO();
		avatarDTO.setFileName(fileName);
		avatarDTO.setOrigName(avatar.getOriginalFilename());
		avatarDTO.setUserName(memberDTO.getUserName());
		
		result = memberDAO.setFileAdd(avatarDTO);
		
		return result;
		
	}
	

	
	
	//login
	
	public MemberDTO getLogin(MemberDTO memberDTO) {
		
		MemberDTO m = memberDAO.getDetail(memberDTO);		
		
		if(m != null) {			
			if(m.getPassword().equals(memberDTO.getPassword())) {				
				memberDTO.setRoleDTOs(m.getRoleDTOs());
				return memberDTO;		
			}else {
				m = null;
			}
		}	
		
		return m;
		
	}
	//update	
	public MemberDTO getDetail(MemberDTO memberDTO) {
		
		return memberDTO = memberDAO.getDetail(memberDTO);
		
		
	}
	
	
	
	public int setUpdate(MemberDTO memberDTO) {
		
		return memberDAO.setUpdate(memberDTO);
		
		
	}
	
	
	
	
	
}
