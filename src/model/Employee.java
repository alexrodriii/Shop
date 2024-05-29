package model;
import java.sql.SQLException;

import javax.swing.JTextField;

import dao.Dao;
import dao.DaoImpIJDBC;
import main.Logable;

public class Employee extends Person implements Logable {
	
	protected int employeeid;
	public Dao dao = new DaoImpIJDBC();;
	//private final int USER = 123;
	//private final String PASSWORD = "test";
	private String name;
	private String password;
	private int user;

	    public Employee(int user, String password) {
	      
	         
	    }
	    
	    public Employee() {
	        
	    }
	
	public boolean login(int user, String password) {

		 try {	
            dao.connect();           
            Employee employee = dao.getEmployee(user, password);
            
            dao.disconnect();
            return employee != null;
            
         } catch (SQLException e) {
             e.printStackTrace();
             return false;
        }
    }
	

	
}
	

