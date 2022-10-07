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
		<h3> 비밀번호 찾기 </h3>
		아이디 : <input type="text" id="mid"> <br>
		이메일 : <input type="text" id="memail"><br>
		<div id="findpasswordconfirmbox"></div>		<!-- 결과 메시지 출력 박스 -->
		<button type="button" onclick="findpassword()">아이디찾기</button>
	</div>
	<script src ="../js/member/find.js" type="text/javascript"></script>
	
</body>
</html>