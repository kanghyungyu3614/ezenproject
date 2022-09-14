package java1.d클래스.EX10;

public class Car { // 클래스 [ 설계도 : 변수 선언 , 메소드 선언 ]
	// 1. 필드
	int gas; // gas 수량을 저장하는 int형 필드[변수]
	
	// 2. 생성자 
	// 3. 메소드 
	// 1. 반환값X 매개변수 int 
	void setGas( int gas ) { 
		this.gas = gas; 
		return; 
	}
	// 2. 반환값 boolean  매개변수x
	boolean isLeftGas() {
		
		// 1. 현재 동일한 클래스의 메소드 호출 [ 내부 메소드 호출  ] 
		setGas(5);	// 메소드명();
		// 2. 서로 다른 클래스의 메소드 호출 [ 외부 메소드 호출 ]
		Car car = new Car();
		car.setGas( 5 );	// 객체명.메소드명()
		
		if( gas == 0 ) { // 만일 gas 변수가 0 이면 
			System.out.println("gas가 없습니다.");
			return false; // 가스 없다는 의미 // 함수 종료 
		}else { // 아니면 
			System.out.println("gas가 있습니다.");
			return true; // 가스가 있다는 의미 // 함수 종료 
		}  // else end 
	} // m end 
	// 3. 반환값 x 매개변수 x  
	void run() {
		while(true) { // 무한반복
			if( gas > 0 ) { // 만일 gas변수가 0보다 크면
				System.out.println("달립니다.[gas잔량:"+gas+"]");
				gas -= 1 ; // 가스 1 감소 
			}else {
				System.out.println("멈춥니다.[gas잔량:"+gas+"]");
				return; // 함수종료 // 무한루프 종료
			}
		} // w e
		// while 이후에 코드가 존재하지 않기때문에 return 문 과 break문 같다.
	} // m e
	
	
	
	
	
	
}