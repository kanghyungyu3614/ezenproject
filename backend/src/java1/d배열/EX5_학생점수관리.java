package java1.d배열;

import java.util.Scanner;

public class EX5_학생점수관리 {
  public static void main(String[] args) {
	
	  
	  boolean run = true; //무한루프 제어 변수
	  int studentNum = 0; // 학생수 저장할 변수 
	  int[] scores = null; // 여러개 점수를 저장할 배열 [ 메모리 할당 전 ]
	  Scanner scanner = new Scanner(System.in);
	  
	  while(run) { // 무한루프 s [종료조건 : 5 입력했을때 ]
		System.out.println("--------------------");  
		System.out.println("1.학생수 2.점수입력 3.점수리스트 4.분석 5.종료");
		System.out.println("선택 : "); int selectNo = scanner.nextInt();
		//1.입력했을때
		if( selectNo == 1) {
			System.out.println("학생수 : "); 
			studentNum = scanner.nextInt();
			scores = new int[studentNum];
			System.out.println("배열에 "+studentNum + "명의 점수 입력 가능");
		} 
		//2.입력했을때 
		else if( selectNo == 2){
			for(int i=0; i<scores.length; i++) {
				System.out.println("scores["+i+"] : ");
				scores[i] = scanner.nextInt();
			}
		} 
		//3.입력했을때
		else if( selectNo == 3){
			
			
				for(int i=0; i<scores.length; i++) {
				//	System.out.println("scores["+i+"]");
					System.out.printf("scores[%d]> %d \n",i,scores[i]);
				}
			
		}  
		//4.입력했을때 
		else if( selectNo == 4){
			int max = 0;  //최고점수
			int sum = 0;  // 평균 구하기전에 합계 구하기
			for(int value : scores) {
				// 만약에 해당 값이 max 보다 크면 max 대입
				if(value> max) { max = value;}
				sum += value; //해당 값을 sum 변수에 누적 더하기
			}// for end
			System.out.println("최고 점수 : "+max);
			double avg = (double)sum/scores.length;
			System.out.println("평균 점수 : "+avg);
			
			// * 순위별[ 내림차순 ] 출력
			for(int i=0; i<scores.length; i++) {
				for(int j=i+1; j<scores.length; j++) {
					if(scores[i] < scores[j]) { // > : 오름차순 <:내림차순
						int temp = scores[i];
						scores[i] = scores[j];
						scores[j] = temp;
					}
				}				
			}
			// 확인
			int rank = 0;
			for(int value : scores) {
				System.out.println((rank+1)+"순위 점수 : "+value);
			}
			
		} 
		//5.입력했을때
		else if( selectNo == 5){
			run = false;
		}  
		// 그외 입력했을때 
		else{
			System.out.println("안내) 알수 없는 번호입니다.");
		} 
		  
	  }
	  System.out.println("프로그램 종료");
	  
	  
	  
  }
}
