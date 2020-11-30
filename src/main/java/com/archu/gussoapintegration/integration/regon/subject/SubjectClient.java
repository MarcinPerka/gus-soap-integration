package com.archu.gussoapintegration.integration.regon.subject;

import com.archu.gussoapintegration.integration.SoapUtils;
import com.archu.gussoapintegration.integration.regon.session.SessionClient;
import com.archu.gussoapintegration.integration.regon.subject.model.DaneSzukajPodmiotRoot;
import com.archu.gussoapintegration.regon.subject.SubjectSearchingParams;
import com.gus.regon.wsdl.DaneSzukajPodmioty;
import com.gus.regon.wsdl.DaneSzukajPodmiotyResponse;
import com.gus.regon.wsdl.ObjectFactory;
import com.gus.regon.wsdl.ParametryWyszukiwania;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;

import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.WSA_ACTION_DANE_SZUKAJ_PODMIOTY;

@Slf4j
@RequiredArgsConstructor
public class SubjectClient extends WebServiceGatewaySupport {

    private final ObjectFactory factory;

    private final SessionClient sessionClient;

    public List<DaneSzukajPodmiotRoot.DaneSzukajPodmiotData> getDaneSzukajPodmiot(SubjectSearchingParams searchingParams) {
        var daneSzukajPodmioty = new DaneSzukajPodmioty();
        ParametryWyszukiwania parametryWyszukiwania = createParametryWyszukiwania(searchingParams, factory);
        daneSzukajPodmioty.setPParametryWyszukiwania(factory.createDaneSzukajPodmiotyPParametryWyszukiwania(parametryWyszukiwania));

        log.debug("Requesting for subject with searching params: {}", searchingParams);
        var daneSzukajPodmiotyResponse = ((DaneSzukajPodmiotyResponse) getWebServiceTemplate().marshalSendAndReceive(daneSzukajPodmioty, SoapUtils.prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_SZUKAJ_PODMIOTY, sessionClient.getSessionId())))
                .getDaneSzukajPodmiotyResult()
                .getValue();

        var daneSzukajPodmiotRoot = SoapUtils.unmarshal(daneSzukajPodmiotyResponse, DaneSzukajPodmiotRoot.class);
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
}