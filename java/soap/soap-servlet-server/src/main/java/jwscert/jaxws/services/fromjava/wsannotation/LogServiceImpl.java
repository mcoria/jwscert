package jwscert.jaxws.services.fromjava.wsannotation;

import javax.jws.WebService;


/*
<portType name="LogService">...</portType>
<binding name="LogServicePortBinding" type="tns:LogService">...</binding>
<service name="LogWebService">
	<port name="LogServicePort" binding="tns:LogServicePortBinding">...</port>
</service>
*/

@WebService(name = "LogService", serviceName = "LogWebService")
public class LogServiceImpl {
	public void log(String msg) {
		System.out.println(msg);
	}
}