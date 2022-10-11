print();
 
function print(){
	$.ajax({
		url : "/jspweb/member/infolist", 
		success : function( result ){
			let memberlist = JSON.parse( result )
			// 1. tag 가져오기
			let table =  document.querySelector("#memeberlisttable")
			// 2. table 에 넣을 제목 셋팅 
			let tag = 
				'<tr>'+
					'<th> 번호 </th>	<th> 아이디 </th><th> 이름 </th>'+
					'<th> 연락처 </th><th> 이메일 </th><th> 주소 </th>'+
					'<th> 날짜 </th>	<th> 포인트 </th>'+
				'</tr>';
			//3. tag 값 넣기 
			for( let i = 0 ; i < memberlist.length ; i++ ){
				// 4. 해당 인덱스의 객체호출 
				let m = memberlist[i]
				// 5.해당 객체의 정보를  tag변수 누적 더하기 [ html 출력 ]  
				tag +=  
					'<tr>'+
						'<td> '+m.mno+' </td> 		<td> '+m.mid+' </td>'+
						'<td> '+m.mname+' </td> 	<td> '+m.mphone+' </td>'+
						'<td> '+m.memail+' </td>	<td> '+m.maddress+' </td>'+
						'<td> '+m.mdate+' </td> 	<td> '+m.mpoint+' </td>'+
					'</tr>';
			}
			// 6. html 문자열을 table 에 넣어주기 
			table.innerHTML = tag
		}
	})
	
}