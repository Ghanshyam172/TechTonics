package actions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventsDao;

public class DeleteTalkServet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public DeleteTalkServet() {
        super();
        // TODO Auto-generated constructor stub
    }	
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("inside delete");
		response.setContentType("text/html");
		int id =Integer.parseInt(request.getParameter("id"));
		try {
			EventsDao rldao= new EventsDao();
			rldao.deleteTechTalk(id);
			response.sendRedirect("AllTalksServlet");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
