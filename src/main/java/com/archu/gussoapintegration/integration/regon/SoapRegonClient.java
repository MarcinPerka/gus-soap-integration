package com.archu.gussoapintegration.integration.regon;

import com.gus.regon.ObjectFactory;
import com.gus.regon.Zaloguj;
import com.gus.regon.ZalogujResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.WSA_ACTION_ZALOGUJ;

@Slf4j
@AllArgsConstructor
public class SoapRegonClient extends WebServiceGatewaySupport {

    private String userKey;

    public ZalogujResponse getZaloguj() {
        var factory = new ObjectFactory();

        var zaloguj = new Zaloguj();
        var pKluczUzytkownika = factory.createZalogujPKluczUzytkownika(userKey);
        zaloguj.setPKluczUzytkownika(pKluczUzytkownika);

        return (ZalogujResponse) getWebServiceTemplate().marshalSendAndReceive(
                zaloguj,
                SoapRegonUtils.prepareSoapActionCallback(getWebServiceTemplate(), WSA_ACTION_ZALOGUJ)
        );
    }
}
