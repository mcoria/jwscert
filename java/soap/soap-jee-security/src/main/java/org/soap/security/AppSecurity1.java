package org.soap.security;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;


@WebService(serviceName="AppSecurity1")
@DeclareRoles({"admins","users"})
@Stateless(name="AppSecurity1")
public class AppSecurity1 {
	
	@Resource
	private WebServiceContext ctx;

	@RolesAllowed("admins")
	@WebMethod(operationName="sayHello1")
	public String sayHello(String word){
		return "Hola " + ctx.getUserPrincipal().getName() + " " + word + ", inRole (admins): " +  ctx.isUserInRole("admins") + ", inRole (users): " +  ctx.isUserInRole("users");
	}
	
	@RolesAllowed("users")
	@WebMethod(operationName="sayBye1")
	public String sayBye(String word){
		return "Hola " + ctx.getUserPrincipal().getName() + " " + word + ", inRole (admins): " +  ctx.isUserInRole("admins") + ", inRole (users): " +  ctx.isUserInRole("users");
	}
	
	@PermitAll
	@WebMethod(operationName="sayPermitAll1")
	public String sayPermitAll(String word){
		return "Hola " + ctx.getUserPrincipal().getName() + " " + word + ", inRole (admins): " +  ctx.isUserInRole("admins") + ", inRole (users): " +  ctx.isUserInRole("users");
	}	
	
	@DenyAll
	@WebMethod(operationName="sayDenyAll1")
	public String sayDenyAll1(String word){
		return "Hola " + word ;
	}		

}
