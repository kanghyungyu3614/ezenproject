package java1.d배열;

import java.beans.beancontext.BeanContextMembershipListener;
import java.lang.reflect.Member;
import java.util.Scanner;

public class EX6_회원 {
  
	public static void main(String[] args) {
		
	//0. 메모리
		String[][] memberlist = new String[100][4]; //문자열 400개를 저장할수 있는 배열 선언
		Scanner scanner = new Scanner(System.in);    // 입력객체 

		//1. 무한루프[프로그램 실행]
		while(true) {
			System.out.println("===============회원제 페이지===============");
			System.out.println("메뉴 : 1.로그인 2.회원가입 3.아이디찾기 4.비밀번호찾기");
			System.out.println("=======================================");
			System.out.println("선택 : ");
			int btn = scanner.nextInt();
			 //1 입력했을때
			if(btn==1) {
				// 1. 아이디/ 비밀번호를 입력받는다.
				System.out.println("아이디 : ");
				String id = scanner.next();
				System.out.println("비밀번호 : ");
				String password = scanner.next();
				// 2. 배열내 모든 항목[인덱스]와 비교해서 입력한 아이디와 비밀번호가 있는지 확인
				int login = 0; // 로그인 처리에 대한 상태를 저장하는 변수 
				for(int i=0; i<memberlist.length; i++) {
					// 해당 인덱스가 null이 아니면서
					if(memberlist[i][0] != null) {
						// 해당 인덱스의 아이디가 입력받은 id와 같으면서
						if(memberlist[i][0].equals(id)) {
							login = 2; // 아디는 맞으나 비밀번호를 틀렸을때 
							//해당 인덱스의 비밀번호가 입력받은 password 와 같으면
							if(memberlist[i][1].equals(password)) {
								System.out.println("안내) 로그인 성공 !!");
								//로그인 성공 [ 아이디와 비밀번호가 모두 맞았을때 ]
								login = 1;
								
								//(추후코드) 로그인 메뉴 //
								while(true) {
									System.out.println("회원 메뉴 : 1.회원탈퇴 2.로그아웃 ");
								    int btn2 = scanner.nextInt();
								    if(btn2 ==1) {
								    	//---------------------------------------//
								    	// i = 로그인 성공한 인덱스 = 로그인한 회원의 인덱스 
								    	memberlist[i][0] = null;
								    	memberlist[i][1] = null;
								    	memberlist[i][2] = null;
								    	memberlist[i][3] = null;
								    	  // 삭제된 회원 뒤로 한칸씩 당기기 null 뒤로 한칸씩 당기기 
			                               for(int j = i; j<memberlist.length; j++) {
			                            	   memberlist[j][0] = memberlist[j+1][0];
			                            	   memberlist[j][1] = memberlist[j+1][1];
			                            	   memberlist[j][2] = memberlist[j+1][2];
			                            	   memberlist[j][3] = memberlist[j+1][3];
			                            	   // 다음 인덱스의 null 이면 [회원이 없다는 뜻으로]
			                            	   if(memberlist[j+1][0] == null) {
			                            		   break;
			                            		   // for end
			                            	   }
			                            	   
			                               }
								    	//---------------------------------------//
								    	System.out.println("안내) 회원탈퇴가 되었습니다.");
								    	break;
								    }
								    else if(btn2==2) {
								    	break;
								    }
								}							
								break;
							}
						}
					}
				}
				// 3. 있으면 로그인 성공 없으면 로그인 실패
			    if(login ==0) {
			    	System.out.println("안내) 동일한 아이디가 없습니다.");
			    }
			    else if(login==2) {
			    	System.out.println("안내) 비밀번호가 일치 하지 않습니다.");
			    }
			    else if(login==1) {
			    	System.out.println("안내) 로그아웃 되었습니다.");
			    }			    
			} 

			//2 입력했을때
			else if(btn==2) {
				System.out.println("===============회원가입 페이지===============");
				// 1. 회원정보를 4개의 변수로 입력받기 [ 바로 배열에 대입x]
				System.out.println("아이디 : "); String id = scanner.next();
				//아이디 중복여부 [true : 중복없다, false:  중복있다.]
				boolean idcheck = true;
				//2. 아이디 중복체크 : 입력받은 id가 배열내 존재하면 회원가입실패 
				for(int row = 0; row<memberlist.length; row++) {
					// 입력받은 id와 배열내 id 와 같다면!! [중복 찾음]
					// null 은 equals 메소드 사용 불가 [ == null , != null] 
					if(memberlist[row][0] != null &&memberlist[row][0].equals(id)) {
						System.out.println("안내) 이미 사용중인 아이디 입니다.");
						idcheck = false;
						break;
					}
				}
				
				//3. 아이디 중복 흐름 제어
				if(idcheck) {
					System.out.println("비밀번호 : "); String password = scanner.next();
					System.out.println("이름 : "); String name = scanner.next();
					System.out.println("전화번호 : "); String phone = scanner.next();
					
					
					//3. 입력받은 배열에 저장한다.  [배열호출 : 배열명[행인덱스][열인덱스]]
					// 2-1. 배열내 빈 행 찾는다.
					for(int row=0; row<memberlist.length; row++) {
							if(memberlist[row][0]==null){
								// row번째 아이디가 null이면 = 회원이 없다!!
								// 2-2. null 행 위치에 입력받은 데이터를 하나씩 대입 
								memberlist[row][0] = id;
								memberlist[row][1] = password;
								memberlist[row][2] = name;
								memberlist[row][3] = phone;
								System.out.println("안내) 회원가입 성공 ");
								// 2-3. 저장했으면 반복문 종료
								break;
								
							}
							if(row == 99) {
								System.out.println("안내) 최대 회원수가 찼습니다. [회원가입불가능 : 관리자에게문의]");
							}
					
				        }
				}	
			} 
			//3 입력했을때
			else if(btn==3) {
				System.out.println("===============아이디 찾기 페이지===============");
				System.out.println("===============이름를 입력하세요.===============");
				String name = scanner.next();
				System.out.println("===============폰번호를 입력하세요.===============");
				String phone = scanner.next();
				for(int i=0; i<memberlist.length; i++) {
					if(memberlist[i][0] !=null && name.equals(memberlist[i][2]) && phone.equals(memberlist[i][3]) ) {
						
						System.out.println("안내) 회원님의 아이디 : "+memberlist[i][0]);
						break;
					}
					if(i == memberlist.length-1){
						System.out.println("동일한 회원정보가 없습니다.");
					}
				}
			} 
			//4 입력했을때
			else if(btn==4) {
				System.out.println("===============비밀번호 찾기 페이지===============");
				System.out.println("===============이름를 입력하세요.===============");				
				String name = scanner.next();
				System.out.println("===============폰번호를 입력하세요.===============");
				String phone = scanner.next();
				for(int i=0; i<memberlist.length; i++) {
					if(memberlist[i][0] !=null && name.equals(memberlist[i][2]) && phone.equals(memberlist[i][3]) ) {
						
						System.out.println("안내) 회원님의 비밀번호 : "+memberlist[i][3]);
						break;
					}
					if(i == memberlist.length-1){
						System.out.println("동일한 회원정보가 없습니다.");
					}
				}			
			} 
			else {System.out.println("안내) 알수 없는 번호입니다.");}
		}
		
	} 
}


/* 
  회원제 프로그램 구현
  [조건]
     1. 2차원 배열
  [기능]
   1. 회원가입 기능 
      1.아이디 비밀번호 이름 전화번호 입력받아 등록
      2. 배열내 빈 공간의 인덱스를 찾아서 해당 인덱스에 회원정보 넣기
         String = null
         int = 0
         double = 0.0
         boolean = false
      3.아이디 중복체크
      4.최대 회원 100명
         * 1명 4개 변수 -> 400 변수 -> 2차원 배열 -> [100][4]
         * 행 당 1명
         * 0열 : 아이디 1열: 비밀번호 2:이름 3: 전화번호 
   2. 로그인 기능
     아이디 비밀번호가 동일하면 로그인 성공
   3. 아이디찾기 기능
      이름 전화번호가 동일하면 아이디 알려주기
   4. 비밀번호찾기 기능
      아이디 전화번호가 동일하면 비밀번호 알려주기 
   [출력]
   1.메뉴: 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기
 */
 