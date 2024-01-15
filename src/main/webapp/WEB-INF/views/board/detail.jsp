<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Board detail</span></h1>
            </div>
	
            <div class="row gx-5 justify-content-center">
                <div class="col-lg-11 col-xl-9 col-xxl-8">
        		   <!--1-->
                      <div class="card overflow-hidden shadow rounded-4 border-0 mb-5">
                          <div class="card-body p-0">
                              <div class="d-flex align-items-center">
                                 
                                  <div class="p-5">
                                      <h2 class="fw-bolder">${boardDTO.boardName}</h2>
                                      <div>
                                      	${boardDTO.boardContents}
                                      </div>
                                  </div>                                  
                                 
                              </div>
                          </div>
                      </div>                
                </div>
            </div> 
            
             				
        </main> 
        <c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
