
let pageinfo = {
	listsize : 2,
	page : 1
}

list(1) // js 열람시 메소드 1번 실행 
function list(page){ // 함수 정의한다

	pageinfo.page = page; // 객체 정보 변경
	
	$.ajax({
		url : "http://localhost:8080/jspweb/board/list" , 
		data : pageinfo,
			success : function( re ){
			
			let boards = JSON.parse(re);
			// 1. Object 내 게시물리스트 먼저 호출
			
			console.log(boards)
			let boardlist = boards.data
			console.log( "boardlist 는?"+boardlist )
			let html = ""
			// boardlist -> 객체를 하나씩 꺼내기
			for( let i = 0 ;  i<boardlist.length ; i++){
				// 1. i번째 객체 호출 
				let b = boardlist[i]
				console.log( b )
				// 2. i번쨰 객체의 정보를 html 형식으로 변환해서 문자열에 저장
				html += '<tr>' +
							'<td>'+b.bno+'</td>'+
							//'<td><a href="http://localhost:8080/jspweb/board/view.jsp?bno='+b.bno+'">'+b.btitle+'</a></td>'+
							'<td onclick="viewload('+b.bno+')">'+b.btitle+'</td>'+
							'<td>'+b.mid+'</td>'+
							'<td>'+b.bdate+'</td>'+
							'<td>'+b.bview+'</td>'+
						'</tr>';
			} // for end 
				console.log( html )
			document.querySelector('.btalbe').innerHTML = html
			
			// 1. 페이지버튼 html 구성 
			let pagehtml = '';
			
			 
			 if(page<=1){
			 // 2. 이전 버튼
			 	pagehtml += '<button onclick="list+('+(page)+')">이전</button>';				
			 }else{
			 	pagehtml += '<button onclick="list+('+(page-1)+')">이전</button>';	
			 }
			 
			// 4. 페이지번호 버튼 [시작버튼 ~ 마지막버튼]
			for( let page = boards.startbtn ; page<= boards.endbtn ; page++ ){
				pagehtml += '<button onclick="list('+page+')">'+page+'</button>'
			}
			// 3. 다음 버튼 // 만일 현재페이지가 마지막페이지이면 다음페이지 불가 
			if( page >= boards.totalpage ){ pagehtml += '<button onclick="list( '+(page)+')">다음</button>'; }
			else{ pagehtml += '<button onclick="list( '+(page+1)+')">다음</button>'; }
			 
			
			document.querySelector('.pagebox').innerHTML = pagehtml;
			
		}
	})
}

function viewload( bno ){
	alert( bno )
	$.ajax({
		url : "http://localhost:8080/jspweb/board/viewload" , 
		data : { "bno" : bno },
		success : function( re ){
			location.href = "http://localhost:8080/jspweb/board/view.jsp"
		}
	})
}