package POJO;

import java.util.LinkedList;

public class Employee {
	String firstName = "";
	String lastName = "";
	String fullName = "";
	int employeeID = 0;
	String email = "";

	String phone = "";
	String jobTitle = "";
	// permissions renamed roles so it doesn't match names with other stuff as much
	LinkedList<Role> roles = new LinkedList<Role>();
	
	
	// leave empty unless except for login
	String userName = "";
	String password = "";
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(String firstName, String lastName, String fullName, int employeeID, String email, String phone,
			String jobTitle, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fullName = fullName;
		this.employeeID = employeeID;
		this.email = email;
		this.phone = phone;
		this.jobTitle = jobTitle;
		this.userName = userName;
		this.password = password;
	}


	public String getFirstName() {
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public LinkedList<Role> getRoles() {
		return roles;
	}
	public void setRoles(LinkedList<Role> roles) {
		this.roles = roles;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
