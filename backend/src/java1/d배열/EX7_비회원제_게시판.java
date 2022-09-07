package java1.d배열;

import java.util.Scanner;

public class EX7_비회원제_게시판 { // class s 

public static void main(String[] args) { // main s
	
Scanner scanner = new Scanner(System.in);	// 입력객체
//게시판 추가
String[][] boardlist =  new String[100][4]; // 문자열 400개를 저장할수 있는 배열 선언 [ 초기값 : null 400 개 ] 
	
	
while(true) {				
	System.out.println("----------- 1.커뮤니티 -----------");
	System.out.println("번호\t 작성자\t 제목\t");	
// 여기서 리스트를 출력해야한다.
	for( int row = 0 ; row<boardlist.length ; row++ ) {
		if( boardlist[0][0] == null) {
			break;
		}
		else if(boardlist[row][0] != null) {
			System.out.println(row+"\t"+boardlist[row][2]+"\t"+boardlist[row][0]);
			continue;			
		}
	}
	System.out.println("1.글쓰기\t 2.글보기\t 선택\t");
	int boardNumber = scanner.nextInt();
//글쓰기 버튼을 눌렀으면
   if(boardNumber==1) {
		System.out.println("-----------글쓰기 페이지-----------");
		//-----------제목: title-----------
		System.out.print("title : ");
		String BoardTitle = scanner.next();
		//-----------내용: content-----------
		System.out.print("content : ");
		String BoarContent = scanner.next();
		//-----------글쓴이: writer-----------
		System.out.print("writer : ");
		String BoardWriter = scanner.next();
		//-----------비밀번호: password-----------
		System.out.print("password : ");
		String BoardPassword = scanner.next();
		
		
		
				
				
				for( int row = 0 ; row<boardlist.length ; row++ ) {
				if( boardlist[row][0] == null ) { // row번째 게시판내용이 null이면 = 게시판 글 이 없다!! 
					// 2-2 : null 행 위치에 입력받은 데이터를 하나씩 대입
					boardlist[row][0] = BoardTitle;
					boardlist[row][1] = BoarContent;
					boardlist[row][2] = BoardWriter;
					boardlist[row][3] = BoardPassword;
					// 2-3 : 저장했으면 반복문 종료 [ 끝내기 ]
					break;
				} // if end 
				// 마지막 행까지 빈공간이 없으면 [ 최대 회원 100명 , 최대 행 인덱스 = 0~99 ]
				else if( boardlist[row][0] != null && row == 99 ) { 
					System.out.println("안내) 최대 회원수가 찼습니다. [회원가입불가능 : 관리자에게문의 ] ");
				}else { 
					continue;
				}
			}// for end 
				
	}							
	// 글보기 보튼을 눌렀으면
	else if(boardNumber==2) {
				System.out.println("----------- 보고싶은 게시글의 번호를 알려주세요. -----------");

				int BoardSee = scanner.nextInt();
				//게시물이 있는지 판별하는것
				int nothing = 0;
				for(int j=0; j<boardlist.length; j++) {
					if(boardlist[BoardSee][0] == null) {
						nothing = 1;
					}
				}
				if(BoardSee<0 || BoardSee>boardlist.length && nothing == 1) {
					System.out.println("그런번호는 없습니다.");
					//break; //continue? or break?
				}
				else if(nothing == 0) {
					System.out.println("----------- 게시물 상세페이지 -----------");
					System.out.println("작성자 : "+boardlist[BoardSee][2]+"   "+"제목 : "+boardlist[BoardSee][0]);
					System.out.println("내용 : "+boardlist[BoardSee][1]);
					System.out.println("-------------------------------------");
					System.out.println("1.목록보기(뒤로가기)"+" "+"2.글삭제"+" "+"3.글수정"+"\t"+"선택 : ");
				    //1.목록보기(뒤로가기)"+" "+"2.글삭제"+" "+"3.글수정"
					int Boardchoice =  scanner.nextInt();
				    //"1.목록보기(뒤로가기)"
				    if(Boardchoice==1) {
				    	continue; //continue ==> 커뮤니티로 가진다.
				    }
				    //"2.글삭제"
				    else if(Boardchoice==2) {
				    	//비밀번호를 입력하세요.
				    	System.out.println("비밀번호를 입력하세요.");
				    	String BoardPassword = scanner.next();
				    	if(BoardPassword.equals(boardlist[BoardSee][3])) {
				    		boardlist[BoardSee][0] = null;
				    		boardlist[BoardSee][1] = null;
				    		boardlist[BoardSee][2] = null;
				    		boardlist[BoardSee][3] = null;
				    		System.out.println("알림)) 삭제 성공");
				    		// 삭제할때 게시글이 안떠서 여기서 한번 출력해준다.
				    		for( int row = 0 ; row<boardlist.length ; row++ ) {
				    			if(boardlist[row][0] != null) {
				    				System.out.println(row+"\t"+boardlist[row][2]+"\t"+boardlist[row][0]);
				    				continue;			
				    			}
				    			else if(boardlist[row][0] == null && boardlist[row+1][0] != null ) {
				    				System.out.println((row)+"\t"+boardlist[row+1][2]+"\t"+boardlist[row+1][0]);
				    			    //앞에꺼로 이동시키기
				    				boardlist[row][0] = boardlist[row+1][0];
				    				boardlist[row][1] = boardlist[row+1][1];
				    				boardlist[row][2] = boardlist[row+1][2];
				    				boardlist[row][3] = boardlist[row+1][3];
				    				
				    				// 뒤어껄 제거 
				    				boardlist[row+1][0] = null;
				    				boardlist[row+1][1] = null;
				    				boardlist[row+1][2] = null;
				    				boardlist[row+1][3] = null;
				    				continue;
				    			}
				    			else if(boardlist[row][0] == null && boardlist[row+1][0] == null) {
				    				System.out.println("종료");
									break;
				    			}
				    			else if(row == 99) {
										System.out.println("종료");
										break;
				    			}
				    		}
				    		
				    	}
				    	else {
				    		System.out.println("알림)) 비밀번호가 다릅니다. [ 삭제실패]");
				    		continue;
				    	}
				    }
				    //"3.글수정"
				    else if(Boardchoice==3) {
				    	//비밀번호를 입력하세요.
				    	System.out.println("알림)) 현 게시물의 비밀번호");
				    	String BoardPassword = scanner.next();
				    	if(BoardPassword.equals(boardlist[BoardSee][3])) {
						System.out.println("-----------글수정 페이지-----------");
						//-----------제목: title-----------
						System.out.print("수정할 제목 : ");
						String BoardTitle = scanner.next();
						//-----------내용: content-----------
						System.out.print("수정할 내용 : ");
						String BoarContent = scanner.next();
						boardlist[BoardSee][0] = BoardTitle;
						boardlist[BoardSee][1] = BoarContent;
						System.out.print("알림)) 내용이 수정되었습니다.");
						continue;
				        }
				    	else {
				    		System.out.println("알림)) 비밀번호가 다릅니다. [ 수정실패]");
				    		continue;
				    	}
				  }
				
				}
				}
   }
}
}

				
						
