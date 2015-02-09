package jwscert.rest.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import jwscert.rest.model.Book;
import jwscert.rest.model.BookStore;

import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class JsonResourcesTest extends BaseTest {

	private static final String RESOURCE = "/bookstore";
	
	private BookStore bookStore = BookStore.getInstance();
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		bookStore.reset();
	};
	
	@Test
	public void listAll() {
        WebResource webResource = resource();
        ClientResponse responseMsg = webResource.path(RESOURCE).get(ClientResponse.class);
        List<Book> books = responseMsg.getEntity(new GenericType<List<Book>>(){});
        assertEquals(MediaType.APPLICATION_JSON_TYPE, responseMsg.getType());
        assertEquals(bookStore.getAll().size(), books.size());
	}	
	
	@Test
	public void finById() {
        WebResource webResource = resource();
        ClientResponse responseMsg = webResource.path(RESOURCE+"/1").get(ClientResponse.class);        
        Book book = responseMsg.getEntity(Book.class);
        assertEquals(MediaType.APPLICATION_JSON_TYPE, responseMsg.getType());
        assertEquals(1, book.getId());
	}
	
	@Test
	public void findByIdNotFound() {
        WebResource webResource = resource();
        ClientResponse responseMsg = webResource.path(RESOURCE+"/1000").get(ClientResponse.class);
        assertEquals(Status.NOT_FOUND.getStatusCode(), responseMsg.getStatusInfo().getStatusCode());
	}
	
	@Test
	public void create() {
        WebResource webResource = resource();
        
        Book book = new Book();
        book.setId(3);
        book.setName("Name3");
        
        ClientResponse responseMsg = webResource.path(RESOURCE).type(MediaType.APPLICATION_JSON_TYPE).post(ClientResponse.class, book);
        assertEquals(Status.OK.getStatusCode(), responseMsg.getStatusInfo().getStatusCode());
        
        Book bookFound = bookStore.getById(3);
        
        assertEquals(3, bookFound.getId());
        assertEquals("Name3", bookFound.getName());
	}	
	
}
