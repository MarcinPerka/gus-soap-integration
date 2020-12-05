package com.archu.gussoapintegration.regon.fullreport;

import com.archu.gussoapintegration.integration.regon.fullreport.FullReportClient;
import com.archu.gussoapintegration.regon.fullreport.dto.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class FullReportService {

    private final FullReportClient fullReportClient;
    private final FullReportConverter fullReportConverter;

    public NaturalPersonGeneralDataDTO getNaturalPersonGeneralData(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getOsFizycznaDaneOgolne(searchingParams));
    }

    public NaturalPersonCeidgActivityDTO getNaturalPersonCeidgActivity(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getOsFizycznaDzialalnoscCeidg(searchingParams));
    }

    public NaturalPersonAgriculturalActivityDTO getNaturalPersonAgriculturalActivity(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getOsFizycznaDzialalnoscRolnicza(searchingParams));
    }

    public NaturalPersonRemainingActivityDTO getNaturalPersonRemainingActivity(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getOsFizycznaDzialalnoscPozostala(searchingParams));
    }

    public NaturalPersonActivityDeletedTo20141108DTO getNaturalPersonActivitiyDeletedTo20141108(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getOsFizycznaDzialalnoscSkreslonaDo20141108(searchingParams));
    }

    public List<NaturalPersonPkdDTO> getNaturalPersonPkd(FullReportSearchingParams searchingParams) {
        return fullReportClient.getOsFizycznaPkd(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public List<NaturalPersonLocalUnitsDTO> getNaturalPersonLocalUnits(FullReportSearchingParams searchingParams) {
        return fullReportClient.getOsFizycznaListaJednLokalnych(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public NaturalPersonLocalUnitDTO getNaturalPersonLocalUnit(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getJednLokalnaOsFizycznej(searchingParams));
    }

    public List<NaturalPersonLocalUnitPkdDTO> getNaturalPersonLocalUnitPkd(FullReportSearchingParams searchingParams) {
        return fullReportClient.getJednLokalnaOsFizycznejPkd(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public LegalEntityDTO getLegalEntity(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getOsPrawna(searchingParams));
    }

    public List<LegalEntityPkdDTO> getLegalEntityPkd(FullReportSearchingParams searchingParams) {
        return fullReportClient.getOsPrawnaPkd(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public List<LegalEntityLocalUnitsDTO> getLegalEntityLocalUnits(FullReportSearchingParams searchingParams) {
        return fullReportClient.getOsPrawnaListaJednLokalnych(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public LegalEntityLocalUnitDTO getLegalEntityLocalUnit(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getJednLokalnaOsPrawnej(searchingParams));
    }

    public List<LegalEntityLocalUnitPkdDTO> getLegalEntityLocalUnitPkd(FullReportSearchingParams searchingParams) {
        return fullReportClient.getJednLokalnaOsPrawnejPkd(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public List<LegalEntityCivilPartnershipDTO> getLegalEntityCivilPartnership(FullReportSearchingParams searchingParams) {
        return fullReportClient.getOsPrawnaSpCywilnaWspolnicy(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public SubjectTypeDTO getSubjectType(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getTypPodmiotu(searchingParams));
    }
}