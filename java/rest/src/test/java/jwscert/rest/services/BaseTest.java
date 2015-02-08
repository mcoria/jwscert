package jwscert.rest.services;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.LowLevelAppDescriptor;

public abstract class BaseTest extends JerseyTest {


	@Override
	public WebResource resource() {
		return client().resource(getClientURI());
	}

	@Override
	protected AppDescriptor configure() {
		ResourceConfig rc = new DefaultResourceConfig();
		rc.add(new MyApplication());
		rc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
		
		ClientConfig cc = new DefaultClientConfig();
		cc.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
		cc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
		
		return new LowLevelAppDescriptor.Builder(rc).clientConfig(cc).build();
	};

	protected String getClientURI() {
		String port = System.getProperty("jersey.test.clientPort");
		if (port != null) {
			return "http://localhost:" + port;
		}
		return super.getBaseURI().toString();
	}
	
	
}
