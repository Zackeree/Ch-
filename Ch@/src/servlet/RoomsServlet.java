package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.FakeDatabase;
import model.Message;
import model.User;
import servlet.LoginServlet;

public class RoomsServlet extends HttpServlet {
	
	FakeDatabase db = new FakeDatabase();
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/rooms.jsp").forward(req, resp);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	String input = request.getParameter("text");
    	
    	ArrayList<String> messageList = db.retrieveMessages();
    	
    	Message message = new Message(input);
    	
    	
    	db.addMessage(message.ValidateMessage());
    	
    	request.setAttribute("messages", messageList);
    	request.getRequestDispatcher("/_view/rooms.jsp").forward(request, response);
    	
    }
    
    
}
