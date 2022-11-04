
// [전역변수]
let cartlist = null; // 장바구니 리스트
let totalprice = 0; // 총 주문금액 []

getcart()
function getcart(){
	$.ajax({
		url : "/jspweb/product/cart", 
		type : "get" , 
		success : re =>{ 
			cartlist = JSON.parse( re )
			let html = '<tr><th width="5%"><input type="checkbox"></th><th width="10%"> 이미지 </th><th width="40%"> 상품정보 </th><th width="15%"> 수량 </th> <th width="15%">가격</th> <th width="10%"> 비고 </th> </tr>';
			cartlist.forEach( c => {
				html +=  '	<tr>'+
								'<td> <input type="checkbox"> </td>'+
								'<td> <img width="80%" alt="" src="/jspweb/admin/pimg/'+c.pimg+'"> </td>'+
								'<td> '+c.pname+' <br> - '+c.pcolor+' / '+c.psize+' </td>'+
								'<td> '+c.amount+' </td>'+
								'<td> '+c.amount * (c.pprice - ( c.pprice * c.pdiscount ) )+' </td>'+
								'<td> <button>삭제</button> </td>'+
							'</tr>';
				totalprice += 	c.amount * (c.pprice - ( c.pprice * c.pdiscount ) )	;
			})
			document.querySelector('.cart_t').innerHTML = html
			
		}
	})
}



let member = null;
getmember()
function getmember(){
	$.ajax({
		url : "/jspweb/member/info",
		success : re =>{ member = JSON.parse(re); }
	})
}
/* 아임포트 [ 결제  API  ]*/
   function requestPay() {
	  var IMP = window.IMP;   // 생략 가능
  	  IMP.init("imp78274384"); // 예: imp00000000 
      IMP.request_pay({ 
          pg: "kcp", // pg카드 
          pay_method: "card",
          merchant_uid: "",   //주문번호 [ 1. 자동번호  2. 직접만들기( 날짜+시간+mid+난수 ) ]
          name: cartlist[0].pname+ "외 "+cartlist.length,
          amount: totalprice,                         // 숫자타입
          buyer_email: member.memail,
          buyer_name: member.mname,
          buyer_tel: member.mphone,
          buyer_addr: member.maddress,
          buyer_postcode: "01181"
      }, function (rsp) { // callback
          if (rsp.success) {// 결제 성공 시 로직,

          } else {
              // 결제 실패 시 로직 [ 테스트 -> 실패(성공)]
              alert()
          
          }
      });
    }
    
    
    