package com.archu.gussoapintegration.regon.summaryreport;

import com.archu.gussoapintegration.regon.summaryreport.dto.SummaryReportBaseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping(path = "/api/regon/summary-reports", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class SummaryReportController {

    private final SummaryReportService summaryReportService;

    @GetMapping("/BIR11NowePodmiotyPrawneOrazDzialalnosciOsFizycznych")
    public List<SummaryReportBaseDTO> getSummaryReport1(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getSummaryReport1(searchingParams);
    }

    @GetMapping("/BIR11AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych")
    public List<SummaryReportBaseDTO> getSummaryReport2(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getSummaryReport2(searchingParams);
    }

    @GetMapping("/BIR11SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych")
    public List<SummaryReportBaseDTO> getSummaryReport3(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getSummaryReport3(searchingParams);
    }

    @GetMapping("/BIR11NoweJednostkiLokalne")
    public List<SummaryReportBaseDTO> getSummaryReport4(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getSummaryReport4(searchingParams);
    }

    @GetMapping("/BIR11AktualizowaneJednostkiLokalne")
    public List<SummaryReportBaseDTO> getSummaryReport5(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getSummaryReport5(searchingParams);
    }

    @GetMapping("/BIR11JednostkiLokalneSkreslone")
    public List<SummaryReportBaseDTO> getSummaryReport6(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getSummaryReport6(searchingParams);
    }
}
