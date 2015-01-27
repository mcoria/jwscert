package jwscert.rest.services;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ={"/MyServlet"})
public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) {
        System.out.println("My servlet has been initialized");
    }
	
    public void doGet(HttpServletRequest request, HttpServletResponse response){
    	System.out.println("Get called");
    }
    
}
