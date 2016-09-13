package jwscert.jaxws.services.fromjava.exceptions;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class TestAppException {
	

	@Resource(name="c", type=java.lang.Object.class)
	private WebServiceContext context;
	
	@WebMethod
	public void testOperation(String str) throws MyAppException, Exception{
		if ("MyAppException".equals(str)){
			throw new MyAppException();
		}
		if ("RuntimeException".equals(str)){
			throw new RuntimeException("Esta es una exception");
		}
		if ("Exception".equals(str)){
			throw new Exception("Esta es una exception");
		}
		
		QName operation = (QName) context.getMessageContext().get(MessageContext.WSDL_OPERATION);
		
		System.out.println(operation);
	}
}
