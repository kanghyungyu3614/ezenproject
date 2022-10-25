<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="/jspweb/css/dashboard.css" rel="stylesheet">
</head>
<body>	
		<!-- 관리자 페이지 -->
		<!-- 만약에 세션이 없거나 관리자가 아니면 -->
		<% 
			String mid = (String)session.getAttribute("mid");
			if( mid==null ||  !mid.equals("admin")){
				response.sendRedirect("../member/index.jsp");
			}  // 사용자가 url 을 타고 들어올수 있기 때문
		%>
		<!-- marquee : 텍스트 슬라이드(전광판) / 속성 : scrollamount : 슬라이드 속도 -->
		<marquee scrollamount="10">공지사항 표시되는 위치</marquee>
		
		<!-- 사이드바 [ 펼치기/접기 ]-->
		<div class="sidebar">
			<h3> 관리자 메뉴 </h3>
			<ul class="side_menu">
				<li class="side_item"><a href="#">제품등록</a></li>
				<li class="side_item"><a href="#">제품목록</a></li>
				<li class="side_item"><a href="#">제고관리</a></li>
				<li class="side_item"><a href="#">주문관리</a></li>
				<li class="side_item"><a href="#">매출관리</a></li>
				<li class="side_item"><a href="#">회원목록</a></li>
				<li class="side_item"><a href="#">배송관리</a></li>
			</ul>
		</div>
		<script src="../js/admin/dashboard.js" type="text/javascript"></script>
</body>
</html>