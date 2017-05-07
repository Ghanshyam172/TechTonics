package actions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EventsDao;
import pojos.TechTalkPojo;

public class UpdateTechTalkServlet extends HttpServlet {

	
	
	        EventsDao dao;
	        public UpdateTechTalkServlet() throws ClassNotFoundException, SQLException {
	        super();
	        dao = new EventsDao();
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			System.out.println("in Update Servlet");
		
		String id1 =	request.getParameter("id");	
		String ti =	request.getParameter("title");
		String des =	request.getParameter("description");
		String pres =	request.getParameter("presenter");
		String ddt=request.getParameter("date");
		String tim =request.getParameter("time");
		
		int parsedId = Integer.parseInt(id1);
		
		
		TechTalkPojo updtPojo = new TechTalkPojo(parsedId,ti,des,pres,ddt,tim);
		
		
		 try {
			dao.modifiedData(updtPojo);
			
			System.out.println("changes saved successfully");

			RequestDispatcher rd=request.getRequestDispatcher("AllTalksServlet");
			rd.forward(request, response);
		 
		 
		 
		 } catch (SQLException e) {
			e.printStackTrace();
		}
			
		}

	

}
