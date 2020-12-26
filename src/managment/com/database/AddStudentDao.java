package managment.com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managment.com.bean.AddStudent;

public class AddStudentDao {

	private String jdbcURL = "jdbc:mysql://localhost:3306/student?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "rodion";

    private static final String INSERT_USERS_SQL = "INSERT INTO studentdetails" + "  (name,marks,email,dob,gender, course) VALUES " +
        " (?, ?,?,?,?,?);";
    
    private static final String SELECT_ALL_USERS = "select * from studentdetails";
    private static final String UPDATE_USERS_SQL = "update studentdetails set name = ?,marks=?,email= ?, dob=?,gender=?,course =? where id = ?";
    private static final String DELETE_USERS_SQL = "delete from studentdetails where id = ?";
    private static final String SELECT_USER_BY_ID = "select * from studentdetails where id =?";

    
    public AddStudentDao() {}

    
//     JDBC connection
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

//    Method for insert Student details in database
    
    
    public int registerStudent(AddStudent student) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        int resultCount = 0;
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
        	preparedStatement.setString(1, student.getName());
           
            preparedStatement.setInt(2, student.getMarks());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getDob());
            preparedStatement.setString(5, student.getGender());
            preparedStatement.setString(6, student.getCourse());
//            System.out.println(preparedStatement);
            resultCount  = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        
        return resultCount;
    }
    
    
//    method for display list of student
    
    public List < AddStudent > selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < AddStudent > users = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");
                String email = rs.getString("email");
                String dob = rs.getString("dob");
                String gender = rs.getString("gender");
                String course = rs.getString("course");
                users.add(new AddStudent(id, name,marks, email, dob,gender,course));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
    
    
    public boolean updateUser(AddStudent addstudent) throws SQLException {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            
            statement.setString(1, addstudent.getName());
            statement.setInt(2, addstudent.getMarks());
            statement.setString(3, addstudent.getEmail());
            statement.setString(4, addstudent.getDob());
            statement.setString(5, addstudent.getGender());
            statement.setString(6, addstudent.getCourse());
            
            statement.setInt(7, addstudent.getId());
            if(statement.executeUpdate() > 0) {
            	 rowUpdated = true;
            } else {
            	// error page
            }
        }
        return rowUpdated;
    }
    
   
    public AddStudent selectUser(int id) {
        AddStudent s = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                int marks = rs.getInt("marks");
                String email = rs.getString("email");
                String dob = rs.getString("dob");
                String gender = rs.getString("gender");
                String course = rs.getString("course");
                s = new AddStudent(name,marks, email,dob,gender, course);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return s;
    }
    
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
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
