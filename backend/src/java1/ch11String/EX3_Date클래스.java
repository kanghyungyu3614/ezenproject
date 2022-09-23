package java1.ch11String;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EX3_Date클래스 {
  public static void main(String[] args) {
	  // 1. 날짜
	  Date now = new Date(); 
	  System.out.println(now);
	  String strNow1= now.toString();
	  System.out.println(strNow1);
      
	  // 2. SimpleDateFormat() :  날짜/시간 형식[모양]변환
	     // 1. SimpleDateFormat 객체명 = new SimpleDateFormat("형식"); 
	     // 2. 객체명.format(데이터)
	  
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
      String strNow2 = sdf.format( new Date());
      System.out.println(strNow2);
      
      // 3. Calendar 클래스 
      Calendar cal = Calendar.getInstance(); //운영체제에서 설정되어 있는 시간대날짜와 시간의 정보 호출 
	  int year = cal.get(Calendar.YEAR); //연도 호출 
	  System.out.println(year);
	  int month = cal.get(Calendar.MONTH)+1; System.out.println(month); //월0-11
	  // 1월[0] 
	  int day = cal.get(Calendar.DAY_OF_MONTH); System.out.println(day);
	  
	  int week = cal.get(Calendar.DAY_OF_WEEK);
	  String strWeek = null;
	  switch(week) {
	   case Calendar.MONDAY : strWeek="월"; break;
	   case Calendar.TUESDAY : strWeek="화"; break;
	   case Calendar.WEDNESDAY : strWeek="수"; break;
	   case Calendar.THURSDAY : strWeek="목"; break;
	   case Calendar.FRIDAY : strWeek="금"; break;
	   case Calendar.SATURDAY : strWeek="토"; break;
	   default : strWeek="일"; break;
	  };
	  System.out.println(strWeek);
	  int amPm = cal.get(Calendar.AM_PM);
	  if(amPm == Calendar.AM) {
		  System.out.println("오전");
	  }else { System.out.println("오후");}
	  System.out.println(cal.get(Calendar.HOUR));
	  System.out.println(cal.get(Calendar.MINUTE));
	  System.out.println(cal.get(Calendar.SECOND));
	  
	  new EX4_달력().run();
	  //ex.run();
	  
	  
	  
	  
	  
	  
  }
}
