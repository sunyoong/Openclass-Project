<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
function idck(){
	/* 입력한 아이디값 */
	const m_id = document.getElementById('m_id').value;
	/* 아이디 판단 결과 */
	const idResult = document.getElementById('idCheck-result');
	/* 아이디 유효성 검사할 때 필요한 글자수 */
	const validId = m_id.length;
	/* 영어 소문자, 숫자 */
	const exp = /^(?=.*[a-z])(?=.*\d)[a-z\d]{5,20}$/;
	
	
	$.ajax({
		type: 'post',
		url: '/member/idCheck',
		data: {'m_id' : m_id},
		dataType: 'text',
		success: function(result){
			console.log('ajax성공');
			if(result == "o"){
				idResult.innerHTML = '이미 사용중인 아이디입니다.';
				idResult.style.color = 'red';
			} else{
				if(validId==0){
					idResult.innerHTML = '필수항목입니다.';
					pwResult.style.color = 'red';
				} else if(validId < 5 || validId > 20){
					idResult.innerHTML = '5~20자 이내로 작성해주세요.';
					pwResult.style.color = 'red';
				} else {
					if(m_id.match(exp)){
						idResult.innerHTML = '사용 가능한 아이디입니다.';
						idResult.style.color = 'green';
					} else {
						idResult.innerHTML ='5~20자의 영문 소문자, 숫자만 사용 가능합니다.';
						pwResult.style.color = 'red';
					}
										
				}
				}
		},
		error: function(){
			console.log('오타..');
		}
		
	})
	

	if(validId == 0){
		
	}
	
	
	
}
function pwCheck(){
	/* 비밀번호 유효성 체크 */
	const pw = document.getElementById('m_password').value;
	const pwResult = document.getElementById('pwCheck-result');
	const pwLength = pw.length;
	const exp1 = /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*()-_])[A-Za-z\d!@#$%^&*()-_]{8,16}$/;
	if(pwLength == 0){
		pwResult.innerHTML = '필수항목입니다.';
		pwResult.style.color = 'red';
	} else if(pwLength<8||pwLength>16){
		pwResult.innerHTML = '8~16자 이내로 작성해주세요.';
	} else{
		if(pw.match(exp1)){
			pwResult.innerHTML = '사용 가능한 비밀번호입니다.';
			pwResult.style.color = 'green';
		} else{
			pwResult.innerHTML = '8~16자 영문 대 소문자, 숫자, 특수문자만 입력 가능합니다.';
			pwResult.style.color = 'red';
		}
	}
	}

</script>



</head>
<body>
<h2>member/save.jsp</h2>
<form action="/member/save" method="post">
아이디 : <input type="text" name="m_id" id="m_id" onblur="idck()"><br>
<span id="idCheck-result"></span><br>
비밀번호 : <input type="password" name="m_password" id="m_password" onblur="pwCheck()"><br>
<span id="pwCheck-result"></span><br>
이름 : <input type="text" name="m_name"><br>
이메일 : <input type="text" name="m_email"><br>
전화번호 : <input type="text" name="m_phone"><br>
<input type="submit" value="가입하기">


</form>
</body>
</html>