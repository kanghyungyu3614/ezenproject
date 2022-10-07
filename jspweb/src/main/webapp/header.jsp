<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 뷰포트 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- 사용자 정의 css 호출  -->
	<link rel="stylesheet" href="/jspweb/css/header.css">
	<!-- 폰트어섬  -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>

	<div class="webbox">
		<div class="hd_top">
			<div>	<!--  로고  -->
				<span class="hd_title"> 
					<a href="/jspweb/index.jsp">Ezen Shop</a> 
				</span>	
			</div>
			
			<ul class="hd_sub">	<!--  상단 메뉴 -->
				<li> <a href="/jspweb/member/login.jsp">로그인</a> </li>
				<li> <a href="/jspweb/member/signup.jsp">회원가입</a> </li>
				<li> <a href="#">마이쇼핑</a> </li>
				<li> <a href="#">고객센터</a> </li>
			</ul>
		</div>
		<div>
			<ul class="hd_menu">
			     <li><a href="#">BIG SIZE!</a></li>
			     <li><a href="#">1+1이벤트</a></li>
			     <li><a href="#">아우터</a></li>
			     <li><a href="#">상의</a></li>
			     <li><a href="#">바지</a></li>
			     <li><a href="#">슈즈</a></li>
			     <li><a href="#">악세사리</a></li>
			     <li><a href="#">BEST</a></li>
			     <li><a href="#">트레이닝</a></li>
			     <li><a href="#">50% 할인</a></li>
			     <li><a href="#">MUSCLE-FIT</a></li>
			     <li class="searchbox">
			        <span>
 				     	<input>
			     		<i class="fas fa-search"></i>			        
			        </span>
			     	<i class="fas fa-shopping-cart"></i>
			     </li>
			</ul>
		</div>
		
		
	</div>
	<!-- jquery 라이브러리 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

</body>
</html>

<!-- 
	<div> : 레이아웃 , 박스권 , 구역 
	<ul> : 글머리 리스트 
		<li> : 리스트 아이템[ 값/항목 ] 
 -->