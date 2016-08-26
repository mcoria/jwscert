package jwscert.jaxws.services;

import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class HolaSOAPHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext ctx) {
		if((boolean)ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
			System.out.println("HolaSOAPHandler.handleMessage() - outbound");	
		}else {
			System.out.println("HolaSOAPHandler.handleMessage() - inbound");
		}
		
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext ctx) {
		if((boolean)ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
			System.out.println("HolaSOAPHandler.handleMessage() - outbound");	
		}else {
			System.out.println("HolaSOAPHandler.handleMessage() - inbound");
		}
		return true;
	}

	@Override
	public void close(MessageContext ctx) {
		System.out.println("HolaSOAPHandler.close()");
	}

	@Override
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

}
