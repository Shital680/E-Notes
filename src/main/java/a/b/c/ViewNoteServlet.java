package a.b.c;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewNoteServlet")
public class ViewNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter p=response.getWriter();
		
		
		
		try {
			HttpSession session = request.getSession();
			String receivedData = (String) session.getAttribute("userEmail");
			
			List<UserDetails> li=DatabaseAllOperations.getNotesByUsername(receivedData);
			
			p.print("<head>");
			p.print("<link rel='stylesheet' href='styles.css'>");
			p.print("</head>");
			p.print("<body class='all'>");
			p.print("<div class='main1'>");
			p.print("<div  id='sidebar' class='topnav'>");
			p.print("<a id='home' href='ViewNoteServlet'>Home</a>");
			p.print("<a id='add' href='add.html'>Add</a>");
			p.print("</div>");
			p.print("<div  id='sidebar2' class='topnav'>");
			p.print("<a  id='logout' href='LogoutServlet'>Logout</a>" );
			p.print("</div>");
			p.print("</div>");
			p.print("</body>");
			for(UserDetails u:li) {
				p.print("<div class='view1'>");
				p.print("<input class='view2' type='text' name='title' value='"+u.getTitle()+"'  >");
				p.println("<br><textarea class='view1' name='note' rows='10' cols='50'  >");
				p.print(u.getNote());
				p.print("</textarea><br>");
				p.print("<a class='but' href='EditNoteServlet?id="+u.getId()+"'><input class='a1' type='submit' value='Edit'></a><br>");
				p.print("<a class='but' href='DeleteNoteServlet?id="+u.getId()+"'><input class='a2' type='Submit' value='Delete'></a></a>");
				p.print("</div>");
				}
			}catch(Exception e){
			e.printStackTrace();
		}
	}

}
