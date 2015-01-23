package jwscert.rest.servlet;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


@Path("/consumes")
public class ConsumesAnnotation {

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String postFormURLEncoded(@FormParam("variable1") String variable1, 
									 @FormParam("variable2") String variable2 ){
		return "variable1: " + variable1 + ", variable2: " + variable2 ;
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public String postTextPlain(){
		return MediaType.TEXT_PLAIN;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String postApplicationJson(){
		return MediaType.APPLICATION_JSON;
	}	
}
