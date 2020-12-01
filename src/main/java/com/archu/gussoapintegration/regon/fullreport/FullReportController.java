package com.archu.gussoapintegration.regon.fullreport;

import com.archu.gussoapintegration.regon.fullreport.dto.*;
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
@RequestMapping(path = "/api/regon/full-reports", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class FullReportController {

    private final FullReportService fullReportService;

    @GetMapping("/natural-person/general-data")
    public NaturalPersonGeneralDataDTO getNaturalPersonGeneralData(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonGeneralData(searchingParams);
    }

    @GetMapping("/natural-person/ceidg-activity")
    public FullReportBaseDTO getNaturalPersonCeidgActivity(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonCeidgActivity(searchingParams);
    }

    @GetMapping("/natural-person/agricultural-activity")
    public FullReportBaseDTO getNaturalPersonAgriculturalActivity(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonAgriculturalActivity(searchingParams);
    }

    @GetMapping("/natural-person/remaining-activities")
    public FullReportBaseDTO getNaturalPersonRemainingActivities(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonRemainingActivities(searchingParams);
    }

    @GetMapping("/natural-person/activities-deleted-to-2014-11-08")
    public FullReportBaseDTO getNaturalPersonActivitiesDeletedTo20141108(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonActivitiesDeletedTo20141108(searchingParams);
    }

    @GetMapping("/natural-person/pkd")
    public List<NaturalPersonPkdDTO> getNaturalPersonPkd(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonPkd(searchingParams);
    }

    @GetMapping("/natural-person/local-units")
    public List<FullReportBaseDTO> getNaturalPersonLocalUnits(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonLocalUnits(searchingParams);
    }

    @GetMapping("/natural-person/local-unit")
    public FullReportBaseDTO getNaturalPersonLocalUnit(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonLocalUnit(searchingParams);
    }

    @GetMapping("/natural-person/local-unit-pkd")
    public List<FullReportBaseDTO> getNaturalPersonLocalUnitPkd(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonLocalUnitPkd(searchingParams);
    }

    @GetMapping("/legal-entity")
    public FullReportBaseDTO getLegalEntity(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntity(searchingParams);
    }

    @GetMapping("/legal-entity/pkd")
    public List<LegalEntityPkdDTO> getLegalEntityPkd(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntityPkd(searchingParams);
    }

    @GetMapping("/legal-entity/local-units")
    public List<FullReportBaseDTO> getLegalEntityLocalUnits(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntityLocalUnits(searchingParams);
    }

    @GetMapping("/legal-entity/local-unit")
    public FullReportBaseDTO getLegalEntityLocalUnit(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntityLocalUnit(searchingParams);
    }

    @GetMapping("/legal-entity/local-unit-pkd")
    public List<FullReportBaseDTO> getLegalEntityLocalUnitPkd(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntityLocalUnitPkd(searchingParams);
    }

    @GetMapping("/legal-entity/civil-partnership")
    public List<FullReportBaseDTO> getLegalEntityCivilPartnership(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntityCivilPartnership(searchingParams);
    }

    @GetMapping("/subject-type")
    public SubjectTypeDTO getSubjectType(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getSubjectType(searchingParams);
    }

}
