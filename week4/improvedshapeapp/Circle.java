package week4.improvedshapeapp;

public class Circle extends Shape {

	int radius;
	
	public Circle(String colour, int radius) {
		super(colour);
		this.radius = radius;
	}

	@Override
	public int getArea() {
		return (int) (Math.PI * radius * radius);
	}

	@Override
	public int getPerimeter() {
		return (int) (2 * Math.PI * radius);
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", colour=" + colour + "]";
	}
	
	
	
	

}
