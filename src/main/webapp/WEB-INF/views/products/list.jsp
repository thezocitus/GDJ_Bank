<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<%
 System.out.println("LIST");
%>
<!DOCTYPE html>
<c:import url="../temps/bootStrap_css.jsp"></c:import>
<html>
<head>
<c:import url="../temps/header.jsp"></c:import>
<meta charset="UTF-8">
<title>Products</title>

</head>
<body>
	<table class="table table-success table-striped">
		<thead>
			<tr>
				<td>PRODUCT_NUM</td>
				<td>PRODUCT_NAME</td>
				<td>PRODUCT_CONTENTS</td>
				<td>PRODUCT_RATE</td>
				<td>PRODUCT_JUMSU</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
				 	<td>${pageScope.dto.productNum}</td>
				 	<td><a href="./detail?productNum=${pageScope.dto.productNum}">${pageScope.dto.productName}</a></td>
				 	<td>${pageScope.dto.productContents}</td>
				 	<td>${pageScope.dto.productRate}</td>
				 	<td>${pageScope.dto.productJumsu}</td>
			</c:forEach>			
		</tbody>
	</table>
	<div>	
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <c:if test="${!pager.start}">
				    <li class="page-item">
				      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			    </c:if>
			    
		   <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    <li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
		   </c:forEach>
		   
		   
	 		 <c:if test="${!pager.last}">
				<li>
			      <a class="page-link" href="./list?page=${pager.lastNum+1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
		    </c:if>
		  </ul>
		</nav>	
	</div>
	
	<a href="add" class="btn btn-outline-primary" role="button">ADD</a>
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>