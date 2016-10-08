package jwscert.jaxws.services.fromjava;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Action;

@WebService
public interface ServiceEndpointInterface {
	
	@WebMethod
	@Action(input="http://localhost/hola_in",
			output="http://localhost/hola_out")
	public String hola(String param);

}
