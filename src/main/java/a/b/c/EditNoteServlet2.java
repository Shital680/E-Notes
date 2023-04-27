 package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditNoteServlet2")
public class EditNoteServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		String eid=request.getParameter("id");
		int id=Integer.parseInt(eid);
		
		String title=request.getParameter("title");
		String note=request.getParameter("note");
		
		UserDetails u=new UserDetails();
		u.setId(id);
		u.setTitle(title);
		u.setNote(note);
		
		int status=DatabaseAllOperations.update(u);
		
		if(status > 0) {
			response.sendRedirect("ViewNoteServlet");
		}
		else {
			p.print("Unable to update");
		}
		p.close();
	}

}
