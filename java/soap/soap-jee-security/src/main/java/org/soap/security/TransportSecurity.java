package org.soap.security;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="Transport")
public class TransportSecurity {
	
	@WebMethod(operationName="sayHelloTransport")
	public String sayHello(String word){
		return "Hola " + word;
	}

}
