package com.archu.gussoapintegration.regon;

import com.archu.gussoapintegration.integration.regon.SoapRegonClient;
import com.archu.gussoapintegration.regon.fullreport.FullReportConverterVisitorImpl;
import com.archu.gussoapintegration.regon.fullreport.FullReportSearchingParams;
import com.archu.gussoapintegration.regon.subject.SubjectConverter;
import com.archu.gussoapintegration.regon.subject.dto.SubjectDTO;
import com.archu.gussoapintegration.regon.subject.SubjectSearchingParams;
import com.archu.gussoapintegration.regon.summaryreport.SummaryReportConverterVisitorImpl;
import com.archu.gussoapintegration.regon.summaryreport.SummaryReportSearchingParams;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class RegonService {

    private final SoapRegonClient soapRegonClient;
    private final SubjectConverter regonConverter;
    private final FullReportConverterVisitorImpl fullReportConverterVisitor;
//    private final SummaryReportConverterVisitorImpl summaryReportConverterVisitor;

    public String login() {
        return soapRegonClient.getZaloguj();
    }

    public List<SubjectDTO> getSubjects(SubjectSearchingParams searchingParams) {
        var result =  soapRegonClient.getDaneSzukajPodmiot(searchingParams);
        return regonConverter.convertDaneSzukajPodmiotRootToSubjectDTO(result);
    }

    public Object getFullReport(FullReportSearchingParams searchingParams) {
        //TODO convert to dtos to rid off of useless stuff.
        return soapRegonClient.getDanePobierzPelnyRaport(searchingParams);
    }

    public Object getSummaryReport(SummaryReportSearchingParams searchingParams) {
        //TODO convert to dtos to rid off of useless stuff.
        return soapRegonClient.getDanePobierzRaportZbiorczy(searchingParams);
    }
}
