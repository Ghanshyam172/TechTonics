package dao;

import static utils.ConnectionUtil.getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import pojos.TechTalkPojo;
public class EventsDao {

	private Connection con;
	private Statement stmt;
	private PreparedStatement prepdStmt1,prepdStmt2;
	
	public EventsDao() throws ClassNotFoundException, SQLException{
		
		con=getConnect();
		this.prepdStmt1=con.prepareStatement("insert into techtalkdetails values(?,?,?,?,?,?)");
		this.prepdStmt1 = con.prepareStatement("delete from techtalkdetails where id=?");
		this.stmt = con.createStatement();
	}	
		public void cleanUp() throws SQLException {
			if (prepdStmt1 != null)
				prepdStmt1.close();

			if (con != null)
				con.close();
		
	}
	
		public String registerTechTalk(TechTalkPojo event) throws Exception {
			String flag = "registration failed";
			
			// set parameters 
			prepdStmt1.setInt(1, 0);
			prepdStmt1.setString(2, event.getDate());
			prepdStmt1.setString(3, event.getTime());
			prepdStmt1.setString(4, event.getPresenter());
			prepdStmt1.setString(5, event.getDescription());
			prepdStmt1.setString(6, event.getTitle());

			// execute
			int updateCount = prepdStmt1.executeUpdate();
			if (updateCount == 1)
				flag = "You have registered Successfully!";
			return flag;

		}
	
		
		//delete techtalk 
		public int deleteTechTalk(int id) throws SQLException {
			this.prepdStmt2.setInt(1, id);

			return this.prepdStmt2.executeUpdate();
		}
		
		public int modifiedData(TechTalkPojo ttp) throws SQLException {
			String sqlupdate = "UPDATE techtalkdetails SET date ='" + ttp.getDate()
					+ "',time ='" + ttp.getTime() + "',presenter = '"
					+ ttp.getPresenter() + "',description = '" + ttp.getDescription()
					+ "',title='" + ttp.getTitle() + "' WHERE id = "
					+ ttp.getId();
			// techtalkdetails is database table name
			stmt.executeUpdate(sqlupdate);

			return 0;
		}
}
