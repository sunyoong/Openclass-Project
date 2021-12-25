<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>update.jsp</h2>
<form action="/product/update?p_number=${product.p_number}" method="post">
<input type="hidden" name="m_number" value="${product.p_number}">
멘토(작성자) : <input type="text" name="m_id" value="${product.m_id}" readonly><br>
클래스 이름 : 	<input type="text" name="p_name" value="${product.p_name}"><br>
클래스 내용 : <textarea name="p_contents" row="50" value="${product.p_contents}"></textarea><br>
클래스 가격 : <input type="text" name="p_price" value="${product.p_price}"><br>
클래스 시작일 : <input type="date" name="p_startDate" value="${product.p_startDate}"><br>
클래스 종료일 : <input type="date" name="p_endDate" value="${product.p_endDate}"><br>
<input type="submit" value="수정">
</form>
</body>
</html>