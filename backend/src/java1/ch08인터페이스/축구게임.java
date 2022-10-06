package java1.ch08인터페이스;

public class 축구게임 implements 게임패드{
	@Override
	public void A버튼() {
        System.out.println("슛");		
	}
	@Override
	public void B버튼() {
		System.out.println("패스");
	}
	@Override
	public void C버튼() {
		System.out.println("태클");
	}
}
