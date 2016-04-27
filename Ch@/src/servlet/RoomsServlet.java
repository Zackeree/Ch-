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
import servlet.LoginServlet;

public class RoomsServlet extends HttpServlet {
	
	FakeDatabase db = new FakeDatabase();
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
    	ArrayList<Message> messageList = db.retrieveMessages();
    	req.setAttribute("messages", messageList);
		req.getRequestDispatcher("/_view/rooms.jsp").forward(req, resp);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	String input = request.getParameter("text");
    	
    	ArrayList<Message> messageList = db.retrieveMessages();
    	Message message = new Message(input);
    	
    	db.addMessage(message.getValidatedMessage());
    	HttpSession session = request.getSession(true);
    	
    	Object user = session.getAttribute("user");
		User realUser = User.class.cast(user);
		
		request.setAttribute("username", realUser.getID());
    	request.setAttribute("messages", messageList);
    	request.getRequestDispatcher("/_view/rooms.jsp").forward(request, response);
    	
    }
    
    
}
