package java1.ch3조건문반복문;

//1. 클래스 선언 
public class EX1_IF { // CLASS S
	// 2. main() : 코드를 읽어주는 메소드
	public static void main(String[] args) { // MAIN S
		
		// 예1 ) : 참 실행문이 1개일때는 중괄호 생략 가능 
		if( 3 > 1 ) System.out.println("예1) 3이 1보다 크다");
		
		// 예2 ) : 조건이 true이면 실행 아니면 실행x
		if( 3 > 5 ) System.out.println("예2) 3이 5보다 크다"); 
		// 조건이 false 이기때문에 실행 안됨!!
		
		// 예3) p.136	[ 예상 : 점수가 93점이기때문에  첫번째 if만 실행 ]
		
		int score = 93; // 점수 변수 
		
		if( score >= 90 ) {	// 실행문( ; ) 2개 이상이면 { } 으로 묶음  // // 93 > 90 -> true 실행 O 
			System.out.println("점수가 90보다 큽니다. ");
			System.out.println("등급은 A입니다.");
		} // if end 
		
		if( score <90 ) // 93 < 90 -> fasle 실행x
			System.out.println("점수가 90보다 작습니다. ");
			System.out.println("등급은 B입니다."); // if와 상관없이 출력
		//////////////////////////////////////////////////////////
		if( score <90 ) {
			System.out.println("점수가 90보다 작습니다. ");
			System.out.println("등급은 B입니다."); // if와 상관없이 출력
		}
		
		// 예제4) p.137
		//int score = 85;
			// 변수선언시 : 중복이름 불가능 
		int score2 = 85;
		
		if( score2 >= 90 ) { // 85>=90 -> false -> 실행x
			System.out.println("예제4) 점수가 90보다 큽니다.");
			System.out.println("예제4) 등급은 A입니다.");
		} // if end 
		else { // 위 조건에서 false 이면 실행o
			System.out.println("예제4) 점수가 90보다 작습니다.");
			System.out.println("예제4) 등급은 B입니다.");
		} // else end 
		
		// 예제5 ) p.138		조건이 다수일때 1. if~elseif ( 하나의 true )		2. ( 다수의 true ) if 다중
		int score3 = 75;
		if( score3>=90 ) { 		System.out.println("점수가 100~90입니다."); System.out.println("등급은 A입니다. "); }
		else if( score3>=80 ) { System.out.println("점수가 80~89입니다."); 	System.out.println("등급은 B입니다. "); }
		else if( score3>=70 ) { System.out.println("점수가 70~79입니다."); 	System.out.println("등급은 C입니다. "); }
		else{ 					System.out.println("점수가 70 미만입니다."); 	System.out.println("등급은 D입니다. "); }
		// VS 
		if( score3 >= 90 ) { System.out.println("점수가 100~90입니다."); 	System.out.println("등급은 A입니다. "); }
		if( score3 >= 80 ) { System.out.println("점수가 80~89입니다."); 	System.out.println("등급은 B입니다. "); }
		if( score3 >= 70 ) { System.out.println("점수가 70~79입니다."); 	System.out.println("등급은 C입니다. "); }
		if( score3 <  70 ) { System.out.println("점수가 70 미만입니다."); 	System.out.println("등급은 D입니다. "); }
		
		// 예제6 if 중첩
		int score4 = 95;	char 성별 = 'M';
		if( score4 == 100 ) {
			if( 성별 == 'M') { System.out.println("100점 이면서 남자이다."); }
			else { System.out.println("100점 이면서 여자이다. ") ; }
		}else {
			if( 성별 == 'F') { System.out.println("100점 아니면서 여자이다."); }
			else { System.out.println("100점 아니면서 남자이다."); }
		}// if end 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // MAIN E
} // CLASS E
/*
	IF문 : 조건식의 결과에 따라 블록 실행 여부 결정 
		if( 조건식 ) {  조건이 true }
		- 조건식 : true · false / 비교연산자 , 논리연산자 , 변수 , 함수 
		
		if 형태 
			1. 
				if( 조건 ) 참			: 참[true] 위치에 실행문[ ; ]이 1개 이면 { } 생략 가능 
			2. 
				if( 조건 ) { 참 }		: 참[true] 위치에 실행문[ ; ]이 2개 이상일떄
			3. 
				if( 조건 ) { 참 }
				else{ 거짓 }
			4.
				if( 조건 ) { 참 }
				else if( 조건2 ) { 참2 } 
				else if( 조건3 ) { 참3 }
				else{ 거짓 }
			5.
				if( 조건 ) { 
					if( 조건 ) {
						참
					}else{
						거짓
					}
				}
	
*/