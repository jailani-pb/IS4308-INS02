package week3.computerapplication;

public class SmartPhone extends Portable {

	boolean displayOn;
	
	public SmartPhone(String operatingSystem) {
		super(operatingSystem);
	}
	
	public void turnDisplayOn() {
		displayOn = true;
	}
	
	public void turnDisplayOff() {
		displayOn = false;
	}
	
	@Override
	public void bootUp() {
		super.bootUp();
		turnDisplayOn();
	}

}
