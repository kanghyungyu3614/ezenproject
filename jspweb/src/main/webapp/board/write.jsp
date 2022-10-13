<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <%@include file="../header.jsp"%>
       <div class="webbox">
         <h3> 글쓰기 </h3>
         
         <!-- 1.form = [페이지전환O] 2.ajax = [페이지전환X] 선택 -->
         <form method="get" action="http://localhost:8080/jspweb/board/write">
	         제목 : <input type="text" name="btitle"> <br>
    	     내용 : <input type="text" name="bcontent">
    	     <button type="submit">쓰기</button> 
         </form>
       </div>
</body>
</html>