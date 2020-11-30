package com.archu.gussoapintegration.regon.fullreport;

import com.archu.gussoapintegration.integration.regon.fullreport.FullReportClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class FullReportService {

    private final FullReportClient fullReportClient;
    private final FullReportConverter fullReportConverter;

    public Object getFullReport(FullReportSearchingParams searchingParams) {
        return fullReportClient.getDanePobierzPelnyRaport(searchingParams);
    }
}