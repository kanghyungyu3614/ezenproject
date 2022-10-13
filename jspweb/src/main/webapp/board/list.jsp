<%@page import="model.dao.BoardDao"%>
<%@page import="model.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
     <%@include file="../header.jsp"%>
     <div class="webbox">
     	  <a href="write.jsp">글쓰기</a>
     	  
     	  <!-- jsp로 테이블 표시 [HTML(JSP) --- 서블릿[X] --- DAO] -->
     	  <!-- js로 테이블 표시 [HTML(JSP) --- JS --- 서블릿[X] --- DAO] -->
     	  <table>
     	      <tr>
     	         <th>번호</th><th>제목</th><th>작성자</th>
     	      </tr>
     	      
     	      <% //스크립트 태그 : html에 java 작성할수 있는 공간
     	      ArrayList<BoardDto> list = BoardDao.getInstance().getlist();
     	      
     	      for( int i =0; i< list.size(); i++){
     	    	  %>
     	    	  <tr>
     	    	  		<td><%=list.get(i).getBno()%></td>
     	    	  		<td><%=list.get(i).getBtitle()%></td>
     	    	  		<td><%=list.get(i).getMno()%></td>
     	    	  </tr>
     	    	  <% 
     	      }
     	      %>
     	  </table>
     </div>
     <script type="text/javascript" src="../js/board/list.js"></script>
</body>
</html>