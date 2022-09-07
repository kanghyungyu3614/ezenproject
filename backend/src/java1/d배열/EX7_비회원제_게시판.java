package java1.d배열;

import java.util.Scanner;

public class EX7_비회원제_게시판 { // class s 

public static void main(String[] args) { // main s
	
// 0. 메모리
String[][] memberlist = new String[100][4]; // 문자열 400개를 저장할수 있는 배열 선언 [ 초기값 : null 400 개 ] 
Scanner scanner = new Scanner(System.in);	// 입력객체
//게시판 추가
String[][] boardlist =  new String[100][4]; // 문자열 400개를 저장할수 있는 배열 선언 [ 초기값 : null 400 개 ] 
	
	
	
// 1. 무한루프[ 프로그램 실행 ] 
while( true ) { // while start [ 종료조건 : 없다 ]
	System.out.println("============= 회원제 페이지 ===================");
	System.out.println("메뉴 : 1.로그인 2.회원가입 3.아이디찾기 4.비밀번호찾기");
	System.out.println("============================================");
	System.out.print("선택 : ");	int btn = scanner.nextInt();
	// 1 입력했을떄
  if( btn == 1 ){
		
	System.out.println("================= 로그인 페이지 ===============");
	// 1. 아이디 / 비밀번호  입력받는다.
	System.out.print("아이디 : ");	String id = scanner.next();
	System.out.print("비밀번호 : ");	String password = scanner.next();
	// 2. 배열내 모든 항목[인덱스]와 비교해서 입력한 아이디와 비밀번호 있는지 확인 
	int logincheck = 0 ; // *로그인 처리에 대한 상태를 저장하는 변수 
    for( int i = 0 ; i<memberlist.length ; i++ ) {
	  if( memberlist[i][0] != null ) { 
	  // 해당 인덱스가 null 아니면서 
	  if( memberlist[i][0].equals( id ) ) { 
	  // 해당 인덱스의 아이디가 입력받은 id와 같으면서 
	  logincheck = 2;	// 아이디는 맞으나 비밀번호 틀렸을때 
	  if( memberlist[i][1].equals( password ) ) {
		  // 해당 인덱스의 비밀번호가 입력받은 password 와 같으면 
		  System.out.println("안내) 로그인 성공 !!");
		  logincheck = 1; // 로그인 성공 [ 아이디와 비밀번호가 모두 맞았을때 ]
		  //로그인 메뉴 
		  while(true) {
			 System.out.print("회원 메뉴 : 1.회원탈퇴 2.로그아웃 3.게시판이동 ");
			 int btn2 = scanner.nextInt();
			 if( btn2 == 1 ) { 
				// ------------------------------------------- //
				// i = 로그인 성공한 인덱스 = 로그인한 회원의 인덱스 
				memberlist[i][0] = null;	memberlist[i][1] = null;
				memberlist[i][2] = null;	memberlist[i][3] = null;
				// 삭제된 회원 뒤로 한칸씩 당기기
				for( int j = i ; j<memberlist.length ; j++  ) {
					memberlist[j][0] = memberlist[j+1][0];
					memberlist[j][1] = memberlist[j+1][1];
					memberlist[j][2] = memberlist[j+1][2];
					memberlist[j][3] = memberlist[j+1][3];
				// 다음 인덱스의 null 이면 [ 회원이 없다는 뜻으로 ]
				if( memberlist[j+1][0] == null ) {
					break;
				}
				} // for end 
				// --------------------------------------------// 
				System.out.println("안내) 회원탈퇴가 되었습니다.");
				break;
				}
			    // 로그아웃
				else if( btn2 == 2 ) { break; }
//------------------------------------------------------------------------
//------------------------------------------------------------------------
//------------------------------------------------------------------------
//-----------------------------------------------------------------------
			    // 여기서부터 게시판
				else if( btn2 == 3 ) {  
				// 여기서부터 게시판	
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
				    	System.out.println("알림)) 현 게시물의 비밀번호");
				    	int BoardPassword = scanner.nextInt();
				    	if(BoardPassword == Integer.parseInt(boardlist[BoardSee][3])) {
				    		boardlist[BoardSee][0] = null;
				    		boardlist[BoardSee][1] = null;
				    		boardlist[BoardSee][2] = null;
				    		boardlist[BoardSee][3] = null;
				    		System.out.println("알림)) 삭제 성공");
				    		continue;
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
				    	int BoardPassword = scanner.nextInt();
				    	if(BoardPassword == Integer.parseInt(boardlist[BoardSee][3])) {
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
						    	 
 }//while문의 끝 							
}//else if 끝
//------------------------------------------------------------------------
//------------------------------------------------------------------------
//------------------------------------------------------------------------
//------------------------------------------------------------------------
//------------------------------------------------------------------------
// 여기까지 게시판
//-----------------------------------------------------------------------
		} // while end 
		break;
		} // if end 
		}  // if end
	} // if end 
} // for end 
			// // 3. 있으면 로그인 성공 없으면 로그인 실패
			if( logincheck == 0 ) { System.out.println("안내) 동일한 아이디가 없습니다."); } 
			else if( logincheck == 2){ System.out.println("안내) 비밀번호가 일치 하지 않습니다.");}
			else if( logincheck == 1) { System.out.println("안내) 로그아웃 되었습니다.");}
		} // if end 
	else if( btn == 2 )   // 2 입력했을떄
		{  
			System.out.println("================= 회원가입 페이지 ===============");
			// 1. 회원정보를 4개의 변수로 입력받기 [ 바로 배열에 대입X ]
			System.out.print("아이디 : ");	String id = scanner.next();
			
			// 2. 아이디 중복체크 : 입력받은 id가 배열내 존재하면 회원가입실패
			boolean idcheck = true;	// 아이디 중복여부 	[ true : 중복없다 , false : 중복있다. ]
			for( int row = 0 ; row<memberlist.length ; row++ ) {
				if( memberlist[row][0] != null && memberlist[row][0].equals( id ) ) { 
					// 해당 인덱스의 id가 null 이 아니면서 입력받은 id 같다!! [ 중복 찾음 ] // null 은 equals메소드 사용 불가 [  == null , != null ]
					System.out.println("안내) 이미 사용중인 아이디 입니다. ");
					idcheck = false; break; // 아이디중복체크 여부 변수 수정후 반복문 탈출
				} // if end 
			} // for end 
			// 3. 아이디 중복 흐름 제어 
			if( idcheck ) { // 중복이 없으면
				System.out.print("비밀번호 : ");	String password = scanner.next();
				System.out.print("이름 : ");		String name = scanner.next();
				System.out.print("전화번호 : ");	String phone = scanner.next();
				// 4. 입력받은 변수들을 배열에 저장한다. [ 배열호출 : 배열명[행인덱스][열인덱스] ]
					// 2-1. 배열내 빈[null] 행 찾는다.
					for( int row = 0 ; row<memberlist.length ; row++ ) {
						if( memberlist[row][0] == null ) { // row번째 아이디가 null이면 = 회원이 없다!! 
							// 2-2 : null 행 위치에 입력받은 데이터를 하나씩 대입
							memberlist[row][0] = id;	memberlist[row][1] = password; 
							memberlist[row][2] = name;	memberlist[row][3] = phone;
							System.out.println("안내) 회원가입 성공 ");
							// 2-3 : 저장했으면 반복문 종료 [ 끝내기 ]
							break;
						} // if end 
						// 마지막 행까지 빈공간이 없으면 [ 최대 회원 100명 , 최대 행 인덱스 = 0~99 ]
						if( row == 99 ) { System.out.println("안내) 최대 회원수가 찼습니다. [회원가입불가능 : 관리자에게문의 ] ");}
					}// for end 
			} // if 3 end
		} // else if end 
	else if( btn == 3 )   // 3 입력했을떄
		{ 
			System.out.println("================= 아이디찾기 페이지 ===============");
			// 1. 이름  , 전화번호 입력받기
			System.out.print("이름 : "); 	String name = scanner.next();
			System.out.print("전화번호 : ");	String phone = scanner.next();
			// 2. 배열내 모든 항목 비교해서 동일한 이름,전화번호
			for( int i = 0 ; i<memberlist.length ; i++ ) {	// 모든 항목 출력 
				if( memberlist[i][0] != null && 		// null 아니면서 
						memberlist[i][2].equals(name) && 	// 이름이 같고 
							memberlist[i][3].equals( phone ) ) { // 전화번호가 같으면
					System.out.println("안내) 회원님의 아이디 : " + memberlist[i][0]);
					break;
				} // if end
				// 3. 존재하면 해당 아이디 출력 아니면 미출력
				if( i == memberlist.length-1 ){ // i가 마지막인덱스와 같으면 [ 모두 검사했는데 조건 못찾음 ] 
					System.out.println("안내) 동일한 회원정보가 없습니다. ");
				} // if end 
			} // for end 
			
		}
	else if( btn == 4 )   // 4 입력했을떄
		{ 
			System.out.println("================= 비밀번호 페이지 ===============");
			// 1. 아이디 , 전화번호 입력받기 
			System.out.print("아이디 : "); 	String id = scanner.next();
			System.out.print("전화번호 : ");	String phone = scanner.next();
			// 2. 배열내 모든 항목 비교해서 동일한 아이디 , 전화번호 
			for( int i = 0 ; i<memberlist.length ; i++ ) { // 인덱스 0 부터 마지막인덱스까지 반복
				if( memberlist[i][0] != null &&
						memberlist[i][0].equals(id) &&
							memberlist[i][3].equals(phone) ) {
					System.out.println("안내) 회원님의 비밀번호 : " + memberlist[i][1] );
					break;
				}
				// i가 마지막 인덱스 이면 	[ 인덱스 = 길이-1 ]
				// 3. 존재하면 해당 비밀번호 출력 아니면 미출력
				if( i == memberlist.length-1 ) {
					System.out.println("안내) 동일한 회원정보가 없습니다. ");
				}
			}
			
		}
	else { System.out.println("안내) 알수 없는 번호입니다. "); } // 그외 입력했을떄

} // while end 
} // main e
} // class e 



/*
 	회원제 프로그램 구현
 		[조건]
 			1. 2차원 배열 
 		[기능]
 			1. 회원가입 기능
 				1. 아이디 비밀번호 이름 전화번호 입력받아 등록 
 				2. 배열내 빈 공간[null]의 인덱스를 찾아서 해당 인덱스에 회원정보 넣기 
 					String = null
 					int = 0		double = 0.0	boolean = false
 				3. 아이디 중복체크
 				4. 최대 회원 100명 
 					* 1명 4개 변수 -> 400 변수 -> 2차원 배열 -> [100][4] 
 					* 행 당 1명 
 					* 0열 : 아이디 	1열 : 비밀번호 	2 : 이름 		3 : 전화번호
 			2. 로그인 기능 
 				아이디 비밀번호 가 동일하면 로그인 성공 
 			3. 아이디찾기 기능 
 				이름 전화번호 가 동일하면 아이디 알려주기 
 			4. 비밀번호찾기 기능 
 				아이디 전화번호 가 동일하면 비밀번호 알려주기 
 		[출력]
 			1. 메뉴 : 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 
 */
