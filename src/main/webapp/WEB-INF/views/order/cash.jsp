<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>cash.jsp</h2>
<h2>무통장입금</h2>
<form action="/order/cash-pay?p_number=${order.p_number}" method="post">
총결제금액 : ${order.p_price}
<h3>결제정보</h3> 
입금은행<br>
<select name="bank">
<option value="" disabled>선택하세요</option>
<option value="sinhan">신한은행</option>
<option value="nonghyup">농협은행</option>
<option value="kukmin">국민은행</option>
<option value="woori">우리은행</option>
<option value="hana">하나은행</option>
</select><br>

<input type="checkbox" name="rept" value="cashrept">현금영수증발행
<br>
<input type="submit" value="신청하기">
</form>

</body>
</html>