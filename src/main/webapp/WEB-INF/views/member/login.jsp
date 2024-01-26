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
                <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Login</span></h1>
         </div>
 		<!-- Page content-->
            <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-4 py-5 px-4 px-md-5">
                        <div class="text-center mb-5">
                            <div class="feature bg-primary bg-gradient-primary-to-secondary text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                            <h1 class="fw-bolder">Welcome To MUNG'S LALD</h1>
                            <p class="lead fw-normal text-muted mb-0">Let's work together!</p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                            	<div>
                            		${msg}
                            	</div>
                                 
                                <form id="addForm" action="login" method="post" enctype="multipart/form-data">
                                 <!-- username : id  -->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="userName" name="userName" type="text" value="a" placeholder="아이디를 입력하세요" />
                                        <label for="userName">아이디를 입력하세요</label>
                                        <div class="invalid-feedback" data-sb-feedback="productName:required">아이디를 입력하세요</div>
                                    </div>                                  
                                  
                                       <!-- password  input-->
                                   <div class="form-floating mb-3">
                                        <input class="form-control" id="rate" name="password" type="password" value="a" placeholder="password" />
                                        <label for="password">비밀번호</label>
                                        <div class="invalid-feedback"data-sb-feedback="password:required" >password</div>
                                    </div> 
                                   
                                  
                                    <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button></div>
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
