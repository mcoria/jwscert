package jwscert.jaxws.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

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
		String urlStr = "http://wsf.cdyne.com/WeatherWS/Weather.asmx";
		//URL url = new URL(urlStr);
		QName serviceName = new QName("http://ws.cdyne.com/WeatherWS/", "Weather");
		Service service = Service.create(serviceName);
		service.addPort(portQName, SOAPBinding.SOAP11HTTP_BINDING, urlStr);
		System.out.println("Setup complete.");	
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
			


			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}


	public void testSayHelloSource() throws Exception {
		Dispatch<Source> sourceDispatch = service.createDispatch(portQName, Source.class, Service.Mode.PAYLOAD);
		Source result = sourceDispatch.invoke(new StreamSource(new StringReader("asd")));
		
	}
	   
    
	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(arg0, arg1);
	}

}