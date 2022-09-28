package java1.ch12스레드.타이머;

import java.util.Scanner;

public class Timer extends Thread {
	// A클래스 extends B클래스 : 상속[연장]
	// A클래스 = 자식클래스		// B클래스 = 부모클래스 
	// A클래스는 B클래스의 멤버(필드,생성자,메소드) 접근할수 있다.

private boolean stop = true;
private boolean wait = true;

public void setStop(boolean stop) { this.stop = stop; }
public void setWait(boolean wait) { this.wait = wait; }

@Override // 부모클래스의 이미 존재하는 메소드 재정의한다.,
public void run() { 초단위(); }


private void 초단위() {
	int i = 1 ;
	while( stop ) {	// 외부에서 stop 변수 조작해서 함수 종료시키자 
		if( wait  ) {
			System.out.println( i +"초");
			try{ Thread.sleep(1000); }
			catch (Exception e) {}
			i++;
		}
	}
}
}