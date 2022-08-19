/**
 * 
 
     //p. 249
     자바스크립트 데이터 를 저장하는 방법
        1. 변수/상수
        2. 배열
        3. 객체
        let/const 객체명 = { 키1:값1
                            키2:값2
                            키3:값3
                            키4: function(){}
        				  }
 
 
 */
const pet = {
	name: "구름",
	eat : function(food){
		alert(this.name + '은/는 ' + food + '을/를 먹습니다.')
	}
}
pet.eat("밥")

//p. 250 속성 추가
//1. 객체 만들기
const student = {}
// 2.기존에 없는 키 접근 -> 새로운 속성 부여
student.이름 = "윤인성"
studnet.취미 = "악기"
student.장래희망 = "생명공학자"
//3. 객체 확인
console.log(student)

// 객체내 속성 제거
delete studnet.장래희망

console.log(student)

// p.251
const pet2 = {
	name: "구름",
	eat(food){
		alert(this.name +'은/는' +food+ '을/를 먹습니다.')
	    }
}
pet2.eat("밥")	

// p.254
// 1.
const 객체 = {
	name : "혼자 공부하는 파이썬",
    price : 18000,
    publisher: "한빛미디어"

}
