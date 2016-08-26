package jwscert.jaxws.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.junit.Test;

import jwscert.jaxws.services.generated.Hola;
import jwscert.jaxws.services.generated.HolaService;

public class HolaClientTest {
	
	//@Test
	public void test(){
		try {
			URL url = new URL("http://d-mauricioca:8080/soap-handlers/HolaService?wsdl");
			
			HolaService holaService = new HolaService(url);
			holaService.setHandlerResolver(new HandlerResolver() {
				
				@SuppressWarnings("rawtypes")
				@Override
				public List<Handler> getHandlerChain(PortInfo portInfo) {
					List<Handler> chain = new ArrayList<Handler>();
					chain.add(new HolaLogicalHandler());
					chain.add(new HolaSOAPHandler());
					return chain;
				}
			});

			Hola holaPort = holaService.getHolaServicePort();
			
			System.out.print(holaPort.test("TEST"));
			
		} catch (MalformedURLException e) {
			System.out.print(e);
		}
	}

}
