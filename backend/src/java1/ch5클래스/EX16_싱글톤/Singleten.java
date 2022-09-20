package java1.ch5클래스.EX16_싱글톤;

public class Singleten {
	
	private static Singleten s1 = new Singleten();
	
	// 싱글톤 : 객체 1개만 선언 가능한 클래스
		// 방법 : 
		// 1. 외부에서 생성자를 못쓰게 하자
			// private Singleten() {}
		// 접근제한자 : 
			// private : 현재 클래스에서만 호출 가능 
			// public	: 프로젝트 어디서든 호출 가능 
	
		// 2. 필드에 정적 객체 선언 
			// private static 클래스명 객체명 = 생성자();
	
		// 3. 정적싱글톤객체 반환 메소드  [ 외부에서 간접 접근 ] 
			// public static Singleten 메소드명(){ return 싱글톤객체명; }
	
	private Singleten() {}
	
	public static Singleten getInstance() {
		return s1;
	}
	
}