<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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

</body>
</html>