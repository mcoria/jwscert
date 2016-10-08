package jwscert.jaxws.services.fromjava;

import javax.ejb.Singleton;
import javax.jws.WebService;

@WebService
@Singleton
public class MySingletonEjb {
	public String hello(String param){
		return "Hello " + param;
	}
}
