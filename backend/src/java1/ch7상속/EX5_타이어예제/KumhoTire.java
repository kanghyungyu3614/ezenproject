package java1.ch7상속.EX5_타이어예제;

public class KumhoTire extends Tire {

	public KumhoTire(int maxRotation, String location) {
		super(maxRotation, location);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean roll() {
		++accumulatedRotation; //누적 회전수 1씩증가
		//최대회전수 보다 누적회전수가 더 작으면 [ 수명남음 ]
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " KumhoTire 수명 : "
			+ (maxRotation-accumulatedRotation) +"회");
			return true;
			//수명이 없을경우 true
		}
		else {
			System.out.println("*** "+location +" KumhoTire 펑크***");
			return false; 
			//수명이 없을경우 false [ 펑크일경우 ]
		}
	}
  
}
