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
<h2> index.jsp</h2>



<a href="/member/paging">회원목록</a>
<a href="/member/save">회원가입</a>
<a href="/member/login">로그인</a>
<a href="/member/logout">로그아웃</a>
<a href="/member/mypage?m_number=${sessionScope.memberNum}">마이페이지</a>
member : ${member}
loginUser : ${sessionScope.loginUser}
login-member-Num : ${sessionScope.memberNum}
loginId : ${sessionScope.loginId}

</body>
</html>