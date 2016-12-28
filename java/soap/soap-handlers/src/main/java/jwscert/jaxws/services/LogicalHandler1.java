package jwscert.jaxws.services;

import javax.xml.transform.Source;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

public class LogicalHandler1 implements LogicalHandler<LogicalMessageContext> {

	@Override
	public boolean handleMessage(LogicalMessageContext ctx) {
		if((boolean)ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
			System.out.println("LogicalHandler1.handleMessage() - outbound");
		}else {
			System.out.println("LogicalHandler1.handleMessage() - inbound");
		}
		
		LogicalMessage lmsj = ctx.getMessage();
		
		Source payload = lmsj.getPayload();
		
		return true;
	}

	@Override
	public boolean handleFault(LogicalMessageContext ctx) {
		if((boolean)ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
			System.out.println("LogicalHandler1.handleFault() - outbound");
		}else {
			System.out.println("LogicalHandler1.handleFault() - inbound");
		}
		return true;
	}

	@Override
	public void close(MessageContext ctx) {
		//System.out.println("LogicalHandler1.close()");
	}

}
