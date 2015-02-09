package jwscert.rest.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import jwscert.rest.model.Book;

@Path("/bookstore/search")
public interface SearchBooks {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> searchByName(@QueryParam("name") String name);
}
