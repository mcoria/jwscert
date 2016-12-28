package jwscert.jaxws.services.fromwsdl;

import javax.jws.WebService;

import net.webservicex.GlobalWeather;

@WebService(serviceName="GlobalWeatherService", 
			portName="GlobalWeatherPort", 
			endpointInterface="net.webservicex.GlobalWeather",
			targetNamespace = "http://www.webserviceX.NET",
			wsdlLocation = "WEB-INF/wsdl/globalweather.wsdl"
			)
public class GlobalWeatherImp implements GlobalWeather {

	@Override
	public String getWeather(String cityName, String countryName) {
		return "GlobalWeatherImp0"; 
	}

	@Override
	public String getCitiesByCountry(String countryName) {
		return "GlobalWeatherImp0 " + countryName;
	}

}
