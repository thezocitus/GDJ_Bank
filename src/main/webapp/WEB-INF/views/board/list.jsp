<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<!-- 사용전 경로 수정 -->
<c:import url="../temps/head_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- Navigation-->
		<c:import url="../temps/header.jsp"></c:import>

		<div class="text-center mb-5">
			<h1 class="display-5 fw-bolder mb-0">
				<span class="text-gradient d-inline">${board} List</span>
			</h1>
		</div>

		<div class="row gx-5 justify-content-center">
			<div class="col-lg-11 col-xl-9 col-xxl-8"></div>
		</div>
		<!-- table  -->
		<table class="table table-hover">
			<thead>
				<tr class="table-dark">
					<th>No</th>
					<th>Title</th>
					<th>Writer</th>
					<th>Contents</th>
					<th>Date</th>
					<th>Hit</th>
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
						<c:set var="f" value="${dto.flag}"></c:set>
						<c:if test="${f==1}">
							<tr>
								<td>${dto.boardNum}</td>
								<td>삭제됨</td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
						</c:if>
					</c:catch>
					<c:if test="${f==0}">
						<tr>
							<td>${dto.boardNum}</td>

							<td><a href="./detail?boardNum=${dto.boardNum}"> <c:catch>
										<c:forEach begin="1" end="${dto.boardDepth}">
											&emsp;
										</c:forEach>
									</c:catch> ${dto.boardName}
							</a></td>
							<td>${dto.boardWriter}</td>
							<td>${dto.boardContents}</td>
							<td>${dto.boardDate}</td>
							<td>${dto.boardCount}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		<form action="./list" method="get">

			<select class="form-select" name="kind">
				<option value="kind1">Title</option>
				<option value="kind2">Contents</option>
				<option value="kind3">Writer</option>
			</select>

			<div class="input-group mb-3">

				<input type="text" class="form-control" name="search">
				<button class="btn btn-outline-secondary" type="submit">검색</button>

			</div>
		</form>


		<div>
			<a href="./add" class="btn btn-danger">글쓰기</a>
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
					href="./list?page=${pager.lastNum+1}" aria-label="Next"> <span
						aria-hidden="true">&raquo;</span>
				</a></li>
			</ul>
		</nav>

	</main>
	<c:import url="../temps/footer.jsp"></c:import>
</body>

</html>
