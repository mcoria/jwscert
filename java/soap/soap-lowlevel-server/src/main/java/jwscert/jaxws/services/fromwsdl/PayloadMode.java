package jwscert.jaxws.services.fromwsdl;

import javax.annotation.PostConstruct;
import javax.xml.transform.Source;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

import net.webservicex.GetCitiesByCountryResponse;
import net.webservicex.ObjectFactory;


@WebServiceProvider(serviceName = "GlobalWeatherService", 
					portName = "GlobalWeatherPort", 
					targetNamespace = "http://www.webserviceX.NET", 
					wsdlLocation = "WEB-INF/wsdl/globalweather.wsdl")
@ServiceMode(value = Mode.PAYLOAD)
public class PayloadMode implements Provider<Source> {

	private Utils utils = null;
	
	private ObjectFactory weatherFactory = null;

	@PostConstruct
	public void init() {
		utils = new Utils();
		weatherFactory = new ObjectFactory();
	}

	@Override
	public Source invoke(Source request) {
		
		System.out.print("PayloadMode.invoke(Source request)....\n");
		
		utils.sourceToXML(request, System.out);
		
		System.out.flush();
		
		return createBody();
	}

	private Source createBody() {
		GetCitiesByCountryResponse wsResponse = weatherFactory.createGetCitiesByCountryResponse();
		wsResponse.setGetCitiesByCountryResult("PayloadMode");
		return utils.toJAXBSource(wsResponse);
	}
	
	
	

}
