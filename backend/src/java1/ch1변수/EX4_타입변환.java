package java1.ch1변수;

public class EX4_타입변환 {
  
	
	public static void main(String[] args) {
	 
		
		//p.24
		byte 바이트변수 = 10;
		int 인트변수 = 바이트변수;   //int = byte [ 가능 = 자동타입 변환 ]
		// byte 바이트변수2 = 인트변수; //byte = int [ 불가능 = 강제 타입 변환 ]
		byte 바이트변수3 = (byte)인트변수; // 강제 타입변환 [ (자료형/클래스)변수/객체 ]
		
    }
	
	
	
}

/*
	   타입변환 = 자료형 변환 = 변수의 상자[크기] 변환
	   1. 자동 타입 변환 [작은 자료형 ---> 큰 자료형]
	      byte -> short -> int -> long -> float -> double
	      
	   2. 강제 타입 변환 [ 큰 자료형 --> 작은 자료형 ]
	      * 데이터 손실 
	      -  (자료형)변수명
	      
	   3. 연산시 타입 변환
	      1. [정수] int 보다 작은 수 끼리 연산시 -> 연산결과 int형
	      2. [실수] 끼리 연산시 => 연산결과 double형
	      
	   4. 문자열 ---> 기본 타입 
	      Integer.parseInt( 문자열 ) -> 숫자
	          // 주의점 : "a" -> 불가능     // "10"[문자열]  -> 10[정수열]
	           * 
	         
 */
 