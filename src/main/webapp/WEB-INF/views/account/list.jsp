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
                    <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Product List</span></h1>
                </div>
			<table class="table table-hover">
			<thead>
				<tr class="table-dark">
					<th>번호</th>
					<th>제품명</th>
					<th>이율</th>
					<th>잔고</th>					
				</tr>
			</thead>
			<tbody>
				<c:if test="${list.size()==0 }">
					<tr>
						<td colspan="5">없음.</td>
					</tr>
				</c:if>
				<c:forEach items="${list}" var="dto">
					<c:set var="f" value="0"></c:set>					
					
						<tr>
							<td>${dto.accountNum}</td>
							<td><a href="/product/detail?productNum=${dto.productDTO.productNum}"> accountDate
							</a></td>
							<td>3</td>
							<td>${dto.accountBlance}</td>
							
							</tr>
						
					</c:forEach>
				</tbody>
			</table>	                
                	
			</div>		
			    <nav aria-label="Page">
			<ul class="pagination">
				<li class="page-item"><a class="page-link"
					href="./list?page=${pager.startNum-1}" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item"><a class="page-link"
						href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				</c:forEach>
				<li class="page-item"><a class="page-link"
					href="./list?page=${pager.lastNum+1}" aria-label="Next">
					 <span aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>
			
			
        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정 하세요 -->
        <c:import url="../temps/footer.jsp"></c:import>

    </body>
</html>
