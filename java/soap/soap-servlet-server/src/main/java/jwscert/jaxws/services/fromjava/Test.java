package jwscert.jaxws.services.fromjava;

import javax.jws.WebService;

@WebService(endpointInterface="jwscert.jaxws.services.fromjava.ITest")
public class Test implements ITest {

	@Override
	public String hola(String param) {
		return param;
	}

}
