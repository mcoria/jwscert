package jwscert.rest.servlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/queryparam")
public class ExtractQueryParam {

	/*
	@GET
	public String hello(){
		return "Hello";
	}*/
	
	@GET
	public String helloWithParams(@QueryParam("text") String text){
		return text;
	}
}
