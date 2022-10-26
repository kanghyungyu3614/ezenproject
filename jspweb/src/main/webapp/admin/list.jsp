<%@page import="model.dto.ProductDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
	
		<table id="table">
			<tr>
				<th> 제품이미지 </th> 
				<th> 제품번호 </th>
				<th> 카테고리 </th>
				<th> 제품명 </th>
				<th> 가격 </th>
				<th> 할인율 </th>
				<th> 판매가[가격*할인율] </th>
				<th> 판매상태 </th>
				<th> 등록날짜 </th>
			</tr>
		</table>
	</div>
	
	<script src="../js/admin/list.js" type="text/javascript"></script>

</body>
</html>



