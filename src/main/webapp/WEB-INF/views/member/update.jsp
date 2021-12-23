<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
function pwck(){
	console.log('pwck 누르면 나오지롱');
	const pw = document.getElementById('m_password').value;
	console.log(pw);
	/* const DBpw = ${member.m_password};
	console.log(DBpw);
	 */
	 const pwckResult = document.getElementById('pwckResult');
	
	$.ajax({
		type: "post",
		url: "/member/pwResult",
		data: {"m_password" : pw},
		dataType: "text",
		success: function(result){
			console.log("ajax성공");
			if(result == "o"){
				pwckResult.innerHTML = '비밀번호가 일치합니다.';
				pwckResult.style.color = 'green';
			} else{
				pwckResult.innerHTML = '비밀번호 불일치';
				pwckResult.style.color = 'red';
			}
		},
		error: function(){
			console.log("오타 찾아요");
		}
		
		
		
		
	})
	
	
	
}
</script>
</head>
<body>
<h2>member/update.jsp</h2>
${member}

<form action="/member/update" method="post">
<input type="hidden" name="m_number" id="m_number" value="${member.m_number}">
아이디 : <input type="text" name="m_id" id="m_id" value="${member.m_id}" readonly><br>
비밀번호 : <input type="password" id="m_password" onblur="pwck()">
<span id="pwckResult"></span>
비밀번호 재설정 : <input type="password" name="m_password">
이름 : <input type="text" name="m_name" value="${member.m_name}" readonly><br>
이메일 : <input type="text" name="m_email" value="${member.m_email}"><br>
전화번호 : <input type="text" name="m_phone" value="${member.m_phone}"><br>
<input type="submit" value="수정">
</form>


</body>
</html>