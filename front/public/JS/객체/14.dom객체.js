/*
	contextmenu : 오른쪽 클릭[ 메뉴 ]했을때 이벤트 
*/

// 1.모든 사진들의 요소 호출 
const imgs = document.querySelectorAll('img')
	// 배열[객체] = ???????? All --> 여러개 --> 배열 ( 인덱스 )

// 2. 
for( let i = 0 ; i<imgs.length; i++ ){
	imgs[i].addEventListener( 'contextmenu' , (event) => {
		event.preventDefault()
	})
}
// 3. 
for( let i in imgs  ){
	if( imgs.length-1 == i ){ break }   // 마지막 인덱스 제외
	imgs[i].addEventListener( 'contextmenu' , (event) => {
		event.preventDefault()
	})
}
// 4.
for( let i of imgs  ){
	i.addEventListener( 'contextmenu' , (event) => {
		event.preventDefault()
	})
}

// 5.
imgs.forEach( (img) => { 
	img.addEventListener( 'contextmenu' , (event) => {
		event.preventDefault()
	})
} )

/* --------------------------------------*/

let 상태 = false /* 체크박스를 체크 여부 저장 변수[ 체크이면 true / 체크X false] */

// html 요소 가져오기 
const 체크박스 = document.querySelector('input')

// 체크박스 에서 체크가 변경이 있을때 이벤트 실행 
체크박스.addEventListener('change' , ( 이벤트속성 ) => {  
	상태 = 이벤트속성.currentTarget.checked
	//상태 = 체크박스.checked
}) 

// html 요소 가져오기 
const 링크 = document.querySelector('a')
// 링크 를 클릭했을때 이벤트 발생 
링크.addEventListener('click' , (event)=>{ 
	if( !상태 ){ // ! 논리반대 : true -> false  // false -> true 
	//if(  상태 == false )
	//if( 상태 != true )
		// 만약에 상태가 false 이면  [ 체크가 안되어 있으면 ]
		event.preventDefault()
	}
})



