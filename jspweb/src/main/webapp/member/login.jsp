<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="webbox">
		<h3> 로그인 페이지[ form (동기식) 전송 ] </h3>
		<form action="/jspweb/member/login" method="post">
			아이디 : <input type="text" name="mid">			<br>
			비밀번호 : <input type="text" name="mpassword">	<br>
			<input type="submit" value="로그인"> 
		</form>
		
		<h3> 로그인 페이지[ js ajax(비동기식) 전송 ] </h3>
		아이디 : <input type="text" id="mid" >			<br>
		비밀번호 : <input type="text" id="mpassword">		<br>
		<div id="loginconfirmbox"></div>
		<input type="submit" onclick="login()" value="로그인"> 
		
	</div>
	
	<script src="../js/member/login.js" type="text/javascript"></script>
	
	
	
	
</body>
</html>