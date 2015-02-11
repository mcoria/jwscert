package jwscert.rest.services.book;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.Assert;
import org.junit.Test;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import jwscert.rest.model.Book;
import jwscert.rest.model.BookStore;
import jwscert.rest.services.BaseTest;

public class JsonSearchBooksTest extends BaseTest  {

	private static final String RESOURCE = "/bookstore/search";
	
	private BookStore bookStore = BookStore.getInstance();	
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		bookStore.reset();
	};
	
	@Test
	public void search() throws UniformInterfaceException, ClientHandlerException, UnsupportedEncodingException {
        WebResource webResource = resource();
        ClientResponse responseMsg = webResource
        							.path(RESOURCE)
        							.queryParam("name", "Name1")
        							.get(ClientResponse.class);
        List<Book> books = responseMsg.getEntity(new GenericType<List<Book>>(){});
        assertEquals(MediaType.APPLICATION_JSON_TYPE, responseMsg.getType());
        assertTrue(books.size() > 0);
        Book book = books.get(0);
        assertNotNull(book);
        assertTrue(book.getName().contains("Name1") );
	}		
}
