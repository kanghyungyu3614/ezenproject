package java1.ch5클래스.EX14;

public class Car {
  CarData data = new CarData(); 
  //2.생성자
  String model;
  int speed;
 Car( String model) {
	this.model = model;
}
  
  void setSpeed(int speed) {
	  this.speed = speed;
  }
  
  void run() {
	  for(int i=10; i<=50; i+=10) {
		  this.setSpeed(i);
		  System.out.println(this.model + "가 달립니다.(시속 : "+this.speed+"km/h");
	  }
  }
}
