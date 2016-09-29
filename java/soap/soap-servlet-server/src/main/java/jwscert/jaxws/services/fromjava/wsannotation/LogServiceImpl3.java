package jwscert.jaxws.services.fromjava.wsannotation;

import javax.jws.WebService;


/*
<portType name="LogService3">...</portType>
<binding name="ThePortBinding" type="tns:LogService3">...</binding>
<service name="LogWebService3">
	<port name="ThePort" binding="tns:ThePortBinding">...</port>
</service>
*/

@WebService(name = "LogService3", serviceName = "LogWebService3", portName="ThePort")
public class LogServiceImpl3 {
	public void log(String msg) {
		System.out.println(msg);
	}
}