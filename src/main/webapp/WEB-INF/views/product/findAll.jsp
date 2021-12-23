<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script>

	const hits = document.getElementById('hits-list');
	

</script>
</head>
<body>
<h2>product/findAll.jsp</h2>
${productList}<br>
${paging}
<select name="list">
<option value="" selected></option>
<option value="hits" id="hits-list">조회수</option>
<option value="satisfy" id="satis-list">만족도순</option>
<option value="resisNum" id="resis-list">수강인원</option>
<option value="recommend" id="recom-list">추천수</option>
</select>
<table class = "table" id="classList">
	<tr>
		<th>번호</th>
		<th>멘토</th>
		<th>클래스이름</th>
		<th>클래스내용</th>
		<th>클래스가격</th>
		<th>시작일</th>
		<th>종료일</th>
		<th>할인율</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.p_number}</td>
			<td>${product.m_id}</td>
			<td><a href="/product/detail?p_number=${product.p_number}&page=${page}">${product.p_name}</a></td>
			<td>${product.p_contents}</td>
			<td>${product.p_price}</td>
			<td>${product.p_startDate}</td>
			<td>${product.p_endDate}</td>
			<td>${product.p_discount}</td>
			<td>${product.p_hits}</td>
			<td>${product.p_satisfy}</td>
			<td>${product.p_resisNum}</td>
			<td>${product.p_recommend}</td>
		</tr>	
	</c:forEach>
</table>

<!-- 페이징처리 -->
<div>
<c:choose>
<c:when test="${paging.page<=1}">
	[이전]&nbsp;
</c:when>
<c:otherwise>
	<a href="/product/paging?page=${paging.page-1}">[이전]</a>&nbsp;
</c:otherwise>
</c:choose>

<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
<c:choose>
<c:when test="${i eq paging.page}">
	${i}
</c:when>
<c:otherwise>
	<a href="/product/paging?page=${i}">${i}</a>
</c:otherwise>
</c:choose>
</c:forEach>


<c:choose>
<c:when test="${paging.page>=paging.maxPage}">
	[다음]&nbsp;
</c:when>
<c:otherwise>
	<a href="/product/paging?page=${paging.page+1}">[다음]</a>&nbsp;
</c:otherwise>
</c:choose>

</div>






</body>
</html>