package jwscert.rest.services.ejb;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ejb")
@Stateless
public class EjbBean {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWithParams(){
		return "Hello World from EJB";
	}
	
}
