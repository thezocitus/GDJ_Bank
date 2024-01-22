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
                <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">MyPage</span></h1>
         </div>
 		<!-- Page content-->
            <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-4 py-5 px-4 px-md-5">
                        <div class="text-center mb-5">
                           
                            <h1 class="fw-bolder">Welcome To MUNG'S LAND</h1>
                            
                            <c:if test="${mem.avatarDTO.fileName == null}">
                            <img src="/resources/assets/Pablobg.png" class="rounded mx-auto d-block" alt="...">
                            </c:if>
                            
                            <c:if test="${mem.avatarDTO.fileName != null}">
                            <img src="/resources/upload/memberFiles/${mem.avatarDTO.fileName}" class="rounded mx-auto d-block" alt="...">
                            </c:if>
                            <p class="lead fw-normal text-muted mb-0">Let's work together!</p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">                             
                                <form id="addForm" action="mypage" method="post" enctype="multipart/form-data">
                                    
                                      <div class="form-floating mb-3">
                                        <input class="form-control" id="name" name="name" type="text" placeholder="name" disabled/>
                                        <label for="name">${mem.name}</label>
                                      
                                    </div>     
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="userName" name="userName" type="text" placeholder="userName" disabled/>
                                        <label for="userName">${mem.userName}</label>
                                     
                                    </div>                                  
                                  
                                       
                                   <div class="form-floating mb-3">
                                        <input class="form-control" id="rate" name="password" type="password" placeholder="password" disabled/>
                                        <label for="password">${mem.password}</label>
                                     
                                    </div> 
                                  
                                   <div class="form-floating mb-3">
                                        <input class="form-control" id="rate" name="phone" type="text" placeholder="phone" disabled/>
                                        <label for="phone">${mem.phone}</label>
                                 
                                    </div>                                 
                                  
                                      <div class="form-floating mb-3">
                                        <input class="form-control" id="rate" name="email" type="email" placeholder="email" disabled/>
                                        <label for="email">${mem.email}</label>
                                      
                                    </div>            
                                   
                                	  <div class="form-floating mb-3">
                                        <input class="form-control" id="rate" name="address" type="text" placeholder="address" disabled/>
                                        <label for="address">${mem.address}</label>
                                       
                                    </div>     
                                    
                                 
                                    <div class="d-none" id="submitSuccessMessage">
                                        <div class="text-center mb-3">
                                            <div class="fw-bolder">Form submission successful!</div>
                                            To activate this form, sign up at
                                            <br />
                                            <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                                        </div>
                                    </div>
                                  
                                    <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
                                    <!-- Submit Button-->                                	
                                	
                                   
                                </form>
                                  <form id="submitButton" action="mypage" method="get" enctype="multipart/form-data">
                                 <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" name="update" type="submit">수정</button></div>
                                 </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>       
        </main> 
        <c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
