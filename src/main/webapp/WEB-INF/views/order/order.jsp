<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>

</script>
</head>
<body>
<h2>order.jsp</h2>
${member}

<h2>수강신청</h2>
<form action="/order/save?m_number=${sessionScope.memberNum}" method="post" name="order_form">
<input type="hidden" name= "m_number" value="${sessionScope.memberNum}">
<input type="hidden" name= "p_number" value="${product.p_number}">
<input type="hidden" name= "m_id" value="${sessionScope.loginId}">
주문정보 : <input type="text" name="p_name" value="${product.p_name}" readonly>;
결제금액 : <input type="text" name="p_price" value="${product.p_price}" readonly>;
최종가격 : <input type="text" name="p_price" value="${product.p_price}" readonly>;
<input type="radio" id="card1" name="o_payment" value="card" >카드
<input type="radio" id="cash1" name="o_payment" value="cash" >현금
<input type="submit" value="다음">

</form>


</body>
</html>