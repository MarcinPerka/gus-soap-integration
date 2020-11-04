package com.archu.gussoapintegration.gus.regon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class RegonConfig {

    @Value("${soap.regon.service-url}")
    private String serviceUrl;

    @Value("${soap.regon.marshaller-context-path}")
    private String marshallerContextPath;

    @Value("${soap.regon.client-default-uri}")
    private String clientDefaultUri;


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in pom.xml
        marshaller.setContextPath(marshallerContextPath);
        return marshaller;
    }

    @Bean
    public RegonClient regonClient(Jaxb2Marshaller marshaller) {
        RegonClient client = new RegonClient(serviceUrl);
        client.setDefaultUri(clientDefaultUri);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
