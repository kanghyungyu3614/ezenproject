package java1.ch12스레드;

import java.util.Scanner;

public class Music extends Thread {
	private boolean stop = true;
	
	public void setStop (boolean stop) {
		this.stop = stop;
	}
	  @Override
	public void run() {
		while(stop) {
			System.out.println("음악재생중~~~");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
		}
	}
}
