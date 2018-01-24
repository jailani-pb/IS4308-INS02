package week3.computerapplication;

public class Laptop extends Portable {

	boolean sleep;
	
	public Laptop(String operatingSystem) {
		super(operatingSystem);
	}
	
	public void openLid() {
		sleep = false;
	}
	
	public void closeLid() {
		sleep = true;
	}

	
	
}
