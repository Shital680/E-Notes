package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditNoteServlet")
public class EditNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		p.println("<h1 class='viewall'>Update Note</h1>");
//		String eid=request.getParameter("id");
//		int id=Integer.parseInt(eid);
//		
//		UserDetails u=DatabaseAllOperations.getUserById(id);
		try {
			List<UserDetails> li=DatabaseAllOperations.getAllNotes();
			p.print("<head>");
			p.print("<link rel='stylesheet' href='styles.css'>");
			p.print("</style>");
			p.print("</head>");
			p.print("<body class='all'>");
			p.print("<div class='main1'>");
			p.print("<div  id='sidebar' class='topnav'>");
			p.print("<a id='home' href='ViewNoteServlet'>Home</a>");
			p.print("<a id='add' href='add.html'>Add</a>");
			p.print("</div>");
			p.print("<div  id='sidebar2' >");
			p.print("<a  id='logout' href='LogoutServlet'>Logout</a>" );
			p.print("</div>");
			p.print("</div>");
			
			String eid=request.getParameter("id");
			int id=Integer.parseInt(eid);
			
			UserDetails u=DatabaseAllOperations.getUserById(id);
			p.print("<form action='EditNoteServlet2' method='post'>");
			p.print("<input type='hidden' name='id' value='"+u.getId()+"'>");
			p.print("<input class='title11' type='text' name='title' value='"+u.getTitle()+"'  >");
			p.println("<br><textarea class='note12' name='note' rows='10' cols='50'  >");
			p.print(u.getNote());
			p.print("</textarea><br>");
			p.print("<input class='editinput' type='submit' value='Edit & Save'");
			p.print("</form>");
			p.print("</body>");
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	

}
