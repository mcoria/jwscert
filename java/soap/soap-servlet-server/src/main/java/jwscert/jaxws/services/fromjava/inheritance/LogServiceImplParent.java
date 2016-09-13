package jwscert.jaxws.services.fromjava.inheritance;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class LogServiceImplParent extends LogServiceImplParentSuper {
	@WebMethod
	public void logParent(String msg){
		System.out.println(msg);
	}
}
