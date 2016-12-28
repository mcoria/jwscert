package jwscert.jaxws.services.fromwsdl;

import javax.annotation.PostConstruct;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;

import org.w3c.dom.Document;

import net.webservicex.GetCitiesByCountryResponse;
import net.webservicex.ObjectFactory;

@WebServiceProvider(serviceName = "GlobalWeatherService", 
					portName = "GlobalWeatherPort", 
					targetNamespace = "http://www.webserviceX.NET", 
					wsdlLocation = "WEB-INF/wsdl/globalweather.wsdl")
@ServiceMode(value = Mode.MESSAGE)
public class MessageMode implements Provider<SOAPMessage> {

	private Utils utils = null;
	
	private ObjectFactory weatherFactory = null;

	@PostConstruct
	public void init() {
		utils = new Utils();
		weatherFactory = new ObjectFactory();
	}

	@Override
	public SOAPMessage invoke(SOAPMessage request) {
		try {
			MessageFactory messagefactory = MessageFactory.newInstance();

			SOAPMessage response = messagefactory.createMessage();

			SOAPBody respBody = response.getSOAPBody();

			respBody.addDocument(createBody());

			response.saveChanges();

			return response;

		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private Document createBody() {
		GetCitiesByCountryResponse wsResponse = weatherFactory.createGetCitiesByCountryResponse();
		wsResponse.setGetCitiesByCountryResult("MessageMode");
		return utils.toDocument(wsResponse);
	}

}
