package java1.ch12스레드.타이머;

import java.util.Scanner;

public class Ex_실행 {
	
	
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		Timer timer = new Timer(); // 타이머객체 = 멀티 스레드 선언 
		boolean timerstate = false;	// 타이머 현재 실행상태 변수 
		boolean waitstate = true;	// 타이머 현재 일시정지 상태 변수 
		
		while(true) {
			System.out.println("1.타이머시작 2.리셋 3.저장[db]");
			int ch = scan.nextInt();
			
			// 1. 타이머 처음 켰을때 
			if( ch== 1 && timerstate == false && waitstate == true ) {
				timer.start();  timerstate = true; 
			}
			// 2. 타이머가 켜져 있을때 일시정지 
			else if( ch== 1 && timerstate == true && waitstate == true ) { 
				timer.setWait(false);  	waitstate = false;
			}
			// 3. 타이머가 켜져 있을때 일시정지 해제
			else if( ch== 1 && timerstate == true && waitstate == false  ) { 
				System.out.println("ㅇㅇ");
				timer.setWait(true);	waitstate = true;
			}
			// 4. 타이머가 켜져 있을때 리셋
			else if( ch== 2 ) { 
				// timer.stop(); -- 비권장
				timer.setStop( false ); // -- 안전하게 종료
				timerstate = false; 	waitstate = true;
				timer = new Timer(); 
			}
		}
	}

}

/*
 
 	멀티스레드 
 		1. Thread 클래스 상속
 		2. Runnable 인터페이스 구현
 	
 		* run 메소드 구현 
 		* start 메소드로 run 호출 
 */