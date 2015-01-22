package jwscert.rest.servlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("/path/{path1}")
public class PathAnnotation {

	@PathParam("path1")
	private String path1;
	
	@GET
	public String getNivel1(){
		return "Path1: " + path1 ;
	}	
	
	@GET
	@Path("/{path2}")
	public String getNivel2(@PathParam("path2") String path2){
		return "Path1: " + path1 + ", Path2: " + path2;
	}
}
