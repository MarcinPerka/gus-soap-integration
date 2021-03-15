package com.archu.gussoapintegration.integration.regon.summaryreport;

import com.archu.gussoapintegration.api.regon.summaryreport.SummaryReportSearchingParams;
import com.archu.gussoapintegration.exception.ResourceNotFoundException;
import com.archu.gussoapintegration.integration.regon.session.SessionHolder;
import com.archu.gussoapintegration.integration.regon.summaryreport.model.*;
import com.gus.regon.wsdl.DanePobierzRaportZbiorczy;
import com.gus.regon.wsdl.DanePobierzRaportZbiorczyResponse;
import com.gus.regon.wsdl.ObjectFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;
import java.util.Optional;

import static com.archu.gussoapintegration.integration.SoapUtils.prepareSoapActionCallback;
import static com.archu.gussoapintegration.integration.SoapUtils.unmarshal;
import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY;

@Slf4j
@RequiredArgsConstructor
public class SummaryReportClient extends WebServiceGatewaySupport {


    private final ObjectFactory factory;

    private final SessionHolder sessionHolder;

    private enum SummaryReportName {
        BIR11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych,
        BIR11AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych,
        BIR11SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych,
        BIR11NoweJednostkiLokalne,
        BIR11AktualizowaneJednostkiLokalne,
        BIR11JednostkiLokalneSkreslone
    }

    private DanePobierzRaportZbiorczy createDanePobierzRaportZbiorczy(SummaryReportSearchingParams searchingParams, SummaryReportName bir11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych) {
        var danePobierzRaportZbiorczy = new DanePobierzRaportZbiorczy();
        danePobierzRaportZbiorczy.setPDataRaportu(factory.createDanePobierzRaportZbiorczyPDataRaportu(searchingParams.getDate().toString()));
        danePobierzRaportZbiorczy.setPNazwaRaportu(factory.createDanePobierzRaportZbiorczyPNazwaRaportu(bir11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych.name()));
        return danePobierzRaportZbiorczy;
    }

    private String callDanePobierzRaportZbiorczyEndpoint(DanePobierzRaportZbiorczy danePobierzRaportZbiorczy) {
        var optionalResponse = Optional.of(getWebServiceTemplate()
                .marshalSendAndReceive(danePobierzRaportZbiorczy,
                        prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY, sessionHolder.getSessionId())
                ));

        return optionalResponse.map(response -> ((DanePobierzRaportZbiorczyResponse) response).getDanePobierzRaportZbiorczyResult().getValue())
                .orElseThrow(ResourceNotFoundException::new);
    }

    public List<NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData> getNowePodmiotyPrawneOrazDzialalnosciOsFizycznych(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, SummaryReportName.BIR11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych);
        var danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
    }

    public List<AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData> getAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, SummaryReportName.BIR11AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych);
        var danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
    }

    public List<SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData> getSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, SummaryReportName.BIR11SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych);
        var danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
    }

    public List<NoweJednostkiLokalneRoot.NoweJednostkiLokalneData> getNoweJednostkiLokalne(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, SummaryReportName.BIR11NoweJednostkiLokalne);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11NoweJednostkiLokalne);
        var danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, NoweJednostkiLokalneRoot.class).getDane();
    }

    public List<AktualizowaneJednostkiLokalneRoot.AktualizowaneJednostkiLokalneData> getAktualizowaneJednostkiLokalne(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, SummaryReportName.BIR11AktualizowaneJednostkiLokalne);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11AktualizowaneJednostkiLokalne);
        var danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, AktualizowaneJednostkiLokalneRoot.class).getDane();
    }

    public List<SkresloneJednostkiLokalneRoot.SkresloneJednostkiLokalneData> getJednostkiLokalneSkreslone(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = createDanePobierzRaportZbiorczy(searchingParams, SummaryReportName.BIR11JednostkiLokalneSkreslone);
        log.info("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11JednostkiLokalneSkreslone);
        var danePobierzRaportZbiorczyResponse = callDanePobierzRaportZbiorczyEndpoint(danePobierzRaportZbiorczy);
        return unmarshal(danePobierzRaportZbiorczyResponse, SkresloneJednostkiLokalneRoot.class).getDane();
    }

}