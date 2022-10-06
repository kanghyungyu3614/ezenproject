package java1.ch08인터페이스;

public class Audio implements RemoteControl{
	private int volume;
	
	@Override 
	public void turnOn() {
		System.out.println("Audio 켭니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Audio 끕니다.");
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
		System.out.println("현재 audio 볼륨 : " + this.volume);		
	}
}
