/**
 * 
 */
// 1.js 태그 속성
const header = document.createElement('h1')
//2. 텍스트 조작
header.textContent = 'js에서 만든 태그'
header.style.color = 'white'
header.style.backgroundColor = 'black'
// 3. 해당 태그에 하위태그로 객체를 추가
document.body.appendChild(header)

const divA = document.querySelector("#first")
const divB = document.querySelector("#second")
const h1 = document.createElement('h1')
h1.textContent = '이동하는 h1 태그'
const toSecond = () =>{
	divB.appendChild(divA)
	setTimeout(toFirst , 2000)
}


const toFirst = () => {
	divA.appendChild(h1)
    setTimeout( toSecond, 2000)
}
toFirst()



setTimeout(toSecond, 3000)



const h2 = document.querySelector('h2')
setTimeout( ()=>{ h2.parentNode.removeChild(h2) } , 3000)

const 익명함수 = () =>{h2.parentNode.removeChild(h2) }
setTimeout ( 익명함수, 3000)

function 함수 (){
	h2.parentNode.removeChild(h2)
	document.body.removeChild(h2)
}
setTimeout(함수, 3000)
