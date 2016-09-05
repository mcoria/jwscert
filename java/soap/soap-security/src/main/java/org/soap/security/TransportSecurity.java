package org.soap.security;

import javax.jws.WebService;

@WebService(name="Transport")
public class TransportSecurity {
	public String sayHello(String word){
		return "Hola " + word;
	}

}
