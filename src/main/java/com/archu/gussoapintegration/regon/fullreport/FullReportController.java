package com.archu.gussoapintegration.regon.fullreport;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping(path = "/api/regon/full-reports", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class FullReportController {

    private final FullReportService fullReportService;

    @GetMapping
    public Object getFullReport(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getFullReport(searchingParams);
    }
}
