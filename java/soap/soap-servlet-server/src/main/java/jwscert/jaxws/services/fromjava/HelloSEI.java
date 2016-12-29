package jwscert.jaxws.services.fromjava;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;

@WebService

/*
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, 
			use = SOAPBinding.Use.LITERAL,  
			parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
*/ 
public interface HelloSEI {
	
	@Action(input="http://localhost/hola_in",
			output="http://localhost/hola_out")
	public String hola(String param);

	
	@Oneway
	public void doOneWay(String param);
}
