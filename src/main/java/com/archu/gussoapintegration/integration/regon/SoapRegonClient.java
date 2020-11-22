package com.archu.gussoapintegration.integration.regon;

import com.archu.gussoapintegration.integration.regon.model.DaneSzukajPodmiotRoot;
import com.archu.gussoapintegration.regon.searchingparams.FullReportSearchingParams;
import com.archu.gussoapintegration.regon.searchingparams.SubjectSearchingParams;
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
        var daneSzukajPodmiotyResponse =  ((DaneSzukajPodmiotyResponse) getWebServiceTemplate().marshalSendAndReceive(daneSzukajPodmioty, SoapRegonUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_SZUKAJ_PODMIOTY, sessionId)))
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
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private ParametryWyszukiwania createParametryWyszukiwania(SubjectSearchingParams searchingParams, ObjectFactory factory) {
        var parametryWyszukiwania = new ParametryWyszukiwania();
        if (searchingParams.getNip() != null)
            parametryWyszukiwania.setNip(factory.createParametryWyszukiwaniaNip(searchingParams.getNip()));
        if (searchingParams.getKrs() != null)
            parametryWyszukiwania.setKrs(factory.createParametryWyszukiwaniaKrs(searchingParams.getKrs()));
        if (searchingParams.getRegon() != null)
            parametryWyszukiwania.setRegon(factory.createParametryWyszukiwaniaRegon(searchingParams.getRegon()));
        if (searchingParams.getRegonsWith9Digits() != null)
            parametryWyszukiwania.setRegony9Zn(factory.createParametryWyszukiwaniaRegony9Zn(String.join(",", searchingParams.getRegonsWith9Digits())));
        if (searchingParams.getRegonsWith14Digits() != null)
            parametryWyszukiwania.setRegon(factory.createParametryWyszukiwaniaRegony14Zn(String.join(",", searchingParams.getRegonsWith14Digits())));
        if (searchingParams.getKrses() != null)
            parametryWyszukiwania.setRegon(factory.createParametryWyszukiwaniaKrsy(String.join(",", searchingParams.getKrses())));
        if (searchingParams.getNips() != null)
            parametryWyszukiwania.setRegon(factory.createParametryWyszukiwaniaNipy(String.join(",", searchingParams.getNips())));
        return parametryWyszukiwania;
    }

    public DanePobierzPelnyRaportResponse getDanePobierzPelnyRaport(FullReportSearchingParams searchingParams) {
        var factory = new ObjectFactory();

        var danePobierzPelnyRaport = new DanePobierzPelnyRaport();
        danePobierzPelnyRaport.setPRegon(factory.createDanePobierzPelnyRaportPRegon(searchingParams.getRegon()));
        danePobierzPelnyRaport.setPNazwaRaportu(factory.createDanePobierzPelnyRaportPNazwaRaportu(searchingParams.getFullReportName()));

        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), searchingParams.getFullReportName());

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
