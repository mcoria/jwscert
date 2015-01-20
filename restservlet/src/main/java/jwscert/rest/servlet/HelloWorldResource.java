package jwscert.rest.servlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloWorldResource {


	/*
	@GET
	public String hello(){
		return "Hello";
	}*/
	
	@GET
	public String helloWithParams(){
		return "Hello World";
	}
		
}
