package com.archu.gussoapintegration.integration.regon.session;

import com.archu.gussoapintegration.integration.SoapUtils;
import com.gus.regon.wsdl.ObjectFactory;
import com.gus.regon.wsdl.Zaloguj;
import com.gus.regon.wsdl.ZalogujResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.annotation.PostConstruct;

import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.WSA_ACTION_ZALOGUJ;

@Slf4j
@RequiredArgsConstructor
public class SessionClient extends WebServiceGatewaySupport {

    private final String USER_KEY;

    private final ObjectFactory factory;

    @Getter
    private String sessionId;

    @PostConstruct
    public void init() {
        refreshSession();
    }

    public String getZaloguj() {
        var zaloguj = new Zaloguj();
        var pKluczUzytkownika = factory.createZalogujPKluczUzytkownika(USER_KEY);
        zaloguj.setPKluczUzytkownika(pKluczUzytkownika);

        var zalogujResponse = (ZalogujResponse) getWebServiceTemplate().marshalSendAndReceive(
                zaloguj,
                SoapUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_ZALOGUJ, sessionId)
        );

        log.debug("Requesting for login sid");

        sessionId = zalogujResponse.getZalogujResult().getValue();

        return sessionId;
    }

    @Scheduled(fixedRateString = "${soap.regon.session-refresh}")
    private void refreshSession() {
        log.debug("Refreshing session id");
        getZaloguj();
        log.debug("New session id: {}", sessionId);
    }
}
