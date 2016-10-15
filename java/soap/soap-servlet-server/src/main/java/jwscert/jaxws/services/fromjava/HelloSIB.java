package jwscert.jaxws.services.fromjava;

import javax.jws.WebService;

@WebService(endpointInterface="jwscert.jaxws.services.fromjava.HelloSEI")
public class HelloSIB implements HelloSEI {

	@Override
	public String hola(String param) {
		return param;
	}

	
	@Override
	public void doOneWay(String param){
		if ("fail".equals(param)){
			throw new RuntimeException("failing");
		}
	}	
}
