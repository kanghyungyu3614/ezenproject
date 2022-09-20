package java1.ch5클래스.EX17_final;

public class EX17실행 {
 public static void main(String[] args) {
	//1. 객체 선언 
	// 클래스 객체명 = new 생성자();
	// Person p1 = new Person();
	 Person p2 = new Person("123456-1234567","홍길동");
	 p2.name = "USA"; // 오류 : final 필드는 수정 불가
	 
	 
}
}
