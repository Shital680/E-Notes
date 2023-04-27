package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
	
		if(DatabaseAllOperations.validate(email,password)) {
			//RequestDispatcher rd=request.getRequestDispatcher("ViewNoteServlet");
		 response.sendRedirect("ViewNoteServlet");
			//rd.forward(request,response);
			
		}else {
			p.print("<head>");
			p.print("<link rel='stylesheet' href='styles.css'>");
			p.print("</head>");
			p.print("<body class='container'>");
			p.print("<h1 class='alert'>Email or Password is incorrect.</h1>");
			p.print("</body>");
			request.getRequestDispatcher("login.html").include(request, response);
			
		}
		p.close();
	}

}
