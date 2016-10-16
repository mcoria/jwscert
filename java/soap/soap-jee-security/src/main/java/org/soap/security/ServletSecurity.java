package org.soap.security;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService
@DeclareRoles({"ADMINS","USERS"})  //--> Esto no funciona, ver como se hace el mapping para el metodo isUserInRole()
//@RolesAllowed({"ADMINS","USERS"})  --> Esto no funciona
public class ServletSecurity {
	
	@Resource
	private WebServiceContext ctx;
	
	@WebMethod(operationName="sayHello0")
	public String sayHello(){
		return "Principal: " + ctx.getUserPrincipal().getName() + ", inRole (admins): " +  ctx.isUserInRole("admins") + ", inRole (users): " +  ctx.isUserInRole("users");
	}

}
