package jwscert.rest.services;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MediaTypeAnnotationTest extends BaseTest {

	private static final String RESOURCE = "/media";

	@Test
	public void testPostTextPlain() {
        WebResource webResource = resource();
        ClientResponse responseMsg = webResource.path(RESOURCE).entity("Test", MediaType.TEXT_PLAIN_TYPE)
        		.post(ClientResponse.class);        
        assertEquals(MediaType.TEXT_PLAIN_TYPE, responseMsg.getType());
        assertEquals("postTextPlain: Test", responseMsg.getEntity(String.class));
	}
	
	@Test
	public void testPostFormURLEncoded() throws UnsupportedEncodingException{
        WebResource webResource = resource();
        String body = "variable1=" + URLEncoder.encode("Este es el primer valor" , "UTF-8") +
        		"&variable2=" + URLEncoder.encode("Este es el segundo valor" , "UTF-8");
        ClientResponse responseMsg = webResource.path(RESOURCE).entity(body, MediaType.APPLICATION_FORM_URLENCODED_TYPE)
        		.post(ClientResponse.class);
        assertEquals(MediaType.TEXT_PLAIN_TYPE, responseMsg.getType());
        assertEquals("postFormURLEncoded: variable1=Este es el primer valor, variable2=Este es el segundo valor", responseMsg.getEntity(String.class));
	}	
	
	@Test
	public void testPostApplicationJson(){
        WebResource webResource = resource();
        ClientResponse responseMsg = webResource.path(RESOURCE).entity("Test", MediaType.APPLICATION_JSON_TYPE)
        		.post(ClientResponse.class);
        assertEquals(MediaType.APPLICATION_JSON_TYPE, responseMsg.getType());
        assertEquals("postApplicationJson: Test", responseMsg.getEntity(String.class));
	}
	
	@Test
	public void testPostApplicationXml(){
        WebResource webResource = resource();
        ClientResponse responseMsg = webResource.path(RESOURCE).entity("Test", MediaType.APPLICATION_XML_TYPE)
        		.post(ClientResponse.class);
        assertEquals(MediaType.APPLICATION_XML_TYPE, responseMsg.getType());
        assertEquals("postApplicationXml: Test", responseMsg.getEntity(String.class));
	}	
}
