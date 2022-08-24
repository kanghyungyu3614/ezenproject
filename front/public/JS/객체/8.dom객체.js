/**
 * 
 */

document.addEventListener('DOMContentLoaded', ()=>{
	//1. 텍스트 조작
	const a = document.querySelector('#a') // 해당 id의 요소 가져오기
	const b = document.querySelector('#b') //
	
	a.textContent = '<h1> 텍스트 그대로 넣기 </h1>'
	b.innerHTML =   '<h1> html 형식으로 넣기 </h1>'
	//2. 속성 조작
	const rects = document.querySelectorAll('.rect')
	
	for( let i =0; i<rects.length; i++){
		const width = (i +1) * 100
		const src = `http://placekitten.com/${width}/250`
	    rects[i].setAttribute('src', src)
	    // 배열내 해당 i번째 인덱스의 태그에 속성을 추가[이미지 경로]
	}
	
	
	const divs = document.querySelectorAll('#divbox div')
	divs.forEach((div,index)=>{
		
		console.log(div, index)
		const val = index*10
		div.style.height = `10px`
		div.style.backgroundColor = `rgba(${val},${val},${val})`
	})
	
	
})
