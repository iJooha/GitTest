package polymorphism;

public class LgTV  implements TV {
	private Speaker speaker;
	private int price;
	
	public LgTV() {
		System.out.println("LgTV 생성자");
	}
	
	public LgTV(Speaker speaker) {
		System.out.println("LGTV 생성자(1)");
		this.speaker =speaker;
	}
	public LgTV(Speaker speaker, int price) {
		System.out.println("LGTV 생성자(2개)");
		this.speaker =speaker;
		this.price =price;
	}
	public void powerOn() {
		System.out.println("LgTV-----------전원 킨다.");
		System.out.println("가격 : "+ price + "원");
	}

	public void powerOff() {
		System.out.println("LgTV----------전원 끈다.");
	}

	public void volumeUp() {
	//	System.out.println("LgTV----------소리 올린다.");
		speaker.volumeUp();
	}

	public void volumeDown() {
	//	System.out.println("LgTV----------소리 내린다.");
		speaker.volumeDown();
	}
}