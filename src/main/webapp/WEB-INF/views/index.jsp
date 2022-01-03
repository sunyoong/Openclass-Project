<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<style>
header {
	position: fixed;
	width:100%;
	height:100%;
	background-color: brown;
	font-size:20px;
	display:auto:
	flex-shrink:1;
}

</style>



</head>
<body>
<header>
<div class="container-fluid d-flex align-items-center">
<!-- 클래스 아이콘, 메뉴선택  -->
<div class="grid">
<div class="grid d-flex" style="bs-column : 12;">
<div class="g-col-6 pr-3">CLASSMATE</div>
<div class="g-col-4">클래스</div>
</div>

</div>
<div class="d-flex"> 
<input type="text" class="form-control" placeholder="Search" style="font-size:15px;">
<button class="btn btn-light" style="mr-3">확인</button>
</div>

</div>


</header>
<section>



</section>

<section>



</section>


<footer>







</footer>



<c:if test="${sessionScope.loginId eq 'admin111'}">
<a href="/member/admin">관리자 페이지</a>
<a href="/member/paging">회원목록</a>
</c:if>

<c:if test="${sessionScope.loginId != null}">
<a href="/member/logout">로그아웃</a>
<a href="/member/mypage?m_number=${sessionScope.memberNum}">마이페이지</a>
<a href="/product/index?m_number=${sessionScope.memberNum}">클래스</a>
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