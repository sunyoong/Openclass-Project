<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> payment.jsp</h2>
${order}
주문번호 : ${order.o_number}
<input type="button" name="card" onclick="card()" value="카드">
<input type="button" name="cash" onclick="cash()" value="현금">
 
</body>
</html>