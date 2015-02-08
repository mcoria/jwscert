package jwscert.rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import jwscert.rest.model.Book;
import jwscert.rest.model.BookStore;

@Path("/bookstore")
public class JsonResources {

	BookStore bookStore = BookStore.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return Response.ok(bookStore.getAll()).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") int id) {
		Book book = bookStore.getById(id);
		if (book != null) {
			return Response.ok(book).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
	
	@POST
	public Response create(Book book) {
		bookStore.create(book);
		return Response.ok().build();
	}	

}
