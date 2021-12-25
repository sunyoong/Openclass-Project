<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>product/save.jsp</h2>

<form action="/product/save?m_number=${m_number}" method="post">
<input type="hidden" name="m_number" value=${m_number}>
멘토(작성자) : <input type="text" name="m_id" value="${m_id}" readonly><br>
클래스 이름 : 	<input type="text" name="p_name" ><br>
클래스 내용 : <textarea name="p_contents" row="50"></textarea><br>
클래스 가격 : <input type="text" name="p_price"><br>
클래스 시작일 : <input type="date" name="p_startDate"><br>
클래스 종료일 : <input type="date" name="p_endDate"><br>
<input type="submit" value="등록">
</form>
</body>
</html>