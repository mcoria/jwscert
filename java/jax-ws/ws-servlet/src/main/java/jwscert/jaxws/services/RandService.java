package jwscert.jaxws.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RandService {
	@WebMethod
	public String Hola() {
		return "Hola";
	}

}
