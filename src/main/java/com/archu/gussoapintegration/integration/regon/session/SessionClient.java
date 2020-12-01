package com.archu.gussoapintegration.integration.regon.session;

import com.gus.regon.wsdl.ObjectFactory;
import com.gus.regon.wsdl.Zaloguj;
import com.gus.regon.wsdl.ZalogujResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.annotation.PostConstruct;

import static com.archu.gussoapintegration.integration.SoapUtils.prepareSoapActionCallback;
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
        var zaloguj = createZaloguj();
        log.debug("Requesting for login sid");
        sessionId = callZalogujEndpoint(zaloguj);
        return sessionId;
    }

    private String callZalogujEndpoint(Zaloguj zaloguj) {
        return ((ZalogujResponse) getWebServiceTemplate().marshalSendAndReceive(
                zaloguj, prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_ZALOGUJ, sessionId)
        )).getZalogujResult().getValue();
    }

    private Zaloguj createZaloguj() {
        var zaloguj = new Zaloguj();
        var pKluczUzytkownika = factory.createZalogujPKluczUzytkownika(USER_KEY);
        zaloguj.setPKluczUzytkownika(pKluczUzytkownika);
        return zaloguj;
    }

    @Scheduled(fixedRateString = "${soap.regon.session-refresh}")
    private void refreshSession() {
        log.debug("Refreshing session id");
        getZaloguj();
        log.debug("New session id: {}", sessionId);
    }
}
