package actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterLoginDao;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private dao.RegisterLoginDao rldao;
	
    public LoginServlet(RegisterLoginDao rldao) throws ClassNotFoundException, SQLException {
		super();
		rldao = new RegisterLoginDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 resp.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = resp.getWriter();
	        
	        String email = req.getParameter("email");
	        String pass = req.getParameter("password");
	        
	        // admin login credentials 
	        if(req.getParameter("email").equals("ghanshyam.sharma@atmecs.com")&&req.getParameter("password").equals("root"))
	        {
	        	 HttpSession session=req.getSession();  
	             session.setAttribute("email",email); 
	             RequestDispatcher rs =req.getRequestDispatcher("AllTalkServlet");
	            rs.forward(req, resp);
	        }
	        else
	        {
	        	
	        	
	        	try {
					rldao.login(email, pass);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	HttpSession session=req.getSession();  
	             session.setAttribute("email",email);  
	           RequestDispatcher rs = req.getRequestDispatcher("TechTalkServet");
	           rs.include(req, resp);
	        }			
	}
	
    
    public void init(ServletConfig config){
    	
    }
	
    public void destroy(){
    	
    	
    }
	
	
}
