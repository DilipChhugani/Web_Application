package Cybage.net;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet 
{
	int Counter = 0;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public logout() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*HttpSession session=request.getSession();
		session.removeAttribute("uname");


		session.invalidate();*/
		System.out.println();

		HttpSession session = request.getSession();

		
		if(!(session.isNew()))
		{
			Counter++;
			System.out.println(Counter);
			System.out.println(session);
			session.invalidate();
			Counter -- ;
			System.out.println(Counter);
			System.out.println("Invalidating Session");
			response.sendRedirect("index.html");
		}

	}



}
