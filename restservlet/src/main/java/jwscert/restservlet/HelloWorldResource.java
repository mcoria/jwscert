package jwscert.restservlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/hello")
@Produces("text/plain")
public class HelloWorldResource {

	/*
	@GET
	public String hello(){
		return "Hello";
	}*/
	
	@GET
	//@Path("?text={text}")
	public String helloWithParams(@QueryParam("text") String text){
		return text;
	}
	
}
