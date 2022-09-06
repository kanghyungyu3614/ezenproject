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
				
			} 

			//2 입력했을때
			else if(btn==2) {
				System.out.println("===============회원가입 페이지===============");
				// 1. 회원정보를 4개의 변수로 입력받기 [ 바로 배열에 대입x]
				System.out.println("아이디 : "); String id = scanner.next();
				System.out.println("비밀번호 : "); String password = scanner.next();
				System.out.println("이름 : "); String name = scanner.next();
				System.out.println("전화번호 : "); String phone = scanner.next();
			    //2. 입력받은 배열에 저장한다.  [배열호출 : 배열명[행인덱스][열인덱스]]
				// 2-1. 배열내 빈 행 찾는다.
				for(int row=0; row<memberlist.length; row++) {
					if(memberlist[row][0]==null){
						// row번째 아이디가 null이면 = 회원이 없다!!
						// 2-2. null 행 위치에 입력받은 데이터를 하나씩 대입 
						memberlist[row][0] = id;
						memberlist[row][1] = password;
						memberlist[row][2] = name;
						memberlist[row][3] = phone;
						// 2-3. 저장했으면 반복문 종료
						break;
				
					}
					if(row == 99) {
					 System.out.println("안내) 최대 회원수가 찼습니다. [회원가입불가능 : 관리자에게문의]");
					}
				}	
			} 
			//3 입력했을때
			else if(btn==3) {
				
			} 
			//4 입력했을때
			else if(btn==4) {
				
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
 