/**
 * 
         틱택톡(삼목)
         1.게임판 구현
         2. 버튼 눌림 기능
         3. 사용자(선택) vs 컴퓨터(랜덤)
         4. 승리자 판단

 */
 
let 게임상황 = [];     
let 승리 ='' 
게임판그리기()






 // 1.게임판 출력하는 함수
 function 게임판그리기(){
	
	승리 = '' // 승리 변수를 공백으로 초기화
	게임상황  =  [null,null,null,null,null,null,null,null,null]
	//function 함수 만들기 키워드 
	let 게임판 = '' //여러개 버튼(태그)을 저장하는 변수
	
	
	for(let i=0; i<9; i++){
		게임판 += `<button id=${i} onclick='버튼선택(${i})'>${i}</button>`
		//게임판 변수에 버튼(tag)을 누적 더하기
		if(i%3===2){
		//3배수 찾기  //2 5 8 인경우 줄바꿈처리하기
		게임판 += '<br>'	
		}
	}
	// 문서(html)의 id가 gameboard 의 
	document.getElementById(`gameboard`).innerHTML = 게임판
}





 // 2. 버튼 선택 함수
 function 버튼선택(i){
    //사용자 선택한 버튼의 id의 html -> o 변경

	if(중복검사[i]){ 
		 alert("안내)이미 둔 자리 입니다.")
		 return 
	}
	document.getElementById(i).innerHTML = 'O'
	 게임상황[i]='O'
	
	if(게임결과()){ //게임결과 함수에서 true가 리턴되면
		 alert("게임종료 승리 : " + 승리)
		 return //함수 강제 종료
	}
	
	
	 while( true ){
		let rand = Math.floor(Math.random()*9)
		if(!중복검사(rand))
		document.getElementById(rand). innerHTML = 'X'
		게임상황[rand] = 'X'
		break
	}
	 
	 
	//[컴퓨터] 난수 발생
	// Math            //Math : 수학 내장 객체
	//random()         //Math.random() 0~1사이의 난수 발생
	                   //Math.random() * 끝번호-1
	                   //Math.random() * 끝번호 + 1 : 1~10 사이의 난수
	
}         
	
	
	
	
	    

 // 3. 현재 위치에 알이 있는지 검사 함수 [중복검사]
 function 중복검사(i){
	if( 게임상황[i] != null){ //배열은 모두 null로 초기화했기 때문에 null 아니면 O또는x가 존재하는 의미 [ 알이 있다.]
		return true; //알이 있다.
	}else{
		return false; //알이 없다.
	}
	
}


 // 4. 게임 결과 함수
 function 게임결과(){
	//1. 가로로 이기는 수 [012 , 345, 678]
	for( let i = 0; i<=6; i+=3){
		// i는 0부터 6까지 3씩 증가반복 [ 3회 : 0 3 6 ]
		if(게임상황[i] !=null && 게임상황[i] == 게임상황[i+1] && 게임상황[i+1] == 게임상황[i+2]){
			승리 = 게임상황[i] //승리 변수에 i번째 알 저장
			return true
		}
	}
	//2. 세로로 이기는 수 [036, 147, 258]
	for(let i=0; i<=2; i++){
		if(게임상황[i] !=null && 게임상황[i] == 게임상황[i+3] && 게임상황[i+6]){
			승리 = 게임상황[i] //승리 변수에 i번째 알 저장
			return true			
		}
	}
	//3. 대각선으로 이기는 수 [048, 246]
	for(let i=0; i<=0;i++){
		if(게임상황[i] !=null && (게임상황[i] == 게임상황[i+4] && 게임상황[i+8])&&(게임상황[i+2] == 게임상황[i+4] && 게임상황[i+6])){
			승리 = 게임상황[i] //승리 변수에 i번째 알 저장
			return true			
		}		
	}
	
	//4. 무승부 [위 상황이 아니면서 알이 9개 이면]
	
	for(let i=0; i<=0;i++){
		
		
	}
	
	
	
}

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 