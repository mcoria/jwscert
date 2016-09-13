package jwscert.jaxws.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;

import com.cdyne.weather.types.GetCityWeatherByZIP;
import com.cdyne.weather.types.GetCityWeatherByZIPResponse;
import com.cdyne.weather.ws.WeatherSEI;
import com.cdyne.weather.ws.WeatherService;

/**
 * 
 * @author mauricioca
 * 
 * Observar que como la referencia es al Service no necesitamos especificar en @WebServiceRef(value =  WeatherService.class)
 * dado que lo infiere del tipo. Comparar esto con WeatherServlet1.
 *
 */
@WebServlet(name = "WeatherServlet0", urlPatterns = { "/WeatherServlet0" })
public class WeatherServlet0 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Resuelve el WSDL de acuerdo a lo que esta definido por defecto en
	 * GlobalWeather
	 */
	@WebServiceRef

	/*
	 * Busca el WSDL en el server, no utiliza el catalogo
	 */
	// @WebServiceRef(wsdlLocation =
	// "http://www.webservicex.net/globalweather.asmx?wsdl")

	/*
	 * Esta URI es resuelta por medio del catalogo
	 */
	// @WebServiceRef(wsdlLocation = "http://localhost/weather.wsdl")

	private WeatherService service;

	
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
		WeatherSEI port = getPort();
		GetCityWeatherByZIP request = new GetCityWeatherByZIP();
		request.setZIP(zip);
		return port.getCityWeatherByZIP(request);
	}
	

	public WeatherSEI getPort() {
		String endpointURL = "http://wsf.cdyne.com/WeatherWS/Weather.asmx";
		WeatherSEI port = service.getWeatherSEI();
		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);
		return port;
	}
    
    
	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(arg0, arg1);
	}

}