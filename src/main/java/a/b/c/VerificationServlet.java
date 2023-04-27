package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/VerificationServlet")
public class VerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		String email=request.getParameter("email");
		
		if(DatabaseAllOperations.Verification(email)) {
			p.print("<head>");
			p.print("<link rel='stylesheet' href='styles.css'>");
			p.print("</head>");
			p.print("<body class='container'>");
			p.print("<h1 class='alert'>User already Exists</h1>");
			p.print("</body>");
			request.getRequestDispatcher("login.html").include(request, response);
			//response.sendRedirect("SaveServlet");

		}else {
			request.getRequestDispatcher("SaveServlet").include(request, response);
		}
	}

}
