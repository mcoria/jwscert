package jwscert.jaxws.services.fromwsdl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import net.webservicex.GlobalWeatherSoap;

@WebService(serviceName="GlobalWeather", portName="GlobalWeatherSoap", endpointInterface="net.webservicex.GlobalWeatherSoap", targetNamespace="http://www.webserviceX.NET")
// wsdlLocation = "WEB-INF/wsdl/globalweather.wsdl", 
public class GlobalWeatherImp1 implements GlobalWeatherSoap {

	@Override
	@WebMethod
	public String getWeather(String cityName, String countryName) {
		return "Hola";
	}

	@Override
	@WebMethod
	public String getCitiesByCountry(String countryName) {
		return "Hola";
	}

}
