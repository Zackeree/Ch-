package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FakeDatabase;

public class LoginServlet extends HttpServlet {
	
	FakeDatabase db = new FakeDatabase();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");
        
        if(FakeDatabase.validate(db, id, pass))
        {
            RequestDispatcher rs = req.getRequestDispatcher("Welcome");
            rs.forward(req, resp);
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = req.getRequestDispatcher("index.html");
           rs.include(req, resp);
        }
        
        // Set attributes so login.jsp can fetch them
        req.setAttribute("id", req.getParameter("id"));
        req.setAttribute("pass", req.getParameter("pass"));
    } 
}