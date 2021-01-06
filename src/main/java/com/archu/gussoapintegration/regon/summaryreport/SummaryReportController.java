package com.archu.gussoapintegration.regon.summaryreport;

import com.archu.gussoapintegration.regon.summaryreport.dto.SummaryReportBaseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/legal-entities-and-activities-of-natural-people/new")
    public List<SummaryReportBaseDTO> getNewLegalEntitiesAndActivitiesOfNaturalPeople(@ModelAttribute @Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getNewLegalEntitiesAndActivitiesOfNaturalPeople(searchingParams);
    }

    @GetMapping("/legal-entities-and-activities-of-natural-people/updated")
    public List<SummaryReportBaseDTO> getUpdatedLegalEntitiesAndActivitiesOfNaturalPeople(@ModelAttribute @Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getUpdatedLegalEntitiesAndActivitiesOfNaturalPeople(searchingParams);
    }

    @GetMapping("/legal-entities-and-activities-of-natural-people/deleted")
    public List<SummaryReportBaseDTO> getDeletedLegalEntitiesAndActivitiesOfNaturalPeople(@ModelAttribute  @Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getDeletedLegalEntitiesAndActivitiesOfNaturalPeople(searchingParams);
    }

    @GetMapping("/local-units/new")
    public List<SummaryReportBaseDTO> getNewLocalUnits(@ModelAttribute @Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getNewLocalUnits(searchingParams);
    }

    @GetMapping("/local-units/updated")
    public List<SummaryReportBaseDTO> getUpdatedLocalUnits(@ModelAttribute @Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getUpdatedLocalUnits(searchingParams);
    }

    @GetMapping("/local-units/deleted")
    public List<SummaryReportBaseDTO> getDeletedLocalUnits(@ModelAttribute @Valid SummaryReportSearchingParams searchingParams) {
        return summaryReportService.getDeletedLocalUnits(searchingParams);
    }
}
