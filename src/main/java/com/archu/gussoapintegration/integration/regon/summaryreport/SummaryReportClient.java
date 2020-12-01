package com.archu.gussoapintegration.integration.regon.summaryreport;

import com.archu.gussoapintegration.integration.regon.session.SessionClient;
import com.archu.gussoapintegration.integration.regon.summaryreport.model.*;
import com.archu.gussoapintegration.regon.summaryreport.SummaryReportSearchingParams;
import com.gus.regon.wsdl.DanePobierzRaportZbiorczy;
import com.gus.regon.wsdl.DanePobierzRaportZbiorczyResponse;
import com.gus.regon.wsdl.ObjectFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;

import static com.archu.gussoapintegration.integration.SoapUtils.prepareSoapActionCallback;
import static com.archu.gussoapintegration.integration.SoapUtils.unmarshal;
import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY;
import static com.archu.gussoapintegration.integration.regon.summaryreport.SummaryReportName.*;

@Slf4j
@RequiredArgsConstructor
public class SummaryReportClient extends WebServiceGatewaySupport {


    private final ObjectFactory factory;

    private final SessionClient sessionClient;

    private DanePobierzRaportZbiorczy createDanePobierzRaportZbiorczy(SummaryReportSearchingParams searchingParams, SummaryReportName bir11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych) {
        var danePobierzRaportZbiorczy = new DanePobierzRaportZbiorczy();
        danePobierzRaportZbiorczy.setPDataRaportu(factory.createDanePobierzRaportZbiorczyPDataRaportu(searchingParams.getDate().toString()));
        danePobierzRaportZbiorczy.setPNazwaRaportu(factory.createDanePobierzRaportZbiorczyPNazwaRaportu(bir11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych.name()));
        return danePobierzRaportZbiorczy;
    }

    private String callDanePobierzRaportZbiorczyEndpoint(DanePobierzRaportZbiorczy danePobierzRaportZbiorczy) {
        return ((DanePobierzRaportZbiorczyResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzRaportZbiorczy,
                prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY, sessionClient.getSessionId())
        )).getDanePobierzRaportZbiorczyResult().getValue();
    }

    public List<NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData> getNowePodmiotyPrawneOrazDzialalnosciOsFizycznych(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, BIR11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), BIR11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych.name());
        var danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
    }

    public List<AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData> getAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, BIR11AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), BIR11AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych.name());
        String danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
    }

    public List<SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData> getSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, BIR11SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), BIR11SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych.name());
        var danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
    }

    public List<NoweJednostkiLokalneRoot.NoweJednostkiLokalneData> getNoweJednostkiLokalne(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, BIR11NoweJednostkiLokalne);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), BIR11NoweJednostkiLokalne.name());
        var danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, NoweJednostkiLokalneRoot.class).getDane();
    }

    public List<AktualizowaneJednostkiLokalneRoot.AktualizowaneJednostkiLokalneData> getAktualizowaneJednostkiLokalne(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, BIR11AktualizowaneJednostkiLokalne);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), BIR11AktualizowaneJednostkiLokalne.name());
        var danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, AktualizowaneJednostkiLokalneRoot.class).getDane();
    }

    public List<SkresloneJednostkiLokalneRoot.SkresloneJednostkiLokalneData> getJednostkiLokalneSkreslone(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, BIR11JednostkiLokalneSkreslone);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), BIR11JednostkiLokalneSkreslone.name());
        var danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, SkresloneJednostkiLokalneRoot.class).getDane();
    }

}