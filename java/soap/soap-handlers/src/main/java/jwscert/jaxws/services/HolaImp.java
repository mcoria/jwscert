package jwscert.jaxws.services;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import jwscert.jaxws.services.generated.Hola;

@WebService(
		serviceName="HolaService", 
		portName="HolaServicePort", 
		endpointInterface="jwscert.jaxws.services.generated.Hola"
		//wsdlLocation="WEB-INF/wsdl/HolaService.wsdl"
		)
@HandlerChain(file="handler-chain.xml")
public class HolaImp implements Hola {

	@Resource
	private WebServiceContext ctx;
	
	@Override
	public String test(String in) {
		System.out.println("HolaImp .... processing");	
		return in;
	}

}
