
package eu.christophburmeister.playground.soapclient;


import javax.xml.ws.BindingProvider;

import eu.christophburmeister.playground.schema.cities.GetCityByCodeRequest;
import eu.christophburmeister.playground.schema.cities.GetCityByCodeResponse;
import eu.christophburmeister.playground.schema.cities.GetCountryByCityNameRequest;
import eu.christophburmeister.playground.schema.cities.GetCountryByCityNameResponse;
import eu.christophburmeister.playground.schema.cities.Cities;
import eu.christophburmeister.playground.schema.cities.CitiesService;

public final class Executor {

	private String endpointAdress;
	
    public void execute() {
              
        CitiesService ss = new CitiesService();
        Cities port = ss.getCitiesSoap11();  

		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAdress);
        
		// creating the requests        
        GetCityByCodeRequest getCityByCodeRequest = new GetCityByCodeRequest();
        GetCountryByCityNameRequest getCountryByCityNameRequest = new GetCountryByCityNameRequest();
        
        // enriching the requests
        getCityByCodeRequest.setCode(16816);
        getCountryByCityNameRequest.setCityName("Neuruppin");
        
        // invoking the requests and fetching the responses                    
        GetCityByCodeResponse getCityByCodeResponse = port.getCityByCode(getCityByCodeRequest);
        GetCountryByCityNameResponse getCountryByCityNameResponse = port.getCountryByCityName(getCountryByCityNameRequest);
             
        // 
        System.out.println(getCityByCodeResponse.getCity().getName());
        System.out.println(getCountryByCityNameResponse.getCountry());
        


    }

	public String getEndpointAdress() {
		return endpointAdress;
	}

	public void setEndpointAdress(String endpointAdress) {
		this.endpointAdress = endpointAdress;
	}
}
