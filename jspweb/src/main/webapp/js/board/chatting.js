// 자바스크립트 : F5 할때마다 [ 새로 열릴때마다 ] 메모리 초기화

// 전송방식 : 1.보내기버튼 눌렀을때 2. 메시지 입력 상자 에서 엔터를 눌렀을때 


	// 4. 메시지 받았을때 
function onmessage( e ){  // e : 서버소켓으로 부터 받은 정보 담겨져있음
	// e.data : 받은 정보의 메시지
	console.log( e ); console.log( e.data );
	let msg = JSON.parse( e.data ) // 받은 String --> JSON 변환
	console.log( msg )
	// 1. 출력 구역 호출 
	let contentbox = document.querySelector('.contentbox')
	// 2. 받은 메시지를 html 꾸미기 
	let html = '<div>'+e.data+'</div>';
	// 받은 메시지를 html 추가한다.
	contentbox.innerHTML += html
 }

// 3. 메시지 보내기 
function send() {
	// 1. 보낼 데이터 객체 구성
	let msg = {	// 객체 = {  속성명 : 값 , 속성명 : 값  } 
		content : document.querySelector('.msgbox').value , // 내용
		from : mid ,  // 보낸 사람 아이디 
		date : new Date().toLocaleTimeString() // js 현재시간 메소드 // 보낸시간 
	}
	websocket.send( JSON.stringify(msg) ) // 해당 객체를 JSON형식으로 변환 --> 메시지 전송
	document.querySelector('.msgbox').value = '' // 전송 후 입력상자 초기화 
}
function enterkey( ){
	//엔터키를 눌렀을때
	if( window.event.keyCode == 13 ){ // window.event.keyCode : 키보드의 입력된 데이터를 숫자표현 [ 엔터 = 13 ]
		send()
	}
}



// 1. 전역변수
let websocket = null // 웹소켓 선언 
// 2. 로그인 id 호출 [ jsp vs ajax  세션 호출 ]
let mid = document.querySelector('.mid').value
// 2. 만약에 로그인이 되어 있는경우에만 서버소켓으로부터 접속한다. 
if( mid !== 'null' ){ // 로그인이 되어있으면
	// JS 지원하는 클라이언트 웹소켓 클래스 [ new WebSocket("ws://ip:port/프로젝트/서버소켓엔드포인트/"+변수)  ] 
	websocket = new WebSocket("ws://localhost:8080/jspweb/chatting/"+mid); 
	// 3. 2번에서 구현된 메소드를 클라이언트소켓에 대입 
	websocket.onopen = function( e ){ onopen(e) }
	websocket.onclose = function( e ){ onclose(e) }
	websocket.onmessage = function( e ){ onmessage(e) }
}else{ // 로그인이 안되어있으면
	alert('로그인하고 오세요~'); location.href="../member/login.jsp";
}
// 2. 메소드 구현 [ 1.접속했을때 , 2.나갔을때 3. 메시지보내기 4. 메시지 받았을때  ]
function onopen(e){ alert('채팅방에 들어왔습니다.'+ e ) }
function onclose(e){ alert('채팅방에 나갔습니다.'+ e ) }

