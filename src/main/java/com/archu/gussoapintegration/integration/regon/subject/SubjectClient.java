package com.archu.gussoapintegration.integration.regon.subject;

import com.archu.gussoapintegration.api.regon.subject.SubjectSearchingParams;
import com.archu.gussoapintegration.exception.ResourceNotFoundException;
import com.archu.gussoapintegration.integration.SoapUtils;
import com.archu.gussoapintegration.integration.regon.session.SessionHolder;
import com.archu.gussoapintegration.integration.regon.subject.model.DaneSzukajPodmiotRoot;
import com.gus.regon.wsdl.DaneSzukajPodmioty;
import com.gus.regon.wsdl.DaneSzukajPodmiotyResponse;
import com.gus.regon.wsdl.ObjectFactory;
import com.gus.regon.wsdl.ParametryWyszukiwania;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;
import java.util.Optional;

import static com.archu.gussoapintegration.integration.SoapUtils.prepareSoapActionCallback;
import static com.archu.gussoapintegration.integration.regon.SoapRegonConstants.WSA_ACTION_DANE_SZUKAJ_PODMIOTY;

@Slf4j
@RequiredArgsConstructor
public class SubjectClient extends WebServiceGatewaySupport {

    private final ObjectFactory factory;

    private final SessionHolder sessionHolder;

    public List<DaneSzukajPodmiotRoot.DaneSzukajPodmiotData> getDaneSzukajPodmiot(SubjectSearchingParams searchingParams) {
        var daneSzukajPodmioty = createDaneSzukajPodmioty(searchingParams);
        log.info("Requesting for subject with searching params: {}", searchingParams);
        var daneSzukajPodmiotyResponse = callDaneSzukajPodmiotyEndpoint(daneSzukajPodmioty);
        return SoapUtils.unmarshal(daneSzukajPodmiotyResponse, DaneSzukajPodmiotRoot.class).getDane();
    }

    private String callDaneSzukajPodmiotyEndpoint(DaneSzukajPodmioty daneSzukajPodmioty) {
        var optionalResponse = Optional.of(getWebServiceTemplate()
                .marshalSendAndReceive(daneSzukajPodmioty,
                        prepareSoapActionCallback(getDefaultUri(), WSA_ACTION_DANE_SZUKAJ_PODMIOTY, sessionHolder.getSessionId())
                ));

        return optionalResponse.map(response -> ((DaneSzukajPodmiotyResponse) response).getDaneSzukajPodmiotyResult().getValue())
                .orElseThrow(ResourceNotFoundException::new);
    }

    private DaneSzukajPodmioty createDaneSzukajPodmioty(SubjectSearchingParams searchingParams) {
        var daneSzukajPodmioty = new DaneSzukajPodmioty();
        ParametryWyszukiwania parametryWyszukiwania = createParametryWyszukiwania(searchingParams, factory);
        daneSzukajPodmioty.setPParametryWyszukiwania(factory.createDaneSzukajPodmiotyPParametryWyszukiwania(parametryWyszukiwania));
        return daneSzukajPodmioty;
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