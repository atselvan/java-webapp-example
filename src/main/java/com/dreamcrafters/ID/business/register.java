package main.java.com.dreamcrafters.ID.business;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.com.dreamcrafters.ID.services.*;

@SuppressWarnings("serial")
@WebServlet("/register")
public class register extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		System.out.println("In Register doPost");
		response.setContentType("text/html");
		userTO user = new userTO();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setemailId(request.getParameter("emailId"));
		user.setPassword(request.getParameter("password"));
		
		userService userService = new userService();
		userService.userPersist(user.getFirstName(), user.getLastName(), user.getemailId(), user.getPassword());
	}
}
