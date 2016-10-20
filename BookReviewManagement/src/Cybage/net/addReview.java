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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addReview
 */
@WebServlet("/addReview")
public class addReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
String review=request.getParameter("review");

HttpSession session=request.getSession();
Integer id=		(Integer) session.getAttribute("bookid");


try {
	DbConnection cn=new DbConnection();
Connection conn=			cn.getConnection();
		String sql="Insert into book_review (book_review,book_id) values(?,?)";
		System.out.println(sql);
		PreparedStatement stmnt=conn.prepareStatement(sql);
		

stmnt.setString(1, review);
		stmnt.setInt(2, id);
	//	stmnt.setString(1, );
		
		
		System.out.println(stmnt.executeUpdate());
		
		PrintWriter pw=response.getWriter();
		
		pw.println("Data Inserted");
		
		response.sendRedirect("search1.jsp");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
