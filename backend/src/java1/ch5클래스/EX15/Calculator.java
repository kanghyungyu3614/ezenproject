package java1.ch5클래스.EX15;

public class Calculator {

	// 1. 필드
	double pi1 = 3.14159;			// 인스턴스 필드 	= 객체 마다 메모리 할당 
	static double pi2 = 3.14159;	// 정적 필드		= 메소드영역 메모리 할당
	
	// 인스턴스 메소드	1
	int plus1( int x , int y ) {  return x + y; }
	
	// 정적 메소드  1 
	static int plus2( int x , int y ) {	 return x + y; }
	
	// 인스턴스 메소드 2 	
	int minus1( int x , int y ) { return x - y; }
	
	// 정적 메소드  2
	static int minus2( int x , int y ) { return x - y; }
	
	
}