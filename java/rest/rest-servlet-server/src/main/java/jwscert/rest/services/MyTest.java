package jwscert.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/mytest")
public class MyTest {
	
	@GET
	public String Hello(){
		return "Hello word MyTest";
	}
}
