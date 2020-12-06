package com.archu.gussoapintegration.integration.regon.session;

import com.gus.regon.wsdl.ObjectFactory;
import com.gus.regon.wsdl.Zaloguj;
import com.gus.regon.wsdl.ZalogujResponse;
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

    private final SessionHolder sessionHolder;

    @PostConstruct
    public void init() {
        refreshSession();
    }

    public String getZaloguj() {
        var zaloguj = createZaloguj();
        log.info("Requesting for session id");
        sessionHolder.setSessionId(callZalogujEndpoint(zaloguj));
        return sessionHolder.getSessionId();
    }

    private String callZalogujEndpoint(Zaloguj zaloguj) {
        return ((ZalogujResponse) getWebServiceTemplate().marshalSendAndReceive(
                zaloguj, prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_ZALOGUJ, sessionHolder.getSessionId())
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
        log.info("Refreshing session id");
        getZaloguj();
        log.info("New session id: {}", sessionHolder.getSessionId());
    }
}
