package jwscert.rest.services;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import jwscert.rest.model.Book;
import jwscert.rest.model.BookStore;

public class SearchBooksTest extends BaseTest  {

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
        ClientResponse responseMsg = webResource.path(RESOURCE + "?name=" + URLEncoder.encode("Name1", "UTF-8")).get(ClientResponse.class);
        List<Book> books = responseMsg.getEntity(new GenericType<List<Book>>(){});
        assertEquals(MediaType.APPLICATION_JSON_TYPE, responseMsg.getType());
        assertEquals(1, books.size());
	}		
}
