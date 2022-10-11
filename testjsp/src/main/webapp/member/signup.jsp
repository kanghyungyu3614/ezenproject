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
		<input type="submit" value="과제제출" onclick="print()">
	</form>
	
			<table id="boardTable">
			<tr>
				<td id="mno">회원번호 </td>
				<td id="mtitle">제목 </td>
				<td id="mcontent">내용 </td>
				<td id="mname">작성자 </td>
				<td id="mpassword">비밀번호 </td>
				<td id="mdate">작성일 </td>
				<td id="mpoint">조회수 </td>
			</tr>
		</table>
	
	<script type="text/javascript" src="../js/print.js"></script>
</body>
</html>