package servlet;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.RegisterController;
import database.FakeDatabase;
import database.IDatabase;
import model.User;
import persist.DerbyDatabase;

public class RegisterServlet extends HttpServlet {
	
	DerbyDatabase db = new DerbyDatabase();
	ArrayList<User> result = new ArrayList();
	RegisterController controller = new RegisterController();
	private User model;
	
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
        
        model = new User(username, password, email);
        HttpSession session = request.getSession(true);
        
        String errorMessage = controller.getError(username, password, password2, email);
        
        if(!controller.validateCredentials(username, password, password2, email)) {
        	request.setAttribute("error", errorMessage);
			request.getRequestDispatcher("/_view/register.jsp").forward(request, response);
        }
        else {
        	controller.registerUser(username, password, email);
        	session.setAttribute("user", model);
        	session.setAttribute("status", "You Have Sucessfully Registered!");
        	response.sendRedirect("index");
        }
	}
}