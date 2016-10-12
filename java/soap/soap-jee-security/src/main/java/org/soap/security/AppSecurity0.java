package org.soap.security;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

@WebService(serviceName="AppSecurity0")
@DeclareRoles({"ADMINS","USERS"})
public class AppSecurity0 {
	
	@Resource
	private WebServiceContext ctx;
	
	@WebMethod(operationName="sayHello0")
	public String sayHello(String word){
		return ", inRole (ADMINS): " +  ctx.isUserInRole("ADMINS") + ", inRole (USERS): " +  ctx.isUserInRole("users");
	}

}
