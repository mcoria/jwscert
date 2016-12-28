package jwscert.jaxws.services;

import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

public class LogicalHandler2 implements LogicalHandler<LogicalMessageContext> {

	@Override
	public boolean handleMessage(LogicalMessageContext ctx) {
		if((boolean)ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
			System.out.println("LogicalHandler2.handleMessage() - outbound");
		}else {
			System.out.println("LogicalHandler2.handleMessage() - inbound");
		}
		return true;
	}

	@Override
	public boolean handleFault(LogicalMessageContext ctx) {
		if((boolean)ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
			System.out.println("LogicalHandler2.handleFault() - outbound");
		}else {
			System.out.println("LogicalHandler2.handleFault() - inbound");
		}
		return true;
	}

	@Override
	public void close(MessageContext ctx) {
		//System.out.println("LogicalHandler2.close()");
	}

}
