package com.archu.gussoapintegration.gus.regon;

import com.archu.gus.regon.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;

@Configuration
public class RegonConfig {

    @Value("${soap.regon.user-key}")
    private String userKey;

    @Value("${soap.regon.api-url}")
    private String apiUrl;

    @Value("${soap.regon.marshaller-context-paths}")
    private String[] marshallerContextPaths;

    @Value("${soap.regon.client-default-uri}")
    private String clientDefaultUri;


    @Bean
    public Jaxb2Marshaller marshaller() {
        var marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in pom.xml
        marshaller.setContextPaths(marshallerContextPaths);
        return marshaller;
    }

    @Bean
    public RegonClient regonClient(Jaxb2Marshaller marshaller) throws SOAPException {
        var client = new RegonClient(apiUrl, userKey, new ObjectFactory());
        client.setDefaultUri(clientDefaultUri);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        var msgFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        var saajSoapMessageFactory = new SaajSoapMessageFactory(msgFactory);
        client.getWebServiceTemplate().setMessageFactory(saajSoapMessageFactory);
        return client;
    }

}
