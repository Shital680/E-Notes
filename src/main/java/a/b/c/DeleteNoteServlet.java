package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteNoteServlet")
public class DeleteNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eid=request.getParameter("id");
		int id=Integer.parseInt(eid);
		DatabaseAllOperations.delete(id);
		response.sendRedirect("ViewNoteServlet");
//		try {
//		List<UserDetails> li=DatabaseAllOperations.getAllNotes();
//		p.print("<head>");
//		p.print("<link rel='stylesheet' href='styles.css'>");
//		p.print("</style>");
//		p.print("</head>");
//		p.print("<body class='all'>");
//		p.print("<div class='main1'>");
//		p.print("<div  id='sidebar' class='topnav'>");
//		p.print("<a id='home' href='ViewNoteServlet'>Home</a>");
//		p.print("<a id='add' href='add.html'>Add</a>");
//		p.print("<a id='edit' href='EditNoteServlet'>Edit</a>");
//		p.print("<a id='delete' href='delete.html'>Delete</a>");
//		p.print("<div>");
//		p.print("<div>");
//		p.print("form action='EditNoteServlet2' method='post'>");
//		p.print("input type='hidden' name='id' value='"+u.getId()+"'");
//		p.print("<input class='title1' type='text' name='title' value='"+u.getTitle()+"'  >");
//		p.println("<br><textarea class='note1' name='note' rows='10' cols='50'  >");
//		p.print(u.getNote());
//		p.print("</textarea><br>");
//		p.print("<input type='Submit' value='Delete'");
//		p.print("</form>");
//		p.print("<body>");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	   
	}

}
