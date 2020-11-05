package com.archu.gussoapintegration.gus.regon;

import com.archu.gus.regon.ObjectFactory;
import com.archu.gus.regon.ZalogujResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

@Slf4j
@AllArgsConstructor
public class RegonClient extends WebServiceGatewaySupport {

    private String apiUrl;
    private String userKey;
    private ObjectFactory objectFactory;

    public ZalogujResponse getZaloguj() {
        var request = objectFactory.createZaloguj();
        request.setPKluczUzytkownika(objectFactory.createZalogujPKluczUzytkownika(userKey));

        log.info("Requesting zaloguj for {}", userKey);

        try {
            var response = (ZalogujResponse) getWebServiceTemplate().marshalSendAndReceive(apiUrl, request,
                    message -> {
                        var soapMessage = (SoapMessage) message;
                        soapMessage.setSoapAction("http://CIS/BIR/PUBL/2014/07/IUslugaBIRzewnPubl/ZalogujResponse");
                    });
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
