/**
 * 
 */
 let counter = 0;
 let isConnect = false;
 
 //요소 객체 들
 const h1 = document.querySelector('h1')
 const p = document.querySelector('p')
 const connectBtn = document.querySelector('#connect')
 const disconnectBtn = document.querySelector('#disconnect')   
 const connectIncrease = document.querySelector('#connectIncrease')
 const disconnectIncrease = document.querySelector('#disconnectIncrease')    
 //출력하는 함수
 const listener = () =>{ h1.textContent =  `클릭횟수 : ${counter++}`}
 const dislistener = () =>{ h1.textContent =  `클릭횟수 : ${counter--}`}
//1. 연결 버튼을 클릭했을때 
connectBtn.addEventListener('click', ()=>{
	if( isConnect == false){
		h1.addEventListener('click', listener)
		p.textContent = '이벤트 연결 상태 : 연결'
		isConnect = true;
	}
	
	
})
// 1-1 증가버튼
connectIncrease.addEventListener('click', ()=>{
		if( isConnect == true){
		  counter++
		  h1.textContent =  `클릭횟수 : ${counter}`
	    }	
})
// 1-2 감소버튼
disconnectIncrease.addEventListener('click', ()=>{
		if( isConnect == true){	
		  counter--	
		  h1.textContent =  `클릭횟수 : ${counter}`
		}	
})



//2. 연결해제 버튼을 클릭했을때
disconnectBtn.addEventListener('click' ,()=>{
	if(isConnect == true){
		h1.removeEventListener('click', listener)
		p.textContent = '이벤트 연결 상태 : 해제'
		isConnect = false;
	}
	
	
	
})















