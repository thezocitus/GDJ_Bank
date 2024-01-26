<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div>
		<button id="more" data-replyList-page="#{pager.page}">#{pager.page}/#{pager.lastPage}</button>
	</div>
	
	
</table>