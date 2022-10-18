bview() 
// 1. 수정 페이지 에서 사용되는 기존 게시물 불러오기
function bview(){
	$.ajax({
		url : "/jspweb/board/view" , 
		success : function( re ){
			let board = JSON.parse(re)
			document.querySelector('.btitle').value = board.btitle;
			// 썸머노트는 내용 저장시 html 형식으로 저장하기 때문에 
			document.querySelector('.bcontent').innerHTML = board.bcontent;
			
			if( board.bfile !== null ){ // 첨부파일 존재하면
				let filedelete = board.bfile+'<button type="button" onclick="bfiledelete()">삭제</button>'	// html 구성
				document.querySelector('.oldbfilebox').innerHTML = filedelete;	// 위에서 구성된 html 넣기
			}
			
			/* 썸머노트 실행 */
			$(document).ready(function() {
			  //$('#summernote').summernote( {설정객체} );
			  $('#summernote').summernote( {
				
					plasceholder : '내용 입력 해주세요' , 
					maxHeight : null , 
					minHeight : 300
				});
				
			}); 
			/*---------------*/
		}
	})
}


// 2. 첨부파일 삭제 버튼을 눌렀을때 ( 1.경로 2.보낼데이터 3.받을데이터 )
function bfiledelete(){
	// 1. confirm[ 확인 = true / 취소=false ]
	if(  confirm('삭제 하시겠습니까?') ){ // 만약에 확인 버튼을 눌렀을때
		$.ajax({
			url : "/jspweb/board/bfiledelete" ,
			success : function( re ){ 
				if( re === 'true'){
					alert('첨부파일 삭제')
					// * 현재페이지 새로고침 : location.reload()
					//location.reload()
					document.querySelector('.oldbfilebox').innerHTML ='' // 공백처리 
					// * 특정태그만 새로고침 : JQUERY ( $ ) 제공
					$("#oldbfilebox").load( location.href+' #oldbfilebox');
					// $("#id").load( location.href+' #id')
					// $(".class").load( location.href+' .class') // ?????
				}else{
					alert('첨부파일 삭제 실패')
				}
			}
		})
	}
}
function bupdate(){
	
	let form = document.querySelector('form');
	let formdata = new FormData( form )
	
	console.log( formdata )
	
	$.ajax({
		url : "/jspweb/board/bupdate" ,
		data : formdata , 
		// 첨부파일시
		type : "POST" , 
		contentType : false,
		processData : false , 
		// 성공시
		success : function( re ){ 
			if( re === 'true' ){ alert('수정성공'); location.href = 'view.jsp' }
			else{ alert('수정실패') }
		}
		
	})
	
	
}