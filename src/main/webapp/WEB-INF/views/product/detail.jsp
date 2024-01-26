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
                <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Detail</span></h1>
         </div>
 		<!-- Page content-->
            <section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-4 py-5 px-4 px-md-5">
                        <div class="text-center mb-5">
                            <div class="feature bg-primary bg-gradient-primary-to-secondary text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                            <h1 class="fw-bolder">PRODUCT Detail</h1>
                            <p class="lead fw-normal text-muted mb-0">Let's work together!</p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">                             
                                <form id="addForm" action="" method="post" enctype="multipart/foam-data" >
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="productNum" name="productNum" type="hidden" value="${dto.productNum}" />   
                                     
                                                                        
                                    <!-- 상품명 input-->
                                    
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="productName" name="productName" type="text" placeholder="상품명을 입력하세요" readonly />
                                        <label for="productName">${dto.productName}</label>
                                        
                                    </div>                                  
                                  
                                       <!-- 이자율  input-->
                                   <div class="form-floating mb-3">
                                        <input class="form-control" id="rate" name="productRate" type="text" placeholder="이자율" readonly/>
                                        <label for="rate">${dto.productRate}</label>
                                      
                                    </div> 
                                     <!-- 점수  input-->
                                   <div class="form-floating mb-3">
                                        <input class="form-control" id="rate" name="productJumsu" type="text" placeholder="이자율" readonly/>
                                        <label for="rate">${productJumsu}</label>
                                       
                                    </div>                                 
                                    <!-- detail input-->
                                    <div class="form-floating mb-3">
                                        <textarea class="form-control" id="productContents" name="productContents" type="text" placeholder="상품 상세 설명" style="height: 10rem" readonly></textarea>
                                        <label for="productContents">${productContents}</label>
                                        
                                    </div>  
                                        <!-- 이자율  input-->                                  
                                    
                                    <!-- Submit success message-->
                                    <!---->
                                    <!-- This is what your users will see when the form-->
                                    <!-- has successfully submitted-->
                                    <div class="d-none" id="submitSuccessMessage">
                                        <div class="text-center mb-3">
                                            <div class="fw-bolder">Form submission successful!</div>
                                            To activate this form, sign up at
                                            <br />
                                            <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
                                        </div>
                                    </div>
                                    <!-- Submit error message-->
                                    <!---->
                                    <!-- This is what your users will see when there is-->
                                    <!-- an error submitting the form-->
                                    <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
                                    <!-- Submit Button-->                                    
                                </form>
                                     
				                <div>
				                	<a href="/account/add?productNum=${dto.productNum}" class="btn btn-danger">계좌개설</a>
				                </div>	
				                <div>
				                	<button type="button" id="add">관심상품</button>
				                </div>	
                            </div>
                        </div>
                        
                        <!--reply  -->
                        <form id=replyList>
                        <table class="table table-hover">
								<thead>
									<tr class="table-dark">																			
										<th>Date</th>
										<th>Writer</th>
										<th>Contents</th>
										<th>replyJumsu</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${replyList.size()==0 }">
										<tr>
											<td colspan="5">없음.</td>
										</tr>
									</c:if>
									<c:forEach items="${replyList}" var="r">					
										
											<tr>																							
												<td>${r.replyDate}</td>
												<td>${r.userName}</td>
												<td>${r.replyContents}</td>
												<td>${r.replyJumsu}</td>
											</tr>
									
									</c:forEach>
								</tbody>
							</table>
                        </form>
                        
                        
                        
                    <form name="formReply">
                        <input class="form-control" name="productNum" type="hidden" value="${dto.productNum}" />
                        <div class="mb-3">
                            <label for="replyContents" class="form-label">Example textarea</label>
                            <textarea class="form-control" name="replyContents" id="replyContents" rows="3"></textarea>
                        </div>
                        <div class="my=3">
                          <select class="form-select" id="replyJumsu" name="replyJumsu" aria-label="Default select example">
                            <option selected>점수</option>
                            <option value="5">5</option>
                            <option value="4">4</option>
                            <option value="3">3</option>
                            <option value="2">2</option>
                            <option value="1">1</option>
                          </select>
                        </div>
                        <div>
                            <button type="button" class="btn btn-primary" id="replyAddBtn">댓글달기</button>
                        </div>
                    </form>
                    </div>
                </div>
            </section>       
        </main> 
        <script src="/resources/js/commons/product/productDetail.js"></script>
        <c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
