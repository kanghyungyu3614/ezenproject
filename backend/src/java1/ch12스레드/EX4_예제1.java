package java1.ch12스레드;

import java.util.Scanner;

public class EX4_예제1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean musicstate = false;	// 음악 재생여부 판단 변수 
		Music music = new Music();  // 음악 스레드 선언 
		
		boolean moviestate = false; // 영화 재생여부 판단 변수 
		Movie movie = new Movie();	
		Thread thread = new Thread(movie); // 영화 스레드 선언 
		
		while( true ) {
			if( musicstate == false ) System.out.print("1.음악[재생]   ");
			else System.out.print("1.음악[중지]    ");
			if( moviestate == false ) System.out.print("2.영화[재생]   ");
			else System.out.print("2.영화[중지]    ");
			
			int ch = scanner.nextInt();
			
			if( ch == 1 && musicstate == false ) {  // 음악스레드 시작
				music.start();			
				musicstate = true;
			} else if( ch == 1 && musicstate == true ) {
				music.setStop(false);
				musicstate = false;		music = new Music();
			}
			if( ch == 2 && moviestate == false ) {
				thread.start();	moviestate = true;
			} else if( ch == 2 && moviestate == true ) {
				movie.setStop(false);
				moviestate = false;	thread = new Thread(movie);
			}
			
		}
	}
}

/*
 
 	1. Thread 클래스 
 	2. Runnable 인터페이스 
  
 */