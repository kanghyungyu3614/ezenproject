package java1.ch5클래스.EX18_접근제한자.getset메소드;

public class Car {
    //1. 필드 [필드정보를 보호하기 위해 모든 필드 private 권장] 
	private int speed; //private : 다른 클래스에서 접근 불가
	private boolean stop;
	//2. 생성자
	
	//3. 메소드[ 필드에 직접 접근이 불가능하니까 필드에 간접접근 메소드 선언]
    public int getSpeed() {return speed;}
    //객체명.setSpeed(500)[권장o]
    public void setSpeed() {
    	if(speed<0) {this.speed = 0; return;}
    	else { this.speed = speed;}
    }
    
    public boolean isStop() {return stop;}
    public void setStop(boolean stop) {
    	this.stop=stop;
    	this.speed=0;
    	
    }
}
