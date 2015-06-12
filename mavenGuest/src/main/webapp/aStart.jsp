<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="root" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${root}">기본제공 홈 컨트롤러</a>
	<br/>
	<a href="${root}/guest/test.do">페이지 테스트</a>
	<br/>
	
	<a href="${root }/guest/write.do">방명록</a>
	<br/>
	<img alt="" src="${root }/img/Penguins.jpg" width="100" height="200">
	<br/>
	
	<img alt="" src="${root }/resources/Penguins.jpg" width="100" height="200">
	
</body>
</html>