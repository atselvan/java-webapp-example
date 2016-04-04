package business;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicesDb.loginDb;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Here");
		response.setContentType("text/html");
		loginTO login=new loginTO();
		PrintWriter out= response.getWriter();
		login.setUsername(request.getParameter("username"));
		login.setPassword(request.getParameter("password"));
		
		out.println("<h1>"+login.getUsername()+" "+login.getPassword()+"</h1>");
		
		System.out.println("Here once again!");
		loginDb db = new loginDb();
		db.insertLoginDetails(login.getUsername(),login.getPassword());
	}

}
