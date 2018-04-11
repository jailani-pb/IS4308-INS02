package week14.productmanagementapp.model;

public class Product {

	private int id;
	private String name;
	private double price;
	private boolean inStock;
	
	public Product(int id, String name, double price, boolean inStock) {
		this(name, price, inStock);
		this.id = id;
	}
	
	public Product(String name, double price, boolean inStock) {
		this.name = name;
		this.price = price;
		this.inStock = inStock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "(" + id + ") " + name;
	}
	
}
