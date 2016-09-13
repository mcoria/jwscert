package jwscert.jaxws.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import com.cdyne.weather.types.GetCityWeatherByZIP;
import com.cdyne.weather.types.GetCityWeatherByZIPResponse;
import com.cdyne.weather.ws.WeatherSEI;
import com.cdyne.weather.ws.WeatherService;

/**
 * 
 * @author mauricioca
 * 
 * Observar que como la referencia es al SEI no necesitamos especificar en @WebServiceRef(value =  WeatherService.class)
 * dado que lo infiere del tipo
 *
 */
/*
 * Hacemos referencia al SEI por lo tanto necesitamos saber cual es el Service que crea el proxy a este puerto
 */
//@WebServiceRef(name="weatherPort",type=WeatherSEI.class,value=WeatherService.class, wsdlLocation = "http://wsf.cdyne.com/WeatherWS/Weather.asmx?wsdl")
@WebServiceRef(name="weatherService",type=WeatherService.class, wsdlLocation = "http://wsf.cdyne.com/WeatherWS/Weather.asmx?wsdl")
@WebServlet(name = "WeatherServlet3", urlPatterns = { "/WeatherServlet3" })
public class WeatherServlet3 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	private Utils utils = new Utils();
	
	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {

			out.println("<html lang=\"en\">");
			out.println("<head>");
			out.println("<title>Servlet GlobalWeatherServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet GlobalWeatherServlet at " + request.getContextPath() + "</h1>");

			if (request.getParameter("zip") != null) {
				out.println("<p>");
				utils.jaxbObjectToXML(getCityWeatherByZIP(request.getParameter("zip")), out);
				out.println("</p>");
			} else {
				out.println("<p> Please provide ZIP</p>");
			}

			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	// doGet and doPost methods, which call processRequest, and
	// getServletInfo method


	private GetCityWeatherByZIPResponse getCityWeatherByZIP(String zip) {
		GetCityWeatherByZIP request = new GetCityWeatherByZIP();
		request.setZIP(zip);
		return getPort().getCityWeatherByZIP(request);
	}
	
	private WeatherSEI getPort(){
		//return (WeatherSEI) lookup("java:comp/env/weatherPort");
		WeatherService service = (WeatherService) lookup("java:comp/env/weatherService");
		return service.getWeatherSEI();
	}
    

	private Object lookup(String objectName) {
		try {
			InitialContext jndi = new InitialContext();
			return jndi.lookup(objectName);
		} catch (NamingException ex) {
			throw new RuntimeException(ex);
		}
	}	
    
	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(arg0, arg1);
	}

}