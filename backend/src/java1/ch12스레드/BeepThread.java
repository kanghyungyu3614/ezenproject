package java1.ch12스레드;

import java.awt.Toolkit;

public class BeepThread extends Thread {
	  @Override
	public void run() {
		// TODO Auto-generated method stub
		   Toolkit toolkit = Toolkit.getDefaultToolkit();
		   for(int i=0; i<5; i++) {
			   try {
				   toolkit.beep();
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		   }
	}
}
