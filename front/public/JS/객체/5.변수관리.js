/**
     * 학생 점수 프로그램
       1. 학생 객체 설계
       2. HTML에서 입력받은 데이터를 JS객체에 저장
      
 */
 let studentlist = []
 학생출력()
 
 
 function 점수등록(){
	
	 const student ={
		name : document.getElementById("name").value,
		kor : Number(document.getElementById("kor").value),
		eng : Number(document.getElementById("eng").value),
		math : Number(document.getElementById("math").value) 
	}
	
	if(이름중복체크(student.name)){
		return 
	}
	
	studentlist.push(student)
	
	alert("학생 점수 등록이 되었습니다.")
	
	document.getElementById("name").value = ""
	document.getElementById("kor").value = ""
	document.getElementById("eng").value = ""
	document.getElementById("math").value = ""
	
	학생랭킹()
	학생출력()
}


function 이름중복체크(name){
	for(let i=0; i<studentlist.length; i++){
	if(studentlist[i].name === name){
		alert("이미 존재한 학생명입니다.")
		return true;
	}
}
    return false;
}

function 학생출력(){

	let html ="<tr>" +
	                "<th>등수</th>" +
	                "<th>학생명</th>" +
	                "<th>국어</th>" +
	                "<th>영어</th>" +
	                "<th>수학</th>" +
	                "<th>총점</th>" +
	                "<th>평균</th>" +
	                "<th>비고</th>" +
	          "</tr>"
	          
	for(let i=0; i<studentlist.length; i++){
		let sum =studentlist[i].kor + studentlist[i].eng+studentlist[i].math
		let avg = sum/3
		
		// i는 0부터 배열내 마지막인덱스까지[배열의 길이-1] 1씩 증가반복
		html += "<tr>" +
	                "<th>"+i+"</th>" +
	                "<th>"+studentlist[i].name+"</th>" +
	                "<th>"+studentlist[i].kor+"</th>" +
	                "<th>"+studentlist[i].eng+"</th>" +
	                "<th>"+studentlist[i].math+"</th>" +
	                "<th>"+sum+ "</th>" +
	                "<th>"+avg+"</th>" +
	                "<th><button onclick='학생삭제("+i+")'>삭제</button></th>" +
	          "</tr>"
		 
	}          
	
	   
	          
    document.getElementById("listtable").innerHTML = html

}
function 학생삭제(i){
	studentlist.splice(i,1)
	학생출력()
	학생랭킹()
}

function 학생랭킹(){
	let len = studentlist.length;
	let min = "";
    for(let i=0; i<len; i++){
       for(let j=0; j<len; j++){
		let isum =studentlist[i].kor + studentlist[i].eng+studentlist[i].math
		let iavg = Math.floor(isum/3)
		let jsum =studentlist[j].kor + studentlist[j].eng+studentlist[j].math
		let javg = Math.floor(jsum/3)
	    if(iavg < javg){
		min = studentlist.splice(j,1)
			if(i===0){
				studentlist.unshift(min[0])
			}
			else{
				studentlist[i] = min[0]
				min = ""
				continue;	
			}
	    }else if(iavg > javg || iavg === javg){
		continue;
	    }
     }	
   }
   return true;
}














