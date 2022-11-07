/*
	정규표현식 : 문자 특정 규칙 , 패턴 , 집합 표현할때 사용되는 언어
		 /^ : 정규표현식 시작 
		 $/ : 정규표현식 끝
		 [a-z] : 소문자 패턴
		 [A-Z] : 대문자 패턴
		 [0-9] : 숫자 패턴			\d
		 [가-힣] : 한글 패턴
		 { 최소길이 , 최대길이  } : 문자열 길이 패턴 
		 + : 앞에 있는 패턴 1개 이상 반복
		 ? : 앞에 있는 패턴 0개 혹은 1개 이상 반복
		 * : 앞에 있는 패턴 0개 반복
		 	(?=.*[a-z]) : 최소 한개 이상의 소문자 영문
		 	(?=.*[A-Z]) : 최소 한개 이상의 대문자 영문
		 	(?=.*[0-9]) : 최소 한개 이상의 숫자				(?=.*\d) : 최소 한개 이상의 숫자
		 	(?=.*[!@#$%^&*()_] ) : 최소 한개 이상의 특수문자 
		 	
		 검사 : 정규표현식.test( 데이터 )  : 맞으면 true , false
		 
		 1. /^[a-z0-9]{5,20}$/  						: 소문자/숫자 조합 5~20글자 패턴
		 2. /^[a-zA-Z0-9]{8,20}$/						: 영대소문자/숫자 조합 8~20글자 패턴
		 3. /^[a-zA-Z가-힣]{2,20}$/						: 영대소문자/한글 조합 2~20글자 패턴
		 4. /^([0-9]{2,3})-([0-9]{3,4})-([0-9]{3,4})$/	: 숫자2~3 - 숫자3~4 - 숫자3~4 패턴
		 5. /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/	: 영대소문자/숫자 @ 영대소문자/숫자 . 영대소문자/숫자
*/
// 0. 아이콘
let sicon = '<i class="fas fa-check-circle"></i>'
let bicon = '<i class="fas fa-ban"></i>'
// 1. col3 div 모두 가져오기 
let col3 = document.querySelectorAll('.col3')	// class가 col3 이면 모두 호출 [ ALL -> 배열 ]
/*----- 아이디 ------------ */
function mevent1(){											// 아이디를 입력[keyup]하면 이벤트 발생 = 함수 실행
	let mid = document.querySelector("#mid").value			// 1. 입력받은 아이디 호출 
	let midj = /^[a-z0-9]{5,20}$/							// 2. 정규표현식 작성 
	if( midj.test(mid) ){ // 정규표현식이 동일하면				// 3. 정규표현식 검사 
	
		$.ajax({ 											// 4. 아이디 중복체크 [ 비동기식 - ajax ]
			url : "/jspweb/member/idcheck",
			data : { "mid" : mid } , 
			success : function( re ) {						// 5. 중복체크 결과(re) 
				if( re === 'true'){ col3[0].innerHTML = bicon+" 사용중인 아이디" }
				else{ col3[0].innerHTML = sicon }
			 }
		})// ajax end 
		
	}else{	 col3[0].innerHTML = bicon+'소문자/숫자 조합 5~20글자' } // 정규표현식이 다르면
}
/*----- 비밀번호 ------------ */
function mevent2(){
	let mpassword = document.querySelector("#mpassword").value
	let mpasswordj = /^[a-zA-Z0-9]{8,20}$/
	if( mpasswordj.test(mpassword) ){
		col3[1].innerHTML = sicon; mevent3();
	}else{
		col3[1].innerHTML = bicon+'영대소문자/숫자 조합 8~20글자'
	}
}
/*----- 비밀번호 확인 ------------ */
function mevent3(){
	let mpassword = document.querySelector("#mpassword").value
	let mpasswordconfirm = document.querySelector("#mpasswordconfirm").value
	let mpasswordj = /^[a-zA-Z0-9]{8,20}$/
	if( !mpasswordj.test(mpasswordconfirm) ){ col3[1].innerHTML = bicon+'영대소문자/숫자 조합 8~20글자' }	// 정규표현식 다르면
	else if( mpasswordconfirm != mpassword ) { col3[1].innerHTML = bicon+'비밀번호 서로 다릅니다.' } // 두 비밀번호가 다르면
	else{ col3[1].innerHTML = sicon; mevent2(); }	// 정규표현식 맞고 두 비밀번호 맞으면
}
/*----- 이름 ------------ */
function mevent4(){
	let mname = document.querySelector("#mname").value
	let mnamej = /^[a-zA-Z가-힣]{2,20}$/
	if( mnamej.test( mname) ){ col3[2].innerHTML = sicon;  }
	else{ col3[2].innerHTML = bicon+'영대소문자 혹은 한글 2~20글자'}
}
/*----- 전화번호 ------------ */
function mevent5(){
	let mphone = document.querySelector("#mphone").value
	let mphonej = /^([0-9]{2,3})-([0-9]{3,4})-([0-9]{3,4})$/
	if( mphonej.test(mphone) ){ col3[3].innerHTML = sicon; }
	else{ col3[3].innerHTML = bicon+'지역번호-XXXX-XXXX 형식 입력해주세요' }
}
/*----- 이메일 ------------ */
function mevent6(){
	let memail = document.querySelector("#memail").value
	let memailj = /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-]+$/
	if( memailj.test(memail) ){ 
		
		$.ajax({
			url : "/jspweb/member/emailcheck" , 
			data : { "memail" : memail } , 
			success : function( re ){ 
				if( re === 'true'){ 
					col3[4].innerHTML = bicon+' 사용중인 이메일 입니다. '  
				}
				else{ col3[4].innerHTML = sicon;  }
			 }		
		})
	}
	else{ col3[4].innerHTML = bicon+' 이메일 형식으로 입력해주세요 ' }
}
/*----- 주소 ------------ */
let sample4_postcode =  document.querySelector("#sample4_postcode")
let sample4_roadAddress =  document.querySelector("#sample4_roadAddress")
let sample4_jibunAddress =  document.querySelector("#sample4_jibunAddress")
let sample4_detailAddress =  document.querySelector("#sample4_detailAddress")

