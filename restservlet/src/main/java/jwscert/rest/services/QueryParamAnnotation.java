package jwscert.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/queryparam")
public class QueryParamAnnotation {

	@QueryParam("param1")
	private String param1;
	
	@GET
	public String helloWithParams(@QueryParam("param2") String param2){
		return param1 + " " + param2;
	}
}
