package com.archu.gussoapintegration.integration.regon;

import com.archu.gussoapintegration.integration.regon.fullreport.FullReportClient;
import com.archu.gussoapintegration.integration.regon.session.SessionClient;
import com.archu.gussoapintegration.integration.regon.session.SessionHolder;
import com.archu.gussoapintegration.integration.regon.subject.SubjectClient;
import com.archu.gussoapintegration.integration.regon.summaryreport.SummaryReportClient;
import com.gus.regon.wsdl.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

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
    public SaajSoapMessageFactory messageFactory() {
        var saajSoapMessageFactory = new SaajSoapMessageFactory();
        saajSoapMessageFactory.setSoapVersion(SoapVersion.SOAP_12);

        return saajSoapMessageFactory;
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }

    @Bean
    public SessionHolder sessionHolder() {
        return new SessionHolder();
    }

    @Bean
    public SummaryReportClient summaryReportClient(ObjectFactory objectFactory, SessionHolder sessionHolder, SaajSoapMessageFactory messageFactory, Jaxb2Marshaller marshaller) {
        var client = new SummaryReportClient(objectFactory, sessionHolder);
        client.setDefaultUri(apiEndpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.getWebServiceTemplate().setMessageFactory(messageFactory);
        return client;
    }

    @Bean
    public SessionClient sessionClient(ObjectFactory objectFactory, SessionHolder sessionHolder, SaajSoapMessageFactory messageFactory, Jaxb2Marshaller marshaller) {
        var client = new SessionClient(userKey, objectFactory, sessionHolder);
        client.setDefaultUri(apiEndpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.getWebServiceTemplate().setMessageFactory(messageFactory);
        return client;
    }

    @Bean
    public FullReportClient fullReportClient(ObjectFactory objectFactory, SessionHolder sessionHolder, SaajSoapMessageFactory messageFactory, Jaxb2Marshaller marshaller) {
        var client = new FullReportClient(objectFactory, sessionHolder);
        client.setDefaultUri(apiEndpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.getWebServiceTemplate().setMessageFactory(messageFactory);
        return client;
    }


    @Bean
    public SubjectClient subjectClient(ObjectFactory objectFactory, SessionHolder sessionHolder, SaajSoapMessageFactory messageFactory, Jaxb2Marshaller marshaller) {
        var client = new SubjectClient(objectFactory, sessionHolder);
        client.setDefaultUri(apiEndpoint);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.getWebServiceTemplate().setMessageFactory(messageFactory);
        return client;
    }

}
