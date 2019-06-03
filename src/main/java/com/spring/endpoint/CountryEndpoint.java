package com.spring.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.tirmizee.ws.countries.Country;
import com.tirmizee.ws.countries.GetCountryRequest;
import com.tirmizee.ws.countries.GetCountryResponse;

@Endpoint
public class CountryEndpoint {

	private static final String NAMESPACE_URI = "http://tirmizee.com/ws/countries";
	
	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        Country country = new Country();
        country.setCapital("11111111");
        country.setName("3333333333");
        response.setCountry(country);
        return response;
    }
	
}
