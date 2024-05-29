package dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Employee;

public class DaoImpIJDBC implements Dao {
	
	private Connection connection;
	
	public void connect() throws SQLException  {
	  String url = "jdbc:mysql://localhost:8889/shop";
	  String name = "root";
	  String password = "root";
	   this.connection = DriverManager.getConnection(url,name,password);	
		
	}

	@Override
	public Employee getEmployee(int user, String password) {
		
		Employee employee = null;
		String query = "SELECT * FROM employee WHERE user = ? and password = ? ";
		
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, user);
			ps.setString(2, password);
			
		try(ResultSet rs = ps.executeQuery()){
			if(rs.next()) {
				employee = new Employee(user,password);
                                      
			}
	   	}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      return employee;
	}

	   @Override
	   public void disconnect() throws SQLException {
		 if (connection != null) {
		     connection.close();
		}
		
	}
	
	
	
	
	
	
	
}
