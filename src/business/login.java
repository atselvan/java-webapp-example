package business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class login extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		response.setContentType("text/html");
		loginTO login=new loginTO();
		PrintWriter out= response.getWriter();
		login.setUsername(request.getParameter("username"));
		login.setPassword(request.getParameter("password"));
		
		out.println("<h1>"+login.getUsername()+" "+login.getPassword()+"</h1>");
		
		}

}
