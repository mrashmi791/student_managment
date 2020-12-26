package managment.com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import managment.com.bean.LoginBean;

public class LoginDao {
	
	public boolean validate(LoginBean loginbean) throws ClassNotFoundException {
		boolean status = false;
		
		Class.forName("com,mysql.jdbc.driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useSSL=false", "root", "rodion")) {
			
			PreparedStatement statement = connection.prepareStatement("select * from login wherre username=? and password=?");
			statement.setString(1, loginbean.getUsername());
			statement.setString(2, loginbean.getPassword());
			System.out.println(statement);
			
			ResultSet query = statement.executeQuery();
			status = query.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return status;
		
	}
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }

}
}
