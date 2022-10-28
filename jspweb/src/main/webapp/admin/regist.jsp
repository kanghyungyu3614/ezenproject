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
			제품번호 : <input type="text" readonly="readonly" name="pno">
			제품명 : <input type="text" name="pname"> <br>
			설명 : <textarea rows="" cols="" name="pcomment"></textarea> <br>
			가격 : <input type="text" name="pprice"> <br>
			할인율 : <input type="text" name="pdiscount"> <br>
			제품상태 : <input type="radio" name="pactive" value="0"> 준비중 
					 <input type="radio" name="pactive" value="1"> 판매중
					 <input type="radio" name="pactive" value="2"> 재고없음<br>
			이미지 :	<input type="file" id="pimg" name="pimg"> <br>
			카테고리 : <button type="button" name="pcno" onclick="pcategoryview()">카테고리추가</button>
				<span class="pcategoryaddbox"> <!-- 카테고리 추가 입력 구역  -->
					
				</span>
				
				<div class="pcategorybox"> <!-- 카테고리 목록 구역  -->
					
				</div>
			<button type="reset">취소</button> 
			<button type="button" onclick="regist()">등록</button>
		 </form>
		 <div> <!-- form에 등록된 첨부파일[이미지만 가능] 미리보기 -->
		 	<img alt="" src="" id="pimgpre">
		 </div>
	</div>
	
	<script type="text/javascript" src="../js/admin/regist.js"></script>

</body>
</html>