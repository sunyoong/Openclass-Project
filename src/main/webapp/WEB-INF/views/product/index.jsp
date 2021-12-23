<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>product/index.jsp</h2>
${sessionScope.memberNum}
<a href="/product/myclass?m_number=${sessionScope.memberNum}">마이클래스</a>
<a href="/product/paging?page=${page}">클래스 목록</a>


</body>
</html>