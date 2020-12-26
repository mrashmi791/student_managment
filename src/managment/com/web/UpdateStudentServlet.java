package managment.com.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managment.com.bean.AddStudent;
import managment.com.database.AddStudentDao;

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AddStudentDao studentDAO;
	private int stdId = 0;

    public void init() {
    	studentDAO = new AddStudentDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    		// get id from request...  
    	// fetch student details by id
    	// pass student in loadForm method
    	
    	   stdId = Integer.parseInt(request.getParameter("id"));
	        AddStudent existingUser = studentDAO.selectUser(stdId);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("updatedetails.jsp");
	        request.setAttribute("student", existingUser);
	        dispatcher.forward(request, response);    	
    }
  
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {

    	    String name = request.getParameter("name");
	        int marks = Integer.parseInt(request.getParameter("marks"));
	        String email = request.getParameter("email");
	        String dob = request.getParameter("dob");
	        String gender = request.getParameter("gender");
	        String course = request.getParameter("course-name");
	        
	        AddStudent s1 = new AddStudent(stdId, name, marks,email,dob,gender,course);
	        try {
				studentDAO.updateUser(s1);
				response.sendRedirect("/studentmanagment/list");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
    	        
    	    }
    
//    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//    	    throws SQLException, IOException {
//    	      
//    	        String name = request.getParameter("name");
//    	        int marks = Integer.parseInt(request.getParameter("marks"));
//    	        String email = request.getParameter("email");
//    	        String dob = request.getParameter("dob");
//    	        String gender = request.getParameter("gender");
//    	        String course = request.getParameter("course");
//
//    	        int id = Integer.parseInt(request.getParameter("id"));
//    	        
//    	        AddStudent s1 = new AddStudent(name, marks,email,dob,gender,course);
//    	        studentDAO.updateUser(s1);
//    	        response.sendRedirect("/list");
//}
    
    
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//    	    throws SQLException, ServletException, IOException {
//    	        int id = Integer.parseInt(request.getParameter("id"));
//    	        AddStudent existingUser = studentDAO.selectUser(id);
//    	        RequestDispatcher dispatcher = request.getRequestDispatcher("/addstudent.jsp");
//    	        request.setAttribute("student", existingUser);
//    	        dispatcher.forward(request, response);
//
//    	    }
//    
}