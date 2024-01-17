<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

            <div class="row gx-5 justify-content-center">
                <div class="col-lg-11 col-xl-9 col-xxl-8">
               	<form class="form-control" method="POST" enctype="multipart/form-data">
               		<input type="hidden" name="boardNum" value="${boardDTO.boardNum}">
	               	<div class="mb-3">
					  <label for="title" class="form-label" >제목</label>
					  <input type="text" class="form-control" id="title" name="boardName" value="${boardDTO.boardName}">
					</div>
					<div class="mb-3">
					  <label for="writer" class="form-label">작성자</label>
					  <input type="text" class="form-control" id="writer" name="boardWriter" value="${boardDTO.boardWriter}">
					</div>
					<div class="mb-3">
					  <label for="contents" class="form-label">내용</label>
					  <textarea class="form-control" id="contents"   name=boardContents rows="3">${boardDTO.boardContents}</textarea>
					</div>
					
					<div class="mb-3">
						<input type="file" name="attachs">
						<input type="file" name="attachs">
						<input type="file" name="attachs">						
					</div>
					
					<div>
						<button class="btn btn-primary">등록</button>
					</div>
               	</form>
              
                </div>
            </div> 
 			
