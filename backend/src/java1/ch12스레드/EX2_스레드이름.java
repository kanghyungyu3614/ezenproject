package java1.ch12스레드;

public class EX2_스레드이름 {
 public static void main(String[] args) {
	Thread 메인스레드 = Thread.currentThread();
	System.out.println(" main함수에 있는 스레드 이름 : "+ 메인스레드.getName());
	
	스레드A 스레드a = new 스레드A();
	스레드a.start();
}
}
