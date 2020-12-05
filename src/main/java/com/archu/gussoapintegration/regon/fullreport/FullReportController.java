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
    public NaturalPersonCeidgActivityDTO getNaturalPersonCeidgActivity(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonCeidgActivity(searchingParams);
    }

    @GetMapping("/natural-person/agricultural-activity")
    public NaturalPersonAgriculturalActivityDTO getNaturalPersonAgriculturalActivity(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonAgriculturalActivity(searchingParams);
    }

    @GetMapping("/natural-person/remaining-activity")
    public NaturalPersonRemainingActivityDTO getNaturalPersonRemainingActivity(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonRemainingActivity(searchingParams);
    }

    @GetMapping("/natural-person/activity-deleted-to-2014-11-08")
    public NaturalPersonActivityDeletedTo20141108DTO getNaturalPersonActivityDeletedTo20141108(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonActivitiyDeletedTo20141108(searchingParams);
    }

    @GetMapping("/natural-person/pkd")
    public List<NaturalPersonPkdDTO> getNaturalPersonPkd(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonPkd(searchingParams);
    }

    @GetMapping("/natural-person/local-units")
    public List<NaturalPersonLocalUnitsDTO> getNaturalPersonLocalUnits(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonLocalUnits(searchingParams);
    }

    @GetMapping("/natural-person/local-unit")
    public NaturalPersonLocalUnitDTO getNaturalPersonLocalUnit(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonLocalUnit(searchingParams);
    }

    @GetMapping("/natural-person/local-unit-pkd")
    public List<NaturalPersonLocalUnitPkdDTO> getNaturalPersonLocalUnitPkd(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getNaturalPersonLocalUnitPkd(searchingParams);
    }

    @GetMapping("/legal-entity")
    public LegalEntityDTO getLegalEntity(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntity(searchingParams);
    }

    @GetMapping("/legal-entity/pkd")
    public List<LegalEntityPkdDTO> getLegalEntityPkd(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntityPkd(searchingParams);
    }

    @GetMapping("/legal-entity/local-units")
    public List<LegalEntityLocalUnitsDTO> getLegalEntityLocalUnits(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntityLocalUnits(searchingParams);
    }

    @GetMapping("/legal-entity/local-unit")
    public LegalEntityLocalUnitDTO getLegalEntityLocalUnit(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntityLocalUnit(searchingParams);
    }

    @GetMapping("/legal-entity/local-unit-pkd")
    public List<LegalEntityLocalUnitPkdDTO> getLegalEntityLocalUnitPkd(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntityLocalUnitPkd(searchingParams);
    }

    @GetMapping("/legal-entity/civil-partnership")
    public List<LegalEntityCivilPartnershipDTO> getLegalEntityCivilPartnership(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getLegalEntityCivilPartnership(searchingParams);
    }

    @GetMapping("/subject-type")
    public SubjectTypeDTO getSubjectType(@Valid FullReportSearchingParams searchingParams) {
        return fullReportService.getSubjectType(searchingParams);
    }

}
