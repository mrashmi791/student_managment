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

@WebServlet("/insert")
public class AddStudentServlet extends HttpServlet {

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
    		loadForm(request, response);
    	
    }
    
    protected void loadForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 RequestDispatcher dispatcher = request.getRequestDispatcher("addstudent.jsp");
    	 request.setAttribute("student", new AddStudent());
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
    	       
    	       
    	        AddStudent student = new AddStudent(name,marks,email, dob,gender,course );
    	     
    	        int result = 0;
    	        try {
    	        	result = studentDAO.registerStudent(student);
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	        }
    	        if(result == 1) {
    	        	response.sendRedirect("/studentmanagment/list");
    	        } else {
    	        	// redirect to errorpage
    	        }
    	        
    	    }
}
