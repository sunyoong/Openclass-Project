<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
function pay(){
	const r = document.querySelector('input[name="paymentType"]:checked').value;
	console.log(r);
	const p_number = document.getElementById("p_number2").value;
	console.log(p_number);
	

	
	console.log(order);
	$.ajax({
		type: "post",
		url: "/order/payment",
		data: {"p_number" : p_number},
		dataType: "json",
		success: function(result){
			console.log("success");
			console.log(result);
		},
		error: function(){
			console.log("오타!");
			
		}
		
	})
}
</script>
</head>
<body>
<h2>order.jsp</h2>
<h2>결제하기</h2>
<form id="order" name="order_form">
<input type="hidden" name= "m_number" id="m_number" value="${product.m_number}">
<input type="hidden" name= "p_number" id="p_number2" value="${product.p_number}">
주문정보 : <input type="text" name="p_name" value="${product.p_name}" readonly>;
결제금액 : <input type="text" name="p_price" value="${product.p_price}" readonly>;
최종가격 : <input type="text" name="p_price" value="${product.p_price}" readonly>;
결제방식 : 
<input type="radio" id="card" name="paymentType" value="card">
<label for="c">카드</label>
<input type="radio" id="cash" name="paymentType" value="cash">
<label for="m">현금</label>

<input type="button" value="결제하기" onclick="pay()">
</form>


</body>
</html>