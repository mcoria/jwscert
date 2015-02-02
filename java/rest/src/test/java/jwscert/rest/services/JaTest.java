package jwscert.rest.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

public class JaTest extends JerseyTest {

	private static final String baseUrl = "http://localhost:8080/predictions2";

	@Override
	protected AppDescriptor configure() {
		return new WebAppDescriptor.Builder().build();
	}

	@Test
	public void asdasd() {
		WebResource webResource = resource();
		String responseMsg = webResource.path("/rest/hello").get(String.class);
		assertEquals("Hello World", responseMsg);
		// Assert.assertEquals(1, 2);
	}

}
