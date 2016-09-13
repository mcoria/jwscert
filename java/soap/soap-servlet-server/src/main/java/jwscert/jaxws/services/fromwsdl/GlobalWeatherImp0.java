package jwscert.jaxws.services.fromwsdl;

import javax.jws.WebService;

import net.webservicex.GlobalWeather;

@WebService(serviceName="GlobalWeatherService0", portName="GlobalWeatherPort0", endpointInterface="net.webservicex.GlobalWeather")
public class GlobalWeatherImp0 implements GlobalWeather {

	@Override
	public String getWeather(String cityName, String countryName) {
		return "GlobalWeatherImp0"; 
	}

	@Override
	public String getCitiesByCountry(String countryName) {
		return "GlobalWeatherImp0";
	}

}
