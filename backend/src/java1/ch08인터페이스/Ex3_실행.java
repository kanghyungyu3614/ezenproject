package java1.ch08인터페이스;

public class Ex3_실행 {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		
		// 구현객체 교체
		myCar.frontLeftTire = new KumhoTire();
		myCar.frontRightTire = new KumhoTire();
	}
}
