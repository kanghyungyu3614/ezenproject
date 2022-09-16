package java1.ch5클래스.EX13_비회원게시판_DB버전;

import java.util.Scanner;

public class BoardPage {
	  Scanner scanner = new Scanner(System.in); // 입력객체[ 함수 밖에 만든 이유??]
	  public static void main(String[] args) {
		// 메소드 호출 방식 : 1. static 2.new 
		BoardPage page = new BoardPage();
	    page.view();
	  } //main end
	  //0. 메인화면
	  void view () {
		    BoardPage page = new BoardPage(); // 메소드 호출용 객체
		    while(true){
		    	page.getBoardlist();
		    	System.out.println("1.글쓰기 2.글제목 선택 : "); // 1.안내[출력-print] -> 입력[scanner] -> 저장[변수]
		        int btn = scanner.nextInt();
		        if(btn==1) {page.regist();}
		        else if(btn==2) {page.getBoard();}
		        else {System.out.println("경고) 알수 없는 번호 입니다.");}
		    }	  
	  }
	  //1. 등록화면
	  void regist() {
		  System.out.println("==>>> 등록 페이지");
	  }
	  //2. 모든게시물 출력화면
	  void getBoardlist() {
		  System.out.println("==>>> 게시판");
		  System.out.println("번호\t작성자\t제목\t조회수");
	  }
	  //3. 개별게시물 출력 화면
	  void getBoard() {
		  System.out.println("==>>> 개별조회 페이지");
		  System.out.println("제목 :   ");
		  System.out.println("작성자 :  ");
		  System.out.println("조회수 :  ");
		  System.out.println("내용 : ");
		  //출력
		  System.out.println(" 1.뒤로가기 2.수정 3.삭제 : ");
		  int btn = scanner.nextInt();
		  BoardPage page = new BoardPage();
		  if(btn==1) {return ;}
		  else if(btn==2) {page.update();}
		  else if(btn==3) {page.delete();}
		  else {}
	  }
	  //4. 수정처리 출력 화면
	  void update() {
		  System.out.println("==>>> 수정처리 페이지");
	  }
	  //5. 삭제처리 출력 화면
	  void delete() {
		  System.out.println("==>>> 삭제처리 페이지");
	  }
  
}
