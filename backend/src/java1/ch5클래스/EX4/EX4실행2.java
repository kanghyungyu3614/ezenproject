package java1.ch5클래스.EX4;

public class EX4실행2 {
  public static void main(String[] args) {
	//매개변수가 있는 생성자
	Korean k1 = new Korean("박자바","011225-1234567");
	System.out.println(k1.name);
	System.out.println(k1.ssn);
	System.out.println(k1.nation);
	//매개변수가 없는 생성자
	Korean k2 = new Korean();	
	k2.name = "박자바";
	k2.ssn = "011225-1234567";
	System.out.println(k2.name);
	System.out.println(k2.ssn);
	System.out.println(k2.nation);
}
}
