/**
 * 
 */
let ElevatorFloor = 5;
let ElevatorMine =2;
let Elevator = document.getElementById("elevator")
let UpDownNum = 0
document.getElementById("State_Mine").innerHTML = `내 층수 :  ${ElevatorMine}`

function up_button (){
	//이동하는 함수
	if(UpDownNum>0){
		UpDownNum -= 100
		UpTansFrom()
	}
	else if(UpDownNum<=0){
		UpDownNum += 100
		UpTansFrom()
	}

	function UpTansFrom(){
	 
	 	
	 Elevator.style.transform = "translateY("+(UpDownNum)+"px)";	
	 console.log(UpDownNum)
	}
    
    
    // 숫자가 변하는 거 
	ElevatorFloor += 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
	//엘리베이터가 15층보다 높을때 
	if(ElevatorFloor>5){
	alert("더이상 움직일수 없습니다.")
	UpDownNum = -100;
	console.log(UpDownNum)
	ElevatorFloor -= 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
    }
    //1층에 도착했을때 
    if(ElevatorFloor===1){
	document.getElementById("State_Elevator").innerHTML = `1층에 도착했습니다.`
	}
}




function down_button (){
    //이동하는 함수

    function DownTansFrom(){
	 UpDownNum -= 100
	 Elevator.style.transform = "translateY("+(-UpDownNum)+"px)";	
	 console.log(UpDownNum)
	}
    DownTansFrom()
    
    // 숫자가 변하는 거
	ElevatorFloor -= 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
	
	//엘리베이터가 2층에 도착했을때
	if(ElevatorFloor === ElevatorMine){
	alert("엘리베이터가 도착했습니다.")
	document.getElementById("State_Mine").innerHTML = "엘리베이터가 도착했습니다."
}
	
	//엘리베이터가 1층에 도착했을때
	if(ElevatorFloor===1){
	document.getElementById("State_Elevator").innerHTML = `1층에 도착했습니다.`
	}
	//엘리베이터가 0층보다 낮을때 
	if(ElevatorFloor<0 || UpDownNum===-500){ 
	alert("더이상 움직일수 없습니다.")
	ElevatorFloor += 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
	UpDownNum = 400
	console.log(UpDownNum)
	Elevator.style.transform = "translateY("+(UpDownNum)+"px)";
}



}