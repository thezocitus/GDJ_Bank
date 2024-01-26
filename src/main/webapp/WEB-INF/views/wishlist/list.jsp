<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Personal - Start Bootstrap Theme</title>
    <!-- 사용전 경로를 꼭 수정 하세요 -->
	<c:import url="../temps/head_css.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <!-- 사용전 경로를 꼭 수정 하세요 -->
			<c:import url="../temps/header.jsp"></c:import>
			
			
			<div class="container px-5 my-5">
				<div class="text-center mb-5">
					<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Wish List</span></h1>
				</div>
			<div class="container px-5 mt-5">
				<div class="row g-4 align-items-end">
					<form class="col row g-3 mb-3">
						<div class="col-auto">
							<select class="form-select" name="kind">
								<option value="kind1">이름</option>
								<option value="kind2">내용</option>
								<option value="kind3">이름&내용</option>
							</select>
						</div>
						<div class="col-auto">
							<label for="search" class="visually-hidden">Search</label> <input
								type="text" name="search" class="form-control" id="search" value="${pager.search}">
						</div>
						<div class="col-auto">
							<button type="submit" class="btn btn-light">Search</button>
						</div>
					</form>
					<div class="col-auto d-flex justify-content-end">
						<a class="btn btn-light mb-3" href="./add">상품 등록</a>
					</div>
				</div>
			</div>


			<table class="table table-hover">
			<button type="button" id="del" >삭제</button>			
			<button type="button" id="add" >가입</button>
			<thead>
				<tr class="table-dark">
					<th><input type="checkbox" id="checkAll">전체선택</th>
					<th>No</th>
					<th>Title</th>					
					<th>Contents</th>
					<th>Rate</th>				
				</tr>
			</thead>
			<tbody id="ajaxList">
				<c:if test="${list.size()==0 }">
					<tr>
						<td colspan="5">없음.</td>
					</tr>
				</c:if>
				<form id="deleteForm">
				<c:forEach items="${list}" var="dto">					
						<tr>
							<td><input type="checkbox" class="checks" name="productNum" value="${dto.productNum}"></td>
							<td>${dto.productNum}</td>
							<td><a href="/product/detail?productNum=${dto.productNum}"> ${dto.productName}
							</a></td>
							<td>${dto.productContents}</td>
							<td>${dto.productRate}</td>							
						</tr>					
				</c:forEach>
				</form>
			</tbody>
		</table>
      </div>
                
              <!--   <div>
                	<a href="add" class="btn btn-danger">상품등록</a>
                </div>		 -->
			<nav aria-label="Page navigation example" class="d-flex justify-content-center">
				<ul class="pagination">
					<c:if test="${!pager.start}">
						<li class="page-item"><a class="page-link"
							href="./list?page=${pager.startNum-1}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>

					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li class="page-item"><a class="page-link"
							href="./list?page=${i}&search=${pager.search}&kind=${pager.kind}">
								${i} </a></li>
					</c:forEach>

					<c:if test="${!pager.last}">
						<li class="page-item"><a class="page-link"
							href="./list?page=${pager.lastNum+1}&search=${pager.search}&kind=${pager.kind}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
		
			
        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정 하세요 -->
        <c:import url="../temps/footer.jsp"></c:import>
		<script src="/resources/js/member/wishlist.js"></script>

    </body>
</html>
