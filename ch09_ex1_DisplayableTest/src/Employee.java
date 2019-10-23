public class Employee  implements Displayable, DepartmentConstants {

    private int department;
    private String firstName;
    private String lastName;

    public Employee(int department, String lastName, String firstName) {
        this.department = department;
        this.lastName = lastName;
        this.firstName = firstName;
    }

	@Override
	//public String getDisplayText() {
	public String toString() {
		String deptName = "";
		if (department == ADMIN) {
			deptName =  "Administration" ;
		} else	if (department == EDITORIAL) {
			deptName = "Editorial";
		} else if (department == MARKETING) {			
			deptName = "Marketing";
		}
		return firstName + " " + lastName + " (" + deptName + ")";
	}
}