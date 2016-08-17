package jwscert.jaxws.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Response;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import com.cdyne.weather.types.GetCityWeatherByZIP;

@WebServlet(name = "WeatherServletDispatch", urlPatterns = { "/WeatherServletDispatch" })
public class WeatherServletDispatch extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Service service = null;
	
	private static final QName portQName = new QName("http://ws.cdyne.com/WeatherWS/", "WeatherSoap");
	
	private Utils utils = new Utils();
	
	@PostConstruct
	private void setup(){
		try {
			service = Service.create(new URL("http://wsf.cdyne.com/WeatherWS/Weather.asmx?wsdl"), new QName("http://ws.cdyne.com/WeatherWS/", "Weather"));
			
			//service.addPort(portQName, SOAPBinding.SOAP11HTTP_BINDING , "http://wsf.cdyne.com/WeatherWS/Weather.asmx");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	
	
	public void invoke_Source(PrintWriter out) throws Exception {
		Dispatch<Source> sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
		
		Map<String, Object> context = sourceDispatch.getRequestContext();
		context.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
		context.put(BindingProvider.SOAPACTION_URI_PROPERTY, "http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP");
		
		String request = "<GetCityWeatherByZIP xmlns=\"http://ws.cdyne.com/WeatherWS/\"><ZIP>22043</ZIP></GetCityWeatherByZIP>";
		Source result = sourceDispatch.invoke(new StreamSource(new StringReader(request)));
		
		utils.sourceToXML(result, out);
	}
	
	/*
	public void invoke_Message(PrintWriter out) throws Exception {
		Dispatch<SOAPMessage> sourceDispatch = service.createDispatch(portQName, SOAPMessage.class, Service.Mode.MESSAGE);
		
		Map<String, Object> context = sourceDispatch.getRequestContext();
		context.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
		context.put(BindingProvider.SOAPACTION_URI_PROPERTY, "http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP");
		
		GetCityWeatherByZIP getCityWeatherByZIP = new GetCityWeatherByZIP();
		getCityWeatherByZIP.setZIP("22043");
		
		SOAPMessage request = new SOAPMessage()
		
		Object result = sourceDispatch.invoke(getCityWeatherByZIP);
		
		utils.jaxbObjectToXML(result, out);
	}*/
	
	public void invoke_JAXBContext(PrintWriter out) throws Exception {
		Dispatch<Object> sourceDispatch = service.createDispatch(portQName, utils.getJAXBContext(), Service.Mode.PAYLOAD);
		
		Map<String, Object> context = sourceDispatch.getRequestContext();
		context.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
		context.put(BindingProvider.SOAPACTION_URI_PROPERTY, "http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP");
		
		GetCityWeatherByZIP request = new GetCityWeatherByZIP();
		request.setZIP("22043");
		
		Object result = sourceDispatch.invoke(request);
		
		utils.jaxbObjectToXML(result, out);
	}	
	
	public void invoke_JAXBContextAsync(PrintWriter out) throws Exception {
		Dispatch<Object> sourceDispatch = service.createDispatch(portQName, utils.getJAXBContext(), Service.Mode.PAYLOAD);
		
		Map<String, Object> context = sourceDispatch.getRequestContext();
		context.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
		context.put(BindingProvider.SOAPACTION_URI_PROPERTY, "http://ws.cdyne.com/WeatherWS/GetCityWeatherByZIP");
		
		GetCityWeatherByZIP request = new GetCityWeatherByZIP();
		request.setZIP("22043");
		
		Response<Object> response = sourceDispatch.invokeAsync(request);
		
		do{
			out.println("Waitting response <p/>");
			Thread.sleep(10);
		} while (! response.isDone() );
		
		Object result = response.get();
		
		utils.jaxbObjectToXML(result, out);
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
			
			invoke_Source(out);
			
			out.println("<p/>");
			
			invoke_JAXBContext(out);
			
			out.println("<p/>");
			
			invoke_JAXBContextAsync(out);

			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
    
	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(arg0, arg1);
	}

}