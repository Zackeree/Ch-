package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.RoomsController;
import database.FakeDatabase;
import database.IDatabase;
import model.Message;
import model.User;
import persist.DerbyDatabase;
import servlet.LoginServlet;

public class RoomsServlet extends HttpServlet {
	
	DerbyDatabase db = new DerbyDatabase();
	RoomsController controller = new RoomsController();
	
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
			//ArrayList<Message> messageList = db.retrieveMessages();
			req.setAttribute("messages", controller.getMessages());
			req.getRequestDispatcher("/_view/rooms.jsp").forward(req, resp);
		}
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	String input = request.getParameter("text");
    	
    	if (input != "") {
	    	Message message = new Message(input);
	    	
	    	controller.addMessage(message);
	    	HttpSession session = request.getSession(true);
	    	
	    	Object objUser = session.getAttribute("user");
			User user = User.class.cast(objUser);
				
			request.setAttribute("username", user.getID());
		    request.setAttribute("messages", controller.getMessages());
		    request.getRequestDispatcher("/_view/rooms.jsp").forward(request, response);
    	}
    	else {
    		request.getRequestDispatcher("/_view/rooms.jsp").forward(request, response);
    	}
    }
}
