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

    @GetMapping("/new-legal-entities-and-activities-of-natural-people")
    public List<SummaryReportBaseDTO> getNewLegalEntitiesAndActivitiesOfNaturalPeople(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getNewLegalEntitiesAndActivitiesOfNaturalPeople(searchingParams);
    }

    @GetMapping("/updated-legal-entities-and-activities-of-natural-people")
    public List<SummaryReportBaseDTO> getUpdatedLegalEntitiesAndActivitiesOfNaturalPeople(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getUpdatedLegalEntitiesAndActivitiesOfNaturalPeople(searchingParams);
    }

    @GetMapping("deleted-legal-entities-and-activities-of-natural-people")
    public List<SummaryReportBaseDTO> getDeletedLegalEntitiesAndActivitiesOfNaturalPeople(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getDeletedLegalEntitiesAndActivitiesOfNaturalPeople(searchingParams);
    }

    @GetMapping("/new-local-units")
    public List<SummaryReportBaseDTO> getNewLocalUnits(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getNewLocalUnits(searchingParams);
    }

    @GetMapping("/updated-local-units")
    public List<SummaryReportBaseDTO> getUpdatedLocalUnits(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getUpdatedLocalUnits(searchingParams);
    }

    @GetMapping("/deleted-local-units")
    public List<SummaryReportBaseDTO> getDeletedLocalUnits(@Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getDeletedLocalUnits(searchingParams);
    }
}
