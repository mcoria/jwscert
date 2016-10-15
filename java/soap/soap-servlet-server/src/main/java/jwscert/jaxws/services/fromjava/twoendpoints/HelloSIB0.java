package jwscert.jaxws.services.fromjava.twoendpoints;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(endpointInterface="jwscert.jaxws.services.fromjava.twoendpoints.HelloSEI", serviceName="HelloSIB", portName="HelloSOAP11")
@BindingType(value=SOAPBinding.SOAP11HTTP_BINDING)
public class HelloSIB0 implements HelloSEI {

	@Override
	public String hola(String param) {
		return param;
	}	
}
