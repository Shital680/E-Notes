package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		HttpSession htp=request.getSession();
		htp.invalidate();
		p.print("<head>");
		p.print("<link rel='stylesheet' href='styles.css'>");
		p.print("</head>");
		p.print("<body class='container'>");
		p.print("<h1 class='alert'>You are logged out login again!</h1>");
		p.print("</body>");
		request.getRequestDispatcher("login.html").include(request, response);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
//        dispatcher.include(request, response);
		
	}

}
