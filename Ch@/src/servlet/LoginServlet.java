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
	String id;
	
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
        
        id = username;
        
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
        }
	}
}

/* Have to merge this with above
package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.LoginController;
import model.Library;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Library model;
	private LoginController controller;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nLoginServlet: doGet");

		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nLoginServlet: doPost");

		String errorMessage = null;
		String name         = null;
		String pw           = null;
		boolean validLogin  = false;

		// Decode form parameters and dispatch to controller
		name = req.getParameter("username");
		pw   = req.getParameter("password");

		System.out.println("   Name: <" + name + "> PW: <" + pw + ">");			

		if (name == null || pw == null || name.equals("") || pw.equals("")) {
			errorMessage = "Please specify both user name and password";
		} else {
			model      = new Library();
			controller = new LoginController(model);
			validLogin = controller.validateCredentials(name, pw);

			if (!validLogin) {
				errorMessage = "Username and/or password invalid";
			}
		}

		// Add parameters as request attributes
		req.setAttribute("username", req.getParameter("username"));
		req.setAttribute("password", req.getParameter("password"));

		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("login",        validLogin);

		// if login is valid, start a session
		if (validLogin) {
			System.out.println("   Valid login - starting session, redirecting to /index");

			// store user object in session
			req.getSession().setAttribute("user", name);

			// redirect to /index page
			resp.sendRedirect(req.getContextPath() + "/index");

			return;
		}

		System.out.println("   Invalid login - returning to /Login");

		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
}

*/