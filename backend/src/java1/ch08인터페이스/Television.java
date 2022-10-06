package java1.ch08인터페이스;
	// implements 인터페이스 : 구현하다.(추상을 구현)
	//extends 클래스 : 연장하다 ( 상속 )
	public class Television implements RemoteControl {
	
	//1. 필드
	private int volume;
    //2. 생성자
		
	//3. 메소드 	
		
		
	
	// RemoteControl 인터페이스의 추상메소드를 구현하자.
	@Override
	public void turnOn() {
	    System.out.println(" TV를 켭니다.");	
	}
	@Override
	public void turnOff() {
		System.out.println(" TV를 끕니다.");	
		
	}
	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 tv 볼륨 : " + this.volume);
	}
}
