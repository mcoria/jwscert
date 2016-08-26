package jwscert.jaxws.services;

import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

public class HolaLogicalHandler implements LogicalHandler<LogicalMessageContext> {

	@Override
	public boolean handleMessage(LogicalMessageContext ctx) {
		if((boolean)ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
			System.out.println("HolaLogical.handleMessage() - outbound");	
		}else {
			System.out.println("HolaLogical.handleMessage() - inbound");
		}
		
		return true;
	}

	@Override
	public boolean handleFault(LogicalMessageContext ctx) {
		if((boolean)ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
			System.out.println("HolaLogical.handleMessage() - outbound");	
		}else {
			System.out.println("HolaLogical.handleMessage() - inbound");
		}
		return true;
	}

	@Override
	public void close(MessageContext ctx) {
		System.out.println("HolaLogical.close()");
	}

}
