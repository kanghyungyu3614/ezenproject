package java1.가계부;

import java.util.Scanner;

public class AccountBookPage {
	
	
  Scanner scanner = new Scanner(System.in);	
  AccountBookControl control = new AccountBookControl();
  public static void main(String[] args) { AccountBookPage view = new AccountBookPage(); view.menu();
	AccountBookDao.getInstance();
  }
  
  
  
  void menu() {
	  while(true) {
		  read();
		  System.out.println("1.추가 2.수정 3.삭제 4.검색 5.통계");int btn = scanner.nextInt();
		  if(btn==1) {crate();}
		  else if(btn==2) {update();}
		  else if(btn==3) {delete();}
	  }
  }
  //1. 내용추가 화면 메소드 
  void crate() {
	  System.out.println("날짜 : "); String edate = scanner.next();
	  System.out.println("금액 : "); int emoney = scanner.nextInt();
	  System.out.println("내용 : "); scanner.nextInt(); String ecomment = scanner.nextLine();
	  
	  boolean result = control.create(edate, emoney, ecomment);
	          
  }
  //2. 내용출력 화면 메소드 
  void read() {}
  //3. 내용수정 화면 메소드
  void update() {}
  //4. 내용 삭제 화면 메소드
  void delete() {}
}

