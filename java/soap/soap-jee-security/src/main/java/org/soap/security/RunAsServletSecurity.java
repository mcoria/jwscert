package org.soap.security;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import org.soap.security.ejb.MyEJB;

@WebService
@DeclareRoles({"admins","users"})
public class RunAsServletSecurity {

	@Resource
	private WebServiceContext ctx;
	
	@EJB
	private MyEJB myEJB;
	
	@WebMethod(operationName="myEJB")
	public String myEJB(){
		return "whoAmI(service): " + ctx.getUserPrincipal().getName() + ", whoAmI: " + myEJB.whoAmI() +", inRole (admins): " +  ctx.isUserInRole("admins") + ", inRole (users): " +  ctx.isUserInRole("users");
	}
}
