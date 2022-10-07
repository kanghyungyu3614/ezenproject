/* HTML 과 서블릿 통신 */

// 0. 로그인 버튼 눌렀을때 [ 여러번 실행 --> 함수/메소드 ]
	// 1. 함수정의 [ function 함수명( 매개변수 ){  } ]
	// 2. HTML 함수 실행 --> 이벤트
		// 1. onclick="함수명()"	: 클릭했을때 함수호출 
			// 1. html 입력된 데이터 가져오기 [ DOM객체 ]
	// 1. document.querySelector("#id").value
	// 2. document.getElementById("id").value
function login(){
	let mid = document.querySelector('#mid').value
	let mpassword = document.querySelector('#mpassword').value
	let loginconfirmbox = document.querySelector('#loginconfirmbox')
	$.ajax({
		url : "/jspweb/member/login" ,	// 서블릿 URL
		data : { "mid" : mid , "mpassword" : mpassword  } ,
		success : function( re ){
			if( re === '1' ){ location.href ='/jspweb/index.jsp';}	
			else if( re === '2' ){ loginconfirmbox.innerHTML ='패스워드가 다릅니다.'}
			else if( re === '3' ){ loginconfirmbox.innerHTML ='데이터베이스 오류[관리자에게문의]'}
			else if( re === '0' ){ loginconfirmbox.innerHTML ='존재하지 않는 아이디 입니다.'}
		}
	});
}
	// 2. 변수2개를 서블릿으로 보내자 [ JQUERY : 자바스크립트 라이브러리 ]
		// 1. JQEURY 라이브러리 포함 // 2. AJAX( 비동기식 통신 기법 )
	// $.ajax( { 속성명 = 값 , 속성명 = 값 , 속성명 = 값 }  )
		// url : '서블릿URL' ,  		
		// data : 전송할 데이터 { '키' : 값 , '키' : 값   }  ,
		// success : function( 매개변수 ) { }
/*-------------------*/
