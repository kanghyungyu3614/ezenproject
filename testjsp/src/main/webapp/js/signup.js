//	<button type="button" onclick="delete()">삭제버튼</button>
//</form>
//
//		<table id="boardTable">
//		<tr>
//			<th id="mno">회원번호 </th>
//			<th id="mtitle">제목 </th>
//			<th id="mcontent">내용 </th>
//			<th id="mname">작성자 </th>
//			<th id="mpassword">비밀번호 </th>
//			<th id="mdate">작성일 </th>
//			<th id="mpoint">조회수 </th>
//		</tr>
//	</table>

	let mtitle = document.querySelector("#mtitle");
	let mpassword = document.querySelector("#mpassword");
	let mcontent = document.querySelector("#mcontent");
	let mwriter = document.querySelector("#mwriter");
signup();
function signup(){
	$.ajax({
		url : "http://localhost:8080/testjsp/member/signup.jsp", 
		data : { 
			"mtitle" : mtitle ,
		    "mpassword" : mpassword,
		     "mcontent" : mcontent,
		      "mwriter" : mwriter   
		} , 
		success : function( result ){
			alert("성공했습니다.");
		}
	})
	//print();
}
//게시판 출력
//function print(){
//	
//}



