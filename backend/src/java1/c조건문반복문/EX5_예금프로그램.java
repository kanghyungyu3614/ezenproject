package java1.c조건문반복문;
import java.util.Scanner;
// p.161 확인문제7
public class EX5_예금프로그램 {
   public static void main(String[] args) {
     
	   
	boolean run = true;
    int balance = 0;
    Scanner scanner = new Scanner(System.in);
    while(run) {
    	System.out.println("------------------------");
    	System.out.println("1.예금 2.출금 3.잔고 4.종료");
    	System.out.println("------------------------");
    	System.out.println(" 선택> "); int ch = scanner.nextInt();
    	if( ch==1){ System.out.println("안내) 예금액>"); balance += scanner.nextInt();}
    	else if(ch==2) {
    		int money = scanner.nextInt();
    		if(balance < money ){
    			System.out.println("안내) 잔액이 부족합니다.");
    		}else {
    			balance -= money;
    		}
    		System.out.println("안내) 출금액>"); 
    		balance -= scanner.nextInt();
    	}
    	else if(ch==3) {System.out.println("안내) 잔고>" + balance);}
    	else if(ch==4) {break;}//return 은 함수가 나가짐.
    	else {System.out.println("안내) 알수 없는 번호 입니다.");}
    }
    System.out.println("프로그램 종료");
 
  }
}
