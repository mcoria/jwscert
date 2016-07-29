package jwscert.rest.services.book;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import jwscert.rest.model.Book;
import jwscert.rest.model.BookStore;

@Path("/bookstore/search")
public class SearchBooks  {
	private BookStore bookStore = BookStore.getInstance();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> searchByName(@QueryParam("name") String name) {
		return bookStore.searchByName(name);
	}

}
