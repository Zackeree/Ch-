package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.FakeDatabase;
import database.IDatabase;
import model.Message;
import model.User;
import persist.DerbyDatabase;
import servlet.LoginServlet;

public class RoomsServlet extends HttpServlet {
	
	//FakeDatabase db = new FakeDatabase();
	DerbyDatabase db = new DerbyDatabase();
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
    	
    	
    	HttpSession session = req.getSession(true);
    	Object objUser = session.getAttribute("user");
    	if (objUser == null) {
			req.setAttribute("error", "You must be logged in first!");
        	req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}
		
		else {
			ArrayList<Message> messageList = db.retrieveMessages();
			req.setAttribute("messages", messageList);
			req.getRequestDispatcher("/_view/rooms.jsp").forward(req, resp);
		}
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	String input = request.getParameter("text");
    	
    	ArrayList<Message> messageList = db.retrieveMessages();
    	Message message = new Message(input);
    	
    	db.insertMessage(message.getValidatedMessage());
    	HttpSession session = request.getSession(true);
    	
    	Object objUser = session.getAttribute("user");
		User user = User.class.cast(objUser);
			
		request.setAttribute("username", user.getID());
	    request.setAttribute("messages", messageList);
	    request.getRequestDispatcher("/_view/rooms.jsp").forward(request, response);
	    
    }
}
