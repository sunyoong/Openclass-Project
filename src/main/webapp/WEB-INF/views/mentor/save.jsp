<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멘토가입</title>
</head>
<body>
<form action="/mentor/save/"  method="post" >
아이디 : <input type="text" name="me_id">
비밀번호 : <input type="text" name="me_password">
이름 : <input type="text" name="me_name">
휴대폰 : <input type="text" name="me_phone">
<input type="hidden" name="me_joindate">
<input type="submit" value="확인">
</form>
</body>
</html>