/**
 * 
 */

 const input = document.querySelector('#inchbox')
 const button = document.querySelector('#inchbtn')
 const p = document.querySelector('#inchp')
 
 button.addEventListener( 'click', ()=>{
	
	const inch = Number(input.value)
	if(isNaN(inch)){
		p.textContent = "숫자를 입력해주세요"
		return 
	}
	// 입력값이 숫자이면
	const cm = inch = 2.54
	p.textContent = `${cm} cm`
})


const emailbox = document.querySelector("#emailbox")
const emailp =  document.querySelector("#emailp")

const isemail = (value) =>{
	return (value.indexOf('@')>1) && (value.split("@")[1].indexOf(".")>1)
	
}

emailbox.addEventListener('keyup',(event)=>{
	const value = event.currentTarget.value
	if(isemail(value)){
		p.style.color = "green"
		p.textContent = `이메일 형식 입니다. : ${value}`
	}else{
		p.style.color = 'red'
		p.textContent = `이메일 형식이 아닙니다. : ${value}`
	}
	
	
	
	
})




const selectbox = document.querySelector("#selectbox")
const selectp = document.querySelector("#selectp")


//selectbox 의 데이터가 변경 될때마다 실행되는 이벤트
selectbox.addEventListener('change', (event)=>{
	const options = event.currentTarget.options
	const index = event.currentTarget.options.selectedIndex
	
	selectp.textContent = `선택 : ${options[index].textContent}`
})



// selectbox2 가 데이터 변경 되었을때 
const selectbox2 = document.querySelector('#selectbox2')
const selectp2 = document.querySelector('#selectp2')

selectbox2.addEventListener('change', (event)=>{
	
	// 옵션목록 = selectbox2 모든 옵션을 
	const options = event.currentTarget.options
	const list = []
	
	for( const option of options){
		if(option.selected){
			list.push(option.textContent)
		}
	}
	selectp2.textContent = `선택 : ${list.join(',')}`
})


let 현재값 
let 변환상수 = 10;



const cmiput = document.querySelector("#cmiput");
const cmspan = document.querySelector("#cmspan");
const cmselect = document.querySelector("#cmselect");

cmselect.addEventListener('change', (event)=>{
	const options = event.currentTarget.options
	const index = event.currentTarget.options.selectedIndex
	변환상수 = Number(options[index].values)
	calculate()
})

const calculate = () =>{
	cmspan.textContent = (현재값*변환상수).toFixed(2)
} 

cmiput.addEventListener("keyup", (event)=>{
	현재값 = Number(event.currentTarget.value)
	calculate()
})

// 347p
let timer = 0;
let timerId = 0;
const timerinput = document.querySelector("#timerinput")
const timerh1 = document.querySelector("#timerh1")

timerinput.addEventListener('change', (event)=>{
	if(event.currentTarget.checked){ //체크가 되어 있는 상태 
		timerId = setInterval (()=>{
			timer +=1
			timerh1.textContent = `${timer}초`
		},1000)
	}else{  //체크가 안되어 있는 상태 
		clearInterval(timerId)
	}
})





// 

const radios = document.querySelectorAll('[name=pet]')
const output = document.querySelector('#output')

radios.forEach( (radio)=>{
	radio.addEventListener('change', (event)=>{
		const current = event.currentTarget
		if(current.checked){
			output.textContent = `좋아하는 애완동물은 ${current.value}이시군요!`
		}
	})
})






























