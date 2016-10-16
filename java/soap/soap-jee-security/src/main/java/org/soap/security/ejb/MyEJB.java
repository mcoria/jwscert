package org.soap.security.ejb;

import java.security.Principal;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;

@Singleton(name="MyEJB")
@DeclareRoles({"admins", "users"})
public class MyEJB {
	@Resource 
	private SessionContext ctx;
	
	public String whoAmI(){
		System.out.println("inRole (admins): " +  ctx.isCallerInRole("admins") + ", inRole (users): " +  ctx.isCallerInRole("users"));
		Principal callerPrincipal = ctx.getCallerPrincipal();
		return callerPrincipal.getName();
	}
}
