package jwscert.jaxws.services.fromjava;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class OneWay {

	@WebMethod
	@Oneway
	public void doOneWay(String param){
		if ("fail".equals(param)){
			throw new RuntimeException("failing");
		}
	}
}
