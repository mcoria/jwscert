package jwscert.jaxws.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import org.junit.Before;
import org.junit.Test;

import jwscert.jaxws.services.fromwsdl.Utils;
import net.webservicex.GetCitiesByCountry;


public class PayloadModeClient {
	
	private Service service = null;
	
	private static final String NAMESPACE = "http://www.webserviceX.NET"; 
	private static final QName SERVICE_NAME = new QName(NAMESPACE, "GlobalWeatherService");
	private static final QName PORT_NAME = new QName(NAMESPACE, "GlobalWeatherPort");
	
	private Utils utils = new Utils();
	
	@Before
	public void setUp(){
		try {
			
			service = Service.create(new URL("http://d-mauricioca:8080/soap-lowlevel-server/GlobalWeatherImp?wsdl"), SERVICE_NAME);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}
	
	@Test
	public void invoke_Source(){
		Dispatch<Source> sourceDispatch = service.createDispatch(PORT_NAME, Source.class, Service.Mode.PAYLOAD);
		
		GetCitiesByCountry citiesByCountry = new GetCitiesByCountry();
		
		citiesByCountry.setCountryName("Argentina");
		 
		Source result = sourceDispatch.invoke(utils.toJAXBSource(citiesByCountry));
		
		utils.sourceToXML(result, System.out);
	}
	
	@Test
	public void invoke_JAXBContext() throws Exception {
		Dispatch<Object> sourceDispatch = service.createDispatch(PORT_NAME, utils.getJAXBContext(), Service.Mode.PAYLOAD);
		
		GetCitiesByCountry citiesByCountry = new GetCitiesByCountry();
		
		citiesByCountry.setCountryName("Argentina");
		
		Object result = sourceDispatch.invoke(citiesByCountry);
		
		utils.jaxbObjectToXML(result, System.out);
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
	
	/*
	
	
	
	public void invoke_JAXBContextAsync(PrintWriter out) throws Exception {
		Dispatch<Object> sourceDispatch = service.createDispatch(PORT_NAME, utils.getJAXBContext(), Service.Mode.PAYLOAD);
		
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
	}*/

}
