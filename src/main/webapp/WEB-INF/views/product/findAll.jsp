<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
/* 	function select1(){
		select1.submit();
	}
 */
	 function select1(){
		console.log("ㅎㅇ");
		const select1 = $("#sort option:selected").val();
		const classList = document.getElementById("classList");
		console.log(select1);
	$.ajax({
			type:"get",
			url:"/product/selectList",
			data: {"select": select1},
			dataType:"json",
			success:function(result){
				console.log('성공');
				console.log(result);
				
				let output="<table class=table>";
				output += "<tr>";
				output += "<th>번호</th><th>멘토</th><th>클래스이름</th><th>클래스내용</th><th>클래스가격</th><th>시작일</th><th>종료일</th><th>할인율</th><th>조회수</th><th>만족도</th><th>수강신청인원</th><th>추천수</th><th>삭제</th><th>수정</th>";
				output += "</tr>";
				$.each(result,function(i){
				output += "<tr>";
				output += "<td>" + result[i].p_number + "</td>";
				output += "<td>" + result[i].m_id + "</td>";
				output += "<td>" + result[i].p_name + "</td>";
				output += "<td>" + result[i].p_contents + "</td>";
				output += "<td>" + result[i].p_price + "</td>";
				output += "<td>" + result[i].p_startDate + "</td>";
				output += "<td>" + result[i].p_endDate + "</td>";
				output += "<td>" + result[i].p_discount + "</td>";
				output += "<td>" + result[i].p_hits + "</td>";
				output += "<td>" + result[i].p_satisfy + "</td>";
				output += "<td>" + result[i].p_applyNum + "</td>";
				output += "<td>" + result[i].p_recommend + "</td>";
				/* output += "<td>" + <a href="/product/delete?p_number=${product.p_number}">삭제</a> + "</td>";
				output += "<td>" + <a href="/product/update?p_number=${product.p_number}">수정</a> + "</td>";
				 */
				 output += "</tr>";
				});
				output+= "</table>";
				classList.innerHTML = output;
				
			},
			error: function(){
				console.log('실패');
			}
			}); 
			
	} 
</script>
</head>
<body>
<h2>product/findAll.jsp</h2> 
<a href="/">첫화면</a>
로그인 : ${sessionScope.memberNum}<br>
<%-- ${productList}<br><br>
paging : ${paging} --%>
<!-- <form action="selectList1" method="post" name="select1"> -->
<select name="select" id="sort" onchange="select1()">
<option value="" selected></option>
<option value="p_hits">조회수</option>
<option value="p_satisfy">만족도순</option>
<option value="p_applyNum">수강인원</option>
<option value="p_recommend">추천수</option>
</select>
<!-- </form> -->

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
		<th>만족도</th>
		<th>수강신청인원</th>
		<th>추천수</th>
		<th>삭제</th>
		<th>수정</th>
	
		
	</tr>
	<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.p_number}</td>
			<td>${product.m_id}</td>
			<td><a href="/product/detail?p_number=${product.p_number}&page=${paging.page}">${product.p_name}</a></td>
			<td>${product.p_contents}</td>
			<td>${product.p_price}</td>
			<td>${product.p_startDate}</td>
			<td>${product.p_endDate}</td>
			<td>${product.p_discount}</td>
			<td>${product.p_hits}</td>
			<td>${product.p_satisfy}</td>
			<td>${product.p_applyNum}</td>
			<td>${product.p_recommend}</td>
			<!-- 관리자권한 -->
			<c:if test="${sessionScope.loginId eq 'admin111'}">
			<td><a href="/product/delete?p_number=${product.p_number}&page=${paging.page}">삭제</a></td>
			</c:if>
			
			<c:if test="${sessionScope.memberNum == product.m_number}">
			<td><a href="/product/delete?p_number=${product.p_number}">삭제</a></td>
			<td><a href="/product/update?p_number=${product.p_number}">수정</a></td>
			</c:if>
		</tr>	
	</c:forEach>
</table>

<!-- 페이징처리(검색한 목록결과가 null이 아닐경우)-->

<div>
<c:if test="${a != null}">
<c:choose>
<c:when test="${searchpaging.page<=1}">
	[이전]&nbsp;
</c:when>
<c:otherwise>
	<a href="/product/search?page=${searchpaging.page-1}&searchType=${searchType}&keyword=${keyword}">[이전]</a>&nbsp;
</c:otherwise>
</c:choose>

<c:forEach begin="${searchpaging.startPage}" end="${searchpaging.endPage}" var="i" step="1">
<c:choose>
<c:when test="${i eq searchpaging.page}">
	${i}
</c:when>
<c:otherwise>
	<a href="/product/search?page=${i}&searchType=${searchType}&keyword=${keyword}">${i}</a>
</c:otherwise>
</c:choose>
</c:forEach>


<c:choose>
<c:when test="${searchpaging.page>=searchpaging.maxPage}">
	[다음]&nbsp;
</c:when>
<c:otherwise>
	<a href="/product/search?page=${searchpaging.page+1}&searchType=${searchType}&keyword=${keyword}">[다음]</a>&nbsp;
</c:otherwise>
</c:choose>
</c:if>





<c:if test="${a == null}">
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
</c:if>
</div>

</body>
</html>