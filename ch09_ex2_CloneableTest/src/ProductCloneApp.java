public class ProductCloneApp {
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Product Clone Test\n");

        // create a new product
        Product p1 = new Product();
        p1.setCode("java");
        p1.setDescription("Murach's Beginning Java");
        p1.setPrice(49.50);
        
        Product p2 = new Product();

        try {
            // clone the product
            p2 = (Product) p1.clone();

            // change a value in the cloned product
            p2.setPrice(57.50);

            if (p1.getPrice() == p2.getPrice())
            {
                System.out.println("FAILURE: The clone method of the Product class is not cloning data.");
            }
            else if (p1.getPrice() != p2.getPrice())
            {
                System.out.println("SUCCESS: The clone method of the Product class is cloning data.");
                System.out.println(p1);
                System.out.println(p2);
            }
            System.out.println(); 

        }
 
        catch (CloneNotSupportedException e) {
            System.out.println("A cloning error occurred.");
        }
        

    }
    
}
