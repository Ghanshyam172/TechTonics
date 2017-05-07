package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	
    //for creating connection to MySQL database 
	static final String mysqlDriver="org.gjt.mm.mysql.Driver"; //MySQL driver 
	static final String mysqlUrl="jdbc:mysql://localhost/techtalk";  
	
	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		
		Class.forName(mysqlDriver);  // to create MySQL driver object
		
		//establish connection to given mysqlUrl
		Connection con= DriverManager.getConnection(mysqlUrl,"root","root"); 
		return con;
		
		}
	}
