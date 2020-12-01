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

    public FullReportBaseDTO getNaturalPersonCeidgActivity(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getOsFizycznaDzialalnoscCeidg(searchingParams));
    }

    public FullReportBaseDTO getNaturalPersonAgriculturalActivity(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getOsFizycznaDzialalnoscRolnicza(searchingParams));
    }

    public FullReportBaseDTO getNaturalPersonRemainingActivities(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getOsFizycznaDzialalnoscPozostala(searchingParams));
    }

    public FullReportBaseDTO getNaturalPersonActivitiesDeletedTo20141108(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getOsFizycznaDzialalnoscSkreslonaDo20141108(searchingParams));
    }

    public List<NaturalPersonPkdDTO> getNaturalPersonPkd(FullReportSearchingParams searchingParams) {
        return fullReportClient.getOsFizycznaPkd(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public List<FullReportBaseDTO> getNaturalPersonLocalUnits(FullReportSearchingParams searchingParams) {
        return fullReportClient.getOsFizycznaListaJednLokalnych(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public FullReportBaseDTO getNaturalPersonLocalUnit(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getJednLokalnaOsFizycznej(searchingParams));
    }

    public List<FullReportBaseDTO> getNaturalPersonLocalUnitPkd(FullReportSearchingParams searchingParams) {
        return fullReportClient.getJednLokalnaOsFizycznejPkd(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public FullReportBaseDTO getLegalEntity(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getOsPrawna(searchingParams));
    }

    public List<LegalEntityPkdDTO> getLegalEntityPkd(FullReportSearchingParams searchingParams) {
        return fullReportClient.getOsPrawnaPkd(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public List<FullReportBaseDTO> getLegalEntityLocalUnits(FullReportSearchingParams searchingParams) {
        return fullReportClient.getOsPrawnaListaJednLokalnych(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public FullReportBaseDTO getLegalEntityLocalUnit(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getJednLokalnaOsPrawnej(searchingParams));
    }

    public List<FullReportBaseDTO> getLegalEntityLocalUnitPkd(FullReportSearchingParams searchingParams) {
        return fullReportClient.getJednLokalnaOsPrawnejPkd(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public List<FullReportBaseDTO> getLegalEntityCivilPartnership(FullReportSearchingParams searchingParams) {
        return fullReportClient.getOsPrawnaSpCywilnaWspolnicy(searchingParams).stream().map(fullReportConverter::convert).collect(Collectors.toList());
    }

    public SubjectTypeDTO getSubjectType(FullReportSearchingParams searchingParams) {
        return fullReportConverter.convert(fullReportClient.getTypPodmiotu(searchingParams));
    }
}