package java1.ch10예외처리;

public class EX2_예외처리2 {
	//필드
	
	//생성자
	
	//메소드
		
		
		
		public static void main(String[] args) {
			
		// 0. 
		try {
			Class clazz = Class.forName("java.lang.String2");			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("클래스가 존재하지 않습니다.:"+e);
		}finally {
			System.out.println("찾든 안찾든 무조건 실행");
		}
			
		//1. NullPointer
		try {
			String data= null;
			System.out.println(data.toString());
		}
		catch(NullPointerException e){
			System.out.println("객체의 내용이 없습니다.[참조없다]"+e);
		}
		
		try {
			String data1 = args[0];
			String data2 = args[1];
			System.out.println("data1 : "+ data1);
			System.out.println("data2 : "+ data2);
			
		} catch (Exception e) {
			System.out.println("배열의 인덱스가 없습니다. : "+e);
		}
		//String data = null;
		//System.out.println(data.toString());
		//System.out.println("ddd");
	//	System.out.println(args);
			
			
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
