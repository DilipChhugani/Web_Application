/**
 * 
 */

package com.cybage.tester;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.cybage.util.DBConnection;

/**
 * @author siddharthdu
 * class to display column names of a table along with data in the table
 */

public class Tester {
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Connection conn = DBConnection.getConnection();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select * from employee");
			ResultSetMetaData rsmd = rset.getMetaData();
			while(rset.next())
			{
				System.out.println(rsmd.getColumnName(1) + "  " + rset.getInt(1));
				System.out.println(rsmd.getColumnName(2) + "  " + rset.getString(2));
				System.out.println(rsmd.getColumnName(3) + "  " + rset.getDouble(3));
				System.out.println();
			}
			rset.close();
			stmt.close();
			conn.close();  // connection closed
		}
		catch(SQLException e) {
			System.out.println(e);
		}

	}
}