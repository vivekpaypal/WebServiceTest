package com.test.webservice.freelance;

import javax.xml.ws.WebServiceRef;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cdyne.ws.weatherws.ForecastReturn;
import com.cdyne.ws.weatherws.Weather;
import com.cdyne.ws.weatherws.WeatherSoap;

public class WebServiceClient {
	
	
	@WebServiceRef(wsdlLocation="http://wsf.cdyne.com/WeatherWS/Weather.asmx?wsdl")
    private static Weather service;
	private static WebServiceClient client;

	@BeforeClass
	public void initService(){
		service =new Weather();
		
	}
	
	
	@Test
    public void testWeatherServiceByZipCode(){
      
        	client = new WebServiceClient();
            client.doTest();
       
    }

    public void doTest() {
        try {
        	
        	WeatherSoap port = service.getWeatherSoap();
            System.out.println("Retrieving the port from the following service: " + service.getServiceName());
            ForecastReturn result = port.getCityForecastByZIP("94304");
            

            System.out.println(result.getResponseText());	
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
