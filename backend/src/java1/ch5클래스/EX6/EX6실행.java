package java1.ch5클래스.EX6;

import java.util.Scanner;

public class EX6실행 {
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		String[][] Memberarray = new String[100][4]; 	// String 객체 400개를 저장하는 2차원 배열 
		Member[] MemberObject = new Member[100];		// Member 객체 100개를 저장하는 1차원 배열 
		
		while(true) {
			System.out.println("1.회원가입 2.로그인 ");
			int ch = scanner.nextInt();
			if( ch == 1 ) {
				// 입력 
				System.out.print("아이디 : ");	String id = scanner.next();
				System.out.print("비밀번호 : ");	String password = scanner.next();
				System.out.print("이름 : ");		String name = scanner.next();
				// 2차원 배열 예시
					// Memberarray[0][0] = id;	Memberarray[0][1] = password; Memberarray[0][2] = name;
				// 객체 선언 
				Member signupInfo = new Member( id, password, name, 1000 );
				
				// 배열내 모든 인덱스 호출
				int index = 0; // 반복문 실행 횟수 
				System.out.println("밖의index" + index);
				for( Member temp : MemberObject ) {	// for( 반복변수 : 배열 ) { } 
					index++; // 1씩 증가
					System.out.println("안의index" + index);
					if( temp == null ) { // 만약에 해당 객체가 비어 있으면 
						// temp = signupInfo; // 임시변수 수정[ 원본 그대로 ]
						MemberObject[ index ] = signupInfo; // 원본에 수정 [ 주소값 대입 ]
						// 해당 인덱스의 새로운 객체 대입 [ 객체의 주소값 대입 ]
						break;
					}
				}
			}
			else if( ch == 2 ) {
				// 입력
				System.out.print("아이디 : ");	String id = scanner.next();
				System.out.print("비밀번호 : ");	String password = scanner.next();
				// 객체 선언 
				Member loginInfo = new Member(id, password);
				for( Member temp : MemberObject ) { 
					if( temp != null && // 해당 객체가 공백이 아니면서 
							temp.id.equals( loginInfo.id) &&  
							// 해당 객체의 아이디가 입력받은 객체의 아이디와 같고 
								temp.password.equals( loginInfo.password ) ) {
								// 해당 객체의 비밀번호가 입력받은 객체의 비밀번호와 같으면
						System.out.println("로그인성공"); 
						break;
					}
				}
			}
		}
	}
}