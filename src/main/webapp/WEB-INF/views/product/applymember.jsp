<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> applymember.jsp </h2>

${applyList}

<a href="/product/detail?p_number=${product.p_number}">클래스로 돌아가기</a>
</body>
</html>