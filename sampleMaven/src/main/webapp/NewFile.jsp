<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${root}">dd</a>
	
	<a href = "${root }/address/write.do">주소록 작성</a>	&nbsp;&nbsp;
	
	<a href = "${root }/address/select.do">주소록 검색</a>	&nbsp;&nbsp;
	
	<a href = "${root }/address/delete.do">주소록 삭제</a> &nbsp;&nbsp;
	
	<a href = "${root }/address/update.do">주소록 수정</a> &nbsp;&nbsp;
</body>
</html>