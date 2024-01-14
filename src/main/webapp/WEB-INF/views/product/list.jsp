<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">	
    <head>
    <meta charset="UTF-8">
    
   <c:import url="../temps/header.jsp"></c:import>	
   <c:import url="../temps/head_css.jsp"></c:import> 
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
 		<div class="container px-5 my-5">
 			 <div class="text-center mb-5">
                <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Products</span></h1>
             </div>
              <body class="d-flex flex-column h-100 bg-light">
        <main class="flex-shrink-0">
         
            <!-- Page Content-->
            <div class="container px-5 my-5">              
                <div class="row gx-5 justify-content-center">
                    <div class="col-lg-11 col-xl-9 col-xxl-8">
                        <!-- Experience Section-->
                        <section>
                            <div class="d-flex align-items-center justify-content-between mb-4">
                                <h2 class="text-primary fw-bolder mb-0">List</h2>                            
                            </div>
                            <!-- Experience Card 1-->
                            <div class="card shadow border-0 rounded-4 mb-5">
                                <div class="card-body p-5">
                                	<c:forEach items="${list}" var="dto">
                                    <div class="row align-items-center gx-5">
                                        <div class="col text-center text-lg-start mb-4 mb-lg-0">
                                            <div class="bg-light p-4 rounded-4">
                                                <div class="text-primary fw-bolder mb-2">${dto.productNum},  ${dto.productName}</div>
                                                <div class="small fw-bolder">이율 : ${dto.productRate}</div>
                                                <div class="small text-muted">${dto.productCount}</div>
                                                <div class="small text-muted">${dto.productJumsu}</div>
                                            </div>
                                        </div>
                                        <div class="col-lg-8"><div>${dto.productContents}</div></div>
                                    </div>
                                	</c:forEach>
                                </div>
                            </div>                            
                        </section>              
                        
                        <!-- Divider-->
                        <div class="position-absolute start-50 translate-middle">
                        		<nav aria-label="Page navigation example" >
									  <ul class="pagination">
									  <c:if test="${!pager.start}"> 
									    <li class="page-item">									     
									      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
									        <span aria-hidden="true">&laquo;</span>
									      </a>									      
									    </li>
									    </c:if>
									    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
										    <li class="page-item"><a class="page-link" href="./list?page=${i}" >${i}</a></li>			    
									    </c:forEach>
									    <c:if test="${!pager.last}">
										    <li class="page-item">
										      <a class="page-link" href="./list?page=${pager.lastNum+1}" aria-label="Next">
										        <span aria-hidden="true">&raquo;</span>
										      </a>
										    </li>
										 </c:if>
									  </ul>
								</nav>                        
                        </div>                        
                    </div>
                </div>
            </div>
        </main>
      
   
    </body>
	
    
    
             <div>
             	<a href="add">상품등록</a>
             </div>
 
 			
 		
 
        </main> 
        <c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
