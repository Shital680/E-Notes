package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserDetails uo=new UserDetails();
		
		uo.setName(name);
		uo.setEmail(email);
		uo.setPassword(password);
		
		try {
			int status=DatabaseAllOperations.save(uo);
			if(status>0) {
				request.getRequestDispatcher("login.html").include(request,response);
				p.println("Data saved");
			}
			else {
				p.println("Something Went Wrong");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
