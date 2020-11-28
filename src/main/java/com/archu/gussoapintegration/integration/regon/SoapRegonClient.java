package com.archu.gussoapintegration.integration.regon;

import com.archu.gussoapintegration.integration.regon.model.subject.DaneSzukajPodmiotRoot;
import com.archu.gussoapintegration.integration.regon.model.summaryreport.*;
import com.archu.gussoapintegration.regon.fullreport.FullReportUnmarshalVisitorImpl;
import com.archu.gussoapintegration.regon.fullreport.FullReportSearchingParams;
import com.archu.gussoapintegration.regon.subject.SubjectSearchingParams;
import com.archu.gussoapintegration.regon.summaryreport.SummaryReportSearchingParams;
import com.gus.regon.wsdl.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.*;

@Slf4j
@RequiredArgsConstructor
public class SoapRegonClient extends WebServiceGatewaySupport {

    private final String USER_KEY;

    private final ObjectFactory factory;

    private final FullReportUnmarshalVisitorImpl fullReportUnmarshalVisitor;

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
                SoapRegonUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_ZALOGUJ, sessionId)
        );

        log.debug("Requesting for login sid");

        sessionId = zalogujResponse.getZalogujResult().getValue();

        return sessionId;
    }

    public List<DaneSzukajPodmiotRoot.DaneSzukajPodmiotData> getDaneSzukajPodmiot(SubjectSearchingParams searchingParams) {
        var daneSzukajPodmioty = new DaneSzukajPodmioty();
        ParametryWyszukiwania parametryWyszukiwania = createParametryWyszukiwania(searchingParams, factory);
        daneSzukajPodmioty.setPParametryWyszukiwania(factory.createDaneSzukajPodmiotyPParametryWyszukiwania(parametryWyszukiwania));

        log.debug("Requesting for subject with searching params: {}", searchingParams);
        var daneSzukajPodmiotyResponse = ((DaneSzukajPodmiotyResponse) getWebServiceTemplate().marshalSendAndReceive(daneSzukajPodmioty, SoapRegonUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_SZUKAJ_PODMIOTY, sessionId)))
                .getDaneSzukajPodmiotyResult()
                .getValue();

        var daneSzukajPodmiotRoot = SoapRegonUtils.unmarshal(daneSzukajPodmiotyResponse, DaneSzukajPodmiotRoot.class);
        return daneSzukajPodmiotRoot.getDane();
    }


    private ParametryWyszukiwania createParametryWyszukiwania(SubjectSearchingParams searchingParams, ObjectFactory factory) {
        var parametryWyszukiwania = new ParametryWyszukiwania();
        parametryWyszukiwania.setNip(factory.createParametryWyszukiwaniaNip(searchingParams.getNip()));
        parametryWyszukiwania.setKrs(factory.createParametryWyszukiwaniaKrs(searchingParams.getKrs()));
        parametryWyszukiwania.setRegon(factory.createParametryWyszukiwaniaRegon(searchingParams.getRegon()));
        parametryWyszukiwania.setRegony9Zn(factory.createParametryWyszukiwaniaRegony9Zn(searchingParams.getRegonsWith9Digits() != null ? String.join(",", searchingParams.getRegonsWith9Digits()) : null));
        parametryWyszukiwania.setRegony14Zn(factory.createParametryWyszukiwaniaRegony14Zn(searchingParams.getRegonsWith14Digits() != null ? String.join(",", searchingParams.getRegonsWith14Digits()) : null));
        parametryWyszukiwania.setKrsy(factory.createParametryWyszukiwaniaKrsy(searchingParams.getKrses() != null ? String.join(",", searchingParams.getKrses()) : null));
        parametryWyszukiwania.setNipy(factory.createParametryWyszukiwaniaNipy(searchingParams.getNips() != null ? String.join(",", searchingParams.getNips()) : null));
        return parametryWyszukiwania;
    }

    public Object getDanePobierzPelnyRaport(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = new DanePobierzPelnyRaport();
        danePobierzPelnyRaport.setPRegon(factory.createDanePobierzPelnyRaportPRegon(searchingParams.getRegon()));
        danePobierzPelnyRaport.setPNazwaRaportu(factory.createDanePobierzPelnyRaportPNazwaRaportu(searchingParams.getReportName().name()));

        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), searchingParams.getReportName());

        var danePobierzPelnyRaportResponse = ((DanePobierzPelnyRaportResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzPelnyRaport,
                SoapRegonUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_PELNY_RAPORT, sessionId)
        )).getDanePobierzPelnyRaportResult().getValue();
        
        return fullReportUnmarshalVisitor.process(searchingParams.getReportName(), danePobierzPelnyRaportResponse);
    }

    public Object getDanePobierzRaportZbiorczy(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = new DanePobierzRaportZbiorczy();
        danePobierzRaportZbiorczy.setPDataRaportu(factory.createDanePobierzRaportZbiorczyPDataRaportu(searchingParams.getDate().toString()));
        danePobierzRaportZbiorczy.setPNazwaRaportu(factory.createDanePobierzRaportZbiorczyPNazwaRaportu(searchingParams.getReportName().name()));

        log.debug("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), searchingParams.getReportName());

        var danePobierzRaportZbiorczyResponse = ((DanePobierzRaportZbiorczyResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzRaportZbiorczy,
                SoapRegonUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY, sessionId)
        )).getDanePobierzRaportZbiorczyResult().getValue();

        return switch (searchingParams.getReportName()) {
            case BIR11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych -> SoapRegonUtils.unmarshal(danePobierzRaportZbiorczyResponse, NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
            case BIR11AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych -> SoapRegonUtils.unmarshal(danePobierzRaportZbiorczyResponse, AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
            case BIR11SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych -> SoapRegonUtils.unmarshal(danePobierzRaportZbiorczyResponse, SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
            case BIR11NoweJednostkiLokalne -> SoapRegonUtils.unmarshal(danePobierzRaportZbiorczyResponse, NoweJednostkiLokalneRoot.class).getDane();
            case BIR11AktualizowaneJednostkiLokalne -> SoapRegonUtils.unmarshal(danePobierzRaportZbiorczyResponse, AktualizowaneJednostkiLokalneRoot.class).getDane();
            case BIR11JednostkiLokalneSkreslone -> SoapRegonUtils.unmarshal(danePobierzRaportZbiorczyResponse, SkresloneJednostkiLokalneRoot.class).getDane();
        };
    }


    @Scheduled(fixedRateString = "${soap.regon.session-refresh}")
    private void refreshSession() {
        log.debug("Refreshing session id");
        getZaloguj();
        log.debug("New session id: {}", sessionId);
    }
}
