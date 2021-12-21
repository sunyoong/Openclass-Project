<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
function pwCheck(){
	/* 비밀번호 일치여부 */
	const pw = document.getElementById('m_password').value;
	const pw-ck = document.getElementById('pw-ck-result');
	const DBpw = ${member.getM_password};
	$.ajax({
		type: 'post',
		url: '/member/pwResult',
		data: {"m_password" : pw},
		dataType: 'text',
		success: function(result){
			console.log("result : " + result);
			if(result=="o"){
				pw-ck.innerHTML = '비밀번호 일치';
				
			} else{
				pw-ck.innerHTML = '비밀번호 불일치';
			}
		},
		error: function(){
			console.log("오타입니다");
		}
		
	})
	
	
	}

</script>
</head>
<body>
<h2>member/update.jsp</h2>
${member}

<form action="/member/update" method="post">
<input type="hidden" name="m_number" id="m_number">
아이디 : <input type="text" name="m_id" id="m_id" value="${member.m_id}" onblur="idck()" readonly><br>
비밀번호 : <input type="password" name="m_password" id="m_password" onblur="pwCheck()">
<span id="pw-ck-result"></span>
새로운 비밀번호 : <input type="password" name="new-password">
이름 : <input type="text" name="m_name" value="${member.m_name}" readonly><br>
이메일 : <input type="text" name="m_email" value="${member.m_email}"><br>
전화번호 : <input type="text" name="m_phone" value="${member.m_phone}"><br>
<input type="submit" value="수정">
</form>


</body>
</html>