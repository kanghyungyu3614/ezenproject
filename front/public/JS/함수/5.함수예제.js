/**
 *   매개변수(인수)   : 함수 안으로 들어오는 수[변수/메모리]\
        가변 매개변수 함수 : 매개변수가 정해져있지 않는 경우
            -나머지 매개변수 문법 사용 
 */
// 1. 가변 매개변수 함수 선언 
 function sample( ...items ){
	console.log(items)
}

sample(1,2,3)
sample(1,2,3,4)