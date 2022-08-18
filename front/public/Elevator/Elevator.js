/**
 * 
 */
let ElevatorFloor = 5;
let ElevatorMine =2;
let Elevator = document.getElementById("elevator")



document.getElementById("State_Mine").innerHTML = `내 층수 :  ${ElevatorMine}`





function up_button (){
    Elevator.style.transform = "translateY("-100+"px)";
	ElevatorFloor += 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
	//엘리베이터가 15층보다 높을때 
	if(ElevatorFloor>15){
	alert("더이상 움직일수 없습니다.")
	ElevatorFloor -= 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
    }
    //1층에 도착했을때 
    if(ElevatorFloor===1){
	document.getElementById("State_Elevator").innerHTML = `1층에 도착했습니다.`
	}
}




function down_button (){
	Elevator.style.transform = "translateY("+100+"px)";
	ElevatorFloor -= 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
	//엘리베이터가 0층보다 낮을때 
	if(ElevatorFloor===1){
	document.getElementById("State_Elevator").innerHTML = `1층에 도착했습니다.`
	}
	if(ElevatorFloor<0){ 
	alert("더이상 움직일수 없습니다.")
	ElevatorFloor += 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
}

if(ElevatorFloor === ElevatorMine){
	alert("엘리베이터가 도착했습니다.")
	document.getElementById("State_Mine").innerHTML = "엘리베이터가 도착했습니다."
}


}