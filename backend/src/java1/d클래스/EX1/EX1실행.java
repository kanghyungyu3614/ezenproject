package java1.d클래스.EX1;

public class EX1실행 {

	public static void main(String[] args) {
		// 1. 클래스 기반으로 객체 선언 
			// 1. 클래스명 	: 객체 생성시 사용되는 설계도 
			// 2. 변수명 		: 객체이름으로 사용할 임의로 정하기 
			// 3. new 연산자 	: 힙영역에 메모리할당후 주소값을 스택영역 할당 
			// 4. 생성자명 	: 객체 생성시 초기값 담당[ 클래스명과 동일 ] 
		Student s1 = new Student();
		// 1    2  =  3    4 
		// 스택 영역 =  힙 영역 
		System.out.println("s1 변수가 Student 객체를 참조합니다. ");
	
		Student s2 = new Student();
		System.out.println("s2 변수가 Studnet 객체를 참조합니다. ");
		/* 
		 	!! : 동일한 클래스로 객체 선언시 서로 객체[주소가 다름=메모리 다름]가 생성 
		 */
		
	}
}