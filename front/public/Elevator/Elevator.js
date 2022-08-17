/**
 * 
 */
let ElevatorFloor = 5;
let ElevatorMine =2;




document.getElementById("State_Mine").innerHTML = `내 층수 :  ${ElevatorMine}`





function up_button (){
	ElevatorFloor += 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
	if(ElevatorFloor>15){
	alert("더이상 움직일수 없습니다.")
	ElevatorFloor -= 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
}
}




function down_button (){
	ElevatorFloor -= 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
	if(ElevatorFloor<0){
	alert("더이상 움직일수 없습니다.")
	ElevatorFloor += 1;
	document.getElementById("State_Elevator").innerHTML = `엘리베이터 층수 : ${ElevatorFloor}`
}
}