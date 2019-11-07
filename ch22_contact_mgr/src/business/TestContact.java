package business;

public interface TestContact {
	
	// this is public and abstract by default
	// functional interface can only have 1 method
	// regular interfaces can have multiple methods
	
	boolean test(Contact c);
	
}
