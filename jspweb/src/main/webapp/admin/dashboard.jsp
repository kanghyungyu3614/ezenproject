<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
	<link href="/jspweb/css/dashboard.css" rel="stylesheet">
</head>
<body>
	<!-- 관리자 페이지 -->
	<!-- 만약에 세션이 없거나 관리자가 아니면 -->
	<% 
		String mid = (String)session.getAttribute("mid"); 
		if( mid == null || !mid.equals("admin")  ){ response.sendRedirect("../index.jsp"); }
	%>
	<!-- marquee : 텍스트 슬라이드(전광판) / 속성 : scrollamount : 슬라이드 속도 -->
	<marquee scrollamount="10"> 공지사항 표시되는 위치 </marquee>
	
	<!-- 사이드바 [ 펼치기/접기 ] -->
	<div class="sidebar">
		<h1> admin menu </h1>
		<ul class="side_menu">
			<li class="side_item"><a onclick="pagechage('regist.jsp')">제품 등록</a></li>
			<li class="side_item"><a onclick="pagechage('list.jsp')">제품 목록</a></li>
			<li class="side_item"><a href="#">재고 관리</a></li>
			<li class="side_item"><a href="#">주문 관리</a></li>
			<li class="side_item"><a href="#">매출 관리</a></li>
			<li class="side_item"><a href="#">회원 목록</a></li>
			<li class="side_item"><a href="#">배송 관리</a></li>
			
			<li class="side_item"><a href="/jspweb/member/logout.jsp">로그 아웃</a></li>
 		</ul>
	</div>
	<!-- 본문 페이지가 보이는 div 입니다. -->
	<div id="mainbox">
		<!-- 사이드바에서 메뉴 클릭시 jsp가 표시되는 구역 -->
	</div>
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	<script src="../js/admin/dashboard.js" type="text/javascript"></script>

</body>
</html>










