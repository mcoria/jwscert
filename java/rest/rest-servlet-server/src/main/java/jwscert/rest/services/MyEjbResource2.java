package jwscert.rest.services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/ejbwar2")
@Stateless
public class MyEjbResource2 {
	

	@GET
	public String Hello(){
		return "Hello word MyEjbResource";
	}

}
