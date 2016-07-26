package jwscert.jaxws.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import net.webservicex.GlobalWeather;

@WebServlet(name="GlobalWeatherServlet", urlPatterns={"/GlobalWeatherServlet"})
public class GlobalWeatherServletClient extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@WebServiceRef(wsdlLocation = "http://www.webservicex.net/globalweather.asmx?wsdl") // !!! Funciona
	//@WebServiceRef(wsdlLocation = "WEB-INF/wsdl/globalweather.wsdl") // !!! Funciona
	@WebServiceRef
    private GlobalWeather service;
   
    /** 
     * Processes requests for both HTTP <code>GET</code> 
     *   and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + 
                request.getContextPath () + "</h1>");
            out.println("<p>" + sayHello("Argentina") + "</p>");
            out.println("</body>");
            out.println("</html>");
            
        } finally { 
            out.close();
        }
    } 
    
    // doGet and doPost methods, which call processRequest, and
    //   getServletInfo method
    
    private String sayHello(String arg0) {
        return service.getGlobalWeatherSoap().getCitiesByCountry(arg0);
    }
    
    
    @Override
    protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	processRequest(arg0, arg1);
    }
    
}