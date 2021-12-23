<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

</script>
<script>
/* 별점 */
	function star(){
	console.log('star');
	
}
</script>


</head>
<body>
<h2>product/detail.jsp</h2>
<a href="/product/paging?page=${page}">목록으로</a>
${product}
<button onclick="recomBtn()">추천하기</button>
<select id="rating" name="stars">
<option value="" selected>만족도</option>
<option value="1">★</option>
<option value="2">★★</option>
<option value="3">★★★</option>
<option value="4">★★★★</option>
<option value="5">★★★★★</option>
</select>

<table>
	<tr>
		<th>게시글번호</th>
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
		<td>${product.m_id}</td>
		<td>${product.p_name}</td>
		<td>${product.p_contents}</td>
		<td>${product.p_price}</td>
		<td>${product.p_startDate}</td>
		<td>${product.p_endDate}</td>
		<td>${product.p_hits}</td>
		<td>${product.p_discount}</td>
		<td>${product.p_satisfy}</td>
		<td>${product.p_resisNum}</td>
		<td id="recomResult">${product.p_recommend}</td>
	</tr>	
</table>
</body>
</html>