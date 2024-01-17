package com.winter.app.util;

public class Pager {
	
	private Long startRow;
	private Long lastRow;
	//페이지당 출력되는 글의 갯수
	private Long perPage = 10L;
	//페이지 번호 , 파라미터로 받기 위해
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long totalPage;
	
	
	// 이전, 다음 블럭 유무
	private boolean start;
	private boolean last; 
	
	//검색
	
	private String search;
	private String kind;
	
	public void makeRow() {
		
		this.startRow = this.getPage()*this.getPerPage()-(this.getPerPage()-1);
		this.lastRow= this.getPage()*this.getPerPage();
	
	}
	
	public void makeNum(Long totalCount) {
		//1. 총 갯수로 총 페이지 수 구하기
		if(totalCount<1) {
			totalCount=1L;
		}		
		Long totalPage =0L;
		
		totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() >0) {
			totalPage++;
		}
		//2. 총 페이지수로 총 블럭 수 구하기
		
		Long perBlock = 5L;
		Long totalBlock = 0L;
		
		totalBlock = totalPage/perBlock;
		if(totalPage%perBlock>0) {
			totalBlock++;
		}
				
		//3. 현재 페이지 번호로 현재 블럭 번호 구하기
		
		Long curBlock = 0L;
		
		curBlock = this.getPage()/perBlock;
		
		if(this.getPage()%perBlock > 0) {
			
			curBlock++;
		}
				
		//4. 현재 블럭 번호로 시작번호와 끝 번호 구하기
		Long lastnum = curBlock*perBlock;
		Long startnum= lastnum - perBlock+1;
		
		this.setLastNum(lastnum);
		this.setStartNum(startnum);
		
		//5. 이전, 다음 블럭 유무 구하기
		if(curBlock==1) {
			this.setStart(true);
		}
		if(curBlock==totalBlock) {
			this.setLast(true);
			this.setLastNum(totalPage);
		}		 
		
		
	}
	

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPage() {
	
		if(this.page==null || this.page<1) {
			this.page = 1L;
		}
		
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
			
}
