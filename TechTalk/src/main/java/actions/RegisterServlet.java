package actions;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterLoginDao;
import pojos.EmployeeInfoPojo;

public class RegisterServlet {
	
	private static final long serialVersionUID = 1L;

	private RegisterLoginDao rldao;

	public RegisterServlet(RegisterLoginDao rldao) throws ClassNotFoundException, SQLException {
		super();
		rldao = new RegisterLoginDao() ;
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		    response.sendRedirect("signup.jsp");
	}
	
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw=response.getWriter();
		
//		pw.print("in post method");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		
		EmployeeInfoPojo emp=new EmployeeInfoPojo(name, email, pass);
		RequestDispatcher rd;
		try {
			if(emp==null)
			{
				rd=request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
			else {
				if(email.endsWith("@atmecs.com"))
				{
				rldao.register(emp);
				rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				}
				else
				{
					System.out.println("register else part");
				
					request.setAttribute("msg","Use @atmecs.com");
					rd=request.getRequestDispatcher("RegisterServlet");
					this.doGet(request, response);
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
