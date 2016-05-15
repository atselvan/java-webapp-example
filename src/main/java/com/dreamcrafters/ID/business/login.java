package main.java.com.dreamcrafters.ID.business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.dreamcrafters.ID.services.userService;

/**
 * Servlet implementation class login
 */
@SuppressWarnings("serial")
@WebServlet("/login")
public class login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Login doPost");
		response.setContentType("text/html");
		userTO user = new userTO();
		user.setemailId(request.getParameter("emailId"));
		user.setPassword(request.getParameter("password"));
		
		userService service= new userService();
		String name=service.findUser(user.getemailId());
		
		if(name!=null){
			PrintWriter out = response.getWriter();
			out.println("<html><body><H1>Hi "+name+"!</html></body></H1>");
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<html><body><H1>Login Failed!</html></body></H1>");
		}
	}

}
