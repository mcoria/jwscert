package jwscert.jaxws.services.fromwsdl;

import javax.jws.WebService;

import net.webservicex.GlobalWeather;

@WebService(serviceName="GlobalWeatherService1", portName="GlobalWeatherPort1", endpointInterface="net.webservicex.GlobalWeather", targetNamespace="http://www.webserviceX.NET")
public class GlobalWeatherImp1 implements GlobalWeather {

	@Override
	public String getWeather(String cityName, String countryName) {
		return "GlobalWeatherImp1";
	}

	@Override
	public String getCitiesByCountry(String countryName) {
		return "GlobalWeatherImp1";
	}

}
