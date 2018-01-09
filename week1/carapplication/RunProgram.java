package week1.carapplication;

public class RunProgram {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.brand = "Ford";
		car1.model = "Focus ST";
		car1.colour = "Blue";
		Car car2 = new Car();
		car2.brand = "Kia";
		car2.model = "Stinger";
		car2.colour = "Black";
		
		printCarDetails(car1);
		printCarDetails(car2);
		car1.colour = "Black";
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
	}
	
}
