package com.winter.app.board;

import java.sql.Date;

public class BoardDTO {
	
	private Long boardNum;
	private String boardName;	
	private String boardWriter;
	private String boardContents;
	private Date boardDate;
	private Long boardCount;
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public Long getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(Long boardCount) {
		this.boardCount = boardCount;
	}
	 
	
	
	
}
