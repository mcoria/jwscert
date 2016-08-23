package jwscert.jaxws.services.fromjava;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

@WebService(endpointInterface="jwscert.jaxws.services.fromjava.ITest")
@Addressing(enabled=true, required=true)
public class Test implements ITest {

	@Override
	public String hola(String param) {
		return param;
	}

}
