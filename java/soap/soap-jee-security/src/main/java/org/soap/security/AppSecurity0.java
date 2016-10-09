package org.soap.security;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService
public class AppSecurity0 {
	
	@Resource
	private WebServiceContext ctx;
	
	
	public String sayHello(String word){
		return "Hola " + ctx.getUserPrincipal().getName() + " " + word;
	}

}
