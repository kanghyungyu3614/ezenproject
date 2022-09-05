package java1.d배열;

import java.lang.reflect.Array;

public class EX1_배열 {
	public static void main(String[] args) {
		
		// 예1) p.180
		// 1. 배열 선언 
		int[] scores = { 83 , 90 , 87 };	// int형 배열 선언 , 3개 값 초기화 , 인덱스 0~2
		// 2. 배열 호출 
		System.out.println("배열[0] : " + scores[0] ); // 배열내 0번 인덱스 호출  -> 83
		System.out.println("배열[1] : " + scores[1] ); // 배열내 1번 인덱스 호출  -> 90 
		System.out.println("배열[2] : " + scores[2] ); // 배열내 2번 인덱스 호출  -> 87
		System.out.println("배열 : " + scores );			// 배열명 주소[번지] 호출 
		// 3. 배열 반복문 활용
		int sum = 0;
		for( int i = 0 ; i<scores.length ; i++ ) { // i는 0부터 배열의길이 미만 까지 1씩 증가 
			sum += scores[i]; // i번째 인덱스의 값 호출해서 sum변수에 누적 더하기 
		}// for end 
		System.out.println(" 총합 : " + sum );
		System.out.println(" 평균 : " + (sum/3.0) ); 
						// 1. sum/3 	-> int/int 		-> int 
						// 2. sum/3.0 	-> int/double 	-> double
		
		// 예2
		// 1.new 연산자를 이용한 선언 
		int[] 배열 = new int[3];	// int형 3개를 저장할수 있는 배열 [ 고정길이 ]
		
		// 2. for문 배열내 모든 인덱스 호출 
		for( int i = 0 ; i<배열.length ; i++ ) {
			System.out.println( 배열[i] );
		} // for end 
		
		// 3. 배열내 각 인덱스의 데이터 넣기 
		배열[0] = 100;	배열[1] = 93;  배열[2] = 20;
		
		// 4. for문 배열내 모든 인덱스 호출 
		for( int i = 0 ; i<배열.length ; i++ ) {
			System.out.println( 배열[i] );
		}
		// 5. 향상된 for문 
		for( int value : 배열 ) {
			// for( 반복변수 : 배열명 )
			// 배열내 첫번째인덱스 부터 마지막인덱스까지 반복변수에 하나씩 대입
			System.err.println( value );
		}
		
	}
}

/*
 	변수 : 데이터 1개 저장
 	배열 
 		1. *같은 타입[자료형/클래스]의 데이터 를 연속된 공간에 나열
 		2. 인덱스 : 저장되는 순서번호 
 		3. [ ] 
 		4. 제공받은 메소드 X ---> [js] push , splice 
 		-배열 선언 
 			1. 타입[] 배열명;	2. 타입 배열명[];
 		-배열 생성
 			1. 타입[] 배열명 = { 값0 , 값1 , 값2 , 값3 ~~ }	: 배열선언과 동시에 값 대입 
 				* 배열에 미리 값 넣을때 
 			2. 타입[] 배열명 = new 타입[ 길이 ]				: 배열의 길이만큼 선언[ 초기값 ]
 				* 배열의 길이를 미리 설정할때					정수:0 실수:0.0 클래스:null
 		-배열 호출 
 			배열명 : 배열의 메모리 주소(번지)
 			1. 배열명[인덱스번호]
 		-특정 인덱스의 데이터 변경[대입/수정]
 			1. 배열명[인덱스번호] = 새로운 데이터 
 		-배열 길이 
 			배열명.length : 배열의 길이 
 		-반복문 활용
 			for( 자료형 변수명 : 배열명 ) { 실행문 }
 */

