package jwscert.jaxws.services.fromjava;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RandService {
	
	@WebMethod
	public String Hola() {
		return "Hola";
	}

}
