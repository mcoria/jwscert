package org.soap.security;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TransportSecurity {
	
	@WebMethod(operationName="sayHelloTransport")
	public String sayHello(){
		return "Hola";
	}

}
