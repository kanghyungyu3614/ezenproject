package java1.ch08인터페이스;

public interface RemoteControl {
    //1. static final : 상수 키워드 생략시 자동으로 상수 선언
	//2. 초기값 필수 
	public int MAX_VOLUME = 10;
    public int MIN_VOLUME = 0;
    
    // 추상 : abstract == 요약,추상
    // 1. abstract : 추상 키워드 생략시 자동으로 추상 선언
    // 2. 선언만 하자 !!!!!!!!! ----------> 각 클래스에서 정의하자 [ 구현 객체 ]
    public abstract void turnOn();
    public void turnOff();
    public void setVolume(int volume);
}
