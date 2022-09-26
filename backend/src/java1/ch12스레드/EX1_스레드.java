package java1.ch12스레드;

import java.awt.Toolkit;

public class EX1_스레드 {
public static void main(String[] args) {
	   System.out.println("싱글스레드 시작");
	   Toolkit toolkit = Toolkit.getDefaultToolkit();
	   for(int i=0; i<10; i++) {
		   toolkit.beep();
		   try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
	   }
	   for(int i=0; i<5; i++) {
		   System.out.println("띵");
		   try {
			Thread.sleep(500);
		} catch (Exception e) {}
	   }
	   
	   /////////////////////////
	   // p.526 
	   System.out.println("멀티스레드 시작");
	   Runnable beepTask= new BeepTask();
	   Thread thread = new Thread(beepTask);
	   for(int i=0; i<5; i++) {
		   System.out.println("띵");
		   try {
			Thread.sleep(500);
		} catch (Exception e) {}
	   }
	   // 
	   
	   
	   System.out.println("익명 구현객체");
	   Thread thread2 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	});
	   
	  
	   
	   // 4 . 529 : thread 클래스 객체
	   
	   
	   return ;
	   
}
}
