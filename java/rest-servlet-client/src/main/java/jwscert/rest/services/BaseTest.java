package jwscert.rest.services;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


public abstract class BaseTest {
	private static final String RESOURCES_ROOT = "/resources";

	private static final String SERVLET_CONTEXT = "/rest-servlet";
	
	private Client client = Client.create(configure());
	
	public WebResource resource() {
		return client.resource(getClientURI());
	}
	
	protected ClientConfig configure() {
		ClientConfig cc = new DefaultClientConfig();
		cc.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, Boolean.TRUE);
		cc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		return cc;
	};

	protected String getClientURI() {
		String host = System.getProperty("jersey.test.host", "localhost");
		String port = System.getProperty("jersey.test.port", Integer.toString(8088));
		return "http://" + host + ":" + port + SERVLET_CONTEXT + RESOURCES_ROOT;
	}
	
	
}
