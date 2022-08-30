/**
 * 
 */
 let submitButtonArr = [];
function submitButton(){
// 한국이름
let  KoreanNameSubmit = document.querySelector("#KoreanNameSubmit").value
// 영문이름 
let  EnglishNameSubmit  = document.querySelector("#EnglishNameSubmit").value
// 이메일 주소
let  EmailAddressSubmit = document.querySelector("#EmailAddressSubmit").value
// 포트폴리오 
let PortfolioSubmit = document.querySelector("#PortfolioSubmit").value
// 희망 근무지
let WorkSpaceSubmit = document.querySelector("#WorkSpaceSubmit").nodeValue
// 현재상태
let WorkState = document.querySelector("#WorkState")

let ButtonArr = {
	한국이름 : KoreanNameSubmit,
	영문이름 : EnglishNameSubmit,
	이메일주소 : EmailAddressSubmit,
	포트폴리오 : PortfolioSubmit,
	희망근무지 : WorkSpaceSubmit,
	현재상태 : WorkState
}


for(let i=0; i<submitButtonArr.length; i++){
	submitButtonArr.push(ButtonArr)
}
	let html = `<tr>
				   <th>성명</th>
				   <th>영문명</th>
				   <th>메일주소</th> 
				   <th>포트폴리오</th>
				   <th>희망근무지</th>    
				   <th>현재상태</th>
				</tr>`
	html += `<tr>
				   <th>${ButtonArr.한국이름}</th>
				   <th>${ButtonArr.영문이름}</th>
				   <th>${ButtonArr.이메일주소}</th> 
				   <th>${ButtonArr.포트폴리오}</th>
				   <th>${ButtonArr.희망근무지}</th>    
				   <th>${ButtonArr.현재상태}</th>
				</tr>`		
				
				
				
	console.log("KoreanNameSubmit",KoreanNameSubmit)		
	console.log("EnglishNameSubmit",EnglishNameSubmit)
	console.log("EmailAddressSubmit",EmailAddressSubmit)
	console.log("PortfolioSubmit",PortfolioSubmit)
	console.log("KoreanNameSubmit",KoreanNameSubmit)
	console.log("KoreanNameSubmit",KoreanNameSubmit)	
	document.querySelector("#tableResult").innerHTML = html
          
	          
}