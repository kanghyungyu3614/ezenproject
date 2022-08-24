/**
 * 
 */

 document.addEventListener('DOMContentLoaded', ()=>{  
	
	const header = document.querySelector('h1')
	
	header.textContent = '안녕~~'
	header.style.color = 'white'
	header.style.backgroundColor = 'black'
	header.style.padding = '10px'
	
}) 

document.addEventListener('DOMContentLoaded', ()=>{
	const headers = document.querySelectorAll('h1')
	console.log(headers)
	console.log(typeof(headers))
	// 배열내 데이터를 하나씩 꺼내는 방법
	//1.
    for(let i=0; i<headers.length; i++){
	    headers[i].textContent = '안녕' +i
    }
    //2.
    for(let index in headers ){
	     headers[index].textContent = '안녕'+index
    }
    //3.
    for(let object of headers){ 
	     object.textContent = '안녕'
    }
    //4.
    headers.forEach( (obj)=>{obj.textContent = '안녕~~~'})
})