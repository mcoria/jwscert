package jwscert.jaxws.services;

import javax.jws.WebService;

import jwscert.jaxws.services.generated.Hola;

@WebService(endpointInterface="jwscert.jaxws.services.generated.Hola")
public class HolaImplSinHandlerChainAnnotation implements Hola {

	public String test(String in) {
		System.out.println("HolaImplSinHandlerChainAnnotation .... processing");
		
		if ("fail".equals(in)){
			throw new RuntimeException("RuntimeException...");
		}
		return in;
	}

}
