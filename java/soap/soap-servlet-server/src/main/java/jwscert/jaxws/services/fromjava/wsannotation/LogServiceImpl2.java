package jwscert.jaxws.services.fromjava.wsannotation;

import javax.jws.WebService;


/*
<portType name="LogServiceImpl2">...</portType>
<binding name="LogServiceImpl2PortBinding" type="tns:LogServiceImpl2">...</binding>
<service name="LogWebService2">
	<port name="LogServiceImpl2Port" binding="tns:LogServiceImpl2PortBinding">...</port>
</service>
*/

@WebService(serviceName = "LogWebService2")
public class LogServiceImpl2 {
	public void log(String msg) {
		System.out.println(msg);
	}
}