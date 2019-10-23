public class DisplayableTestApp {

    public static void main(String args[]) {
        System.out.println("Welcome to the Displayable Test application\n");

     //   Employee e = new Employee(2, "Smith", "John");
        Displayable d1 = new Employee(2, "Smith", "John");
        display(d1);
       
     //  Product p = new Product("java", "Murach's Java Programming", 57.50);
        Displayable d2 = new Product("java", "Murach's Java Programming", 57.50);
        display(d2);
        
        System.out.println();        
    }

    private static void display(Displayable d) {
        System.out.println(d.getDisplayText());
    }
}