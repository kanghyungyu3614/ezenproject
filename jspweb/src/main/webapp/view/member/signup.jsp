<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>회원가입 페이지</h3>
   <form action="/jspweb/signup" method="get"> 
   <!-- 폼태그 : 전송기능 action="URL경로" method="전송방식" -->
   아이디 : <input type="text" name="id"> <br>
   비밀번호 : <input type="text" name="pw"> <br>
   이름 : <input type="text" name="name"> <br>
   전화번호 : <input type="text" name="phone"> <br>
   <input type="submit" value="가입하기">
   </form>
</body>
</html>