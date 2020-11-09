package com.archu.gussoapintegration.regon;

import com.archu.gussoapintegration.integration.regon.SoapRegonClient;
import com.archu.gussoapintegration.integration.regon.model.DaneSzukajPodmiotRoot;
import com.archu.gussoapintegration.regon.dto.SessionDTO;
import com.gus.regon.wsdl.DanePobierzPelnyRaportResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RegonService {

    private final SoapRegonClient soapRegonClient;

    public SessionDTO login() {
        var zalogujResponse = soapRegonClient.getZaloguj();
        return new SessionDTO(zalogujResponse.getZalogujResult().getValue());
    }

    public List<DaneSzukajPodmiotRoot.DaneSzukajPodmiotData> getSubjects(SearchingParams searchingParams) {
        return soapRegonClient.getDaneSzukajPodmiot(searchingParams);
    }

    public DanePobierzPelnyRaportResponse getFullReport(String regon, String reportName) {
        var danePobierzPelnyRaport = soapRegonClient.getDanePobierzPelnyRaport(regon, reportName);
        //TODO convert to dtos to rid off of useless stuff.
        return danePobierzPelnyRaport;
    }
}
