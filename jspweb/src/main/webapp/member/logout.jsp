<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%@ include file ="../header.jsp" %>
  <% 
          //jsp 스크립트 태그 [java 코드 작성공간]  
         //session.invalidate(); //모든 세션 삭제 
         session.setAttribute("mid",null); //특정 세션 삭제 
         //  페이지 전환 [메인페이지 이동]
         response.sendRedirect("/jspweb/index.jsp");
  
  %>
<!--   <div class="webbox"> -->
<!--      <h3>로그아웃이 되었습니다.</h3> -->
<!--      <a href="/jspweb/index.jsp">메인</a> -->
<!--   </div> -->

</body>
</html>