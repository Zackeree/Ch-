package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import servlet.LoginServlet;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//this is horrible practice but I just want it working
	LoginServlet ls = new LoginServlet();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("In the Index servlet");
		
		//User user = ls.getUser();
		
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		
	}
}
