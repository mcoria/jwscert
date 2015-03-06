package jwscert.rest.services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/hello")
public class HelloRestBean {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWithParams(){
		return "Hello World";
	}
	
}
