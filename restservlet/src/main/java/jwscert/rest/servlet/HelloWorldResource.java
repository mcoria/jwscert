package jwscert.rest.servlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;	


@Path("/hello")	
public class HelloWorldResource {

	
	@GET
	public String helloWithParams(){
		return "Hello World";
	}
		
}
