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

public class LoginServlet extends HttpServlet {
	
	FakeDatabase db = new FakeDatabase();
	
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("id");
        String password = request.getParameter("pass");
        
        if (db.retrieveUser(username) != null) {
	        User user = db.retrieveUser(username);
	        if (db.validate(user.getID(), password)){
	        	request.getSession().setAttribute("user", user);
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
	}
}