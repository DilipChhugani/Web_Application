package Cybage.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Validator
 */
@WebServlet("/Validator")
public class Validator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validator() {
       System.out.println("In constr");
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession hs = request.getSession();
		hs.setAttribute("uname", request.getAttribute("CustomerId"));
		
		System.out.println("HIIIIIIIIIIIIIIII");
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String id=request.getParameter("CustomerId");
		String password=request.getParameter("password");

		System.out.println(id+"    "+password);
		
		String dBpassword = "";
		String dBrole = "";
		try {
			DbConnection cn=new DbConnection();
Connection conn=			cn.getConnection();
			PreparedStatement pst1 = conn.prepareStatement("Select * from login where CustomerName=(?)");
			pst1.setString(1, id); 
			
			ResultSet rst=pst1.executeQuery();
			
			System.out.println(rst != null);
			while(rst.next())
			{
				dBpassword=rst.getString(3);
				System.out.println("in rst "+dBpassword);
				dBrole=rst.getString(4);
				System.out.println("in rst "+dBrole);
				//System.out.println(dBpassword.equals(password));
			}

			
			if(dBrole.equals("admin"))
			{
				System.out.println("In If admin");
				
			if(dBpassword.equals(null))
			{
				System.out.println("In If");
				pw.println("Either Wrong Employee id /You are Not registered....");
				RequestDispatcher rd1=request.getRequestDispatcher("index.html");
				rd1.include(request, response);
			}
			else if(!dBpassword.equals(password))
			{
				System.out.println("In else If");
				pw.println("WRONG PASSWORD Retry...");
				RequestDispatcher rd1=request.getRequestDispatcher("index.html");
				rd1.include(request, response);
			}
			else{
				HttpSession anameSession=request.getSession();
				anameSession.setAttribute("aname", id);
				RequestDispatcher rd=request.getRequestDispatcher("AddBookRemoveBook.jsp");
				rd.forward(request, response);
				
					
				}
			}
				if(dBrole.equals("customer"))
					
					
				{
					
					GenerateHashPassword gh=new GenerateHashPassword();
					String encrypPassword=	gh.encryptPass(password);
					System.out.println("In elseIf cust");
					
					
					if(dBpassword.equals(null))
					{
						System.out.println("In If");
						pw.println("Either Wrong Employee id /You are Not registered....");
						RequestDispatcher rd1=request.getRequestDispatcher("index.html");
						rd1.include(request, response);
					}
					
					
					else if(!dBpassword.equals(encrypPassword))
					{
						System.out.println("In else If");
						pw.println("WRONG PASSWORD Retry...");
						RequestDispatcher rd1=request.getRequestDispatcher("index.html");
						rd1.include(request, response);
					}
					else{
						System.out.println("In else");
						HttpSession anameSession=request.getSession();
						anameSession.setAttribute("uname", id);
						response.sendRedirect("search1.jsp");
							
						}
					
					
				
				}
			



		} 
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		


	}

	}



