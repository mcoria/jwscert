package jwscert.jaxws.services.fromwsdl;

import javax.jws.WebService;

import net.webservicex.GlobalWeather;


@WebService(serviceName="GlobalWeatherService", 
			portName="GlobalWeatherPort", 
			endpointInterface="net.webservicex.GlobalWeather",
			targetNamespace="http://www.webserviceX.NET",
			wsdlLocation = "WEB-INF/wsdl/globalweather.wsdl")
public class GlobalWeatherImp2 implements GlobalWeather{

	@Override
	public String getWeather(String cityName, String countryName) {
		return "GlobalWeatherImp2";
	}

	@Override
	public String getCitiesByCountry(String countryName) {
		return "GlobalWeatherImp2";
	}

}
