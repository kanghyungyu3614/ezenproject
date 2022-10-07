

function login(){
	let mid = document.querySelector('#mid').value
	let mpassword = document.querySelector("#password").value
    
    // 2. 변수2개를 서블릿으로 보내자. 
    
    // $.ajax({속성명=값,속성명=값,...})
    // url : '통신경로' ==> 대체로 컨트롤에 있는 서블릿 주소,
    // data : 전송할 데이터{'키','값','키','값'}
    // success : function (매개변수){}
    $.ajax({
	
	 url : "/jspweb/member/login",
	 data : {"mid": mid,"mpassword":mpassword},
	 success : function(re){
		if(re==='true'){
			alert('로그인성공')
			location.href = '/jspweb/index.jsp';
		}
		else{
			alert('로그인 실패')
			logincofirmbox.innerHTML = '회원정보가 다릅니다.'
		}
	}
	
	 
	
      });
}