package java1.ch08인터페이스;

public class EX_1실행 {
	public static void main(String[] args) {
	   // 1. 객체 [인터페이스x]
	   Television tv = new Television();
	   // 1. 인터페이스 구현 객체
	   // 인터페이스 변수명 = new 구현클래스();
	   RemoteControl rc = new Television();
	   
	   // 2. 메소드 실행
	   rc.turnOn(); // 텔레비전 전원
	   rc.setVolume(5);
	   rc.turnOff();
	   
	   // 3. tv -> audio 인터페이스 변수에 구현객체 변경 
	   rc = new Audio();
	   
	   //
	   rc.turnOn();
	   rc.setVolume(7);
	   rc.turnOff();
	   System.out.println("audio ---> 스마트tv 변경");
	   
	   SmartTelevision stv = new SmartTelevision();

	   rc = stv;
	   rc.turnOn();
	   rc.setVolume(5);
	   rc.turnOff();
	   Searchable sc = stv;
	   sc.search("11번");
	}
}
