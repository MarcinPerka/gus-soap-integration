package com.archu.gussoapintegration.gus.regon;

import com.archu.gus.regon.ObjectFactory;
import com.archu.gus.regon.Zaloguj;
import com.archu.gus.regon.ZalogujResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.transport.TransportConstants;

import javax.xml.soap.MimeHeaders;

@Slf4j
@AllArgsConstructor
public class RegonClient extends WebServiceGatewaySupport {

    private String serviceUrl;

    public ZalogujResponse getZaloguj(String pKluczUzytkownika) {
        ObjectFactory objectFactory = new ObjectFactory();

        Zaloguj request = new Zaloguj();
        request.setPKluczUzytkownika(objectFactory.createZalogujPKluczUzytkownika(pKluczUzytkownika));

        log.info("Requesting zaloguj for {}", pKluczUzytkownika);

        ZalogujResponse response = (ZalogujResponse) getWebServiceTemplate().marshalSendAndReceive(serviceUrl, request,
                webServiceMessage -> {
                    SaajSoapMessage soapMessage = (SaajSoapMessage) webServiceMessage;
                    MimeHeaders headers = soapMessage.getSaajMessage().getMimeHeaders();
                    headers.addHeader(TransportConstants.HEADER_CONTENT_TYPE, "application/xop+xml");
                });

        return response;
    }
}
