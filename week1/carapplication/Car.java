package week1.carapplication;

public class Car {

	String brand;
	String model;
	String colour;
	int currentSpeed = 0;
	
	public void pressAccelerate() {
		currentSpeed += 5;
	}
	
	public void pressBrake() {
		currentSpeed = 0;
	}
	
}
