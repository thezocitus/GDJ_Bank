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
					<th>No</th>
					<th>Title</th>
					<th>Rate</th>
					<th>Contents</th>
					<th>Count</th>
					<th>Jumsu</th>
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
					<c:catch>
						<c:set var="f" value="${dto.productSale}"></c:set>
						<c:if test="${f==0}">
							<tr>
								<td>${dto.productNum}</td>
								<td>삭제됨</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</c:if>
					</c:catch>
					<c:if test="${f==1}">
						<tr>
							<td>${dto.productNum}</td>

							<td><a href="./detail?productNum=${dto.productNum}"> ${dto.productName}
							</a></td>
							<td>${dto.productRate}</td>
							<td>${dto.productContents}</td>
							<td>${dto.productRate}</td>
							<td>${dto.productJumsu}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
      
                
                <div>
                	<a href="add" class="btn btn-danger">상품등록</a>
                </div>		
			</div>
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

    </body>
</html>
