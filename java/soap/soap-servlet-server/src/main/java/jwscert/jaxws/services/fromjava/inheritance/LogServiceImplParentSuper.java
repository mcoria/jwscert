package jwscert.jaxws.services.fromjava.inheritance;

import javax.jws.WebService;

@WebService
public class LogServiceImplParentSuper {
	public void logSuper(String msg) {
		System.out.println(msg);
	}
}
