package com.example.demo.soap.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {
    @Bean
    Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this is the package name specified in the <generatePackage> specified in
    // pom.xml
    marshaller.setContextPath("com.example.xml.employer");
    return marshaller;
  }

    @Bean
    SOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
    SOAPConnector client = new SOAPConnector();
    client.setDefaultUri("http://localhost:8080/ws/employee-status");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }
}
