package jwscert.jaxws.services.fromwsdl;

import javax.jws.WebService;

import net.webservicex.GlobalWeatherSoap;

@WebService(wsdlLocation="WEB-INF/wsdl/globalweather.wsdl", targetNamespace="http://www.webserviceX.NET", serviceName="GlobalWeather", portName="GlobalWeatherSoap", endpointInterface="net.webservicex.GlobalWeatherSoap")
public class GlobalWeatherImp2 implements GlobalWeatherSoap {

	@Override
	public String getWeather(String cityName, String countryName) {
		return "Hola";
	}

	@Override
	public String getCitiesByCountry(String countryName) {
		return "Hola";
	}

}
