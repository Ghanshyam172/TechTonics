package pojos;

public class LoginPojo {

	 String email; //keep email and password accessible to only current package classes
	 String password;
	 
	 //class constructor

	public LoginPojo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	//getter-setter methods
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
		return "Login [email=" + email + ", password=" + password + "]";
	}
	
	 
	 
	
}
