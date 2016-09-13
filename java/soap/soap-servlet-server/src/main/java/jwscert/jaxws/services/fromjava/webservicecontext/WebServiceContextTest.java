package jwscert.jaxws.services.fromjava.webservicecontext;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

//@Resource(name = "context", type = javax.xml.ws.WebServiceContext.class) // No funca
@WebService
public class WebServiceContextTest {
	
	@Resource(name = "context", type = javax.xml.ws.WebServiceContext.class)
	private WebServiceContext contextss;
	

	@WebMethod
	public void test() {

		WebServiceContext ctx = (WebServiceContext) lookup("java:comp/env/context");

		QName operation = (QName) ctx.getMessageContext().get(MessageContext.WSDL_SERVICE);

		System.out.println(operation);
	}

	private Object lookup(String objectName) {
		try {
			InitialContext jndi = new InitialContext();
			return jndi.lookup(objectName);
		} catch (NamingException ex) {
			throw new RuntimeException(ex);
		}
	}
}
