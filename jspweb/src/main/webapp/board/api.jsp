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
	
	<div class="container"> <!-- b:container  -->
	
	
		<!-- 1. 지도를 표시할 div 입니다 -->
		<div id="map" style="width:100%;height:350px;"></div>
		
		<!-- 2. 약국 상세 정보 div 입니다. -->
		<div class="detailbox">
			
		</div>
		
		<div class="row">  <!-- b: row  -->
			<div class="col-sm-3">  <!-- b: col-sm-3 [3/12] -->
				<input type="text" class="form-control addrinput">
			</div>
			<div class="col-sm-1">  <!-- b: col-sm-1 [1/12] -->
			<button type="button" class="btn" onclick="addrsearch()">검색</button>
			</div>
		</div>
		
		<table class="table"> <!-- b:table -->
			
		</table>
		
		<table class="csvtable"> <!--  csvtable 부동산 테이블 -->
		
		
		</table>
		
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1bef67490c385f01367dff2f4cf284cc&libraries=services"></script>
	<script type="text/javascript" src="../js/board/api.js"></script>
</body>
</html>