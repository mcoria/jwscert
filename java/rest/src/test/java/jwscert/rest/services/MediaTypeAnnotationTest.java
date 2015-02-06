package jwscert.rest.services;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MediaTypeAnnotationTest extends BaseTest {

	@Test
	public void testPostApplicationJson(){
        WebResource webResource = resource();
        ClientResponse responseMsg = webResource.path("/consumes").entity("Test", MediaType.APPLICATION_JSON_TYPE)
        		.post(ClientResponse.class);
        assertEquals(MediaType.APPLICATION_JSON_TYPE, responseMsg.getType());
        assertEquals("postApplicationJson: Test", responseMsg.getEntity(String.class));
	}
	
	@Test
	public void testPostApplicationXml(){
        WebResource webResource = resource();
        ClientResponse responseMsg = webResource.path("/consumes").entity("Test", MediaType.APPLICATION_XML_TYPE)
        		.post(ClientResponse.class);
        assertEquals(MediaType.APPLICATION_XML_TYPE, responseMsg.getType());
        assertEquals("postApplicationXml: Test", responseMsg.getEntity(String.class));
	}	
}
