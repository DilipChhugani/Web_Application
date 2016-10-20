package Cybage.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class usersearch
 */
@WebServlet("/usersearch")
public class usersearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usersearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int book_id=0;
		String booktitle=request.getParameter("title");

			try {
				DbConnection cn=new DbConnection();
				Connection conn=			cn.getConnection();
				//PreparedStatement pst1 = conn.prepareStatement("select a.book_id,a.book_title,a.description,a.author_name,b.book_review from a.book,b.book_rewiew where book.book_id =book_review.book_id");
			PreparedStatement pst1 = conn.prepareStatement("select * from book where book_title=?");
			pst1.setString(1, booktitle);
			
		    ResultSet rs = pst1.executeQuery();
		    ArrayList pid_list = new ArrayList();
	            while (rs.next()) {
	            	   ArrayList al = new ArrayList();
book_id=rs.getInt(1);
	                   al.add(rs.getInt(1));
	                   al.add(rs.getString(2));
	                   al.add(rs.getString(3));
	                   al.add(rs.getString(4));
	                   
	                   System.out.println("al :: " + al);
	                   pid_list.add(al);

	            }
	            request.setAttribute("piList", pid_list);
	            HttpSession session=request.getSession();
	       session.setAttribute("bookid",book_id);
	            
	            PreparedStatement pst2=conn.prepareStatement("Select book_review from book_review where book_id=?");
	          System.out.println(book_id);
	            pst2.setInt(1, book_id);
	            
	            
	            ResultSet rs1 = pst2.executeQuery();
			    ArrayList review_list = new ArrayList();
		            while (rs1.next()) {
		            	   ArrayList a2 = new ArrayList();

		            	  
		            	   
		                  a2.add(rs1.getString(1));
		                   
		                   
		                   System.out.println("a2 :: " + a2);
		                   review_list.add(a2);

		            }
		            
		            request.setAttribute("review_list", review_list);
	            RequestDispatcher View = request.getRequestDispatcher("view1.jsp");
	            View.forward(request, response);
	            conn.close();
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
	
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
