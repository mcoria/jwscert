package jwscert.jaxws.services.fromwsdl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import net.webservicex.GlobalWeatherSoap;

@WebService(serviceName="GlobalWeather", portName="GlobalWeatherSoap", endpointInterface="net.webservicex.GlobalWeatherSoap")
public class GlobalWeatherImp0 implements GlobalWeatherSoap {

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
