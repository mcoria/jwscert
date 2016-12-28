package jwscert.jaxws.services;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SOAPHandler2 implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext ctx) {
		if((boolean)ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
			System.out.println("SOAPHandler2.handleMessage() - outbound");	
		}else {
			System.out.println("SOAPHandler2.handleMessage() - inbound");
		}
		
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext ctx) {
		if((boolean)ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
			System.out.println("SOAPHandler2.handleFault() - outbound");	
		}else {
			System.out.println("SOAPHandler2.handleFault() - inbound");
		}
		return true;
	}

	@Override
	public void close(MessageContext ctx) {
		//System.out.println("SOAPHandler2.close()");
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("SOAPHandler2.getHeaders()");
		return null;
	}

}
