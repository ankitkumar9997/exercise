package com.example.demo.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.xml.employer.RegisterEmployeeRequest;
import com.example.xml.employer.RegisterEmployeeResponse;

@Endpoint
public class EmployeeEndpoint {
	private static final String NAMESPACE_URI = "http://example.com/xml/employer";

	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "RegisterEmployeeRequest")
	@ResponsePayload
    public RegisterEmployeeResponse registerEmployee(@RequestPayload RegisterEmployeeRequest request) {
    	RegisterEmployeeResponse response = new RegisterEmployeeResponse();
        response.setStatus("Employee registered: " + request.getName());
        return response;
    }
}
