<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<%@include file="../header.jsp" %>
	<!-- 로그인 안되어 있는 로그인페이지 이동 -->
	<% if( loginid == null ) response.sendRedirect("http://localhost:8080/jspweb/member/login.jsp");  %>
	
	<div class="webbox">
		<h3> 글쓰기 </h3>
		<!-- 1. form = [페이지전환O]  2. ajax = [페이지전환X]  선택  -->
		<!-- 1.  -->  
		<!--
		<form method="get" action="http://localhost:8080/jspweb/board/write">
			제목 : <input type="text" name="btitle"> <br>
			내용 : <input type="text" name="bcontent">
			<button type="submit">쓰기</button>
		</form>
		 -->
		<!--  2.  -->
		 
			제목 : <input type="text"> <br>
			내용 : <input type="text"> <br>
			첨부파일 : <input type="file"> <br>
			<button onclick="bwrite()">쓰기</button>
		
	</div>
	<script type="text/javascript" src="../js/board/write.js"></script>
	
	

</body>
</html>