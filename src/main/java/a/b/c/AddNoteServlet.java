package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddNoteServlet")
public class AddNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();

		HttpSession session = request.getSession();
		String receivedData = (String) session.getAttribute("userEmail");
		
		String email=receivedData;
		String Title=request.getParameter("title");
		String Note=request.getParameter("note");
		
		UserDetails u=new UserDetails();
		u.setEmail(email);
		u.setTitle(Title);
		u.setNote(Note);
		
		try {
			int status=DatabaseAllOperations.add(u);
			
			if(status > 0) {
				response.sendRedirect("ViewNoteServlet");
			}
			else {
				p.println("<p>Unable to save</p>");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