function addresscheck( 이벤트객체 ){
	let 입력된값 = 이벤트객체.currentTarget.value;
	if( 입력된값.indexOf(',') !== -1 ){ col3[5].innerHTML = bicon+' 주소에 ,[쉼표] 입력 불가능' }
	else{ col3[5].innerHTML = sicon; } 
}

sample4_postcode.addEventListener( 'change' ,  addresscheck )	// change 된 객체의 정보를 addresscheck함수에게 인수로 전달
sample4_roadAddress.addEventListener( 'change' ,  addresscheck )
sample4_jibunAddress.addEventListener( 'change' ,  addresscheck )
sample4_detailAddress.addEventListener( 'change' ,  addresscheck )
/* ------ 전송 버튼 눌렀을때 ------- */
function formsubmit(){
	// 1.아이디 ~ 주소 모두 유효성검사 검토 
	for( let i = 0 ; i <= 5 ; i++ ){	//  col3[0] : 아이디  , col3[1] : 비밀번호  ~~~    col3[5] : 주소
		if( col3[i].innerHTML !== sicon ){ alert('입력이 안된 정보가 있습니다.'); return false; }
	}
	// 2.이용약관 체크박스 검토  [ // tag객체명.checked    : 체크가 되어있으면 true 아니면 false ]
	if( document.querySelector('#confirm1').checked == false ){ alert('이용약관에 동의해주세요'); 		return false; }
	if( document.querySelector('#confirm2').checked == false ){ alert(' 개인정보 수집 동의해주세요'); 	return false; }
	
	document.querySelector('.signupform').submit();	// 해당 form 전송 // 폼객체.submit()
	// document.querySelector('.signupform') : signupform 이라는 class 를 가지고 있는 tag 호출
}


/*
	tag객체명.addEventListener( '이벤트명' , 함수명(매개변수) )
	tag객체명.addEventListener( '이벤트명' , function(매개변수){ 실행코드  })
	tag객체명.addEventListener( '이벤트명' , 매개변수 => 실행코드 )
	
	문자열.indexOf(찾을문자) : 해당 문자열에 찾을문자의 인덱스 번호  [ -1 : 없다 ]
	
*/


/*----- 회원가입 전송확인 ------------ */




/* 카카오 우편 api */
   //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 참고 항목 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample4_postcode').value = data.zonecode;
            document.getElementById("sample4_roadAddress").value = roadAddr;
            document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
            
            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
            if(roadAddr !== ''){
                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
            } else {
                document.getElementById("sample4_extraAddress").value = '';
            }

            var guideTextBox = document.getElementById("guide");
            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
            if(data.autoRoadAddress) {
                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                guideTextBox.style.display = 'block';

            } else if(data.autoJibunAddress) {
                var expJibunAddr = data.autoJibunAddress;
                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                guideTextBox.style.display = 'block';
            } else {
                guideTextBox.innerHTML = '';
                guideTextBox.style.display = 'none';
            }
        }
    }).open();
}
/* 카카오 우편 api end */