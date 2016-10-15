package jwscert.jaxws.services.fromjava.twoendpoints;

import javax.jws.WebService;

@WebService(name="TheInterface")
public interface HelloSEI {
	
	public String hola(String param);

}
