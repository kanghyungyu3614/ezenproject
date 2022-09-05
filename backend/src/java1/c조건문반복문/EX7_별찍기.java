package java1.c조건문반복문;
import java.util.Scanner;
public class EX7_별찍기 {
   public static void main(String[] args) {
	   // 0 . Scanner 입력객체 [ 1번만 선언 ]
	   Scanner scanner = new Scanner(System.in);
	   
//	   // 1. 입력받은 수 만큼 * 출력
//	   System.out.println("문제1) 별개수 : "); int s1 = scanner.nextInt();
//	   for(int i = 1; i<= s1; i++) {
//		   System.out.print("*");
//	   }
//	   System.out.println("\n----------------------------------------------");
//       //2. 입력받은 수 만큼 * 출력 [3줄마다 줄바꿈 처리]
//	   System.out.println("문제2) 별개수 : ");
//	   int s2 = scanner.nextInt();   
//	   for(int i=1; i<=s2; i++) {		   
//		   System.out.print("*"); if(i%3==0) {System.out.println();}	   
//	   
//	   }
//	   System.out.println("\n----------------------------------------------");
	   
	   // 별문제3 : 입력받은 줄 만큼 출력
//	   int s3 = scanner.nextInt();
//	   String star = "*";
//	   for(int i=1; i<=s3; i++) {	
//	   if(i==1) {
//		   System.out.println(star); 		   
//	   }
//	   if(i>=2) {
//		   star += "*";
//		   System.out.println(star);  
//	   }
//     }
	   //별문제4 : 입력받은 줄 만큼 출력
//	   int s4 = scanner.nextInt();
//	   String star = "*";
//	   for(int i=1; i<=s4; i++) {	
//	   if(i==1) {
//		   System.out.println(star); 		   
//	   }
//	   if(i>=2) {
//		   star += "*";
//		   System.out.println(star);  
//	   }
//       }	

	   //별문제4 : 입력받은 줄 만큼 출력
//	   int s5 = scanner.nextInt();
//	   for(int i=1; i<=s5; i++) {	
//		 String star = "*";
//	     for(int j=1; j<=s5-i; j++) {
//	     star += "*";
//	     }
//	     System.out.println(star);
//	     star = "";
//       }	
//	   //별문제5 : 입력받은 줄 만큼 출력
//	   int s6 = scanner.nextInt();
//	   String star = "";
//	   for(int i=1; i<=s6; i++) {	
//	     
//		 for(int j=1; j<=s6-i; j++) {
//	      star += " ";
//	     }
//	     for(int k=1; k<=i; k++) {
//	      star += "*";	    	 
//	     }
//	     System.out.println(star);
//	     star = "";
//       }	   
	   //별문제6 : 입력받은 줄 만큼 출력
//	   int s7 = scanner.nextInt();
//	   String star = "";
//	   
//	   for(int i=1; i<=s7; i++) {	
//		 for(int k=1; k<i; k++) {	
//		 star+=" ";
//		 }		 
//		 for(int j=0; j<s7-i+1; j++) {	
//		 star+="*";
//		 }		  
//	     System.out.println(star);
//	     star = "";
//       }
	   //별문제7 : 입력받은 줄 만큼 출력
//	   int s8 = scanner.nextInt();
//	   String star = "";
//	   
//	   for(int i=1; i<=s8; i++) {	
//		 
//		 for(int j=s8-i; j>0; j--){
//			 star += " ";
//		 }
//		 for(int k=1; k<=2*i-1; k++){
//			 star += "*";
//		 }		   
//	     System.out.println(star);
//	     star = "";
//       }
	   //별문제8 : 입력받은 줄만큼 출력
//	   int s9 = scanner.nextInt();
//	   String star = "";
//	   
//	   for(int i=1; i<=s9; i++) {	
//		 
//		 for(int j=s9-i; j>0; j--){
//			 star += " ";
//		 }
//		 for(int k=1; k<=2*i-1; k++){
//			 star += i+"";
//		 }		   
//	     System.out.println(star);
//	     star = "";
//       }	   
	   //별문제9 : 입력받은 줄만큼 출력
//	   int s10 = scanner.nextInt();
//	   String star = "";
//	   
//	   for(int i=1; i<=s10; i++) {	
//		 for(int k=1; k<=i; k++){
//		   star += " ";	   
//		 }
//		 for(int j=1; j<=2*(s10-i)+1; j++) {
//			 star +="*";
//		 } 
//	     System.out.println(star);
//	     star = "";
//       }	   
	   //별문제10 : 입력받은 줄만큼 출력
//	   int s11 = scanner.nextInt();
//	   String star = "";
//
//	   for(int i=1; i<s11; i++) {	
//		 for(int k=0; k<=s11-i; k++){
//		   star += " ";	 
//
//		 }
//		 for(int j=1; j<=2*i-1; j++) {
//			 star +="*";
//
//		 }
//	     System.out.println(star);
//	     star = "";
//       }	   
//	   
//	   for(int i=1; i<=s11; i++) {	
//		 for(int k=1; k<=i; k++){
//		   star += " ";	   
//		 }
//		 for(int j=1; j<=2*(s11-i)+1; j++) {
//			 star +="*";
//		 }
//	     System.out.println(star);
//	     star = "";
//       }		   
//	   
//	   
	   //별문제11 : 입력받은 줄만큼 출력	   
	   int s11 = scanner.nextInt();
	   String star = "";
	   
	   for(int i=0; i<s11; i++) {	
		 for(int j=1; j<i-1; j++) { // 없음 1 2 3 4  
			 star +=" ";
		 }
		 star += "*";
		 for(int k=1; k>0; k--) { // 5 3 1 0
			 star +=" ";
		 }		 
		   
	     System.out.println(star);
	     star = "";
       }	 	   
	   
	   
	   
	   
	   
   }	
}
