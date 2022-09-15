package java1.d클래스.EX12;

import java.util.Scanner;

//print , scanner : 입/출력 작성할 예정 

	/*
	 *  [ 과제 ]
	 * 	1. main 메소드를 제외한 static 없이 구현 
		2. 패스워드 검증 함수 
	 * 
	 */

public class view {
	// * 함수 밖에 scanner 선언한 이유 : 모든 함수에서 같이 사용할려고 [ 필드 ]
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// 1. static 사용 버전
		start(); // 함수 호출 
		// 2. static 없는 버전 
			// view view = new view();
			// view.start();
		
	}
	// 1. 프로그램 시작하는 화면 구현 함수 [ 매개변수x / 반환x / 정적메소드: 호출시 객체 생략 가능 ]
	static void start() {
		while(true) { // 무한루프 
			view_boardlist(); // 무조건  view_boardlist( ) 함수 호출 
			System.out.print("1.글쓰기 2.글보기 선택 : ");
			int ch = scanner.nextInt();
			if( ch == 1 ) { view_regist(); } // 만일 1번 입력했으면 view_regist(); 함수 호출 
			else if( ch ==2 ) { view_board(); } // 만일 2번 입력햤으면 view_board(); 함수 호출 
			else { System.out.println("안내) 알수 없는 번호입니다. ");} // 그외
		}
	} // start end 
	
	// 2. 게시물을 등록하는 화면 구현 함수 
	static void view_regist() { 
		System.out.println(">>> 게시물 등록 페이지 "); 
		System.out.print(" 제목 : "); 		String title = scanner.next();
		System.out.print(" 내용 : ");			String content = scanner.next();
		System.out.print(" 작성자 : ");		String writer = scanner.next();
		System.out.print(" 비밀번호 : ");		String password = scanner.next();
		// 1. 메소드 호출[ 통신 ] 
		boolean result = Controller.con_regist( title , content , writer , password );
		// 2. 메소드 호출한 결과
		if( result ) {
			System.out.println("안내) 게시물 등록 완료 ");
		}else {
			System.out.println("안내) 게시물 실패 [ 관리자에게 문의 ] ");
		}
		return;
	}
	
	// 3. 게시물 상세페이지 화면 구현 함수 
	static void view_board( ) { 
		System.out.print("게시물번호 선택 : "); 		int bnum = scanner.nextInt();
		System.out.println(">>> 게시물 상세 페이지 ");
		Board temp = Controller.boardlist[bnum]; //  새로운객체[임시객체]  = 입력받은 인덱스의 객체
		if( temp == null ) { System.out.println("안내) 없는 게시물번호 입니다."); return; } // 만약에 해당 객체가 null이면 함수 종료 
		System.out.println("제목 : " + temp.title  +"      작성자 : " + temp.writer );
		System.out.println("내용 : " + temp.content );
		System.out.print("1.뒤로가기 2.수정 3.삭제 선택 : ");	int ch = scanner.nextInt();
		if( ch == 1 ) {} 
		else if( ch== 2 ) { view_update( bnum ); } // 수정 화면 함수 호출 
		else if( ch == 3 ) { view_delete( bnum ); } // 삭제 화면 함수 호출 [ 매개변수 1개 int = 현재 보고 있는 게시물 ]
		else { } 
		return;
	} // m end 
	// 4. 게시물 목록 화면 구현 함수
	static void view_boardlist() { 
		System.out.println(">>>게시물 목록 페이지 ");
		System.out.println("번호\t\t작성자\t\t제목");
		for( int i = 0 ; i<Controller.boardlist.length; i++ ) {
			Board temp = Controller.boardlist[i]; // temp 객체의 목적 : 코드 줄이기
			if( temp != null ) {
				System.out.print( i +"\t\t");
				System.out.print( temp.writer +"\t\t"); // temp 미사용시 Contorller.boardlist[i].writer
				System.out.print( temp.title +"\n");
			} // if end 
		}// for end 
		return;
	} // m end 
	
	// 5. 게시물 삭제 함수 
	static void view_delete( int bnum ) {
		System.out.print("비밀번호 : "); String password = scanner.next();
		boolean result =  Controller.con_delete(bnum, password);
		if( result ) { System.out.println("안내) 게시물 삭제 성공 ");}
		else { System.out.println("안내) 게시물 삭제 실패 [ 관리자에게 문의 ] ");}
	} // m end 
	
	// 6. 게시물 수정 함수 
	static void view_update( int bnum ) {
		System.out.print("비밀번호 : "); 		String password = scanner.next();
		System.out.print("수정할 제목 : ");	String title = scanner.next();
		System.out.print("수정할 내용 : ");	String content = scanner.next();
	
		boolean result = 
				Controller.con_update(bnum, password, title, content);
	
		if( result ) { System.out.println("안내) 게시물 수정 성공");}
		else { System.out.println("안내) 게시물 수정 실패"); }
		
	} // m end 
	
	// 7. 비밀번호 검증 함수 ???? 
	
}

