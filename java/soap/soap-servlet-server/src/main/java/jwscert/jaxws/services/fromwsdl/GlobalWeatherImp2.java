package jwscert.jaxws.services.fromwsdl;

import javax.jws.WebService;

import net.webservicex.GlobalWeather;


@WebService(
wsdlLocation = "WEB-INF/wsdl/globalweather.wsdl",
serviceName="GlobalWeatherService", 
portName="GlobalWeatherPort", 
endpointInterface="net.webservicex.GlobalWeather",
targetNamespace="http://www.webserviceX.NET")
public class GlobalWeatherImp2 implements GlobalWeather{

	@Override
	public String getWeather(String cityName, String countryName) {
		return "Hola";
	}

	@Override
	public String getCitiesByCountry(String countryName) {
		return "Hola";
	}

}
