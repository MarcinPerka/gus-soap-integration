package com.archu.gussoapintegration.integration.regon.fullreport;

import com.archu.gussoapintegration.integration.SoapUtils;
import com.archu.gussoapintegration.integration.regon.fullreport.model.OsFizycznaDaneOgolneRoot;
import com.archu.gussoapintegration.integration.regon.session.SessionClient;
import com.archu.gussoapintegration.regon.fullreport.FullReportSearchingParams;
import com.gus.regon.wsdl.DanePobierzPelnyRaport;
import com.gus.regon.wsdl.DanePobierzPelnyRaportResponse;
import com.gus.regon.wsdl.ObjectFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.WSA_ACTION_DANE_POBIERZ_PELNY_RAPORT;

@Slf4j
@RequiredArgsConstructor
public class FullReportClient extends WebServiceGatewaySupport {


    private final ObjectFactory factory;

    private final SessionClient sessionClient;

    //TODO(Not finished)


    public OsFizycznaDaneOgolneRoot.OsFizycznaDaneOgolneData getOsFizycznaDaneOgolne(FullReportSearchingParams searchingParams) {
        var danePobierzPelnyRaport = new DanePobierzPelnyRaport();
        danePobierzPelnyRaport.setPRegon(factory.createDanePobierzPelnyRaportPRegon(searchingParams.getRegon()));
        danePobierzPelnyRaport.setPNazwaRaportu(factory.createDanePobierzPelnyRaportPNazwaRaportu(FullReportName.BIR11OsFizycznaDaneOgolne.name()));

        log.debug("Requesting for full report with regon: {} and report name: {}", searchingParams.getRegon(), FullReportName.BIR11OsFizycznaDaneOgolne.name());

        var danePobierzPelnyRaportResponse = ((DanePobierzPelnyRaportResponse) getWebServiceTemplate().marshalSendAndReceive(
                danePobierzPelnyRaport,
                SoapUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_POBIERZ_PELNY_RAPORT, sessionClient.getSessionId())
        )).getDanePobierzPelnyRaportResult().getValue();

        return SoapUtils.unmarshal(danePobierzPelnyRaportResponse, OsFizycznaDaneOgolneRoot.class).getDane();
    }

}