package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import servlet.LoginServlet;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//this is horrible practice but I just want it working
	LoginServlet ls = new LoginServlet();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		System.out.println("In the Index servlet");
		
		Object objUser = session.getAttribute("user");
		
		if (objUser == null) {
			req.setAttribute("error", "You must be logged in first!");
        	req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
		
		else {
		
			User user = User.class.cast(objUser);
			
			Object objStatus = session.getAttribute("status");
			String status = String.class.cast(objStatus);
			
			req.setAttribute("username", user.getID());
			req.setAttribute("status", status);
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		session.invalidate();
		response.sendRedirect("/home/");
	}
}

/*

package edu.ycp.cs320.lab03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nIndexServlet: doGet");

		String user = (String) req.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		// now we have the user's User object,
		// proceed to handle request...
		System.out.println("   User: <" + user + "> logged in");

		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("\nIndexServlet: doPost");		
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
	}	
}

*/