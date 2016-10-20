package Cybage.net;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterDispatcher
 */
@WebFilter("/FilterDispatcher")
public class FilterDispatcher implements Filter {
	private FilterConfig filterConfig = null;

	/**
	 * Default constructor. 
	 */
	public FilterDispatcher() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;

		String uri=req.getRequestURI();

		HttpSession session=req.getSession();


		if(uri.equals("/Cybage.net/admin.html")|| uri.equals("/Cybage.net/user.html"))
		{
			Validator obj=(Validator) session.getAttribute("id"); 
			//Login ob=(Login) session.getAttribute("login");
			if(obj==null)
			{
				res.sendRedirect("error.jsp");
				return;
			}
		}
		System.out.println("preprocessing");
		chain.doFilter(request, response);
		System.out.println("post-processing");
	}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
