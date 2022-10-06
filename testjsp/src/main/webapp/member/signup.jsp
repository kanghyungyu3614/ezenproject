<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   	 <h3> 게시물페이지 </h3>
   	 

	 <form action="/testjsp/member/signup.jsp" method="post">
		아이디 : 		<input type="text" 		name="testid">					<br>
		비밀번호 : 	<input type="password" 	name="testpassword">			<br>
		이름 : 	<input type="password" 	name="testname">	<br>
		제목 : 		<input type="text" 		name="testtitle">				<br>
		내용 : 	<input type="text" 		name="testcontent">				<br>
		작성자 : 		<input type="text" 		name="testwriter">				<br>
		
		<input type="submit" value="회원가입">
	</form>
</body>
</html>