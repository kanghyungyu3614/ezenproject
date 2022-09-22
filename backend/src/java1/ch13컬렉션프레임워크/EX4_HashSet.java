package java1.ch13컬렉션프레임워크;

import java.util.HashSet;
import java.util.Iterator;

public class EX4_HashSet {
  public static void main(String[] args) {
	HashSet<String> set = new HashSet<>();
	
	set.add("java");    System.out.println("set 현황 : "+set.toString());
	set.add("jdbc");    System.out.println("set 현황 : "+set.toString());
	set.add("servlet/jsp"); System.out.println("set 현황 : "+set.toString());
	set.add("java");    System.out.println("set 현황 : "+set.toString());
	set.add("ibatis");    System.out.println("set 현황 : "+set.toString());
	
	// * 해시코드 함수 확인
	System.out.printf("java 문자열의 해시코드변환 : %d \n", "java".hashCode() );
	System.out.printf("java 문자열의 해시코드변환 : %d \n", "java".hashCode() );
	
	
	
	System.out.println("set내 객체수 : "+set.size());
	Iterator<String> iterator = set.iterator();
	while(iterator.hasNext()) {    //.hasNext() : 다음 객체가 존재하면 true/false 
		String element = iterator.next();  // .next() : 다음 객체로 이동[호출]
		System.out.println("\t"+element);
	}
	
	for (String s: set) {
		System.out.println("\t"+s);
	}
}
}
