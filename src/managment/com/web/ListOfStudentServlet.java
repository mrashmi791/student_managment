package managment.com.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managment.com.bean.AddStudent;
import managment.com.database.AddStudentDao;

@WebServlet("/list")
public class ListOfStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AddStudentDao studentDAO;

    public void init() {
    	studentDAO = new AddStudentDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	try {
			listUser(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    private void listUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	        List < AddStudent > listUser = studentDAO.selectAllUsers();
    	        request.setAttribute("listUser", listUser);
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("studentlist.jsp");
    	        dispatcher.forward(request, response);
    	    }

}
