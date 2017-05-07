package actions;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.EmployeeInfoPojo;
import pojos.TechTalkPojo;
import dao.EventsDao;


public class AddTalkServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
	private EventsDao edao;

	public AddTalkServlet(EventsDao edao) throws ClassNotFoundException, SQLException {
		super();
		edao = new EventsDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("do get");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("do post");
		
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String presenter=request.getParameter("presenter");
		String description=request.getParameter("Description");
		String title=request.getParameter("title");
		
		TechTalkPojo event =new TechTalkPojo(title, description,presenter, date, time);
		RequestDispatcher rd;
		
				try {
					edao.registerTechTalk(event);
					System.out.println("Techtalk added ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rd=request.getRequestDispatcher("AllTalksServlet");
				rd.forward(request, response);
			
			
			
			
		
		
	}
}
