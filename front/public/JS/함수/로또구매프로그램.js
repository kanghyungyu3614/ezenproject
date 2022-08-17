/**
 * 
       로또 구매
          1. 6개 버튼 선택한다.
                 조건 : 한번클릭(선택), 중복배제 , 최대 6개 
          2.컴퓨터 추첨번호[1~45난수] 생성       
          3. 사용자 추첨번호 비교 결과
      
 */
 // 전역변수 vs 지역변수 
 //변수는 지역변수 특징 = {} 안으로 들어갈수 있다. { } 밖으로 못나감 
 let select_numbers = [] //내가 선택한  // 여러 함수에서 사용될 예정 
 let lotto_numbers = [] //컴퓨터가 입력한 
 let Match_Result = 0
 
 
  // 1. 버튼 만들기 함수
 function btn_print(){
	let btnlist = ''  // 1~45의 버튼을 저장하는 변수
	for(let i=1; i<=45; i++){
		// i를 1부터 45까지 1씩 증가 반복
		btnlist += `<button id=${i} onclick=btn_click(${i})>${i}</button>`
		if( i%5===0){
			btnlist += '<br>'
		}
	}
	document.getElementById('btnbox').innerHTML = btnlist;
}

// 2. 버튼 눌렀을때 함수 

function btn_click(i){
	
	// 배열내 존재하는 숫자 인지 확인 
	let index = select_numbers.indexOf(i);	

	//배열내 존재하는 숫자 확인 
	if( index >= 0 ){
		alert("이미 선택한 번호입니다. [ 다시 선택 ]")
		select_numbers.splice(index, 1)
	}
	else{
	// 배열내 개수 체크	
	if(select_numbers.length ==6 ){
		alert("더 이상 선택할수 없습니다.")
	   return 
	}
		select_numbers.push(i)
	}
	
	document.getElementById("selectbox").innerHTML = select_numbers

}
//3. 추천번호 생성 함수
function lotto_number(){
	if(select_numbers.length != 6 ){
		alert('6개 수를 모두 입력후 추첨 해주세요.')
		return 
	}
	//난수 생성 [1 ~45]
	while(true){  // 무한루프 [추첨번호가 6개 되면 종료]
		let rand = Math.floor((Math.random()*45)+1)   // 0~1 사이의 실수 생성
		let index = lotto_numbers.indexOf( rand)
		if(index>=0){
			
		}
		else{
			if(lotto_numbers.length===6){
				break; // 가장 가까운 반복문 탈출  
			}else{  //배열내 수가 6개 가 아니면 해당 난수를 배열에 저장 
				lotto_numbers.push(rand)				
			}
		}
	}
     document.getElementById("lottobox").innerHTML = lotto_numbers
     lotto_result()
}

// 4. 추첨번호 비교 결과 함수 
function lotto_result(){
	
for(let i=0; i<6; i++){
	for(let j=0; j<6; j++){
		if(select_numbers[i]==lotto_numbers[j]){
			Match_Result +=1 
		}
		else{
			continue;
		}
	}
}
let msg = ''
if(Match_Result ==0){msg += "꽝"}
else if(Match_Result ==1){
	msg += "1개 맞았습니다.[5등]"
}
else if(Match_Result ==2){
	msg += "2개 맞았습니다.[4등]"
}
else if(Match_Result ==3){
	msg += "3개 맞았습니다.[3등]"
}
else if(Match_Result ==4){
	msg += "4개 맞았습니다.[2등]"
}
else if(Match_Result ==5){
	msg += "5개 맞았습니다.[1등]"
}

document.getElementById("resultbox").innerHTML = msg

return 

	
}
 
 

 
 
 
 
 
 
 