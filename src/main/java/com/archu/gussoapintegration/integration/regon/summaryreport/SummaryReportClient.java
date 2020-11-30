package com.archu.gussoapintegration.integration.regon.summaryreport;

import com.archu.gussoapintegration.integration.SoapUtils;
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

import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY;

@Slf4j
@RequiredArgsConstructor
public class SummaryReportClient extends WebServiceGatewaySupport {


    private final ObjectFactory factory;

    private final SessionClient sessionClient;

    public List<NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData> getNowePodmiotyPrawneOrazDzialalnosciOsFizycznych(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = new DanePobierzRaportZbiorczy();
        danePobierzRaportZbiorczy.setPDataRaportu(factory.createDanePobierzRaportZbiorczyPDataRaportu(searchingParams.getDate().toString()));
        danePobierzRaportZbiorczy.setPNazwaRaportu(factory.createDanePobierzRaportZbiorczyPNazwaRaportu(SummaryReportName.BIR11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych.name()));

        log.debug("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych.name());

        var danePobierzRaportZbiorczyResponse = ((DanePobierzRaportZbiorczyResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzRaportZbiorczy,
                SoapUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY, sessionClient.getSessionId())
        )).getDanePobierzRaportZbiorczyResult().getValue();

        return SoapUtils.unmarshal(danePobierzRaportZbiorczyResponse, NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
    }

    public List<AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData> getAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = new DanePobierzRaportZbiorczy();
        danePobierzRaportZbiorczy.setPDataRaportu(factory.createDanePobierzRaportZbiorczyPDataRaportu(searchingParams.getDate().toString()));
        danePobierzRaportZbiorczy.setPNazwaRaportu(factory.createDanePobierzRaportZbiorczyPNazwaRaportu(SummaryReportName.BIR11AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych.name()));

        log.debug("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych.name());

        var danePobierzRaportZbiorczyResponse = ((DanePobierzRaportZbiorczyResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzRaportZbiorczy,
                SoapUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY, sessionClient.getSessionId())
        )).getDanePobierzRaportZbiorczyResult().getValue();

        return SoapUtils.unmarshal(danePobierzRaportZbiorczyResponse, AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
    }

    public List<SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData> getSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = new DanePobierzRaportZbiorczy();
        danePobierzRaportZbiorczy.setPDataRaportu(factory.createDanePobierzRaportZbiorczyPDataRaportu(searchingParams.getDate().toString()));
        danePobierzRaportZbiorczy.setPNazwaRaportu(factory.createDanePobierzRaportZbiorczyPNazwaRaportu(SummaryReportName.BIR11SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych.name()));

        log.debug("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych.name());

        var danePobierzRaportZbiorczyResponse = ((DanePobierzRaportZbiorczyResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzRaportZbiorczy,
                SoapUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY, sessionClient.getSessionId())
        )).getDanePobierzRaportZbiorczyResult().getValue();

        return SoapUtils.unmarshal(danePobierzRaportZbiorczyResponse, SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane();
    }

    public List<NoweJednostkiLokalneRoot.NoweJednostkiLokalneData> getNoweJednostkiLokalne(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = new DanePobierzRaportZbiorczy();
        danePobierzRaportZbiorczy.setPDataRaportu(factory.createDanePobierzRaportZbiorczyPDataRaportu(searchingParams.getDate().toString()));
        danePobierzRaportZbiorczy.setPNazwaRaportu(factory.createDanePobierzRaportZbiorczyPNazwaRaportu(SummaryReportName.BIR11NoweJednostkiLokalne.name()));

        log.debug("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11NoweJednostkiLokalne.name());

        var danePobierzRaportZbiorczyResponse = ((DanePobierzRaportZbiorczyResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzRaportZbiorczy,
                SoapUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY, sessionClient.getSessionId())
        )).getDanePobierzRaportZbiorczyResult().getValue();

        return SoapUtils.unmarshal(danePobierzRaportZbiorczyResponse, NoweJednostkiLokalneRoot.class).getDane();
    }

    public List<AktualizowaneJednostkiLokalneRoot.AktualizowaneJednostkiLokalneData> getAktualizowaneJednostkiLokalne(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = new DanePobierzRaportZbiorczy();
        danePobierzRaportZbiorczy.setPDataRaportu(factory.createDanePobierzRaportZbiorczyPDataRaportu(searchingParams.getDate().toString()));
        danePobierzRaportZbiorczy.setPNazwaRaportu(factory.createDanePobierzRaportZbiorczyPNazwaRaportu(SummaryReportName.BIR11AktualizowaneJednostkiLokalne.name()));

        log.debug("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11AktualizowaneJednostkiLokalne.name());

        var danePobierzRaportZbiorczyResponse = ((DanePobierzRaportZbiorczyResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzRaportZbiorczy,
                SoapUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY, sessionClient.getSessionId())
        )).getDanePobierzRaportZbiorczyResult().getValue();

        return SoapUtils.unmarshal(danePobierzRaportZbiorczyResponse, AktualizowaneJednostkiLokalneRoot.class).getDane();
    }

    public List<SkresloneJednostkiLokalneRoot.SkresloneJednostkiLokalneData> getJednostkiLokalneSkreslone(SummaryReportSearchingParams searchingParams) {
        var danePobierzRaportZbiorczy = new DanePobierzRaportZbiorczy();
        danePobierzRaportZbiorczy.setPDataRaportu(factory.createDanePobierzRaportZbiorczyPDataRaportu(searchingParams.getDate().toString()));
        danePobierzRaportZbiorczy.setPNazwaRaportu(factory.createDanePobierzRaportZbiorczyPNazwaRaportu(SummaryReportName.BIR11JednostkiLokalneSkreslone.name()));

        log.debug("Requesting for summary report with date: {} and report name: {}", searchingParams.getDate(), SummaryReportName.BIR11JednostkiLokalneSkreslone.name());

        var danePobierzRaportZbiorczyResponse = ((DanePobierzRaportZbiorczyResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzRaportZbiorczy,
                SoapUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_RAPORT_ZBIORCZY, sessionClient.getSessionId())
        )).getDanePobierzRaportZbiorczyResult().getValue();

        return SoapUtils.unmarshal(danePobierzRaportZbiorczyResponse, SkresloneJednostkiLokalneRoot.class).getDane();
    }

}