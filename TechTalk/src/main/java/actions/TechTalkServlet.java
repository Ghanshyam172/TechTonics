package actions;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojos.TechTalkPojo;
import utils.ConnectionUtil;
import dao.RegisterLoginDao;

public class TechTalkServlet {

	private static final long serialVersionUID = 1L;
	private RegisterLoginDao rldao;
	Connection con;
	Statement stmt;
	
	public TechTalkServlet(RegisterLoginDao rldao, Connection con, Statement stmt) throws ClassNotFoundException, SQLException {
		super();
		rldao = new RegisterLoginDao();
		con = ConnectionUtil.getConnect();
		
	}  
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("AllTalksServlet in post");
		try {
			con=ConnectionUtil.getConnect();
			ArrayList al= null;
			 String sql = "select * from techtalkdetails";
			 stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(sql);
		        al = new ArrayList();

		        while (rs.next()) {

		        	TechTalkPojo event=new TechTalkPojo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		        
		            
		        	al.add(event);
		          }

		     
		        
		        request.setAttribute("techtalkList", al);
		        con.close();
		        request.getRequestDispatcher("TechTalkServlet.jsp").forward(request, response);
		        
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
