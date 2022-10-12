print();
 
function print(){
	$.ajax({
		url : "http://localhost:8080/testjsp/member/signup.jsp", 
		success : function( result ){
			let memberlist = JSON.parse( result )
			// 1. tag 가져오기
			let table =  document.querySelector("#boardTable")
			// 2. table 에 넣을 제목 셋팅 
			let tag = 
				'<tr>'+
					'<th> 회원번호 </th>	<th> 제목 </th><th> 내용 </th>'+
					'<th> 작성자 </th><th> 비밀번호 </th><th> 작성일 </th>'+
					'<th> 조회수 </th>'+
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
						'<td> '+m.mdate+' </td>'+
					'</tr>';
			}
			// 6. html 문자열을 table 에 넣어주기 
			table.innerHTML = tag
		}
	})
	
}