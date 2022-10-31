/*

	== : 같다 [ 값만 비교 ]
	=== : 같다 [ 값 과 자료형 비교 ]

	- 함수
	1. 함수명()
	2. function(인수){ }
	3. 인수 => { }
	
	- 콜백함수 : 함수실행 반환 결과를 [콜백]함수에게 인수로 전달 
		- 함수1 에서 실행된 반환값을 콜백함수의 인수로 전달
	1. 함수1( 콜백함수2(인수) )	
	2. 함수1( 인수 => function(인수){ } )
	3. 함수1( 인수 => { } )
	
	- 활용
	.addEventListener( '이벤트명' , 함수호출[1~3] )
		: 이벤트 실행 결과정보를 반환
	.forEach( 인수 => { 코드 } )
*/

let productlist = null; /* 모든 제품를 가지고 있는 리스트 선언 [ 전역 = 모든 함수 사용목적 ] */

let cselect = document.querySelector('.cselect') 	// 카테고리 선택 상자 
let pselect = document.querySelector('.pselect') 	// 제품 선택 상자
let rows = document.querySelectorAll('.rows') 		// 재고 등록 td 행 목록

// 카테고리목록에서 선택를 클릭했을떄 제품출력 메소드 호출
cselect.addEventListener( 'click' , e => {
	let pcno = e.currentTarget.value // 선택된 카테고리 번호
	getproduct( pcno ); // 선택된 카테고리 번호 인수로 전달 
})

// 제품 목록에서 선택을 했을때 재고 등록 html 구성
pselect.addEventListener( 'click' , e => {
	let pno = e.currentTarget.value // 선택된 카테고리 번호
	productlist.forEach( p => { 
		if( p.pno == pno ){ // 해당 제품의 번호와 선택된 제품의번호와 같으면
			rows[0].innerHTML = p.pcno
			rows[1].innerHTML = p.pno
			rows[2].innerHTML = p.pname
			getstock() // 페이지로드 될때 실행
		}
	})
})

/*1. 페이지 열리면 모든 카테고리 select 넣어주기 */
getcategory()
function getcategory(){
	$.ajax({
		url : "/jspweb/board/pcategory" , 
		type : 'get',
		success : function( re ){
			let categorylist = JSON.parse( re ) // 선언
			// 배열객체.forEach( 반복변수명[아무거나] , 인덱스 , 배열객체명 => { 실행코드 } )
			let html = '<option> 카테고리 선택 </option>'
			categorylist.forEach( c => {
				html += `<option value=${c.pcno}> ${c.pcname}</option>`
			})
			cselect.innerHTML = html
		}			
	})
}
/*2. 선택된 카테고리별 제품리스트를 select 넣어주기 */
function getproduct( pcno ){
	$.ajax({
		url : "/jspweb/admin/regist" , 
		data : { "type" : 1 , "option" : "all"  } ,
		type : 'get',
		success : function( re ){
			productlist = JSON.parse( re ) // 대입 
			let html = ''
			productlist.forEach( p => {
				if( p.pcno == pcno ){ // 해당제품의 카테고리번호 와 선택된 카테고리 번호 와 같으며
					html += `<option value=${p.pno}> ${p.pname}</option>`
				}
			})
			pselect.innerHTML = html
		}
	});
}

// 3. 제고 등록 버튼을 눌렀을때 
function setstock(){
	// 1. 등록할 데이터 구성[객체화]한다. vs form [ 첨부파일 있을경우 ]
	let info = {
		psize : document.querySelector('.psize').value,
		pcolor : document.querySelector('.pcolor').value, 
		pstock : document.querySelector('.pstock').value, 
		pno : rows[1].innerHTML
	}
	console.log(info)
	// 2. 통신
	$.ajax({
		url : "/jspweb/admin/stock",
		type : "post", // post http method
		data: info,
		success : re => {
			if(re=='true'){
				alert('재고등록성공');
				getstock(); // 제품을 클릭했을때 제품재고 메소드 호출 
			}else{
				alert('재고등록실패');
			}
		}
	})
}


// 4. 제품별 재고 출력
function getstock(){
	
	$.ajax({
		url:"/jspweb/admin/stock",
		type: "get", // get method
		data : {"pno" : rows[1].innerHTML},
		success : re =>{
			
			let json = JSON.parse(re);
			console.log(json);
			var html =  '<tr>'+
'						<th>사이즈</th>'+
'						<th>재고</th>'+
'						<th>색상</th>					'+
'					</tr>';
			
			json.forEach( p => {
				// 반복변수명에 인덱스객체 하나씩 대입 			
				html +=  '<tr class="col-md-6">'+
							'<th>'+p.psize+'</th>'+
							'<th>'+p.pstock+'</th>'+
							'<th>'+p.pcolor+'</th>'+
						'</tr>';
			}) // 반복 end 
			document.querySelector('.ptable').innerHTML = html
			
			
			
		}
	})
	
}









