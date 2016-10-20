package Cybage.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
			
		String name=	request.getParameter("name");
		String password=request.getParameter("password");
		String confirmPass=request.getParameter("confirm");
		
		if(!password.equals(confirmPass)){
	PrintWriter out=		response.getWriter();
	System.out.println("Sorry");
	out.println("Your Password is not matching !! try Again");
		}
		else{
			
			GenerateHashPassword gh=new GenerateHashPassword();
		String encrypPassword=	gh.encryptPass(password);
			
			try {
				DbConnection cn=new DbConnection();
				Connection conn=			cn.getConnection();
			PreparedStatement pst1 = conn.prepareStatement("Insert into login(CustomerName,Password,Role) values(?,?,?)");
			pst1.setString(1, name);
			pst1.setString(2, encrypPassword);
			pst1.setString(3, "customer");
			int row=pst1.executeUpdate();
			System.out.println(row);
		
			response.sendRedirect("login.html");
			
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	}

}
