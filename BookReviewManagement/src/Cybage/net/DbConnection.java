package Cybage.net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static final String URL="jdbc:mysql://localhost/my_db";
	public static final String NAME="root";
	public static final String PASSWORD="root";
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(URL, NAME,PASSWORD);
		return conn;
		
	}
	
}
