package week4.improvedshapeapp;

public class Triangle extends Shape {

	int base;
	int height;
	
	public Triangle(String colour, int base, int height) {
		super(colour);
		this.base = base;
		this.height = height;
	}
	
	public int getArea() {
		return (int) (0.5 * base * height);
	}
	
	public int getPerimeter() {
		int c = (int) Math.sqrt((base * base) 
								+ (height * height));
		return base + height + c;
	}

	@Override
	public String toString() {
		return "Triangle [base=" + base + ", height=" + height + ", colour=" + colour + "]";
	}
	
}
