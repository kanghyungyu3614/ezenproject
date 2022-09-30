package java1.ch10예외처리;

public class EX1_예외처리 {
	//필드
	
	//생성자
	
	//메소드
		
		
		
		public static void main(String[] args) {
			
		//1. NullPointer
		//String data = null;
		//System.out.println(data.toString());
		//System.out.println("ddd");
	//	System.out.println(args);
	//	String data1 = args[0];
	//	String data2 = args[1];
	//	System.out.println("data1 : "+ data1);
	//	System.out.println("data2 : "+ data2);
			
			
    //	    3. NumberFormat
	//		String data1 = "100"; //문자열 100 // 왜?
	
	// 1. 자식 객체 선언		
	Dog dog = new Dog();
	changeDog(dog);
	
	// 2. 자식 객체 선언
	Cat cat = new Cat();
	changeDog(cat);
		
	} //main 끝
		
		
	public static void changeDog(Animal animal) {
		if(animal instanceof Dog) {
			Dog dog = (Dog) animal;
			System.out.println("개로 변환");
		}
		System.out.println("고양이는 불가 변환");
	}
		
}
