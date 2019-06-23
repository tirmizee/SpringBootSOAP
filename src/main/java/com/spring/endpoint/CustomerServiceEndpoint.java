package com.spring.endpoint;

import java.math.BigInteger;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.tutorialflix.spring.types.v1.CreateCustomerRequest;
import com.tutorialflix.spring.types.v1.CreateCustomerResponse;

@Endpoint
public class CustomerServiceEndpoint {

	public static final String NAMESPACE_URI = "http://spring.tutorialflix.com/types/v1";
	
	@ResponsePayload
	@PayloadRoot(localPart = "createCustomerRequest", namespace = NAMESPACE_URI)
	public CreateCustomerResponse createCustomer(@RequestPayload CreateCustomerRequest request) {
		CreateCustomerResponse response = new CreateCustomerResponse();
		response.setCustomerID(BigInteger.ONE);
		response.setDetails(request.getCustomerName() + " " + request.getCustomerCity() + " " + request.getCustomerPhoneNumber());
		response.setStatus("SUCCESS");
		return response;
	}

	
}
