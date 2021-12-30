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
	/* 추천하기 */
	function recomBtn(){
		console.log('recomBtn버튼');
		const recommend = "${product.p_recommend}";
		console.log("recommend:" + recommend);
		const number = "${product.p_number}";
		console.log(number);
		const recomResult = document.getElementById("recomResult");
		console.log(recomResult);
		$.ajax({
			type: 'post',
			url:'/product/recommend',
			data: {"p_number": number},
			dataType: "json",
			success: function(product){
				console.log('성공');
				console.log(product.p_recommend);
				recomResult.innerHTML = product.p_recommend;
				
			},
			error: function(){
				console.log('실패');
			}
			
		});
		
		
		
		
	}
	
	
	
	/* 별점 */
	function stars(){
	console.log("stars");
	const ratingResult = document.getElementById("rating").value;
	const p_number = "${product.p_number}";
	
	$.ajax({
		type: "get",
		url:"/product/rating",
		data: {"p_satisfy" : ratingResult, "p_number" : p_number},
		dataType: "text",
		success: function(result){
			console.log("ajax성공");
			console.log(result);
		},
		error: function(){
			console.log("오타가 있나봄..");
		}
		
	})
	
}
	
	
	/* 수강신청 */
	
/* 	function apply(){
		console.log('function resist()');
		const p_applyNum = "${product.p_applyNum}";
		const p_number = "${product.p_number}";
		$.ajax({
			type:"post",
			url:"/product/applyNum",
			data: {"p_applyNum" : p_applyNum, "p_number" : p_number},
			dataType: "text",
			success : function(result){
				console.log("result : " + result);
			},
			error: function(){
				console.log("오타입니다");
			}
			
			
			
			
		})
		
		
		
		
		
	}
	 */
	
</script>



</head>
<body>
<h2>product/detail.jsp</h2>
로그인 회원 :${sessionScope.memberNum}
<a href="/product/paging?page=${page}">목록으로</a>
${product}
<a href="/product/applyform?p_number=${product.p_number}&m_number=${sessionScope.memberNum}">수강하기</a> 
<!-- 추천하기 -->
<button onclick="recomBtn()">추천하기</button>

<!-- 만족도 -->
<select id="rating" onchange="stars()">
<option disabled>만족도</option>
<option value="1">★</option>
<option value="2">★★</option>
<option value="3">★★★</option>
<option value="4">★★★★</option>
<option value="5">★★★★★</option>
</select>


<!-- 수강인원 -->

<table>
	<tr>
		<th>게시글번호</th>
		<th>회원번호</th>
		<th>멘토</th>
		<th>클래스이름</th>
		<th>클래스내용</th>
		<th>클래스가격</th>
		<th>클래스시작일</th>
		<th>클래스종료일</th>
		<th>조회수</th>
		<th>할인율</th>
		<th>만족도</th>
		<th>수강인원</th>
		<th>추천수</th>
	</tr>
	<tr>
		<td>${product.p_number}</td>
		<td>${product.m_number}</td>
		<td>${product.m_id}</td>
		<td>${product.p_name}</td>
		<td>${product.p_contents}</td>
		<td>${product.p_price}</td>
		<td>${product.p_startDate}</td>
		<td>${product.p_endDate}</td>
		<td>${product.p_hits}</td>
		<td>${product.p_discount}</td>
		<td id="satisfy">${product.p_satisfy}</td>
		<td id="applyNum">${product.p_applyNum}</td>
		<td id="recomResult">${product.p_recommend}</td>
	</tr>	
</table>
${applyList}
<a href="/apply/applymember?p_number=${product.p_number}">신청 회원목록</a>


<!-- 댓글등록 -->


<div id="replyId">
작성자 : ${sessionScope.loginId}
<input type="hidden" name="m_id" value="${sessionScope.loginId}" readonly>
<input type="text" name="r_contents" id="r_contents">
<button onclick="write1()">작성</button>
</div>
<div id="replyList">
<table class="table">
<tr> 
	<th>클래스번호</th>
	<th>회원번호</th>
	<th>작성자</th>
	<th>내용</th>
	<th>작성시간</th>
</tr>

<c:forEach items="${replyList}" var="reply">
<tr>
<td>${reply.p_number}</td>
<td>${reply.m_number}</td>
<td>${reply.m_id}</td>
<td>${reply.r_contents}</td>
<td>${reply.r_date}</td>
</tr>
</c:forEach>
</table>
</div>




</body>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function write1(){
		const R_contents = document.getElementById("r_contents").value;
		console.log(R_contents);
		const P_number = "${product.p_number}";
		console.log(P_number);
		const M_id = "${sessionScope.loginId}";
		console.log(M_id);
		const M_number = "${sessionScope.memberNum}";
		console.log(M_number);
		
		let replyList = document.getElementById("replyList");
		
		$.ajax({
			type:'post',
			url: '/reply/save',
			data: {"r_contents" : R_contents, "m_number": M_number, "p_number":P_number, "m_id": M_id},
			dataType: "json",
			success:function(result){
				console.log('성공');
				console.log(result);
				let output="<table class=table>";
				output += "<tr>";
				output += "<th>클래스번호</th><th>회원번호</th><th>작성자</th><th>내용</th><th>작성시간</th>";
				output += "</tr>";
				$.each(result,function(i){
				output += "<tr>";
				/* output += "<td>" + (i+1)+ "</td>"; // 번호 */
				output += "<td>" + result[i].p_number+"</td>";
				output += "<td>" + result[i].m_number+"</td>";
				output += "<td>" + result[i].m_id+"</td>";
				output += "<td>" + result[i].r_contents+"</td>";
				output += "<td>" + result[i].r_date+"</td>";
				output += "</tr>";
			}),
			output +="</table>";
			replyList.innerHTML = output;
			},
			error: function(){
				console.log('실패');
			}
			
			
			
		});
		
		
		
		
		
		
		
		
	}
	

</script>




</html>