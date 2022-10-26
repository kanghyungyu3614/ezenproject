/**
 * 
 */
 getproduct();
// 1. 모든 제품 호출 메소드
function getproduct(){
	$.ajax({
		url: "/jspweb/admin/regist",
		type: "get",
		success:function (re){
			let json = JSON.parse(re);	
			console.log("json");
			console.log(json);
			
			let img = "/jspweb/admin/pimg/"+json[0].pimg;
			let html =  '<tr>'+
							'<th> 제품이미지 </th> '+
							'<th> 제품번호 </th>'+
							'<th> 카테고리 </th>'+
							'<th> 제품명 </th>'+
							'<th> 가격 </th>'+
							'<th> 할인율 </th>'+
							'<th> 판매가[가격*할인율] </th>'+
							'<th> 판매상태 </th>'+
							'<th> 등록날짜 </th>'+
						'</tr>';
			for( let i = 0 ; i<json.length ; i++){	// 약국 하나씩 호출 
					html += '<tr>'+	// 해당 행 클릭시 map 메소드 실행 [ 클릭한 인덱스 매개변수 전달 ]
								'<td>'+'<img src="'+img+'">'+'</td> '+
								'<td>'+json[i].pno+'</td>'+
								'<td> '+json[i].pcomment+'</td>'+
								'<td>'+json[i].pname+'</td>'+
								'<td>'+json[i].pprice+'</td>'+
								'<td>'+json[i].pdiscount+'</td>'+
								'<td>'+Math.random(json[i].pprice*(1-json[i].pdiscount))+'</td>'+
								'<td> 판매중 </td>'+
								'<td>'+json[i].pdate+'</td>'+
							'<tr>';
				} // for end 	
			document.querySelector('#table').innerHTML = html;
		}
	})
}
