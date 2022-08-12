
function 함수1(){
	alert("함수1실행")
}
function 함수2(value){
	alert("함수2실행 매개변수: "+value)
}
function 함수3(value1,  value2){
	alert("함수3실행 매개변수: "+value1+ value2)
	return value1 + value2
}
function 함수4(){
	alert("함수4실행")
	return 10
}

함수1()
함수2(50) //함수 호출시 매개변수 전달
let result = 함수3(3 , 5 )


 
let result2 = 함수4()

//p.204 최솟값을 구하는 함수 
function min(array){  
	let output = array[0] //array에서 0번째 인덱스 호출해서 output 대입
	for (const item of array){
		//배열에 요소를 하나씩 item에 대입 반복
		   //for( 변수 in 배열) : 배열내 인덱스를 하나씩 대입 반복
		   //for( 변수 of 배열) : 배열내 요소의값을 하나씩 대입 반복
		if(output > item){  // 해당 값이 output보다 작으면 
			output = item   // output 해당 값으로 교체 
		}
	}
	return output  //함수가 종료되면서 함수호출했던 곳으로 반환[리턴]
}

const testArray = [52, 273, 32, 103, 275, 24, 57]
console.log(`${testArray}중에서`)
console.log(`최솟값 = ${min(testArray) }`) //함수 결과를 출력




