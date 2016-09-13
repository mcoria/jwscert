package jwscert.jaxws.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Response;
import javax.xml.ws.WebServiceRef;

import com.cdyne.weather.types.ArrayOfWeatherDescription;
import com.cdyne.weather.types.GetWeatherInformationResponse;
import com.cdyne.weather.ws.WeatherSEI;
import com.cdyne.weather.ws.WeatherService;

/**
 * 
 * @author mauricio
 *
 * Muestra como invocar asincrono
 */
@WebServlet(name = "WeatherServlet3", urlPatterns = { "/WeatherServlet3" })
public class WeatherServlet3 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@WebServiceRef(WeatherService.class)
	private WeatherSEI port;
	
	
	private Utils utils = new Utils();	
	
	@PostConstruct
	private void setup(){
		String endpointURL = "http://wsf.cdyne.com/WeatherWS/Weather.asmx";
		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL);		
	}
	
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
			
			out.println("<p>");
			utils.jaxbObjectToXML(getWeatherInformation(), out);
			out.println("</p>");
			
			out.println("<p>");
			utils.jaxbObjectToXML(getWeatherInformationAsync(), out);
			out.println("</p>");	
			
			out.println("<p>");
			getWeatherInformationAsyncCallBack(out);
			out.println("</p>");

			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	
	private ArrayOfWeatherDescription getWeatherInformation() {
		return port.getWeatherInformation();
	}	
	
	private GetWeatherInformationResponse getWeatherInformationAsync() {
		Response<GetWeatherInformationResponse> response = port.getWeatherInformationAsync();
		
		try {
			while (!response.isDone()) {
				Thread.sleep(500);
			}
			GetWeatherInformationResponse result = response.get();
			return result;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void getWeatherInformationAsyncCallBack(final PrintWriter out) {
		Future<?> future = port.getWeatherInformationAsync(new AsyncHandler<GetWeatherInformationResponse>(){

			@Override
			public void handleResponse(Response<GetWeatherInformationResponse> response) {
				try {
					while (!response.isDone()) {
						Thread.sleep(500);
					}
					GetWeatherInformationResponse result = response.get();
					
					utils.jaxbObjectToXML(result, out);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		try {
			while (!future.isDone()) {
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(arg0, arg1);
	}

}