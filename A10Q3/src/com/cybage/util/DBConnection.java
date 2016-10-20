/**
 * 
 */
package com.cybage.util;

/**
 * @author siddharthdu
 * utility class for database connection
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{	
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/first","root","root");
		
	}
	
}

