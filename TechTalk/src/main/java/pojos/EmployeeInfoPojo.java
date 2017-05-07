package pojos;

public class EmployeeInfoPojo {

	//Employee details while signing up
	public String name;
	public String email;
	public String password;
	
	//class constructor
	public EmployeeInfoPojo(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	
	//getter-setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "EmployeeInfoPojo [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	//getter-setters end 
	
	
	
	
	
}
