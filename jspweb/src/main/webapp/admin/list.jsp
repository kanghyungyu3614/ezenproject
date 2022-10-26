<%@page import="model.dao.ProductDao"%>
<%@page import="model.dto.ProductDto"%>
<%@page import="java.util.ArrayList"%>
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
	
	
	<% 
	
		// 서블릿[자바 코드를 입력할수 있는 공간]
		ArrayList<ProductDto> list = new ProductDao().getProductlist(); 
	
	%>
	<table>
		<tr>
			<th>제품명</th><th>제품이미지</th>
		</tr>
		<%
			for(int i=0; i<list.size(); i++){
		%>
			<tr>
				<td><%=list.get(i).getPname()%></td>
				<td><img alt="" src="/jspweb/admin/pimg/<%=list.get(i).getPimg()%>"></td>
			
			</tr>
		<% 		
			}
		%>
		
		
		
	</table>
	
	
	</div>
	<script type="text/javascript" src="../js/list.js"></script>
</body>
</html>