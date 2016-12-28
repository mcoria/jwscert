package jwscert.jaxws.services;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import jwscert.jaxws.services.generated.Hola;
import jwscert.jaxws.services.generated.HolaService;

//@Ignore
public class HolaImpTest {
	
	private HolaService holaService;
			
	@Before
	public void setUp(){
		try {		
		URL url = new URL("http://localhost:8080/soap-handlers/HolaService?wsdl");
		
		holaService = new HolaService(url);
		
		} catch (MalformedURLException e) {
			System.out.print(e);
		}		
	}
	
	/*
	 * Observar como del lado del cliente programaticamente se utiliza
	 * Service.setHandlerResolver(new HandlerResolver(){...})
	 */
	@Test
	public void testSetHandlerResolver() {

		holaService.setHandlerResolver(new HandlerResolver() {
			@SuppressWarnings("rawtypes")
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> chain = new ArrayList<Handler>();
				chain.add(new LogicalHandler1());
				chain.add(new SOAPHandler1());
				chain.add(new LogicalHandler2());
				chain.add(new SOAPHandler2());
				return chain;
			}
		});

		System.out.println("Creando puerto");

		Hola holaPort = holaService.getHolaServicePort();

		System.out.println("Enviando mensaje");

		holaPort.test("JA");

		System.out.println("Respuesta recibida");

	}

	
	/*
	 * Observar como del lado del cliente programaticamente se utiliza
	 * binding.setHandlerChain(chain);
	 */
	@Test
	public void testSetHandlerChain() {

		System.out.println("Creando puerto");

		Hola holaPort = holaService.getHolaServicePort();

		BindingProvider bindingProvider = (BindingProvider) holaPort;

		Binding binding = bindingProvider.getBinding();

		List<Handler> chain = new ArrayList<Handler>();
		chain.add(new LogicalHandler1());
		chain.add(new SOAPHandler1());
		chain.add(new LogicalHandler2());
		chain.add(new SOAPHandler2());

		binding.setHandlerChain(chain);

		System.out.println("Enviando mensaje");

		holaPort.test("JA");

		System.out.println("Respuesta recibida");

	}
	
	
	@Test
	public void testFail(){
		
		System.out.println("Creando puerto");

		Hola holaPort = holaService.getHolaServicePort();

		BindingProvider bindingProvider = (BindingProvider) holaPort;

		Binding binding = bindingProvider.getBinding();

		List<Handler> chain = new ArrayList<Handler>();
		chain.add(new LogicalHandler1());
		chain.add(new SOAPHandler1());
		chain.add(new LogicalHandler2());
		chain.add(new SOAPHandler2());

		binding.setHandlerChain(chain);

		System.out.println("Enviando mensaje");

		holaPort.test("fail");

		System.out.println("Respuesta recibida");
	}	
	
}
