package jwscert.rest.services;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;

public class HelloWorldTest extends BaseTest {
	
	@Test
	public void get() throws URISyntaxException {
        WebResource webResource = resource();
        String responseMsg = webResource.path("/hello").get(String.class);
        assertEquals("Hello World", responseMsg);
	}

}

