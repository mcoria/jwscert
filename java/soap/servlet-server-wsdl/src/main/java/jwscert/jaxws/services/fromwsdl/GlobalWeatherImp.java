package jwscert.jaxws.services.fromwsdl;

//@WebService(endpointInterface="net.webservicex.GlobalWeatherSoap")
public class GlobalWeatherImp {
	
	//private GlobalWeatherSoap port = null;
	
	public GlobalWeatherImp() {
		//GlobalWeather service = new GlobalWeather();
		//port = service.getGlobalWeatherSoap();
	}

	//@Override
	//@WebMethod
	public String getWeather(String cityName, String countryName) {
		return "Hola"; //port.getWeather(cityName, countryName);
	}

	//@Override
	//@WebMethod
	public String getCitiesByCountry(String countryName) {
		return "Hola";
	}

}
