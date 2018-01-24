package week3.computerapplication;

public class Computer {

	String operatingSystem;
	boolean powerStateOn;
	
	public Computer(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
	public void shutDown() {
		powerStateOn = false;
	}
	
	public void bootUp() {
		powerStateOn = true;
		
	}
	
}
