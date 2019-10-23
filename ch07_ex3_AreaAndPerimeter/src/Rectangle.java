import java.text.NumberFormat;

public class Rectangle {
    
    private double length;
    private double width;
    
	public Rectangle() {
        length = 0;
        width = 0;
    }
		
    public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}

	public double calculateArea() {
     	double area = width * length;
     	return area;
    }
    
	public String getAreaNumberFormat() {
		
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMinimumFractionDigits(3);
		String numberFormatted = number.format(this.calculateArea());
		return numberFormatted;    
   	}
    
    public double calculatePerimeter() {
     	double perimeter = (width * 2) + (length * 2);
     	return perimeter;
    }
    
	public String getPerimeterNumberFormat() {
		
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMinimumFractionDigits(3);
		String numberFormatted = number.format(this.calculatePerimeter());
		return numberFormatted;    
   	}
    
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
    
    

}
