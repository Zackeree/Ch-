package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FakeDatabase;
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
        
        if(username == null)
        	username = "";
        if(password == null)
        	password = "";
        
        User[] users = new User[3];
        users[0] = new User("test", "test", "test");
        users[1] = new User("blonge", "pass", "email");
        users[2] = new User("zhenry", "pass", "email");
        
        boolean validate = false;
        int userID = 0;
        
        for(int i = 0; i < users.length; i++)
        {
        	if(username.equals(users[i].getID()) && password.equals(users[i].getPassword()))
        		validate = true; userID = i;
        }
        
        if (validate) {
            request.getSession().setAttribute("user", users[userID]);
            response.sendRedirect("register");
        }
        else {
            request.setAttribute("error", "Terrible username, please be creative!");
            request.getRequestDispatcher("/_view/register.jsp").forward(request, response);
        }
    }
}