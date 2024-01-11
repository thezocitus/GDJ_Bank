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
<title>Product</title>
</head>
<body>
	<h1>Product Detail</h1>
	<!-- <table>
		PRODUCTNUM,PRODUCTNAME,PRODUCTCONTENTS,PRODUCTRATE,PRODUCTJUMSU,FILENUM,FILENAME,ORIGNAME
		
	</table> -->
	
	<h3>${requestScope.DTO.productNum}</h3>
	<h3>${requestScope.DTO.productName}</h3>
	<h3>${requestScope.DTO.productContents}</h3>
	<h3>${requestScope.DTO.productRate}</h3>
	<h3>${requestScope.DTO.productJumsu}</h3>
	<div>
		<h2>FIles</h2>
		<c:forEach items="${dto.productFileDTOs}" var="f">
			<a href="/resources/upload/products/${f.fileName}">${f.origName}</a>
		</c:forEach>
	</div>
	
	
	
	<a href="">Update</a>
			
			<!-- regions/update get:form -->
			<button id="up" data-region-id="${dto.region_id}">Update</button>
			

 			<button id="del">Delete</button>
 			<button id="test">test</button>
 			<form id="frm" action="./delete" method="post">
 				<input type="hidden" name="region_id" value="${dto.region_id}"> 
 			</form>
 			
 			<c:if test="${dto != null }">
 			<h3>${dto.region_id}</h3>
 			<div>${dto.region_name}</div>
 			<div>
 				<h2>FILE</h2>
 				<c:forEach items="${dto.regionFileDTOs}" var="f">
 				<a href="/resources/upload/regions/${f.fileName}">${f.origName}</a>
 				</c:forEach>
 			</div>
 			
			<a href="">Update</a>
			
			<!-- regions/update get:form -->
			<button id="up" data-region-id="${dto.region_id}">Update</button>
			

 			<button id="del">Delete</button>
 			<button id="test">test</button>
 			<form id="frm" action="./delete" method="post">
 				<input type="hidden" name="region_id" value="${dto.region_id}"> 
 			</form>
 			</c:if>
 			<c:if test="${empty dto} ">
 			<h3>없는 번호  입니다.</h3>
 			</c:if>
	
	


	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>