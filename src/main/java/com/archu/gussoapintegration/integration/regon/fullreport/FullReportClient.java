package com.archu.gussoapintegration.integration.regon.fullreport;

import com.archu.gussoapintegration.integration.regon.fullreport.model.*;
import com.archu.gussoapintegration.integration.regon.session.SessionClient;
import com.archu.gussoapintegration.regon.fullreport.FullReportSearchingParams;
import com.gus.regon.wsdl.DanePobierzPelnyRaport;
import com.gus.regon.wsdl.DanePobierzPelnyRaportResponse;
import com.gus.regon.wsdl.ObjectFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;

import static com.archu.gussoapintegration.integration.SoapUtils.prepareSoapActionCallback;
import static com.archu.gussoapintegration.integration.SoapUtils.unmarshal;
import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.WSA_ACTION_DANE_POBIERZ_PELNY_RAPORT;
import static com.archu.gussoapintegration.integration.regon.fullreport.FullReportName.*;

@Slf4j
@RequiredArgsConstructor
public class FullReportClient extends WebServiceGatewaySupport {


    private final ObjectFactory factory;

    private final SessionClient sessionClient;

    private DanePobierzPelnyRaport createDanePobierzPelnyRaport(FullReportSearchingParams searchingParams, FullReportName bir11TypPodmiotu) {
        var danePobierzPelnyRaport = new DanePobierzPelnyRaport();
        danePobierzPelnyRaport.setPRegon(factory.createDanePobierzPelnyRaportPRegon(searchingParams.getRegon()));
        danePobierzPelnyRaport.setPNazwaRaportu(factory.createDanePobierzPelnyRaportPNazwaRaportu(bir11TypPodmiotu.name()));
        return danePobierzPelnyRaport;
    }

    private String callDanePobierzPelnyRaportEndpoint(DanePobierzPelnyRaport danePobierzPelnyRaport) {
        return ((DanePobierzPelnyRaportResponse) getWebServiceTemplate()
                .marshalSendAndReceive(danePobierzPelnyRaport,
                        prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_PELNY_RAPORT, sessionClient.getSessionId())
                )).getDanePobierzPelnyRaportResult().getValue();
    }

    public OsFizycznaDaneOgolneRoot.OsFizycznaDaneOgolneData getOsFizycznaDaneOgolne(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11OsFizycznaDaneOgolne);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11OsFizycznaDaneOgolne.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDaneOgolneRoot.class).getDane();
    }

    public OsFizycznaDzialalnoscCeidgRoot.OsFizycznaDzialalnoscCeidgData getOsFizycznaDzialalnoscCeidg(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11OsFizycznaDzialalnoscCeidg);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11OsFizycznaDzialalnoscCeidg.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscCeidgRoot.class).getDane();
    }

    public OsFizycznaDzialalnoscRolniczaRoot.OsFizycznaDzialalnoscRolniczaData getOsFizycznaDzialalnoscRolnicza(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11OsFizycznaDzialalnoscRolnicza);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11OsFizycznaDzialalnoscRolnicza.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscRolniczaRoot.class).getDane();
    }

    public OsFizycznaDzialalnoscPozostalaRoot.OsFizycznaDzialalnoscPozostalaData getOsFizycznaDzialalnoscPozostala(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11OsFizycznaDzialalnoscPozostala);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11OsFizycznaDzialalnoscPozostala.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscPozostalaRoot.class).getDane();
    }

    public OsFizycznaDzialalnoscSkreslonaDo20141108Root.OsFizycznaDzialalnoscSkreslonaDo20141108Data getOsFizycznaDzialalnoscSkreslonaDo20141108(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11OsFizycznaDzialalnoscSkreslonaDo20141108);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11OsFizycznaDzialalnoscSkreslonaDo20141108.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscSkreslonaDo20141108Root.class).getDane();
    }

    public List<OsFizycznaPkdRoot.OsFizycznaPkdData> getOsFizycznaPkd(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11OsFizycznaPkd);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11OsFizycznaPkd.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaPkdRoot.class).getDane();
    }

    public List<OsFizycznaListaJednLokalnychRoot.OsFizycznaListaJednLokalnychData> getOsFizycznaListaJednLokalnych(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11OsFizycznaListaJednLokalnych);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11OsFizycznaListaJednLokalnych.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaListaJednLokalnychRoot.class).getDane();
    }

    public JednLokalnaOsFizycznejRoot.JednLokalnaOsFizycznejData getJednLokalnaOsFizycznej(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11JednLokalnaOsFizycznej);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11JednLokalnaOsFizycznej.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsFizycznejRoot.class).getDane();
    }

    public List<JednLokalnaOsFizycznejPkdRoot.JednLokalnaOsFizycznejPkdData> getJednLokalnaOsFizycznejPkd(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11JednLokalnaOsFizycznejPkd);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11JednLokalnaOsFizycznejPkd.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsFizycznejPkdRoot.class).getDane();
    }

    public OsPrawnaRoot.OsPrawnaData getOsPrawna(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11OsPrawna);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11OsPrawna.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsPrawnaRoot.class).getDane();
    }

    public List<OsPrawnaPkdRoot.OsPrawnaPkdData> getOsPrawnaPkd(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11OsPrawnaPkd);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11OsPrawnaPkd.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsPrawnaPkdRoot.class).getDane();
    }

    public List<OsPrawnaListaJednLokalnychRoot.OsPrawnaListaJednLokalnychData> getOsPrawnaListaJednLokalnych(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11OsPrawnaListaJednLokalnych);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11OsPrawnaListaJednLokalnych.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsPrawnaListaJednLokalnychRoot.class).getDane();
    }

    public JednLokalnaOsPrawnejRoot.JednLokalnaOsPrawnejData getJednLokalnaOsPrawnej(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11JednLokalnaOsPrawnej);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11JednLokalnaOsPrawnej.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsPrawnejRoot.class).getDane();
    }

    public List<JednLokalnaOsPrawnejPkdRoot.JednLokalnaOsPrawnejPkdData> getJednLokalnaOsPrawnejPkd(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11JednLokalnaOsPrawnejPkd);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11JednLokalnaOsPrawnejPkd.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsPrawnejPkdRoot.class).getDane();
    }

    public List<OsPrawnaSpCywilnaWspolnicyRoot.OsPrawnaSpCywilnaWspolnicyDane> getOsPrawnaSpCywilnaWspolnicy(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11OsPrawnaSpCywilnaWspolnicy);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11OsPrawnaSpCywilnaWspolnicy.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsPrawnaSpCywilnaWspolnicyRoot.class).getDane();
    }

    public TypPodmiotuRoot.TypPodmiotuData getTypPodmiotu(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, BIR11TypPodmiotu);
        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), BIR11TypPodmiotu.name());
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, TypPodmiotuRoot.class).getDane();
    }
}