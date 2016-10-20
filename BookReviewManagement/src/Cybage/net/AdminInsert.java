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
 * Servlet implementation class AdminInsert
 */
@WebServlet("/AdminInsert")
public class AdminInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		String booktitle=request.getParameter("booktitle");
		String description=request.getParameter("description");
		String authorname=request.getParameter("authorname");
	
	
		
		HttpSession session = request.getSession(false);

	    String name = (String) session.getAttribute("aname");
        pw.println("Hello"+name);
        System.out.println(name);
	
        if(name != null)
        {
			
			try {
				DbConnection cn=new DbConnection();
				Connection conn=			cn.getConnection();
				
		
			PreparedStatement pst1 = conn.prepareStatement("Insert into book values(?,?,?,?)");
			pst1.setInt(1, bookid);
			pst1.setString(2, booktitle);
			pst1.setString(3, description);
			pst1.setString(4,authorname);
			
			int row=pst1.executeUpdate();
			System.out.println(row);
			pw.println("<h2>Boook Added sucessfully..</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("admin.html");
			rd.include(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	
	
	
	
	
	}
	
	}

}


