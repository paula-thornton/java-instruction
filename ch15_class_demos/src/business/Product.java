package business;

public class Product {
	
	private String code;
	private String description;
	private double price;
	
	public Product(String code, String description, double price) {
		super();   	// doesn't actually do anything
					// means parent = java.lang.????
		this.code = code;
		this.description = description;
		this.price = price;
	}

	public Product() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", description=" + description + ", price=" + price + "]";
	}
	
	public static void increasePrice(Product p) {
		double price = p.getPrice() * 2;
		p.setPrice(price); 
	}

}
