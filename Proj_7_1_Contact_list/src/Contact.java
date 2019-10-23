
public class Contact {
	
	// instatnce variables
    private String firstName;  // private can't be accessed by other classes
    private String lastName;   // = encapsulation
    private String email;
    private String phone;
    
    // empty constructor;
    public Contact() {
    	super();    // references object superclass - not really needed
    }
    
	// fully-qualified constructor;
    public Contact(String firstName, String lastName, String email, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
	public String getFirstName() {      // empty consturctor
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone
				+ "]";
	}
	
	public String displayContact() {
		String str = 
		"\n-----------------------------------------------------------------------" + 
		"\n---- Current Contact --------------------------------------------------" +
		"\n-----------------------------------------------------------------------" +
		"\nName:           " + firstName + " " + lastName +
		"\nEmail Address:  " + email +
		"\nPhone Number:   " + phone +
		"\n-----------------------------------------------------------------------\n";
		return str;
	}
    
}
