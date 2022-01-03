<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	/* function pwdate(){
		const id = document.getElementById("m_id").value;
		const pwdate = document.getElementById("m_pwdate").value;
		$.ajax({
			type: "post", 
			url: "/member/pwdateCK",
			data: {"m_id" : id},
			dataType: "text",
			success: function(result){
				console.log('성공');
				console.log(result);
				if(result =="o"){
					
				}
				
				
			}, 
			error: function(){
				console.log('실패');
			}
		});
		
		
		
		
	}
 */
</script>



</head>
<body>
<h2>member/login.jsp</h2>
<form action="/member/login" method="post" name="login_form">
아이디 : <input type="text" name="m_id" id="m_id" >
비밀번호 : <input type="password" name="m_password" id="m_password"> 
<input type="hidden" name="m_pwdate" id="m_pwdate">
<input type="submit" value="확인"> 
</form>


</body>
</html>