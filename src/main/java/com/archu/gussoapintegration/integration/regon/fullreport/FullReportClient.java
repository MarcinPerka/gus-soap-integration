package com.archu.gussoapintegration.integration.regon.fullreport;

import com.archu.gussoapintegration.api.regon.fullreport.FullReportSearchingParams;
import com.archu.gussoapintegration.exception.ResourceNotFoundException;
import com.archu.gussoapintegration.integration.regon.fullreport.model.*;
import com.archu.gussoapintegration.integration.regon.session.SessionHolder;
import com.gus.regon.wsdl.DanePobierzPelnyRaport;
import com.gus.regon.wsdl.DanePobierzPelnyRaportResponse;
import com.gus.regon.wsdl.ObjectFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;
import java.util.Optional;

import static com.archu.gussoapintegration.integration.SoapUtils.prepareSoapActionCallback;
import static com.archu.gussoapintegration.integration.SoapUtils.unmarshal;
import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.WSA_ACTION_DANE_POBIERZ_PELNY_RAPORT;

@Slf4j
@RequiredArgsConstructor
public class FullReportClient extends WebServiceGatewaySupport {


    private final ObjectFactory factory;

    private final SessionHolder sessionHolder;

    private enum FullReportName {
        BIR11OsFizycznaDaneOgolne,
        BIR11OsFizycznaDzialalnoscCeidg,
        BIR11OsFizycznaDzialalnoscRolnicza,
        BIR11OsFizycznaDzialalnoscPozostala,
        BIR11OsFizycznaDzialalnoscSkreslonaDo20141108,
        BIR11OsFizycznaPkd,
        BIR11OsFizycznaListaJednLokalnych,
        BIR11JednLokalnaOsFizycznej,
        BIR11JednLokalnaOsFizycznejPkd,
        BIR11OsPrawna,
        BIR11OsPrawnaPkd,
        BIR11OsPrawnaListaJednLokalnych,
        BIR11JednLokalnaOsPrawnej,
        BIR11JednLokalnaOsPrawnejPkd,
        BIR11OsPrawnaSpCywilnaWspolnicy,
        BIR11TypPodmiotu
    }


    private DanePobierzPelnyRaport createDanePobierzPelnyRaport(FullReportSearchingParams searchingParams, FullReportName bir11TypPodmiotu) {
        var danePobierzPelnyRaport = new DanePobierzPelnyRaport();
        danePobierzPelnyRaport.setPRegon(factory.createDanePobierzPelnyRaportPRegon(searchingParams.getRegon()));
        danePobierzPelnyRaport.setPNazwaRaportu(factory.createDanePobierzPelnyRaportPNazwaRaportu(bir11TypPodmiotu.name()));
        return danePobierzPelnyRaport;
    }

    private String callDanePobierzPelnyRaportEndpoint(DanePobierzPelnyRaport danePobierzPelnyRaport) {
        var optionalResponse = Optional.of(getWebServiceTemplate()
                .marshalSendAndReceive(danePobierzPelnyRaport,
                        prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_PELNY_RAPORT, sessionHolder.getSessionId())
                ));

