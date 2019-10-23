
public class InstatnceCreatorApp {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.setID(10);
		System.out.println(car1.toString());
		
		Car car2 = new Car(20);
		System.out.println(car2.toString());
		
		System.out.println(Car.objectCount);
		
		Product p1 = new Product();
		p1.setCode("java");
		p1.setDescription("Murachs Java");
		p1.setPrice(57.50);
		increasePrice(p1);
		System.out.println(p1);
		p1.setDescription("Murachs Java");
		
		System.out.println(p1.toString());
		System.out.println(p1);  // same result
		
		Truck t1 = new Truck();

		t1.setId(11);
		System.out.println(t1);
		
		Truck t2 = new Truck(2);
		System.out.println(t2);
		
	}
	


}
