package com.spring.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.tirmizee.ws.user.GetUserRequest;
import com.tirmizee.ws.user.GetUserResponse;
import com.tirmizee.ws.user.User;

@Endpoint
public class UserEndpoint {

	private static final String NAMESPACE_URI = "http://tirmizee.com/ws/user";
	
	@ResponsePayload
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    public GetUserResponse getCountry(@RequestPayload GetUserRequest request) {
		
		User user = new User();
		user.setCitizenId("19002000");
		user.setEmail("zee_pratya");
		user.setFirstName("tirmizee");
		
		GetUserResponse response = new GetUserResponse();
		response.setMessageCode("MS001");
		response.setMessageDesc("RRRR");
		response.setDetail(user);
        return response;
    }
	
}
