package java1.ch3조건문반복문;

import java.util.Scanner;
public class EX2_IF연습문제 {
   public static void main(String[] args) {
	
   // * 입력객체	
   Scanner scanner = new Scanner(System.in);
   
   // 문제1 : 2개의 정수를 입력받아서 더 큰수 출력
//   System.out.println("문제1 : 2개의 정수를 입력받아서 더 큰수 출력 : ");
//   int 정수1 = scanner.nextInt();
//   int 정수2 = scanner.nextInt();
//   
//   if(정수1>정수2) {
//	   System.out.println(정수1);
//   }
//   else {
//	   System.out.println(정수2);
//   }
   // 문제2 : 3개의 정수를 입력받아서 가장 큰수 출력
//   System.out.println("문제2 : 3개의 정수를 입력받아서 더 큰수 출력 : ");
//   int 정수1 = scanner.nextInt();
//   int 정수2 = scanner.nextInt();
//   int 정수3 = scanner.nextInt();
//   
//   if(정수1>정수2 && 정수1 >정수3) {
//	   System.out.println(정수1);
//   }
//   else if(정수2>정수1 && 정수2 >정수3) {
//	   System.out.println(정수2);
//   }	   
//   else if(정수3>정수1 && 정수3 >정수2) {
//	   System.out.println(정수3);
//   }	   
	// 문제3 : 4개의 정수를 입력받아서 가장 큰수 출력
//	 int 정수1 = scanner.nextInt();
//	 int 정수2 = scanner.nextInt();
//	 int 정수3 = scanner.nextInt();   
//	 int 정수4 = scanner.nextInt();
//     if(정수1>정수2 && 정수1 >정수3 && 정수1 >정수4) {
//	   System.out.println(정수1);
//	 }
//	 else if(정수2>정수1 && 정수2 >정수3 && 정수2 >정수4) {
//		   System.out.println(정수2);
//	 }	   
//	 else if(정수3>정수1 && 정수3 >정수2 && 정수3 >정수4) {
//		   System.out.println(정수3);
//	 }	 
//	 else if(정수4>정수1 && 정수4 >정수2 && 정수4 >정수3) {
//		   System.out.println(정수4);
//	}	 
   
   
   
	// 문제4 : 3개의 정수를 입력받아서 오름차순 / 내림차순 
	 
     //오름차순
//     int 정수1 = scanner.nextInt();
//	 int 정수2 = scanner.nextInt();
//	 int 정수3 = scanner.nextInt();   
//	 int 위치교체 = 0;
//	 
//	 int[] 가장큰수 = {정수1,정수2,정수3};
//		for (int i = 0; i < 가장큰수.length; i++) {
//			for (int j = 0; j < 가장큰수.length; j++) {
//				if(가장큰수[i]>가장큰수[j]) {
//					
//				}
//				else if() {
//					
//				}
//				else if(가장큰수[i]==가장큰수[j]) {
//					continue;
//				}
//			}
//		}		 
// 문제3 : 3개의 정수를 입력받아서 오름차순[>] / 내림차순[<] [ 경우의수 :  3 7 5 : 3>7 , 3>5 , 7>5     총 : 3개  ] 
		System.out.print("문제3) 정수1 입력: "); 
		int 문제3_1 = scanner.nextInt();
		System.out.print("문제3) 정수2 입력: "); 
		int 문제3_2 = scanner.nextInt();
		System.out.print("문제3) 정수3 입력: "); 
		int 문제3_3 = scanner.nextInt();
		if( 문제3_1 > 문제3_2 ) { int temp = 문제3_1; 문제3_1 = 문제3_2; 문제3_2 = temp; }
		if( 문제3_1 > 문제3_3 ) { int temp = 문제3_1; 문제3_1 = 문제3_3; 문제3_3 = temp; }
		if( 문제3_2 > 문제3_3 ) { int temp = 문제3_2; 문제3_2 = 문제3_3; 문제3_3 = temp; }
		System.out.printf("%d %d %d \n" , 문제3_1 , 문제3_2 , 문제3_3 ); // 출력방식 1 
		System.out.println( 문제3_1 +" "+ 문제3_2 +" "+ 문제3_3 );  // 출력방식 1 
   
   
   
   
   
   
   
   
   
//		// 문제4 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 [ 경우의수 : 2개 ]
//		System.out.print("문제3) 점수 입력: "); int 문제4 = scanner.nextInt();
//		if( 문제4 >= 90 ) { System.out.println("합격"); }
//		else { System.out.println("불합격"); }	 
	 
   
   
   
   
	// 문제6 : 점수를 입력받아 점수가 90점 이상이면 합격 아니면 불합격 출력 
//   System.out.print("문제6) 점수를 입력받아 점수가 90점 이상이면 합격 : ");
//   int 점수 = scanner.nextInt();
//   if(점수>=90) {
//	   System.out.println("합격입니다.");
//   }else {
//	   System.out.println("불합격입니다.");
//   }
   
   
   
   
	//문제7
		// 점수를 입력받아 점수가 90점 이상이면 A등급
		//				점수가 80점 이상이면 B등급
		//				점수가 70점 이상이면 C등급
		//				그외 재시험
   
//   int 점수 = scanner.nextInt();
//   if(점수>=90) {
//	   System.out.println("A등급입니다.");
//   }else if(점수<90 && 점수>=80) {
//	   System.out.println("B등급입니다.");
//   }else if(점수<80 && 점수>=70) {
//	   System.out.println("C등급입니다.");
//   }      
   
   
   
   
	/* 문제8
		[ 입력 ] : 국어,영어,수학 입력받기
		[ 조건 ]
			평균이 90점 이상이면서 
				국어점수 100점 이면 '국어우수' 출력
				영어점수 100점 이면 '영어우수' 출력
				수학점수 100점 이면 '수학우수' 출력
			평균이 80점 이상이면서 
				국어점수 90점이상 이면 '국어장려' 출력
				영어점수 90점이상 이면 '영어정려' 출력
				수학점수 90점이상 이면 '수학장려' 출력
			그외 재시험 
	 */
   		int 국어점수 = scanner.nextInt();
   		int 영어점수 = scanner.nextInt();
        int 수학점수 = scanner.nextInt();
        int 평균 = (국어점수+영어점수+수학점수);
        if(평균>=90) {
        	if(국어점수==100) {}
        	if(국어점수==100) {}
        	if(국어점수==100) {}
        }
        else if(평균>=80 && 평균<90) {
        	if(국어점수==100) {}
        	if(국어점수==100) {}
        	if(국어점수==100) {}
        }
        else {
        	System.out.println("재시험");
        }
   
   
   
   
   
   
   
	//문제9 로그인페이지
		// [ 입력 ] : 아이디와 비밀번호를 입력받기
		// [ 조건 ] : 회원아이디가 admin 이고 
		//           비밀번호가 1234 일 경우에는 
		//          로그인 성공 아니면 로그인 실패 출력 

 }
}
