package jwscert.jaxws.services.fromjava;

import javax.jws.WebService;

@WebService(endpointInterface="jwscert.jaxws.services.fromjava.ITest")
public class ServiceImplementationBean implements ServiceEndpointInterface {

	@Override
	public String hola(String param) {
		return param;
	}

}
