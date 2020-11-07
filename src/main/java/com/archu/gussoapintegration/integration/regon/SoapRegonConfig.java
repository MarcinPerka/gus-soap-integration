package com.archu.gussoapintegration.integration.regon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;

@Configuration
public class SoapRegonConfig {

    @Value("${soap.regon.user-key}")
    private String userKey;

    @Value("${soap.regon.api-endpoint}")
    private String apiEndpoint;

    @Value("${soap.regon.marshaller-context-paths}")
    private String[] marshallerContextPaths;

    @Bean
    public Jaxb2Marshaller marshaller() {
        var marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in pom.xml
        marshaller.setContextPaths(marshallerContextPaths);
        return marshaller;
    }

    @Bean
    public SaajSoapMessageFactory messageFactory() throws SOAPException {
        var messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        var saajSoapMessageFactory = new SaajSoapMessageFactory(messageFactory);
        saajSoapMessageFactory.setSoapVersion(SoapVersion.SOAP_12);

        return saajSoapMessageFactory;
    }


    @Bean
    public SoapRegonClient soapClient(Jaxb2Marshaller marshaller, SaajSoapMessageFactory messageFactory) throws SOAPException {
        var client = new SoapRegonClient(userKey);
        client.setDefaultUri(apiEndpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.getWebServiceTemplate().setMessageFactory(messageFactory);
        return client;
    }

}
