package java1.ch08인터페이스;

public class SmartTelevision implements RemoteControl, Searchable{
  
  private int volume;
  
  @Override
	public void search(String url) {
        System.out.println(url + "을 검색합니다.");		
	}
  
  @Override
	public void turnOn() {
		
	}
  @Override
	public void turnOff() {
		
	}
  @Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume = volume;
		}
		System.out.println("현재 tv 볼륨 : " + this.volume);
		
	}
}
