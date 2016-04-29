package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.LoginController;
import database.FakeDatabase;
import model.User;
import persist.DerbyDatabase;

public class LoginServlet extends HttpServlet {
	
	FakeDatabase db = new FakeDatabase();
	DerbyDatabase db2 = new DerbyDatabase();
	LoginController controller = new LoginController();
	private String id, errorMessage;
	private User model;
	
	public LoginServlet() {
		//model = new User(null,null,null);
	}
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	 HttpSession session = request.getSession(true);
         
         Object logStatus = session.getAttribute("status");
         
         if (logStatus != null) {
        	 response.sendRedirect("index");
         }
         else {
	    	String shared = "shared";
	        request.setAttribute("sharedId", shared); // add to request
	        request.getSession().setAttribute("sharedId", shared); // add to session
	        this.getServletConfig().getServletContext().setAttribute("sharedId", shared); // add to application context
			request.getRequestDispatcher("/_view/login.jsp").forward(request, response);
         }
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("id");
        String password = request.getParameter("pass");
        
        this.id = username;
        HttpSession session = request.getSession(true);
        
        Object logStatus = session.getAttribute("status");
        
        errorMessage = controller.getError(username, password);
        if(!controller.validateCredentials(errorMessage)) {
        	request.setAttribute("error", errorMessage);
        	request.getRequestDispatcher("/_view/login.jsp").forward(request, response);
        }
        else {
        	model = db2.retrieveUser(username);
        	
        	Object objCurrent = session.getAttribute("user");
			User current = User.class.cast(objCurrent);
			
        	if (current == null) {
        		session.setAttribute("user", model);
	        	session.setAttribute("status", "Logged In!");
	            response.sendRedirect("index");
        	}
        	else if (current.equals(model)) {
        		request.setAttribute("error", "User is already logged in!");
            	request.getRequestDispatcher("/_view/login.jsp").forward(request, response);
        	}
        	else {
	        	session.setAttribute("user", model);
	        	session.setAttribute("status", "Logged In!");
	            response.sendRedirect("index");
        	}
        }
	}
}