package week1.carapplication;

public class RunProgram {

	public static void main(String[] args) {
		Wheels wheels1 = new Wheels();
		wheels1.brand = "Continental";
		wheels1.size = 18;
		wheels1.brakeSpeed = 4;
		Car car1 = new Car();
		car1.brand = "Ford";
		car1.model = "Focus ST";
		car1.colour = "Blue";
		car1.wheels = wheels1;
		Car car2 = new Car();
		car2.brand = "Kia";
		car2.model = "Stinger";
		car2.colour = "Black";
		car2.wheels = wheels1;
		
		printCarDetails(car1);
		printCarDetails(car2);
		car1.colour = "Black";
		car1.wheels.brand = "Pirelli";
		printCarDetails(car1);
		printCarDetails(car2);
		car1.pressAccelerate();
		car1.pressAccelerate();
		printCarDetails(car1);
		printCarDetails(car2);
	}

	public static void printCarDetails(Car car) {
		System.out.println(car.brand + " "
				+ car.model + " "
				+ car.colour + " (Current Speed: "
				+ car.currentSpeed + ")");
		System.out.println(car.wheels.brand + " size "
				+ car.wheels.size + " brake speed "
				+ car.wheels.brakeSpeed);
	}
	
}
