<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>search.jsp</h2>
<!-- 검색기능 -->
<form action="/product/search" method="get">
<!-- 검색분류 -->
<select name="searchType">
<!-- <option value="m_id" value="p_name">전체</option> -->
<option value="m_id">멘토</option>
<option value="p_name">클래스명</option>
</select>
<!-- 검색어입력 -->
<input type="text" name="keyword" placeholder="검색어를 입력하세요"> 
<input type="submit" value="검색">
</form>


</body>
</html>