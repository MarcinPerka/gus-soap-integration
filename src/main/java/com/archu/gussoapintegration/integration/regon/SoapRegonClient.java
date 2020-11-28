package com.archu.gussoapintegration.integration.regon;

import com.archu.gussoapintegration.integration.regon.model.fullreport.*;
import com.archu.gussoapintegration.integration.regon.model.subject.DaneSzukajPodmiotRoot;
import com.archu.gussoapintegration.integration.regon.model.summaryreport.*;
import com.archu.gussoapintegration.regon.searchingparams.*;
import com.gus.regon.wsdl.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

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

    public List<DaneSzukajPodmiotRoot.DaneSzukajPodmiotData> getDaneSzukajPodmiot(SubjectSearchingParams searchingParams) {
        var factory = new ObjectFactory();

        var daneSzukajPodmioty = new DaneSzukajPodmioty();
        ParametryWyszukiwania parametryWyszukiwania = createParametryWyszukiwania(searchingParams, factory);
        daneSzukajPodmioty.setPParametryWyszukiwania(factory.createDaneSzukajPodmiotyPParametryWyszukiwania(parametryWyszukiwania));

        log.debug("Requesting for subject with searching params: {}", searchingParams);
        var daneSzukajPodmiotyResponse = ((DaneSzukajPodmiotyResponse) getWebServiceTemplate().marshalSendAndReceive(daneSzukajPodmioty, SoapRegonUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_SZUKAJ_PODMIOTY, sessionId)))
                .getDaneSzukajPodmiotyResult()
                .getValue();

        var daneSzukajPodmiotRoot = unmarshal(daneSzukajPodmiotyResponse, DaneSzukajPodmiotRoot.class);
        return daneSzukajPodmiotRoot.getDane();
    }

    private <T> T unmarshal(String xml, Class<T> rootClass) {
        log.debug("Parsing xml to: {}", rootClass.toString());
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(rootClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (T) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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
        var factory = new ObjectFactory();

        var danePobierzPelnyRaport = new DanePobierzPelnyRaport();
        danePobierzPelnyRaport.setPRegon(factory.createDanePobierzPelnyRaportPRegon(searchingParams.getRegon()));
        danePobierzPelnyRaport.setPNazwaRaportu(factory.createDanePobierzPelnyRaportPNazwaRaportu(searchingParams.getReportName().name()));

        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), searchingParams.getReportName());

        var danePobierzPelnyRaportResponse = ((DanePobierzPelnyRaportResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzPelnyRaport,
                SoapRegonUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_PELNY_RAPORT, sessionId)
        )).getDanePobierzPelnyRaportResult().getValue();

        return switch (searchingParams.getReportName()) {
            case BIR11OsFizycznaDaneOgolne -> unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDaneOgolneRoot.class).getDane();
            case BIR11OsFizycznaDzialalnoscCeidg -> unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscCeidgRoot.class).getDane();
            case BIR11OsFizycznaDzialalnoscRolnicza -> unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscRolniczaRoot.class).getDane();
            case BIR11OsFizycznaDzialalnoscPozostala -> unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscPozostalaRoot.class).getDane();
            case BIR11OsFizycznaDzialalnoscSkreslonaDo20141108 -> unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscSkreslonaDo20141108Root.class).getDane();
            case BIR11OsFizycznaPkd -> unmarshal(danePobierzPelnyRaportResponse, OsFizycznaPkdRoot.class).getDane();
            case BIR11OsFizycznaListaJednLokalnych -> unmarshal(danePobierzPelnyRaportResponse, OsFizycznaListaJednLokalnychRoot.class).getDane();
            case BIR11JednLokalnaOsFizycznej -> unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsFizycznejRoot.class).getDane();
            case BIR11JednLokalnaOsFizycznejPkd -> unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsFizycznejPkdRoot.class).getDane();
            case BIR11OsPrawna -> unmarshal(danePobierzPelnyRaportResponse, OsPrawnaRoot.class).getDane();
            case BIR11OsPrawnaPkd -> unmarshal(danePobierzPelnyRaportResponse, OsPrawnaPkdRoot.class).getDane();
            case BIR11OsPrawnaListaJednLokalnych -> unmarshal(danePobierzPelnyRaportResponse, OsPrawnaListaJednLokalnychRoot.class).getDane();
            case BIR11JednLokalnaOsPrawnej -> unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsPrawnejRoot.class).getDane();
            case BIR11JednLokalnaOsPrawnejPkd -> unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsPrawnejPkdRoot.class).getDane();
            case BIR11OsPrawnaSpCywilnaWspolnicy -> unmarshal(danePobierzPelnyRaportResponse, OsPrawnaSpCywilnaWspolnicyRoot.class).getDane();
            case BIR11TypPodmiotu -> unmarshal(danePobierzPelnyRaportResponse, TypPodmiotuRoot.class).getDane();
        };
    }

    public Object getDanePobierzRaportZbiorczy(SummaryReportSearchingParams searchingParams) {
        var factory = new ObjectFactory();

        var danePobierzRaportZbiorczy = new DanePobierzRaportZbiorczy();
        danePobierzRaportZbiorczy.setPDataRaportu(factory.createDanePobierzRaportZbiorczyPDataRaportu(searchingParams.getDate().toString()));
        danePobierzRaportZbiorczy.setPNazwaRaportu(factory.createDanePobierzRaportZbiorczyPNazwaRaportu(searchingParams.getReportName().name()));

        log.debug("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), searchingParams.getReportName());

        var danePobierzRaportZbiorczyResponse = ((DanePobierzRaportZbiorczyResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzRaportZbiorczy,
                SoapRegonUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY, sessionId)
        )).getDanePobierzRaportZbiorczyResult().getValue();

        return switch (searchingParams.getReportName()) {
            case BIR11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych -> unmarshal(danePobierzRaportZbiorczyResponse, NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
            case BIR11AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych -> unmarshal(danePobierzRaportZbiorczyResponse, AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
            case BIR11SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych -> unmarshal(danePobierzRaportZbiorczyResponse, SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
            case BIR11NoweJednostkiLokalne -> unmarshal(danePobierzRaportZbiorczyResponse, NoweJednostkiLokalneRoot.class).getDane();
            case BIR11AktualizowaneJednostkiLokalne -> unmarshal(danePobierzRaportZbiorczyResponse, AktualizowaneJednostkiLokalneRoot.class).getDane();
            case BIR11JednostkiLokalneSkreslone -> unmarshal(danePobierzRaportZbiorczyResponse, SkresloneJednostkiLokalneRoot.class).getDane();
        };
    }


    @Scheduled(fixedRateString = "${soap.regon.session-refresh}")
    private void refreshSession() {
        log.debug("Refreshing session id");
        sessionId = getZaloguj().getZalogujResult().getValue();
        log.debug("New session id: {}", sessionId);
    }
}
