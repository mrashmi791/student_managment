package managment.com.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managment.com.bean.AddStudent;
import managment.com.bean.LoginBean;
import managment.com.database.AddStudentDao;
import managment.com.database.LoginDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private LoginDao loginDao;
	public void init() {
		loginDao = new LoginDao();
	}

    
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {

		        String username = request.getParameter("name");
		        String password = request.getParameter("password");
		        LoginBean loginBean = new LoginBean();
		        loginBean.setUsername(username);
		        loginBean.setPassword(password);
		        
		        try {
		            if (loginDao.validate(loginBean)) {
		                //HttpSession session = request.getSession();
		                // session.setAttribute("username",username);
		                response.sendRedirect("loginsuccess.jsp");
		            } else {
		                HttpSession session = request.getSession();
		                //session.setAttribute("user", username);
		                //response.sendRedirect("login.jsp");
		            }
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
	}

}