        return optionalResponse.map(response -> ((DanePobierzPelnyRaportResponse) response).getDanePobierzPelnyRaportResult().getValue())
                .orElseThrow(ResourceNotFoundException::new);
    }

    public OsFizycznaDaneOgolneRoot.OsFizycznaDaneOgolneData getOsFizycznaDaneOgolne(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11OsFizycznaDaneOgolne);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsFizycznaDaneOgolne);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDaneOgolneRoot.class).getDane();
    }

    public OsFizycznaDzialalnoscCeidgRoot.OsFizycznaDzialalnoscCeidgData getOsFizycznaDzialalnoscCeidg(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11OsFizycznaDzialalnoscCeidg);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsFizycznaDzialalnoscCeidg);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscCeidgRoot.class).getDane();
    }

    public OsFizycznaDzialalnoscRolniczaRoot.OsFizycznaDzialalnoscRolniczaData getOsFizycznaDzialalnoscRolnicza(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11OsFizycznaDzialalnoscRolnicza);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsFizycznaDzialalnoscRolnicza);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscRolniczaRoot.class).getDane();
    }

    public OsFizycznaDzialalnoscPozostalaRoot.OsFizycznaDzialalnoscPozostalaData getOsFizycznaDzialalnoscPozostala(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11OsFizycznaDzialalnoscPozostala);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsFizycznaDzialalnoscPozostala);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscPozostalaRoot.class).getDane();
    }

    public OsFizycznaDzialalnoscSkreslonaDo20141108Root.OsFizycznaDzialalnoscSkreslonaDo20141108Data getOsFizycznaDzialalnoscSkreslonaDo20141108(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11OsFizycznaDzialalnoscSkreslonaDo20141108);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsFizycznaDzialalnoscSkreslonaDo20141108);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDzialalnoscSkreslonaDo20141108Root.class).getDane();
    }

    public List<OsFizycznaPkdRoot.OsFizycznaPkdData> getOsFizycznaPkd(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11OsFizycznaPkd);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsFizycznaPkd);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaPkdRoot.class).getDane();
    }

    public List<OsFizycznaListaJednLokalnychRoot.OsFizycznaListaJednLokalnychData> getOsFizycznaListaJednLokalnych(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11OsFizycznaListaJednLokalnych);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsFizycznaListaJednLokalnych);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsFizycznaListaJednLokalnychRoot.class).getDane();
    }

    public JednLokalnaOsFizycznejRoot.JednLokalnaOsFizycznejData getJednLokalnaOsFizycznej(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11JednLokalnaOsFizycznej);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11JednLokalnaOsFizycznej);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsFizycznejRoot.class).getDane();
    }

    public List<JednLokalnaOsFizycznejPkdRoot.JednLokalnaOsFizycznejPkdData> getJednLokalnaOsFizycznejPkd(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11JednLokalnaOsFizycznejPkd);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11JednLokalnaOsFizycznejPkd);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsFizycznejPkdRoot.class).getDane();
    }

    public OsPrawnaRoot.OsPrawnaData getOsPrawna(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11OsPrawna);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsPrawna);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsPrawnaRoot.class).getDane();
    }

    public List<OsPrawnaPkdRoot.OsPrawnaPkdData> getOsPrawnaPkd(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11OsPrawnaPkd);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsPrawnaPkd);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsPrawnaPkdRoot.class).getDane();
    }

    public List<OsPrawnaListaJednLokalnychRoot.OsPrawnaListaJednLokalnychData> getOsPrawnaListaJednLokalnych(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11OsPrawnaListaJednLokalnych);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsPrawnaListaJednLokalnych);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsPrawnaListaJednLokalnychRoot.class).getDane();
    }

    public JednLokalnaOsPrawnejRoot.JednLokalnaOsPrawnejData getJednLokalnaOsPrawnej(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11JednLokalnaOsPrawnej);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11JednLokalnaOsPrawnej);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsPrawnejRoot.class).getDane();
    }

    public List<JednLokalnaOsPrawnejPkdRoot.JednLokalnaOsPrawnejPkdData> getJednLokalnaOsPrawnejPkd(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11JednLokalnaOsPrawnejPkd);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11JednLokalnaOsPrawnejPkd);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, JednLokalnaOsPrawnejPkdRoot.class).getDane();
    }

    public List<OsPrawnaSpCywilnaWspolnicyRoot.OsPrawnaSpCywilnaWspolnicyDane> getOsPrawnaSpCywilnaWspolnicy(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11OsPrawnaSpCywilnaWspolnicy);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsPrawnaSpCywilnaWspolnicy);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, OsPrawnaSpCywilnaWspolnicyRoot.class).getDane();
    }

    public TypPodmiotuRoot.TypPodmiotuData getTypPodmiotu(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = createDanePobierzPelnyRaport(searchingParams, FullReportName.BIR11TypPodmiotu);
        log.info("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11TypPodmiotu);
        var danePobierzPelnyRaportResponse = callDanePobierzPelnyRaportEndpoint(danePobierzPelnyRaport);
        return unmarshal(danePobierzPelnyRaportResponse, TypPodmiotuRoot.class).getDane();
    }
}