package java1.ch5클래스.EX16_싱글톤;

public class EX16실행 {

	public static void main(String[] args) {
	
		// 객체 선언 [ 클래스명 객체명 = new 생성자(); ]
		// 
		// Singleten s1 = new Singleten();	// 오류 : 생성자 private
		// Singleten s2 = new Singleten();	// 오류 : 생성자 private
		
		// Singleten.s1;	// 오류 : s1객체 private
		Singleten s3 =  Singleten.getInstance();
		Singleten s4 =  Singleten.getInstance();
		
		// s3 과 s4 객체는 같다.
		if( s3 == s4 ) { //  == 스택값 비교 .equals() : 힙값 비교 
			System.out.println(" 주소값이 같다. ");
		}else {
			System.out.println(" 다르다 .");
		}
		
	}
}