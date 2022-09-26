package java1.ch12스레드;

public class 계산기 {
  //필드
  private int 저장소;
  //생성자
  
  //메소드
  public int get저장소() {return 저장소;}

  public void set저장소(int 저장) {
	  this.저장소= 저장;
	  try {
		Thread.sleep(2000);
	} catch (Exception e) {}
	  System.out.println(Thread.currentThread().getName()+" : "+ this.저장소);
  }
}
