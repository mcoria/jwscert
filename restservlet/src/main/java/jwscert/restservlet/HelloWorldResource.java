package jwscert.restservlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
@Produces("text/plain")
public class HelloWorldResource {

	@GET
	public String hello(){
		return "Hello";
	}
}
