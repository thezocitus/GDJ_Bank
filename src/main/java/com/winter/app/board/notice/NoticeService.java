package com.winter.app.board.notice;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.board.BoardDAO;
import com.winter.app.board.BoardDTO;
import com.winter.app.board.BoardFileDTO;
import com.winter.app.board.BoardService;
import com.winter.app.util.FileManager;
import com.winter.app.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Autowired
	@Qualifier("na")
	private NoticeDAO boardDAO;
	
	@Autowired	
	private FileManager fileManager;	
	
	@Autowired
	private ServletContext servletContext;
	
	
	//lIST
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.makeRow();
		Long totalCount = boardDAO.getTotalCount(pager);
		List<BoardDTO> ar =  boardDAO.getList(pager);
		
		return ar;
	}

	
	
	
	
	
	//detail
	
	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return boardDAO.getDetail(boardDTO);
	}

	
	//add
	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		
		//1. 글을 등록 - 글번호 받기위해
		int result = boardDAO.setAdd(boardDTO);
		//2. 파일을 HDD에 저장
		//저장할 실제경로 구해오기
		String path = servletContext.getRealPath("/resources/upload/notice");
		for(MultipartFile f: files) {
			
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.fileSave(path, f);
		//DB에 정보 저장
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOrigName(f.getOriginalFilename());
			boardFileDTO.setBoardNum(boardDTO.getBoardNum());
			result = boardDAO.setFileAdd(boardFileDTO);
		}
		
		return result;
	}

	
	//UPDATE	
	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		
		//hdd 하드 저장
		
		return boardDAO.setUpdate(boardDTO);
	}

	
	//DELETE
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		//1 파일 정보 소환/ 주소 이
		//	1_1 삭제할 파일명 조회
		List<BoardFileDTO> files = boardDAO.getFileList(boardDTO);
		String path = servletContext.getRealPath("/resources/upload/notice");
		
		// file 삭제
		for(BoardFileDTO b : files) {
			
			fileManager.fileDelete(path, b.getFileName());
			
		}
		
		// file 테이블 삭제
		int result = boardDAO.setFileDelete(boardDTO);
		
		
		return boardDAO.setDelete(boardDTO);
	}


	

}
