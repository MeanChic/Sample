<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="root" value="${pageContext.request.contextPath }"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>방명록 쓰기</title>
	<script type="text/javascript" src="${root }/css/guest/script.js"></script>
	<link href="${root }/css/guest/style.css" rel="stylesheet" type="text/css"/>
	</head>
<body>
	<jsp:include page="../template/top.jsp"/>
	<jsp:include page="../template/left.jsp"/>
	<c:set var="root" value="${pageContext.request.contextPath }"/>
	
	<div align="center">
		<c:if test="${count==0 || currentPage==1}">
			<form class="form_style" action="${root }/guest/write.do" method="post"  onsubmit="return formCheck(this)">
				<div class="title">
					<label>이름</label>
					<input type="text" name="name" size="12"/>&nbsp;&nbsp;&nbsp;&nbsp;
					
					<label>비밀번호</label>
					<input type="password" name="password"/>
				</div>
				
				<div class="content">
					<textarea rows="5" cols="55" name="message"></textarea>
				</div>
				
				<div class="title" style="text-align:right;" >
					<input type="submit" value="확인"/>
					<input type="reset" value="취소"/>
				</div>
			</form>
		</c:if>

	<!-- WriteAction에서 (현재 페이지에 해당하는 게시물들을 DB로부터 ArrayList에 담아서) request에 담겨서 넘어왔다. -->
	<!--  리스트 -->
	<c:if test="${count>0 }">
		<c:forEach var="guest" items="${list }">
			<div class="form_style" style="height:130px;">
				<div class="disp" style="border-width:1px;">
					${guest.name } &nbsp;
					<fmt:formatDate value="${guest.writeDate }" type="date"/> &nbsp;&nbsp;
					
					<a href="${root }/guest/update.do?num=${guest.num}&pageNumber=${currentPage}">수정</a>
					<a href="javascript:deleteCheck('${root}/guest/delete.do?num=${guest.num}&pageNumber=${currentPage}')">삭제</a>
				</div>
										
				<div class="disp-content">
					${guest.message }
				</div>
			</div>
			<br/>
		</c:forEach>
	</c:if>
	
	<!-- 페이지 번호 -->
	<center>
		<c:if test="${count>0 }">
		
				<%-- 한 페이지에서 이동가능한 페이지 개수 [1][2][3]...[10] --%> 
			<c:set var="pageBlock" value="${3 }"/>	
				
				<%-- 총페이지 번호 --%>
			<c:set var="pageCount" value="${count/boardSize+(count%boardSize==0?0:1) }"/>	
				
				<%-- 시작 페이지 번호 --%>
			<fmt:parseNumber var="rs" value="${((currentPage-1)/pageBlock) }" integerOnly="true"/>	<%--((currentPage-1)/pageBlock)의 결과값을 int로 형변환하기위해 parseNumber를 사용  --%>
			<c:set var="startPage" value="${rs*pageBlock+1 }"/>	
				
				<%-- 끝 페이지 번호 --%>
			<c:set var="endPage" value="${startPage+pageBlock-1 }"/>	
			<c:if test="${endPage > pageCount }">
				<c:set var="endPage" value="${pageCount }"/>
			</c:if>
			<%------------------------------------------------------------------ --%>
			<c:if test="${startPage>pageBlock }">
				<a href="${root }/guest/write.do?pageNumber=${startPage-pageBlock }">[이전]</a>
			</c:if>
			
			<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<a href="${root }/guest/write.do?pageNumber=${i}">[${i }]</a>
			</c:forEach>
			
			<c:if test="${endPage<pageCount }">
				<a href="${root }/guest/write.do?pageNumber=${startPage+pageBlock }">[다음]</a>
			</c:if>
			
		</c:if>
	</center>
	</div>
</body>
</html>
