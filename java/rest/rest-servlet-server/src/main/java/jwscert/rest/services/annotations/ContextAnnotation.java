package jwscert.rest.services.annotations;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;



@Path("/context")
public class ContextAnnotation {


	@GET
	@Produces("text/plain")
	public String listQueryParamNames(@Context UriInfo info) {
		StringBuilder buf = new StringBuilder();
		for (String param: info.getQueryParameters().keySet()) {
			buf.append(param);
			buf.append("\n");
		}
		return buf.toString();
	}
	
	
	/*
	@GET
	@Produces{"text/plain"}
	public String listHeaderNames(@javax.ws.rs.core.Context HttpHeaders headers) {
		StringBuilder buf = new StringBuilder();
		for (String header: headers.getRequestHeaders().keySet()) {
		buf.append(header);
		buf.append("\n");
		}
		return buf.toString();
	}*/
	
	
}
