getproduct()
// 1. 모든 제품 호출 메소드 
function getproduct(){
	$.ajax({
		url :"/jspweb/admin/regist" ,
		data : { "type" : 1 , "option" : "all" } , 	// 타입이 1 이면 모든 제품 호출 
		type : "get", // 해당 서블릿주소의 doGet메소드과 통신
		success : function( re ){
			
			let json = JSON.parse( re )
			let html = '';
			// forEach( 반복변수명 => { 실행문 } ) : 인덱스 존재하는 객체에 한해 사용가능
			json.forEach( p => {
				// 반복변수명에 인덱스객체 하나씩 대입 
				console.log("p에는 무엇이 들어있을까요?")
				console.log(p)				
				html +=  `<tr>`+
						`	<td> <img src="/jspweb/admin/pimg/${p.pimg}" style="width:100%"> </td> `+
						`	<td> ${p.pno} </td>`+
						`	<td> ${p.pcno}  </td>`+
						`	<td> ${p.pname}  </td>`+
						`	<td> ${p.pprice}  </td>`+
						`	<td> ${p.pdiscount}  </td>`+
						`	<td> ${p.pprice -(p.pprice * p.pdiscount) }  </td>`+
						`	<td> ${p.pactive}  </td>`+
						`	<td> ${p.pdate}  </td>`+
						`	<td> `+
						`		<button type="button" onclick="updatemodal(${p.pno})">수정</button>`+
						`		<button type="button" onclick="deleteprodcut( ${p.pno} )">삭제</button>`+
						`</td>`+
						`</tr>`;
			}) // 반복 end 
			document.querySelector('table').innerHTML += html
		}
	})
} // f end 


// 2-1. 수정 모달 실행 메소드 
function updatemodal( pno ){
	// 1. 해당 모달을 열러주는 버튼에 강제클릭 이벤트 실행 
	document.querySelector(".updatemodalhtn").click() // 해당 버튼을 강제클릭하는 이벤트 실행
	// 2. 해당 모달에 기존 내용물 넣기 
		// 2-1 : 해당 pno의 제품정보 호출 
		$.ajax({
			url : "/jspweb/admin/regist",
			data : { "type" : 2 , "pno" : pno } , 	// 타입이 2 이면 개별 제품 호출 
			type : "get" ,
			success : function( re ){ 
				let json = JSON.parse(re);
				console.log("2-1 수정모달 실행 메소드에 있는 json")
				console.log(json)				
				document.querySelector('.pno').value = json.pno
				document.querySelector('.pcno').value = json.pcno
				document.querySelector('.pname').value = json.pname
				document.querySelector('.pcomment').value = json.pcomment
				document.querySelector('.pprice').value = json.pprice
				document.querySelector('.pdiscount').value = json.pdiscount
				
				// 카테고리 호출 
						$.ajax({
							url : "/jspweb/board/pcategory" , 
							type : "get" , 
							success:function(re){
								let json2 = JSON.parse(re)
								let html = ''
								for( let i = 0 ; i<json2.length ; i++ ){
									let category = json2[i];
									if( category.pcno == json.pcno ){
										
										html += '<input checked type="radio" name="pcno" value='+category.pcno+'>'+category.pcname;
									}else{
										html += '<input type="radio" name="pcno" value='+category.pcno+'>'+category.pcname;
									}
									
								}
								document.querySelector(".pcategorybox").innerHTML = html;
							}
						})
						
						// 제품 상태 호출 
						let pactivebtns =  document.querySelectorAll('.pactive');
						if( json.pactive == 0 ){ pactivebtns[0].checked = true }
						if( json.pactive == 1 ){ pactivebtns[1].checked = true }
						if( json.pactive == 2 ){ pactivebtns[2].checked = true }
				
				
				
				
				
				
				
			}
		})
}
// 2-2. 수정 처리 메소드 
function updateproduct(){
	
	
	// 1. 수정할 정보
	let form = document.querySelector(".updateform")
	let formdata = new FormData(form);
	
	  // formdata 속성 추가
		//formdata.set('속성명' : 데이터)
		//formdata.set('pno' : pno)
	// 2. 수정할 대상
	$.ajax({
		url : "/jspweb/admin/regist",
		type : "put",
		data : formdata , 
		processData : false , 
		contentType : false , 
		success : function (re){
			alert(re)
			if(re == 'true'){
				alert('수정완료')
				console.log("2-2 수정 처리 메소드에 있는 콘솔")
				// 1. 모달닫기
				document.querySelector(".modelclosebtn").click() // 클릭이벤트
				// 새로고침
				pagechage('list.jsp');
			}else{
				console.log("수정실패")
			}
			
		}
	})	
}

// 3. 삭제 메소드 
function deleteprodcut( pno ){
	if( confirm("정말 삭제하시겠습니까?") ){ // 확인 버튼을 눌렀을때
		$.ajax({
			url :"/jspweb/admin/regist" ,
			data : { "pno" : pno } ,
			type : "delete" ,  // 해당 서블릿주소 의 doDelete메소드과 통신
			success: function( re ){ 
				if( re ==='true' ){ alert('삭제성공'); pagechage('list.jsp'); }
					// pagechage() : dashboard.jsp내  dashboard.js가 포함되어 있기때문에 호출이 가능하다.   
						// 현재 구조상 dashboard.jsp내 특정태그에 list.jsp 포함
				else{ alert('삭제실패') }
			}
		}) // ajax end 
	} // if end 
} // f end 
/* 
	server 프로젝트 폴더 클릭 -> server.xml  -> 63줄 정도
		- 톰캣 서버의 기본설정값은 get,post 방식만 객체[Body] 전송 
	원본 : <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
	수정 : <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="GET,POST,PUT,DELETE"/>
 */





























