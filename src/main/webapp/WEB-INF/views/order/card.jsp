<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
function iamport(){
	// 넘겨줄 데이터 + 화면에 표시할 데이터
	const p_name = document.getElementById("p_name").value;
	//가맹점 식별코드
	IMP.init('imp76008143');
	IMP.request_pay({
	    pg : 'kakaopay',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : p_name, //결제창에서 보여질 이름
	    amount : '30000', //실제 결제되는 가격
	    buyer_email : 'iamport@siot.do',
	    buyer_name : 'm_id',
	   buyer_tel : '11111',
	    buyer_addr : '서울 강남구 도곡동',
	    buyer_postcode : '123-456' 
	}, function(rsp) {
		console.log(rsp);
	    if ( rsp.success ) {
	    	var msg = '결제가 완료되었습니다.';
	        msg += '고유ID : ' + rsp.imp_uid;
	        msg += '상점 거래ID : ' + rsp.merchant_uid;
	        msg += '결제 금액 : ' + rsp.paid_amount;
	        msg += '카드 승인번호 : ' + rsp.apply_num;
	    } else {
	    	 var msg = '결제에 실패하였습니다.';
	         msg += '에러내용 : ' + rsp.error_msg;
	    }
	    alert(msg); 

});
}
</script>
</head>
<body>
<h2>card</h2>
<a href="/product/paging">목록</a>
<input type="hidden" name="p_name" id="p_name" value="${order.p_name}">
<button onclick="iamport()">결제하기</button>
${order}

</body>
</html>