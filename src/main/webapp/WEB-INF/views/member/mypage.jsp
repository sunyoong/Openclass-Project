<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>mypage.jsp</h2>
<a href="/member/update?m_number=${sessionScope.memberNum}">내정보 수정</a>
<a href="/member/order">결제내역 확인</a>

</body>
</html>