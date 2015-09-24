package eu.christophburmeister.playground.soapclient;

import eu.christophburmeister.playground.springboot.gen.CitiesPort;
import eu.christophburmeister.playground.springboot.gen.CitiesPortService;
import eu.christophburmeister.playground.springboot.gen.City;
import eu.christophburmeister.playground.springboot.gen.GetCityByCodeServiceRequest;
import eu.christophburmeister.playground.springboot.gen.GetCityByCodeServiceResponse;

public class Executor {

	public void execute() {

		GetCityByCodeServiceRequest request = new GetCityByCodeServiceRequest();

		for (int i=0; i<10; i++){
			request.setCode(16816);

			CitiesPortService citiesService = new CitiesPortService();
			CitiesPort port = citiesService.getCitiesPortSoap11();
			GetCityByCodeServiceResponse response = port.getCityByCodeService(request);
			City city = response.getCity();

			System.out.println(city.getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
