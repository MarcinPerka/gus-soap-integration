package com.archu.gussoapintegration.integration.regon;

import com.archu.gussoapintegration.gus.regon.ObjectFactory;
import com.archu.gussoapintegration.gus.regon.Zaloguj;
import com.archu.gussoapintegration.gus.regon.ZalogujResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class RegonClient extends WebServiceGatewaySupport {

        public ZalogujResponse getZaloguj(String pKluczUzytkownika){
            ObjectFactory objectFactory = new ObjectFactory();

            Zaloguj request = new Zaloguj();
            request.setPKluczUzytkownika(objectFactory.createZalogujPKluczUzytkownika(pKluczUzytkownika));

            log.debug("Requesting zaloguj for {}", pKluczUzytkownika);

            ZalogujResponse response = (ZalogujResponse) getWebServiceTemplate() .marshalSendAndReceive("http://localhost:8080/ws/zaloguj", request,
                    new SoapActionCallback(
                            "https://wyszukiwarkaregontest.stat.gov.pl/wsBIR/UslugaBIRzewnPubl.svc"));

            return response;
        }
}
