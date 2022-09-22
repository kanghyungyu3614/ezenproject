package java1.선생님가계부;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	
	Scanner scanner = new Scanner(System.in);
	Controller control = new Controller();	// 메소드 호출 할려고 객체 생성 
	
	public static void main(String[] args) {  
		View view = new View();    // 메소드 호출 할려고 객체 생성 
		view.menu(); 
	}
	// 0.메인메뉴 화면 메소드 
	void menu() {
		while( true ) {
			read();
			System.out.println("1.추가 2.수정 3.삭제 4.검색 5.통계");
			int btn = scanner.nextInt();
			if( btn == 1 ) { create(); }
			else if( btn == 2 ) { update(); }
			else if( btn == 3 ) { delete(); }
		}
	}
	// 1. 내용 추가 화면 메소드 
	void create() { 
		System.out.print("날짜 : "); String edate = scanner.next();
		System.out.print("금액 : ");	int emoney = scanner.nextInt();
		System.out.print("내용 : ");	scanner.nextLine(); String ecomment = scanner.nextLine();
		boolean result = control.create( edate , emoney , ecomment );
		if( result ) { System.out.println("등록성공");}
		else { System.out.println("등록실패");}
	}
	// 2. 내용 출력 화면 메소드 
	void read() {
		ArrayList< ExpenseDTO > list = control.read();
		System.out.println("번호\t날짜\t\t금액\t내용");
		for( ExpenseDTO dto : list ) { // list에서 dto 하나씩 꺼내오기 
		// for( 타입파라미터 임시변수 : 리스트/배열 ) {}
			System.out.print(dto.getEno() +"\t");
			System.out.print(dto.getEdate() +"\t");
			System.out.print(dto.getEmoney() +"\t");
			System.out.print(dto.getEcomment() +"\n");
		}
	}
	// 3. 내용 수정 화면 메소드 
	void update() { 
		System.out.println("수정할 번호 : "); int eno = scanner.nextInt();
        System.out.println("수정할 날짜 : "); String edate = scanner.next();
        System.out.println("수정할 금액 : "); int emoney = scanner.nextInt();
        System.out.println("수정할 내용 : "); scanner.nextLine();String ecomment = scanner.nextLine();
	    control.update(eno, edate, emoney, ecomment);
	    
	}
	// 4. 내용 삭제 화면 메소드 
	void delete( ) {
        System.out.println("삭제할 번호 : ");
        int eno = scanner.nextInt();
        boolean result = control.delete(eno);
        if(result ==true) {
        	System.out.println("삭제성공");
        }
        else {System.out.println("삭제번호[ 삭제할 번호가 없다 or db오류]");}
}


}

