<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  	<h3> 과제 </h3>
	<form action="/testjsp/member/signup" method="post"> <!--  프로젝트명/프론트폴더/프론트파일 -->
		제목 : 		<input type="text" 		name="mtitle">					<br>
		비밀번호 : 	<input type="password" 	name="mpassword">			<br>
		비밀번호확인 : 	<input type="password" 	name="mpasswordconfirm">	<br>
		내용 : 		<input type="text" 		name="mcontent">				<br>
		작성자 : 	<input type="text" 		name="mwriter">				<br>
		<input type="submit" value="과제제출">
	</form>
</body>
</html>