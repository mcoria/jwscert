package jwscert.jaxws.addressing.services;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;


@WebService(serviceName = "Service0")
@Addressing
public class ServiceImp0 {
	public String hello(String parameter) {
		return "Hola " + parameter;
	}
}
