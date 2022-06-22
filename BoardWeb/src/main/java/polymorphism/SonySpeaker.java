package polymorphism;

public class SonySpeaker implements Speaker{
	
	public SonySpeaker() {
		System.out.println("SonySpeak 생성자");
	}

	public void volumeUp() {
		System.out.println("SonySpeak....소리 올린다.");

	}
	
	public void volumeDown() {
		System.out.println("SonySpeak....소리 내린다.");
	}

}
