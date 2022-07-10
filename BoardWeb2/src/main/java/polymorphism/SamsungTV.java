package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV{
	@Autowired
	@Qualifier("appleSpeaker")
	private Speaker speaker;
	//private  Speaker sp = new AppleSpeaker();
	private int price;
	
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("setPrice호출");
		this.price = price;
	}

	public SamsungTV() {
		System.out.println("samsungTV 생성자(Default)");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("samsungTV 생성자(1개)");
		this.speaker =speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("samsungTV 생성자(2개)");
		this.speaker =speaker;
		this.price =price;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV--------전원 킨다");
		System.out.println("가격 : "+ price+ "원");
	}
	public void powerOff() {
		System.out.println("SamsungTV--------전원 끈다.");
	}

	public void volumeUp() {
		System.out.println("SamsungTV-----------소리 올린다");
	//speaker = new SonySpeaker();
	speaker.volumeUp();
	}

	public void volumeDown() {
		System.out.println("SamsungTV--------소리 내린다.");
		//speaker = new SonySpeaker();
		speaker.volumeDown();
		}
	
	}
