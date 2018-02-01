package week4.shape2d3dapp;

public class RunProgram {

	public static void main(String[] args) {
		Shape2D[] shapes = new Shape2D[5];
		shapes[0] = new Circle("Red", 10);
		shapes[1] = new Square("Blue", 20);
		shapes[2] = new Square("Yellow", 30);
		shapes[3] = new Rectangle(0, 0, 10, 10);
		shapes[4] = new Rectangle(10, 10, 20, 20);
		
		for(int i = 0; i < shapes.length; i++) {
			System.out.println(shapes[i]);
		}
		
		int numberOfCircle = 0;
		int numberOfSquare = 0;
		int numberOfRectangle = 0;
		for(int i = 0; i < shapes.length; i++) {
			if(shapes[i] instanceof Circle) {
				numberOfCircle++;
			}
			if(shapes[i] instanceof Square) {
				numberOfSquare++;
			}
			if(shapes[i] instanceof Rectangle) {
				numberOfRectangle++;
			}
		}
		System.out.println("Number of Circle: " 
						+ numberOfCircle);
		System.out.println("Number of Square: " 
						+ numberOfSquare);
		System.out.println("Number of Rectangle: " 
						+ numberOfRectangle);
	}
	
}




