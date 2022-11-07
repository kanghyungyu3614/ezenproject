
// js 저장소에 있는 'checkplist' 라는 이름으로 checkplist 객체 저장
 let checkplist = JSON.parse(localStorage.getItem('checkplist'));
 console.log("checkplist",checkplist)
let checkbtn =  document.querySelector(".checkbtn")

checkbtn.addEventListener('click' , (e)=>{
	// 1. 체크박스를 체크 했을때 
	if(e.currentTarget.checked == true){
	document.querySelector('.oname').value = member.mname;	
	document.querySelector('.ophone').value = member.ophone;	
	document.querySelector('.oddress').value = member.oddress;			
	}else{
	document.querySelector('.oname').value = '';	
	document.querySelector('.ophone').value = '';	
	document.querySelector('.oddress').value = '';					
	}
})

// 로그인된 회원호출
let member = null;
getmember()
function getmember(){
	$.ajax({
		url : "/jspweb/member/info",
		success : re =>{ member = JSON.parse(re); }
	})
}
let pmethod = null;
function paymethod(payM){
	pmethod = payM
	alert(pmethod)
}

/* 아임포트 [ 결제  API  ]*/
   function requestPay() {
	  var IMP = window.IMP;   // 생략 가능
  	  IMP.init("imp78274384"); // 예: imp00000000 
      IMP.request_pay({ 
          pg: "kcp", // pg카드 
          pay_method: pmethod,
          merchant_uid: "",   //주문번호 [ 1. 자동번호  2. 직접만들기( 날짜+시간+mid+난수 ) ]
          name: checkplist[0].pname+ "외 "+checkplist.length,
          amount: "",                         // 숫자타입
          buyer_email: "",
          buyer_name: "",
          buyer_tel: "",
          buyer_addr: "",
          buyer_postcode: ""
      }, function (rsp) { // callback
          if (rsp.success) {// 결제 성공 시 로직,

          } else {
              // 결제 실패 시 로직 [ 테스트 -> 실패(성공)]
              alert('결제성공');
              setorder();
          }
      });
    }

function setorder(){
	//  받는사람 정보 문자열
	let oinfo ={
		oname :document.querySelector('.oname').value,
		ophone : document.querySelector('.ophone').value ,
		oddress : document.querySelector('.oddress').value,
		oquest : document.querySelector('.oquest').value
	}
	$.ajax({
		url : "/jspweb/product/order",
		data : {
			"data" : JSON.stringify(checkplist),
			"oinfo" : JSON.stringify(oinfo)
		},
		type: "post",
		success : (re)=>{
			if(re == 'true'){
				alert('주문완료')
				localStorage.removeItem('checkplist'); // 저장소 제거
				location.href='/jspweb/product/ordersuccess.jsp'; 
				// 저장소 제거 
			}else{
				alert('주문완료[관리자에게 문의]');
			}
		}
	})
}









     