package java1.ch08인터페이스;

import java.util.Scanner;

public class EX2_실행 {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		게임패드 gpad;
		while(true) {
			System.out.println("1.축구 2.배행기 : ");
			int ch = scanner.nextInt();
			if(ch==1) { 
				gpad = new 축구게임();
			    System.out.println("축구게임시작");
			    게임스타트(gpad);
			}
			else if(ch==2){ 
				gpad = new 비행기게임();
				System.out.println("비행기게임시작");
				게임스타트(gpad);
			}
		}
	}
    public static void 게임스타트(게임패드 gpad) {
	   while (true) {
             char 버튼 = scanner.next().charAt(0);
             if(버튼 =='A') {gpad.A버튼();}
             if(버튼 =='B') {gpad.B버튼();}
             if(버튼 =='C') {gpad.C버튼();}
             if(버튼 =='E') {return;}
	}	
	}

}
