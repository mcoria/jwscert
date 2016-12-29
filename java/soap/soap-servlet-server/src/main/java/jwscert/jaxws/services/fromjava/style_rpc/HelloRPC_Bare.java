package jwscert.jaxws.services.fromjava.style_rpc;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;

@WebService

/*
 * Esta combinacion no es posible: 
 * Incorrect usage of Annotation @javax.jws.soap.SOAPBinding(style=RPC, use=LITERAL, parameterStyle=BARE) 
 * ParameterStyle can only be WRAPPED with RPC Style Web service.
 */
//@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class HelloRPC_Bare {

	
	@Action(input="http://localhost/holaUnParametro_in",
			output="http://localhost/holaUnParametro_out")
	public String holaUnParametro(String parametro1) {
		return parametro1;
	}
	
	@Action(input="http://localhost/hola_in",
			output="http://localhost/hola_out")
	public String hola(String parametro1, String parametro2, int parametro3) {
		return parametro1;
	}

	
	@Oneway
	public void doOneWay(String param){
		if ("fail".equals(param)){
			throw new RuntimeException("failing");
		}
	}	
}
