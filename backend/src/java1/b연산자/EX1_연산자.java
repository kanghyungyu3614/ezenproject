package java1.b연산자;

public class EX1_연산자 {
   
	
	public static void main(String[] args) {
	     
		 // 1.산술
	     int 정수1 = 10; int 정수2 = 20;
		 System.out.println(" 1.더하기 : "+정수1 +정수2);
		 System.out.println(" 2.더하기 : "+(정수1+정수2));
		 System.out.println(" 3.빼기 : "+(정수1-정수2));  
		 System.out.println(" 4.곱하기 : "+(정수1*정수2));
		 System.out.println(" 5.나누기 : "+(정수1/정수2));
		 System.out.println(" 6.나머지 : "+(정수1%정수2));
		 
		 // 2.비교
		 System.out.println(" 7.이상 : "+(정수1>=정수2));
		 System.out.println(" 8.이하 : "+(정수1<=정수2));
		 System.out.println(" 9.초과 : "+(정수1>정수2));
		 System.out.println(" 10.미만 : "+(정수1<=정수2));
		 System.out.println(" 11.같다 : "+(정수1==정수2));
		 System.out.println(" 12.같지않다 : "+(정수1!=정수2));
		 
		 // 3.논리
		 int 정수3 = 30; int 정수4 = 40;
		 System.out.println("13.&&[AND] " + (정수1>=정수2 && 정수3>=정수4));
		 System.out.println("14.||[OR] " + (정수1>=정수2 || 정수4>=정수3));
		 
		 //4.증감
		 int 정수5 = 10;
		 System.out.println(" 후위증가 : "+(정수5++)); // 츨력 후에 1 증가
		 System.out.println(" 확인 : "+ 정수5);
		 System.out.println(" 선위증가 :" + (++정수5)); // 츨력 전에 1 증가
		 System.out.println(" 확인 : "+ 정수5);
		 System.out.println(" 후위감소 :" + (정수5--)); // 츨력 후에 1 감소
		 System.out.println(" 확인 : "+ 정수5);
		 System.out.println(" 선위감소 :" + (--정수5)); // 츨력 후에 1 감소
		 System.out.println(" 확인 : "+ 정수5);
		 //5. 대입연산자 
		 int 정수6 = 10;
		 정수6 +=3;  
		 // 1. 정수6+3-->13 2.정수6 = 13
		 System.out.println("대입 결과 : " + 정수6);
		 
		 정수6 -= 5;  //1. 정수6-5 -> 8 2. 정수6 = 8;
		 System.out.println("대입 결과 : " + 정수6);
		 
		 
		 //6. 삼항 연산자
		 
		 int 점수 = 85;
		 char 등급 = 점수 > 90 ? 'A' : 'B'; // 조건식 ? 참 : 거짓
		           // 만약에 점수가 90점 초과이면 'A' 대입 아니면 'B' 대입
		 System.out.println("등급 결과 : "+ 등급);
		 char 등급2 = 점수 > 90 ? 'A' : 점수 > 80 ? 'B' : 'C';  
		 System.out.println("등급 결과 : "+ 등급2);
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
    }
}
