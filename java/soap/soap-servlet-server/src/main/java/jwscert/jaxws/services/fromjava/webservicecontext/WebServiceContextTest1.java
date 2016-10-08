package jwscert.jaxws.services.fromjava.webservicecontext;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class WebServiceContextTest1 {
	

	@Resource(name="c", type=java.lang.Object.class)
	private WebServiceContext context;
	
	@WebMethod
	public void testOperation(String str){

		QName operation = (QName) (context.getMessageContext().get(MessageContext.WSDL_SERVICE));

		System.out.println(operation);		
		
	}
}
