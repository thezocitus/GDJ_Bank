<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="UTF-8">
    <!-- 사용전 경로 수정 -->
   <c:import url="../temps/head_css.jsp"/> 
   <c:import url="../temps/summernote.jsp"></c:import>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <c:import url="../temps/header.jsp"></c:import>
 			
 			  <div class="text-center mb-5">
                <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Board ADD</span></h1>
            </div>	
			<!-- boardForm import -->
 			<c:import url="../temps/boardForm.jsp"/>
        </main> 
        <c:import url="../temps/footer.jsp"/>
       
       <script type="text/javascript">
        $("#contents").summernote();
       </script>
    </body>
</html>
