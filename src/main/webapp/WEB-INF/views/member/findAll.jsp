<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!--c태그 사용을 위한 jstl주소, 리스트는 foreach로 출력 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2>member/findAll.jsp</h2>
<table class ="table table-striped">
<thead>
	<tr class="table-light">
		<th>회원번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>핸드폰번호</th>
		<th>가입날짜</th>
		<th></th>
		<th></th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${memberList}" var="member">
	<tr>
		<td>${member.m_number}</td>
		<td>${member.m_id}</td>
		<td>${member.m_password}</td>
		<td>${member.m_name}</td>
		<td>${member.m_email}</td>
		<td>${member.m_phone}</td>
		<td>${member.m_joindate}</td>
		<td><a href="/member/update?m_number=${member.m_number}">수정</a></td>
		<td><a href="/member/delete?m_number=${member.m_number}">삭제</a></td>
	</tr>	
	</c:forEach>
</tbody>
</table>
${memberList}


</body>
</html>