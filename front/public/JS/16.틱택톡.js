/**
 * 
         틱택톡(삼목)
         1.게임판 구현
         2. 버튼 눌림 기능
         3. 사용자(선택) vs 컴퓨터(랜덤)
         4. 승리자 판단

 */
게임판그리기()
 // 1.게임판 출력하는 함수
 function 게임판그리기(){
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
	alert(i +"버튼눌림")
    //사용자 선택한 버튼의 id의 html -> o 변경
	document.getElementById(i).innerHTML = 'O'
	//[컴퓨터] 난수 발생
	// Math            //Math : 수학 내장 객체
	//random()         //Math.random() 0~1사이의 난수 발생
	                   //Math.random() * 끝번호-1
	                   //Math.random() * 끝번호 + 1 : 1~10 사이의 난수
	let rand = Math.floor(Math.random() )* 9 // 0~8
	alert(" 난수 : " + rand )
	document.getElementById(rand).innerHTML = 'X'
	
	}                   
 // 3. 게임 상태(상황) 함수
 function 상황출력(){}
 // 4. 게임 결과 함수
 function 게임결과(){}
