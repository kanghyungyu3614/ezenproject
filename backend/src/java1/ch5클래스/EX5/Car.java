package java1.ch5클래스.EX5;

public class Car {
  String company = "현대자동차";
  String model;
  String color;
  int maxSpeed;
  // 생성자 
      // 오버로딩 : 동일한 이름으로 선언 [ 매개변수 따라 구별 ]
      // 생성자에서 사용되는 매개변수명은 필드명과 동일하게 작성 [this 키워드]
      // 1. 빈생성자 : 매개변수 가 없는 생성자[기본생성자]
  Car(){}
      //2. 매개변수가 1개인 생성자
  Car( String model){this.model = model;}
  //3. 매개변수가 2개인 생성자
  Car( String model, String color){
	  
	  this(model, color, 5000);
	  
  }
  //4. 매개변수가 3개인 생성자  
  Car( String model, String color, int maxSpeed){}
}
