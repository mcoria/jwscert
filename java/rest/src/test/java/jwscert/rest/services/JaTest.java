package jwscert.rest.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

public class JaTest extends JerseyTest {

	private static final String baseUrl = "http://localhost:8080/predictions2";

	public JaTest() {
		
	}

	@Override
	protected AppDescriptor configure() {
		
	};
	
	@Test
	public void asdasd() {
        WebResource webResource = resource();
        String responseMsg = webResource.path("helloworld").get(String.class);
        assertEquals("Hello World", responseMsg);
	}

}
