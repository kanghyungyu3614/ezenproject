<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container"> <!-- b: container -->
		<h3> 제품 등록 </h3>
		<form>
			제품명 : <input type="text">
			설명 : <textarea rows="" cols=""></textarea>
			할인율 : <input type="text">
			카테고리 : x
			상품대표이미지 : <input type="file">
			<button type="reset">취소</button> 
			<button type="button" onclick="regist()">등록</button>
		 </form>
		 
		 <div> <!-- form에 등록된 첨부파일[이미지만 가능] 미리보기 -->
		 	
		 </div>
	</div>
	
	<script type="text/javascript" src="../js/admin/regist.js"></script>

</body>
</html>








