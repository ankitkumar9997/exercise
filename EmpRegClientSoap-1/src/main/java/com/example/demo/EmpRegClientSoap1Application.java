package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.soap.client.SOAPConnector;
import com.example.xml.employer.RegisterEmployeeRequest;
import com.example.xml.employer.RegisterEmployeeResponse;

@SpringBootApplication
public class EmpRegClientSoap1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmpRegClientSoap1Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			String name = "Lokesh"; // Default Name
//			if (args.length > 0) {
//				name = args[0];
//			}
			RegisterEmployeeRequest request = new RegisterEmployeeRequest();
			request.setName(name);
			RegisterEmployeeResponse response = (RegisterEmployeeResponse) soapConnector
					.callWebService("http://localhost:8080/ws/employee-status", request);
			System.out.println("Got Response As below ========= : ");
			System.out.println("Name : " + response.getStatus());
		};
	}

}
