package model;
import main.Logable;

public class Employee extends Person implements Logable {
	private int employeeid;
	
	private final int USER = 123;
	private final String PASSWORD = "test";
	
	public Employee() {
		super();
	}
	
	
	public boolean login(int user, String password) {

		
		if (user == USER && password.equals(PASSWORD)) {
			return true;
		} else {
		return false;

		
	}
	
	
	}
}
	

