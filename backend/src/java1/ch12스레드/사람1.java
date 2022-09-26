package java1.ch12스레드;

public class 사람1 {
  private 계산기 계산기;
  public void set계산기(계산기 계산기) {
	//  this.setName("사람1");
	  this.계산기 = 계산기;
  }
  public void run() {
	  계산기.set저장소(100);
  }
  
}
