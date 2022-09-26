package java1.ch12스레드;

import java.security.PublicKey;

public class 스레드A extends Thread {
  public 스레드A() {
	  setName("내 이름은 스레드A");	  
  }
  @Override
  public void run () {
	super.run();  
  }
}
