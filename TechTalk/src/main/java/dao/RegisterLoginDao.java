package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import static utils.ConnectionUtil.getConnect;
import pojos.EmployeeInfoPojo;

public class RegisterLoginDao {

	private Connection con;
	private PreparedStatement preparedStmt1,preparedStmt2;
	
	
	public RegisterLoginDao() throws ClassNotFoundException, SQLException {
		con=getConnect();
		preparedStmt1 = con.prepareStatement("INSERT INTO register VALUES(?,?,?)");
		preparedStmt2 = con.prepareStatement("SELECT * FROM register WHERE email=? AND password=?");
		
	}
	
	
	public boolean login(String email, String passwd) throws Exception {
		boolean status = false;

		preparedStmt2.setString(1, email);
		preparedStmt2.setString(2, passwd);
		ResultSet rs = preparedStmt2.executeQuery();

		status = rs.next();

		return status;

	}
	
	public String register(EmployeeInfoPojo emp) throws Exception {
		String status = "registration failed";
		
		preparedStmt1.setString(1, emp.getName());
		preparedStmt1.setString(2, emp.getEmail());
		preparedStmt1.setString(3, emp.getPassword());
		
		
		int updateCount = preparedStmt1.executeUpdate();
		if (updateCount == 1)
			status = "registration successful";
		return status;

	}
	
	
	
	
	
	public void closeConnection() throws SQLException{
		if(preparedStmt1!=null){
			preparedStmt1.close();
		}
		if(preparedStmt2!=null){
			preparedStmt2.close();
		}
		
		if(con!=null){
			con.close();
		}
		
	}
	
	
}
