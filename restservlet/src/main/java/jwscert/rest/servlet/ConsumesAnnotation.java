package jwscert.rest.servlet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("consumes")
public class ConsumesAnnotation {

	@GET
	@Consumes()
}
