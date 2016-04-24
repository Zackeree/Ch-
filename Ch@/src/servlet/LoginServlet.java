package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FakeDatabase;
import model.User;
import persist.DerbyDatabase;

public class LoginServlet extends HttpServlet {
	
	FakeDatabase db = new FakeDatabase();
	DerbyDatabase db2 = new DerbyDatabase();
	private String id;
	
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String shared = "shared";
        request.setAttribute("sharedId", shared); // add to request
        request.getSession().setAttribute("sharedId", shared); // add to session
        this.getServletConfig().getServletContext().setAttribute("sharedId", shared); // add to application context
		request.getRequestDispatcher("/_view/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("id");
        String password = request.getParameter("pass");
        
        this.id = username;
        
        // Make sure that username is in the database
        if (db2.userAlreadyExists(username) == 1) {
        	User user2 = db2.retrieveUser(username);
        	if (password.equals(user2.getPassword())) {
        		request.getSession().setAttribute("id", user2.getID());
	            response.sendRedirect("index");
        	}
        	else {
        		request.setAttribute("error", "Invalid password, try again");
	            request.getRequestDispatcher("/_view/login.jsp").forward(request, response);
        	}
        }
        else {
        	request.setAttribute("error", "Unknown user, please try again");
            request.getRequestDispatcher("/_view/login.jsp").forward(request, response);
        }
        /*
        if (db.retrieveUser(username) != null) {
	        User user = db.retrieveUser(username);
	        if (db.validate(user.getID(), password)){
	        	request.getSession().setAttribute("id", user.getID());
	            response.sendRedirect("index");
	        }
	        else { 
	        	request.setAttribute("error", "Invalid password, try again");
	            request.getRequestDispatcher("/_view/login.jsp").forward(request, response);
	        }
        }
        else {
        	request.setAttribute("error", "Unknown user, please try again");
            request.getRequestDispatcher("/_view/login.jsp").forward(request, response);
        }*/
	}
}