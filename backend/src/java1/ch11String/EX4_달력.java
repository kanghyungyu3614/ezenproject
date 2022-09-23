package java1.ch11String;

import java.sql.Connection;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import com.mysql.cj.exceptions.RSAException;

import java1.가계부.ExpenseDTO;

public class EX4_달력 {
	
	// 1. 필드
	Scanner scanner = new Scanner( System.in); 	// 입력객체
	Calendar cal = Calendar.getInstance();		// 달력객체 
	int year = cal.get( Calendar.YEAR );
	int month = cal.get( Calendar.MONTH ) + 1;
	int day  = cal.get( Calendar.DAY_OF_MONTH );
	// 2. 생성자
	// 3. 메소드 
	void run() {
		while( true ) {
			cal.set( year, month-1, 1 );// *** 현재날짜를 이용한 1일 요일 찾기  현재 월의 1일 날짜로 세팅
			int sweek = cal.get( Calendar.DAY_OF_WEEK  ); // 현재 월의 1일의 요일 
			int eday = cal.getActualMaximum( Calendar.DAY_OF_MONTH ); // *** 현재날짜의 마지막 일 수 찾기 
			System.out.printf(" =========== %d 년 %d 월 의 달력 =================== \n " , year , month );
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			for( int i = 1 ; i< sweek ; i++ ) { System.out.print("\t"); } // 1. 1일의 전까지 공백 반복문 
			for( int i = 1 ; i<= eday ; i++ ) {  // 2. 1일부터 ~ 마지막 일수 까지 일수를 출력하는 반목문
				System.out.printf( "%2d \t" , i );
				if( sweek % 7 == 0 ) { System.out.println(); } // 토요일 이후[ sweek 7의 배수이면 ]에 줄바꿈처리  
				sweek++ ; // 일수를 출력할때마다 요일도 증가처리 
			}
			System.out.println();
			System.out.println( "일정추가 밑에있어용"  );
			일정출력();
			System.out.println("\n===================================================");
			System.out.print("◀이전달[1]  ▶다음달[2]  검색[3]  일정추가[4] : ");
			int btn = scanner.nextInt();
				// 이전달 : 월에서 1차감  [ 만일 월이 0 이면 월=12 설정 연도 1 차감 ] 
			if( btn == 1 ) { month--; if( month == 0 ) { month = 12; year--; }  }
				// 다음달 : 월에서 1증가  [ 만일 월이 13 이면 월=1 설정 연도 1 증가 ] 
			else if( btn == 2 ) { month++; if( month == 13 ) { month = 1; year++; }  }
			else if( btn == 3 ) {
			    System.out.println("검색 연도:"); int inyear = scanner.nextInt();	
			    System.out.println("검색 월 :");	int inmonth = scanner.nextInt();
			    if(inyear < 1900 || inyear>= 9999||inmonth < 1 || inmonth > 12) {
			    	System.out.println("경고 : 지원하지 않는 날짜 입니다.");
			    }
			    else { year = inyear; month = inmonth;}
			}
			else if( btn == 4 ) {일정추가();} 
		}
		
	} // run
	void 일정추가() {
		System.out.println("날짜 : "); String cdate = scanner.next();
		System.out.println("메모 : "); String ccomment = scanner.next();
		boolean result = 달력Dao.getInstance().일정추가(cdate, ccomment);
		if(result ==true) {System.out.println("일정등록성공");}
		else {
			System.out.println("일정등록실패");
		}
	}  // 날짜, 메모 등
	
	void 일정출력() {
		System.out.println("\n------- 일정 확인------");
		System.out.println("번호\t날짜\t\t메모");
		
		String strmonth = "";
		if(month < 10) {strmonth="0"+month;} 
		else { strmonth = month+"";}
		
		HashMap<Integer, ArrayList<String>> map 
		    = 달력Dao.getInstance().일정출력(String.valueOf(year),month+"");
	     for(Integer key : map.keySet()) {
	    	 System.out.println(key + "\t");
	    	 for(String s : map.get(key)){
	    		 System.out.println(s+"\t");
	      }
	         System.out.println();
	     }
	  } 
     

	////////////////활용 //////////////////////
	// 1. 일정이 있는 날에는 * 표시 
}


