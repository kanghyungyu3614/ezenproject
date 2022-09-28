package java1.ch7상속;

public class Computer extends Calculator {
   @Override
   double areaCircle(double r) {
	   System.out.println("컴퓨터 객체의 원 넓이함수 실행");
	   return Math.PI *r*r;
   }
}
