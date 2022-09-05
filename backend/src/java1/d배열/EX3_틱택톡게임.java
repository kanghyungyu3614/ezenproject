package java1.d배열 ;

import java.util.Random;
import java.util.Scanner;

public class EX3_틱택톡게임{
//	public static void main(String[] args) {
//		// * String(문자) 9개 를 저장할수 있는 배열 선언과 초기값[처음값]
//		String[ ] 게임판 = { "[]","[]","[]","[]","[]","[]","[]","[]","[]" };
//		int 무엇일까요 = 게임판[0].length();
//		System.out.println("무엇일까요" +무엇일까요);
//	 while(true) {
//		 
//		 System.out.println("------두고싶은 위치의 알을 입력하세요------");
//		 Scanner scanner = new Scanner(System.in);
//
//		 
//		 //내가 선택
//		 while(true) {
//			 int choice = scanner.nextInt();
//			 if(게임판[choice].equals("[X]") || 게임판[choice].equals("[O]") ) {
//				 System.err.println("다시선택해주세요.");
//				 choice = scanner.nextInt();
//				 게임판[choice] = "[O]";
//				 break;
//			 }else {
//				 게임판[choice] = "[O]";
//				 break;
//			 }
//			 
//		 }
//		 while(true) {
//			 //컴퓨터 선택
//			 Random random = new Random(); // 랜덤 과 관련된 메소드 제공 
//			 int 컴퓨터 = random.nextInt(8); // 1~9 사이의 난수 발생
//			 
//			 if(게임판[컴퓨터].equals("[O]")) {
//				 컴퓨터 = random.nextInt(8);
//				 게임판[컴퓨터] = "[X]";
//				 break;
//			 }else {
//				 게임판[컴퓨터] = "[X]";
//				 break;
//			 }
//			 
//		 }
//		 
//		 //승리자 찾기 while문 종료시키기 
//		 boolean 승리 = false;
//		 String 승리자 =  new String("누가승리?");
//		 
//		 
//		 // 가로승리?  0 1 2 3 4 5 6 7 8
//		 for(int i=0; i<게임판.length; i++){
//			 if(i ==0 || i==3 || i==6 ) {		 
//				 if(게임판[i].length()>2 && 게임판[i].equals(게임판[i+1]) || 게임판[i+1].equals(게임판[i+2])){
//					 승리 = true;
//					 if(게임판[i].equals("[O]")) {
//						 승리자 = "사용자승리(가로)";
//						 break;
//					 }
//					 else if(게임판[i].equals("[X]")) {
//						 승리자 = "컴퓨터승리(가로)";
//						 break;
//					 }
//				 }
//			 }
//			 else {
//				 continue;
//			 }
//		 }
//		 // 세로승리? 0 3 6   1  4 7  2 5 8
//		 for(int i=0; i<게임판.length; i++){
//			 if(i==0 || i==1 || i==2 ) {		 
//				 if(게임판[i].length()>2 && 게임판[i].equals(게임판[i+3]) || 게임판[i+3].equals(게임판[i+6])){
//					 승리 = true;
//					 if(게임판[i].equals("[O]")) {
//						 승리자 = "사용자승리(세로)";
//						 break;
//					 }
//					 else if(게임판[i].equals("[X]")) {
//						 승리자 = "컴퓨터승리(세로)";
//						 break;
//					 }
//				 }
//			 }
//			 else {
//				 continue;
//			 }
//		 }		 
//		 // 대각선승리? 0 4 8   2  4 6 
//		 for(int i=0; i<게임판.length; i++){
//			 if(i==0) {		 
//				 if(게임판[i].length()>2 && 게임판[i].equals(게임판[i+4]) || 게임판[i+4].equals(게임판[i+8])){
//					 승리 = true;
//					 if(게임판[i].equals("[O]")) {
//						 승리자 = "사용자승리(세로)";
//						 break;
//					 }
//					 else if(게임판[i].equals("[X]")) {
//						 승리자 = "컴퓨터승리(세로)";
//						 break;
//					 }
//				 }
//			 }
//			 else {
//				 continue;
//			 }
//			 
//			 if(i==2) {		 
//				 if(게임판[i].length()>2 && 게임판[i].equals(게임판[i+2]) || 게임판[i+2].equals(게임판[i+6])){
//					 승리 = true;
//					 if(게임판[i].equals("[O]")) {
//						 승리자 = "사용자승리(세로)";
//						 break;
//					 }
//					 else if(게임판[i].equals("[X]")) {
//						 승리자 = "컴퓨터승리(세로)";
//						 break;
//					 }
//				 }
//			 }
//			 else {
//				 continue;
//			 }
//			 
//		 }
//		 
//		 
//		 
//		 
//		 
//		 
//		 //게임판 출력
//		 for(int i=0; i<게임판.length; i++){
//			 System.out.print(게임판[i]);
//			 if(i%3==2) {
//				 System.out.print("\n"); 
//			 }
//			 
//		 }
//		 if(승리==true) {
//			 System.out.println(승리자); 
//			 break;
//		 }
//		 
//	 }// while문 끝
//}
	
	
	public static void main(String[] args) {
		// * String(문자) 9개 를 저장할수 있는 배열 선언과 초기값[처음값]
		String[ ] 게임판 = { "[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]" };
		Scanner scanner = new Scanner(System.in);
		
		while (true) { // 무한루프 [ 종료조건 : 승리판단 있을경우 ] // while 1 
			
			// 1. 게임판 출력 - 배열내 모든 데이터 출력 
			for( int i = 0 ; i<게임판.length ; i++ ) { // i는 0부터 마지막인덱스( 배열의길이-1 ) 까지 1씩 증가
				
				System.out.print( 게임판[i] );
				// 1-2 3줄[ 인덱스 : 2 , 5 , 8 ] 마다 줄바꿈
				if( i == 2 || i == 5 || i == 8 ) { System.out.println(); }
				// if( i == 2 || i == 5 || i == 8 ) ---> if( i % 3 == 2 )
				
			} // for end 
			
			
			
			// 2. 사용자 에게 위치 입력받기 
			while( true ) { // 무한루프 [ 종료조건 : 알을 두었을때 종료 break ] // while 2
				System.out.print("안내) 위치 선택 : "+"\n"); int 위치 = scanner.nextInt();
				if( 위치 < 0 || 위치 > 8 ) { 
					System.out.println("안내) 선택할수 없는 번호입니다.");
				}
				// 해당 위치에 알이 없으면 해당 위치에 알두기 
				if( 게임판[위치] .equals("[ ]") ) {  
					게임판[위치] = "[O]"; break;
				}
				else { 
					System.out.println("안내) 이미 알이 존재하는 위치 입니다. ");
				}
			} // while 2 end 
			
			
			
			
			// 3. 컴퓨터 에게 위치 난수 생성
			while( true ) { // 무한루프 [ 종료조건 : 알을 두었을때 종료 break ] // while 2
				System.out.print("컴퓨터는) 위치 선택 : ");
				Random random = new Random(); // 랜덤 과 관련된 메소드 제공 
				int 컴퓨터 = random.nextInt(9); // 1~9 사이의 난수 발생
				if( 게임판[컴퓨터].equals("[ ]") ) {  게임판[컴퓨터] = "[X]"; break; }
				else { System.out.println("안내) 이미 알이 존재하는 위치 입니다. "); }
			} // while 2 end 
			
			
			 //승리자 찾기 while문 종료시키기 
			 boolean 승리 = false;
			 String 승리자 =  new String("누가승리?");
			 
			 
			 // 가로승리?  0 1 2 3 4 5 6 7 8
			 for(int i=0; i<게임판.length; i++){
				 if(i ==0 || i==3 || i==6 ) {		 
					 if(!게임판[i].equals("[]") && 게임판[i].equals(게임판[i+1]) || 게임판[i+1].equals(게임판[i+2])){
						 승리 = true;
						 if(게임판[i].equals("[O]")) {
							 승리자 = "사용자승리(가로)";
							 break;
						 }
						 else if(게임판[i].equals("[X]")) {
							 승리자 = "컴퓨터승리(가로)";
							 break;
						 }
					 }
				 }
				 else {
					 continue;
				 }
			 }
			 // 세로승리? 0 3 6   1  4 7  2 5 8
			 for(int i=0; i<게임판.length; i++){
				 if(i==0 || i==1 || i==2 ) {		 
					 if(!게임판[i].equals("[]") && 게임판[i].equals(게임판[i+3]) || 게임판[i+3].equals(게임판[i+6])){
						 승리 = true;
						 if(게임판[i].equals("[O]")) {
							 승리자 = "사용자승리(세로)";
							 break;
						 }
						 else if(게임판[i].equals("[X]")) {
							 승리자 = "컴퓨터승리(세로)";
							 break;
						 }
					 }
				 }
				 else {
					 continue;
				 }
			 }		 
			 // 대각선승리? 0 4 8   2  4 6 
			 for(int i=0; i<게임판.length; i++){
				 if(i==0) {		 
					 if(!게임판[i].equals("[]") && 게임판[i].equals(게임판[i+4]) || 게임판[i+4].equals(게임판[i+8])){
						 승리 = true;
						 if(게임판[i].equals("[O]")) {
							 승리자 = "사용자승리(세로)";
							 break;
						 }
						 else if(게임판[i].equals("[X]")) {
							 승리자 = "컴퓨터승리(세로)";
							 break;
						 }
					 }
				 }
				 else {
					 continue;
				 }
				 
				 if(i==2) {		 
					 if(!게임판[i].equals("[]") && 게임판[i].equals(게임판[i+2]) || 게임판[i+2].equals(게임판[i+6])){
						 승리 = true;
						 if(게임판[i].equals("[O]")) {
							 승리자 = "사용자승리(세로)";
							 break;
						 }
						 else if(게임판[i].equals("[X]")) {
							 승리자 = "컴퓨터승리(세로)";
							 break;
						 }
					 }
				 }
				 else {
					 continue;
				 }
				 
			 }
			 
//			 if(승리==true) {
//				 System.out.println(승리자);
//				 break;
//			 }
//			 else {
//				 continue;
//			 }
			 
			 
			 
		
			 			
			
			
			
			
			
			
			
			
			
		} // while 1  end 
		
	} // main end 
}
/*
 	틱택토 게임 설계
 		[ 조건 ]
 		1. 게임판 9칸 사용 -> 배열[0~8] 
 			1. String 배열		클래스는 비교연산자 불가능
 				==  <---> 문자열1.equals(문자열2)
 				!=  <---> !문자열1.equals(문자열2)
 		2. 사용자[O]가 알을 두고자 하는 위치[인덱스] 입력[0~8]
 			1. 선택된 위치가 이미 다른 알이 존재하면 재입력 [중복제거]
 		3. 컴퓨터[X]가 난수생성[0~8]
 			1. 난수의 위치가 이미 다르 알이 존재하면 재생성 [ 중복제거 ]
 		4. 승리자 판단 [ 1.가로로 이기는수 2. 세로로 이기는수 3. 대각선으로 이기는수 4.무승부 ]
 		
 		[ 출력 ]
 			1. 게임판 출력 예시 
 			[ ] [ ] [ ] 
 			[ ] [ ] [ ] 
 			[ ] [ ] [ ] 
 */
 