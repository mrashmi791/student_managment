package managment.com.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managment.com.database.AddStudentDao;

@WebServlet("/delete")
public class DeleteStudentServlet extends HttpServlet {

	private AddStudentDao studentDAO;

    public void init() {
    	studentDAO = new AddStudentDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	try {
    		deleteUser(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException {
    	        int id = Integer.parseInt(request.getParameter("id"));
    	        if(studentDAO.deleteUser(id)) {
    	           response.sendRedirect("success.jsp");
    	        } else {
    	        	// show error message
    	        }
    	        

    	    }
}
