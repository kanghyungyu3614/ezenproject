<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="/jspweb/css/productview.css" rel="stylesheet">
</head>
<body>

	<%@include file = "../header.jsp" %>
	<% // 자바를 작성할수 있는 태그[서블릿] 
		// 1. 경로에 있는 pno request 요청
		int pno = Integer.parseInt( request.getParameter("pno") );
		// 2. 로그인된 회원정보 호출 
		Object object = session.getAttribute("mid");
		String mid = null;
		if( object != null ){ // 로그인 했다.
			mid = (String)object;
		}
	%>
	<input type="text" value="<%=pno%>" class="pno" >	<!-- 제품번호 -->
	<input type="text" value="<%=mid%>" class="mid" >	<!-- 회원아이디 -->
	
	<div class="container">	<!-- b : container -->
		<div class="row">	<!-- b : row  -->
			<!-- 대표 이미지 -->
			<div class="col-md-6">  <!-- b : col-md-6  -->
				<img class="pimg" alt="" src="/jspweb/img/p3.gif">
			</div>
			
			<!-- 상품 정보 -->
			<div class="col-md-6">  <!-- b : col-md-6  -->
				<div class="infobox">
					<!-- 제품명 -->
					<h4 class="pname"> </h4>
					
					<!-- 제품설명 -->
					<div class="pcomment"> </div>
					
					<!-- 가격 -->
					<div class="pricebox">	<!-- 할인율이 있을경우 -->
						<span class="pdiscount"></span>	<!-- 할인율 -->
						<span class="pprice"></span>	<!-- 원가 -->
						<span class="psale"></span>	<!-- 할인이 적용된 가격 -->
					</div>
					
					<!-- 사이즈 종류 -->
					<div class="sizebox"> </div>
					
					<!-- 제품 옵션 -->
					<table class="table into_t">	<!--  b: table -->
						<tr> <td>배송구분</td> <td>2,500원 ( 70,000원 이상 구매시 무료) </td> </tr>
						<tr> <td>카드혜택</td> <td> 무이자할부 </td> </tr>
						<tr> <td>적립혜택</td> <td> 3,000(1%) </td> </tr>
						
						<!-- 색상 선택 행 -->
						<tr> <td>색상</td> 	
							<td>
								<select class="cselect">
								
								</select>
							 </td> 
						</tr>
						
						<!-- 사이즈 선택 행 -->
						<tr> <td>사이즈</td> 	
							<td>
								<select class="sselect">
									<option>-[필수] 색상 우선 선택 </option>
								</select>
							 </td> 
						</tr>
					</table>
					
					<!-- 선택된 제품 목록  -->
					<table class="table select_t">
					
					</table>
					
					<!-- 선택된 제품들의 총 가격 -->
					<div class="row">
						<div class="col-md-6"> 총 상품금액 </div>
						<div class="col-md-6 totalprice"> 0원 (0개) </div>
					</div>
					
					<!-- 버튼목록 -->
					<div class="btnbox">
						<button id="btn1">바로 구매</button>
						<button id="btn2" class="btncart">장바구니 담기</button>
						<button id="btn3" class="btnlike">찜하기 ♡</button>	
					</div>	
				</div>
			</div>
		</div>
		
	</div>
	
	<script type="text/javascript" src="/jspweb/js/product/productview.js"></script>
	
</body>
</html>
