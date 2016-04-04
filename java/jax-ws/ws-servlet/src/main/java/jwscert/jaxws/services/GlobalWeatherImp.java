package jwscert.jaxws.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;



@WebService(endpointInterface="net.webservicex.GlobalWeatherSoap")
public class GlobalWeatherImp implements GlobalWeatherSoap{
	
	private GlobalWeatherSoap port = null;
	
	public GlobalWeatherImp() {
		GlobalWeather service = new GlobalWeather();
		port = service.getGlobalWeatherSoap();
	}

	@Override
	@WebMethod
	public String getWeather(String cityName, String countryName) {
		return "Hola"; //port.getWeather(cityName, countryName);
	}

	@Override
	@WebMethod
	public String getCitiesByCountry(String countryName) {
		return "Hola";
	}

}
