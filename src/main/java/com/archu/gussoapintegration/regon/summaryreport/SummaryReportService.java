package com.archu.gussoapintegration.regon.summaryreport;

import com.archu.gussoapintegration.integration.regon.summaryreport.SummaryReportClient;
import com.archu.gussoapintegration.regon.summaryreport.dto.SummaryReportBaseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class SummaryReportService {

    private final SummaryReportClient summaryReportClient;
    private final SummaryReportConverter summaryReportConverter;

    public List<SummaryReportBaseDTO> getSummaryReport1(SummaryReportSearchingParams searchingParams) {
        var result = summaryReportClient.getNowePodmiotyPrawneOrazDzialalnosciOsFizycznych(searchingParams);
        return result.stream().map(summaryReportConverter::convertNowePodmiotyPrawneOrazDzialalnosciOsFizycznychDataToSummaryReportBaseDTO).collect(Collectors.toList());
    }

    public List<SummaryReportBaseDTO> getSummaryReport2(SummaryReportSearchingParams searchingParams) {
        var result = summaryReportClient.getAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych(searchingParams);
        return result.stream().map(summaryReportConverter::convertAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychToSummaryReportBaseDTO).collect(Collectors.toList());
    }

    public List<SummaryReportBaseDTO> getSummaryReport3(SummaryReportSearchingParams searchingParams) {
        var result = summaryReportClient.getSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych(searchingParams);
        return result.stream().map(summaryReportConverter::convertSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychToSummaryReportBaseDTO).collect(Collectors.toList());
    }

    public List<SummaryReportBaseDTO> getSummaryReport4(SummaryReportSearchingParams searchingParams) {
        var result = summaryReportClient.getNoweJednostkiLokalne(searchingParams);
        return result.stream().map(summaryReportConverter::convertNoweJednostkiLokalneToSummaryReportBaseDTO).collect(Collectors.toList());
    }

    public List<SummaryReportBaseDTO> getSummaryReport5(SummaryReportSearchingParams searchingParams) {
        var result = summaryReportClient.getAktualizowaneJednostkiLokalne(searchingParams);
        return result.stream().map(summaryReportConverter::convertAktualizowaneJednostkiLokalneToSummaryReportBaseDTO).collect(Collectors.toList());
    }

    public List<SummaryReportBaseDTO> getSummaryReport6(SummaryReportSearchingParams searchingParams) {
        var result = summaryReportClient.getJednostkiLokalneSkreslone(searchingParams);
        return result.stream().map(summaryReportConverter::convertJednostkiLokalneSkresloneToSummaryReportBaseDTO).collect(Collectors.toList());
    }
}