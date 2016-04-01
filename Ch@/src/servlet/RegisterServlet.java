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

public class RegisterServlet extends HttpServlet {
	
	FakeDatabase db = new FakeDatabase();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/register.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("id");
        String password = request.getParameter("pass");
        String password2 = request.getParameter("pass2");
        String email = request.getParameter("email");
 
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("password2: " + password2);
        System.out.println("email: " + email);
        if (username.isEmpty() == false && password.isEmpty() == false && email.isEmpty() == false) {
        	if (db.retrieveUser(username) == null) {
        		if (password.equals(password2)) {
        			
        			db.createUser(username, password, email); 
        			response.sendRedirect("index");
        		
        		}
        		else {
        			request.setAttribute("error", "Passwords do not match!");
        			request.getRequestDispatcher("/_view/register.jsp").forward(request, response);
        		}
        	}
        	else {
        		request.setAttribute("error", "Username already taken!");
        		request.getRequestDispatcher("/_view/register.jsp").forward(request, response);
        	}
        }
        else {
        	request.setAttribute("error", "One or more fields is empty!");
    		request.getRequestDispatcher("/_view/register.jsp").forward(request, response);
        }
	}
}