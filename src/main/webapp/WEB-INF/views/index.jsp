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

<c:if test="${sessionScope.loginId eq 'admin'}">
<a href="/member/admin">관리자 페이지</a>
<a href="/member/paging">회원목록</a>
</c:if>

<c:if test="${sessionScope.loginId != null}">
<a href="/member/logout">로그아웃</a>
<a href="/member/mypage?m_number=${sessionScope.memberNum}">마이페이지</a>
<a href="/product/index?m_number=${sessionScope.memberNum}&page=${page}">클래스</a>
<a href="/member/paging">회원목록</a>
</c:if>

<c:if test="${sessionScope.loginId == null}">
<a href="/member/save">회원가입</a>
<a href="/member/login">로그인</a>
</c:if>
member : ${member}
loginUser : ${sessionScope.loginUser}
login-member-Num : ${sessionScope.memberNum}re
loginId : ${sessionScope.loginId}

</body>
</html>