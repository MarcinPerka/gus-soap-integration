package com.archu.gussoapintegration.integration.regon;

import com.gus.regon.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.annotation.PostConstruct;

import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.*;

@Slf4j
@RequiredArgsConstructor
public class SoapRegonClient extends WebServiceGatewaySupport {

    private final String USER_KEY;

    private String sessionId = "";


    @PostConstruct
    public void init() {
        refreshSession();
    }

    public ZalogujResponse getZaloguj() {
        var factory = new ObjectFactory();

        var zaloguj = new Zaloguj();
        var pKluczUzytkownika = factory.createZalogujPKluczUzytkownika(USER_KEY);
        zaloguj.setPKluczUzytkownika(pKluczUzytkownika);

        var zalogujResponse = (ZalogujResponse) getWebServiceTemplate().marshalSendAndReceive(
                zaloguj,
                SoapRegonUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_ZALOGUJ, sessionId)
        );

        log.debug("Requesting for login sid");

        sessionId = zalogujResponse.getZalogujResult().getValue();

        return zalogujResponse;
    }

    public DaneSzukajPodmiotyResponse getDaneSzukajPodmiot(String nip) {
        var factory = new ObjectFactory();

        var daneSzukajPodmioty = new DaneSzukajPodmioty();
        var parametryWyszukiwania = new ParametryWyszukiwania();
        parametryWyszukiwania.setNip(factory.createParametryWyszukiwaniaNip(nip));
        daneSzukajPodmioty.setPParametryWyszukiwania(factory.createDaneSzukajPodmiotyPParametryWyszukiwania(parametryWyszukiwania));

        log.debug("Requesting for subject with nip: {}", nip);

        return (DaneSzukajPodmiotyResponse) getWebServiceTemplate().marshalSendAndReceive(
                daneSzukajPodmioty,
                SoapRegonUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_SZUKAJ_PODMIOTY, sessionId)
        );
    }

    public DanePobierzPelnyRaportResponse getDanePobierzPelnyRaport(String regon, String reportName) {
        var factory = new ObjectFactory();

        var danePobierzPelnyRaport = new DanePobierzPelnyRaport();
        danePobierzPelnyRaport.setPRegon(factory.createDanePobierzPelnyRaportPRegon(regon));
        danePobierzPelnyRaport.setPNazwaRaportu(factory.createDanePobierzPelnyRaportPNazwaRaportu(reportName));

        log.debug("Requesting for full report with regon: {} and report name: {}", regon, reportName);

        return (DanePobierzPelnyRaportResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzPelnyRaport,
                SoapRegonUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_PELNY_RAPORT, sessionId)
        );
    }



    @Scheduled(fixedRateString = "${soap.regon.session-refresh}")
    private void refreshSession() {
        log.debug("Refreshing session id");
        sessionId = getZaloguj().getZalogujResult().getValue();
        log.debug("New session id: {}", sessionId);
    }
}
