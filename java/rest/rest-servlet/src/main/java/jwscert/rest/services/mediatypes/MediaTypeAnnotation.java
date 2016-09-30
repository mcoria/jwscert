package jwscert.rest.services.mediatypes;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/media")
@Produces(MediaType.TEXT_PLAIN)
public class MediaTypeAnnotation {

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public String postTextPlain(String body){
		return "postTextPlain: " + body;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String postFormURLEncoded(@FormParam("variable1") String variable1, 
									 @FormParam("variable2") String variable2 ){
		return "postFormURLEncoded: variable1=" + variable1 + ", variable2=" + variable2 ;
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String postApplicationJson(String body){
		return "postApplicationJson: " + body;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String postApplicationXml(String body){
		return "postApplicationXml: " + body;
	}
}
