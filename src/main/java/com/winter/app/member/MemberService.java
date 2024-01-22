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
	
	public int join(MemberDTO memberDTO, MultipartFile[] files) throws Exception {
		
		 int result = memberDAO.join(memberDTO);
		 
		 return this.fileAdd(memberDTO, files);
		
		
	}
	
	//flieAdd
	public  int fileAdd(MemberDTO memberDTO, MultipartFile[] files) throws Exception {
		
		int result = 0;
		
		String path = "/resources/upload/memberFiles";
		
		for(MultipartFile f : files) {			
			
			if(f.isEmpty()) {
				continue;
			}			
		
		String fileName = fileManager.fileSave(path, f); 
		
		AvatarDTO avatarDTO = new AvatarDTO();
		
		avatarDTO.setFileName(fileName);
		avatarDTO.setOrigName(f.getOriginalFilename());
		avatarDTO.setUserName(memberDTO.getUserName());
		result = memberDAO.setFileAdd(avatarDTO);		
		
		}
		return result;
		
	}

	
	
	//login
	
	public MemberDTO getLogin(MemberDTO memberDTO) {
		
		MemberDTO m = memberDAO.getDetail(memberDTO);		
		
		if(m != null) {			
			if(m.getPassword().equals(memberDTO.getPassword())) {				
				return m;		
			}else {
				m = null;
			}
		}	
		
		return m;
		
	}
	
	public MemberDTO getDetail(MemberDTO memberDTO) {
		
		return memberDTO = memberDAO.getDetail(memberDTO);
		
		
	}
	
	public int setUpdate(MemberDTO memberDTO) {
		
		return memberDAO.setUpdate(memberDTO);
		
		
	}
	
}
