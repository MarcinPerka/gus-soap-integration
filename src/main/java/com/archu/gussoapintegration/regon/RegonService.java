package com.archu.gussoapintegration.regon;

import com.archu.gussoapintegration.integration.regon.SoapRegonClient;
import com.archu.gussoapintegration.regon.dto.*;
import com.archu.gussoapintegration.regon.searchingparams.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RegonService {

    private final SoapRegonClient soapRegonClient;
    private final RegonConverter regonConverter;

    public SessionDTO login() {
        var zalogujResponse = soapRegonClient.getZaloguj();
        return new SessionDTO(zalogujResponse.getZalogujResult().getValue());
    }

    public List<SubjectDTO> getSubjects(SubjectSearchingParams searchingParams) {
        var result =  soapRegonClient.getDaneSzukajPodmiot(searchingParams);
        return regonConverter.convertDaneSzukajPodmiotRootToSubjectDTO(result);
    }

    public Object getFullReport(FullReportSearchingParams searchingParams) {
        //TODO convert to dtos to rid off of useless stuff.
        return soapRegonClient.getDanePobierzPelnyRaport(searchingParams);
    }
}
