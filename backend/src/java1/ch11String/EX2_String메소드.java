package java1.ch11String;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollPaneUI;

import com.mysql.cj.conf.StringProperty;
import com.mysql.cj.xdevapi.Result;

public class EX2_String메소드 {
  public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	// 1. CharAt(인덱스) : 해당 인덱스의 문자 추출
	  String ssn = "010624-4230123"; //문자열
	  char sex = ssn.charAt(7); // 1 
	  System.out.println(sex);
	  switch(sex) {
	  
	  case '1' : 
	  case '3' : 
	    System.out.println("남자 입니다."); break;
	  case '2' : 
	  case '4' : 
	    System.out.println("여자 입니다."); break;	    
	    
	  }
	  // 2. 문자열1.equals(문자열2) : 두 문자열 비교
	  String strVar1 = new String("신문철");
	  String strVar2 = "신문철";
	  
	  if(strVar1 == strVar2) {
		  System.out.println("같은 String 객체를 참조");
	  }
	  else {
		  System.out.println("다른 String 객체를 참조");
	  }
	  if(strVar1.equals(strVar2)) {
		  System.out.println("같은 문자열을 가짐");
	  }
	  else { System.out.println("(힙 값이 다르다) 다른 문자열 가짐");}
	  
	  
	  
	  // 3. getBytes(인코딩타입) 생략시 : 1.java버전 2.설정 
	   String str = "안녕하세요.";
	   byte[] bytes1 = str.getBytes();  // 인코딩타입 생략시 : 1.java버전
	   System.out.println("길이 : "+bytes1.length);
	   String str1 = new String(bytes1); System.out.println("바이트열-> 문자열 : "+str1);
	   try {
		  // EUC-KR
		   byte[] bytes2 = str.getBytes("EUC-KR");
          System.out.println("문자열 -> 바이트열(EUC-KR) : "+bytes2.length);		
          String str2 = new String(bytes2, "EUC-KR");
          System.out.println(" 바이트열 -> 문자열 : "+str2);
          //UTF-8 
          byte[]bytes3 = str.getBytes("UTF-8");
          System.out.println("문자열 -> 바이트열(UTF-8) : "+bytes3.length);
          String str3 = new String (bytes3,"UTF-8");
          System.out.println("바이트열 -> 문자열 : "+str3);
          
	} catch (Exception e) {}
	
	//4. index("문자") : 해당 문자 인덱스번호 찾기
	  String subject = "자바 프로그래밍";
	  System.out.println(subject.indexOf("프로그래밍"));
	  
	  int location = subject.indexOf("프로그래밍");
	  
	  if(location!= -1 ) {
		  System.out.println("찾았다.");
	  }else {System.out.println("못찾았다.");}
	  
	  
	  //5. length() : 문자열 길이 
	  
	 String ssn2 ="7306241230123";
	 int length = ssn.length();
	 if(length==13) {System.out.println("주민번호 자리수가ㅣ 맞습니다.");}
	 else {System.out.println("주민번호 자리수가 틀립니다.");}
	 
	 //6. replace() : 치환 () 
	 String oldStr = "자바는 객체 지향 언어입니다. 자바는 풍부한 API를 지원합니다.";
	 String newStr = oldStr.replace("자바","java");
	 System.out.println(oldStr);
	 System.out.println(newStr);
	  
	 // 7. 
	 String str2 = "Java Programming";
	 System.out.println("소문자변환 : "+str.toLowerCase());
	 System.out.println("대문자변환 : "+str.toUpperCase());
     
	 // 8. trim()
	 String tel1 = "     02";
	 String tel2 = " 123             ";
	 String tel3 = "                   1       23 ";
	 System.out.println(tel1.trim());
	 System.out.println(tel2.trim());
	 System.out.println(tel3.trim());
	  
	 // 9. valueOf() : 다른 자료형 --> 문자열(String) 변환
	 System.out.println( 10 + ""); // 문자열 10 출력
	 System.out.println( String.valueOf(10)); // 정수형10 -> 문자열 10 출력
	 System.out.println( String.valueOf(10.5)); // 문자열 10.5 출력
	 System.out.println( String.valueOf(true)); // 문자열 true 출력
	 
	  // 10. substring([시작인덱스(포함)],[끝인덱스(제외)]) : 문자열 자르기
      String ssn3 = "880815-1234567";
      String firStNum = ssn3.substring(0,6);
      //     0번 : 8   6번 : 
      System.out.println(firStNum);	  
      
      String secondNum = ssn3.substring(7);
      //     7번 : 1    생략 : 끝까지 1234567
      System.out.println(secondNum);
      // 11. split([])
      String[] result = ssn3.split("-");
	  System.out.println(result[0]);
	  System.out.println(result[1]);
	  
	  "ASD".contains("A");
      	  
	  
	  
	  
	  
	  
	  
}
}
