package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import servlet.LoginServlet;

public class ChangeServlet extends HttpServlet {
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

			req.setAttribute("username", user.getID());
			req.setAttribute("status", "Change your password:");
			req.getRequestDispatcher("/_view/change.jsp").forward(req, resp);

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