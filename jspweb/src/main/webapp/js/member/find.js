/*---------- 아이디찾기 ---------- */
function findid(){
	// 1. 해당 id의 input value 와 div 호출 
	let mname = document.querySelector("#mname").value
	let memail = document.querySelector("#memail").value
	let findidconfirmbox = document.querySelector("#findidconfirmbox")
	// 2. 서블릿에게 데이터 보내기 [ 기본값 : get메소드]
	$.ajax({
		url :"/jspweb/member/findid" , 		/* 통신 경로 : 서블릿URL */
		data : { "mname" : mname , "memail" : memail }  , 	/* 보낼 데이터 : { "이름1" : 값1 , "이름2" , 값2 } */
		success : function( 받은데이터 ){
			if( 받은데이터 !== 'null' ){
				findidconfirmbox.innerHTML = '회원 아이디 : ' + 받은데이터
			}else{
				findidconfirmbox.innerHTML = '동일한 회원정보가 없습니다.'
			}
		}
	});
}
/*--------------  비밀번호찾기 ---------------- */
function findpassword(){
	// 1. html 호출 
	let mid = document.querySelector("#mid").value
	let memail = document.querySelector("#memail").value
	let resultbox = document.querySelector("#findpasswordconfirmbox")
	// 2. ajax 
	$.ajax({
		url : "/jspweb/member/findpassword" ,
		data : { "mid" : mid , "memail" : memail }  ,
		success : function( result ){
			if( result === ''){ resultbox.innerHTML = '동일한 회원정보가 없습니다.';}
			else{ resultbox.innerHTML = '임시비밀번호 : '+result; }
		}
	})
}
