package com.test.webservice.freelance;

import javax.xml.ws.WebServiceRef;

import com.cdyne.ws.weatherws.ForecastReturn;
import com.cdyne.ws.weatherws.Weather;
import com.cdyne.ws.weatherws.WeatherSoap;

public class WebServiceClient {
	
	
	@WebServiceRef(wsdlLocation="http://wsf.cdyne.com/WeatherWS/Weather.asmx?wsdl")
    static Weather service = new Weather();

    public static void main(String[] args§) {
        try {
        	WebServiceClient client = new WebServiceClient();
            client.doTest();
        } catch(Exception e) {
            e.printStackTrace();
        }
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
