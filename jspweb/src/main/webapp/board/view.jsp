<%@page import="model.dto.BoardDto"%>
<%@page import="model.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="webbox">
		<h3> 글 조회 </h3>
		<table>
			<tr> <td> 번호 <td> 	<td class="bno"> 		</td> </tr>
			<tr> <td> 제목 <td> 	<td class="btitle">  	</td> </tr>
			<tr> <td> 내용 <td> 	<td class="bcontent"> 	</td> </tr>
			<tr> <td> 작성자 <td> <td class="mid"> 		</td> </tr>
			<tr> <td> 첨부파일 <td> <td class="bfile"> 	</td> </tr>
		</table>
		
		<div class="btnbox">
			<a href="list.jsp"><button>목록보기</button></a>	
		</div>
		
		<div class="replybox">
			<textarea rows="" cols="" class="rcontent"></textarea>
			<button type="button" onclick="rwrite()">댓글작성</button>
		</div>
		
		<div class="replylist">
			
		</div>
		
	</div>
	
	<script type="text/javascript" src="../js/board/view.js"></script>

</body>
</html>