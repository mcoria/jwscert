package jwscert.jaxws.services.fromjava;

import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService
@Stateless
public class MyStatelessEjb {
	public String hello(String param){
		return "Hello MyStatelessEjb " + param;
	}
}
