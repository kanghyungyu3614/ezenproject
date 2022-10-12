<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/signup.css">
</head>
<body>
  	<h3> 과제 </h3>
	<form action="/testjsp/member/signup" method="post"> <!--  프로젝트명/프론트폴더/프론트파일 -->
		제목 : 		<input type="text" 		name="mtitle">					<br>
		비밀번호 : 	<input type="password" 	name="mpassword">			<br>
		비밀번호확인 : 	<input type="password" 	name="mpasswordconfirm">	<br>
		내용 : 		<input type="text" 		name="mcontent">				<br>
		작성자 : 	<input type="text" 		name="mwriter">				<br>
		<button type="button" onclick="print()"> 로그인 </button>
		<button type="button" onclick="delete()">삭제버튼</button>
	</form>
	
			<table id="boardTable">
			<tr>
				<th id="mno">회원번호 </th>
				<th id="mtitle">제목 </th>
				<th id="mcontent">내용 </th>
				<th id="mname">작성자 </th>
				<th id="mpassword">비밀번호 </th>
				<th id="mdate">작성일 </th>
				<th id="mpoint">조회수 </th>
			</tr>
		</table>
	
	<script type="text/javascript" src="../js/print.js"></script>
		<!-- JQUERY 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>