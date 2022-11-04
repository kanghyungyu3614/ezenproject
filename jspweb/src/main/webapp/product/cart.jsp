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
	<div class="container">
		<table class="table cart_t">

		</table>
		
		<button type="button">선택삭제</button>
		<button type="button">전체삭제</button>
		<button type="button">쇼핑하기</button>
		<!-- 1. 아임포트 결제 버튼 -->
		<button onclick="requestPay()" type="button">결제하기</button> 
		
	</div>
	<!-- 2. 아임포트[ 결제 API ]  -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	
	<script src="/jspweb/js/product/cart.js" type="text/javascript"></script>
</body>
</html>