bview()

function bview(){
	$.ajax({
		url : "http://localhost:8080/jspweb/board/view" , 
		success : function( re ){ 
			let board  = JSON.parse( re )
			console.log( "board : "+board )
			document.querySelector('.bno').innerHTML = board.bno;
			document.querySelector('.btitle').innerHTML = board.btitle;
			document.querySelector('.bcontent').innerHTML = board.bcontent;
			document.querySelector('.mid').innerHTML = board.mid;
			/* 절대경로 : 				http://localhost:8080/jspweb/board/filedown */
			/* 상대경로 : 현재 위치 기준[ http://localhost:8080/jspweb/js/view.js ]
						../board/filedown
			 */
			 /*
			 	<a href="URL?변수명=데이터">	: get메소드로 해당 URL 데이터 전송가능 
			 	'<a href="URL?변수명='+변수+'">'
			 */
			console.log( "board.bfile "+board.bfile )
			
			if( board.bfile !== null ){	// null , undefined , 0 , false
				let filelink = '<a href="../board/filedown?bfile='+board.bfile+'">'+board.bfile+'</a>'
				// ' ' : 전체 문자열 처리
				// " " : 전체 문자열내 문자열 구분  
				document.querySelector('.bfile').innerHTML = filelink;
			}
			
			console.log( "board.btnaction는?"+board.btnaction )
			let btnbox = document.querySelector('.btnbox')
			
			if( board.btnaction == true ){
				// 삭제 버튼 활성화
				let deletebtn = '<button onclick="bdelete('+board.bno+')"> 삭제 </button>'
				btnbox.innerHTML += deletebtn;
				// 수정 버튼 활성화 
				let updatebtn = '<button><a href="../board/update.jsp">수정</a></button>'
				btnbox.innerHTML += updatebtn;
			}
		}
	})
}


function bdelete( bno ){ // 삭제 버튼 클릭시 삭제할 번호를 인수[식별]
	$.ajax({
		url : "http://localhost:8080/jspweb/board/bdelete" , 
		data : { "bno" : bno } , // 삭제할 게시물의 식별번호[pk->bno]
		success : function( re ){
			if( re === 'true'){
				alert('글삭제 성공 ');
				location.href="../board/list.jsp"
			}
			else{ alert('글삭제 실패 : [관리자에게문의]') }
		}
	})
}