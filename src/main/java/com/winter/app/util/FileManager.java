package com.winter.app.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	
	public boolean fileDelete(String path, String name) {
		
		File flie = new File(path, name);
		return flie.delete();
	}
	
	
	
	public String fileSave(String path, MultipartFile file) throws Exception {
		
		File f = new File(path);		
		
		if(!f.exists()) {
			f.mkdirs();
		}
		System.out.println(file);
		
		if(f.isFile()) {
			throw new Exception();
		}
		
				
		String fileName=UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		System.out.println(fileName+" : FileManager fliesave");
		//3. 파일을 저장
		// a.FileCopyUtils 클래스 이용
		f = new File(f, fileName);
		FileCopyUtils.copy(file.getBytes(),f);		
	
		return fileName;
		
	}
}
