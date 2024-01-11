<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
 System.out.println("PRODUCT_ADD");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../temps/bootStrap_css.jsp"></c:import>
<title>Products Add</title>
</head>
<header>
<c:import url="../temps/header.jsp"></c:import>
<c:import url="../temps/bootStrap_js.jsp"></c:import>
</header>
<body>
	<section id="container" class="container-fluid">
	 	<div class="row" class="mb-4">
	 		<form action="add" method="post" enctype="multipart/form-data"> <!-- enctype="multipart/form-data" -->
				<!-- enctype="multipart/form-data" 데이터 쪼개어 보내기 -->				
				  <div class="mb-3">
				    <label for="productName" class="form-label">상품명</label><!--Product Name  -->
				    <input type="text" name="productName" class="form-control" id="productName">
				  </div>
				  <div class="mb-3">
				    <label for="productContents" class="form-label">상품설명</label> <!-- Product Contants -->
				     <textarea class="form-control" name="productContents" id="productContents" rows="3"></textarea>
				  </div>	
				   <div class="mb-3">
				    <label for="productRate" class="form-label">상품 이자율</label><!-- PRODUCTRATE -->
				    <input type="text" name="productRate" class="form-control" id="productRate">
				  </div>
				   <div class="mb-3">
				    <label for="productJumsu" class="form-label">상품 평점</label><!-- PRODUCTJUMSU -->
				    <input type="text" name="productJumsu" class="form-control" id="productJumsu">
				  </div>
					<div class="mb-3">
				  			<input type="file" name="photo">
				  			<input type="file" name="photo">
				  			<input type="file" name="photo">				  			
				  	</div>
				   
				  <button type="submit" class="btn btn-primary">ADD</button>
			</form>
	 	</div>
	 </section>
			<script type="text/javascript">
				$('#productContents').summernote()
			</script>


</body>
</html>