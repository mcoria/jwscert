package jwscert.jaxws.services.fromjava.twoendpoints;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;


/*
 * HelloSIB0 implementa el mismo puerto pero con distinto binding, ambos publican en mismo servicio pero lo unico que cambia es el puerto y 
 * el binding que se publica dentro del servicio
 */
@WebService(endpointInterface="jwscert.jaxws.services.fromjava.twoendpoints.HelloSEI", serviceName="HelloSIB", portName="HelloSOAP12")
@BindingType(value=SOAPBinding.SOAP12HTTP_BINDING)
public class HelloSIB1 implements HelloSEI {

	@Override
	public String hola(String param) {
		return param;
	}	
}
