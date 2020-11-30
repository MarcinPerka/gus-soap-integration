package com.archu.gussoapintegration.regon.fullreport;

import com.archu.gussoapintegration.integration.regon.fullreport.FullReportClient;
import com.archu.gussoapintegration.regon.fullreport.dto.NaturalPersonDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class FullReportService {

    private final FullReportClient fullReportClient;
    private final FullReportConverter fullReportConverter;

    public NaturalPersonDTO getNaturalPerson(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convertOsFizycznaDaneOgolneToNaturalPersonDTO(fullReportClient.getOsFizycznaDaneOgolne(searchingParams));
    }
}