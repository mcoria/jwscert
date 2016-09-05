package org.soap.security;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService
@RolesAllowed("administrador")
public class AppSecurity1 {
	
	@Resource
	private WebServiceContext ctx;
	
	
	public String sayHello(String word){
		return "Hola " + ctx.getUserPrincipal().getName() + " " + word;
	}
	

	public String sayHello1(String word){
		return "Hola " + ctx.getUserPrincipal().getName() + " " + word;
	}	

}
