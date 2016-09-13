package jwscert.jaxws.services.fromjava.inheritance;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class LogServiceImpl extends LogServiceImplParent{

	public void log(String msg) {
		System.out.println(msg);
	}
	
	
	@WebMethod(exclude=false)
	public void logN(String msg){
		System.out.println(msg);
	}	
}
