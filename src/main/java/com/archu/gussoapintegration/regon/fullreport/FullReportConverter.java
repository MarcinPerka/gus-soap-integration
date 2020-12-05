package com.archu.gussoapintegration.regon.fullreport;

import com.archu.gussoapintegration.integration.regon.fullreport.model.*;
import com.archu.gussoapintegration.regon.fullreport.dto.*;
import org.springframework.stereotype.Component;

@Component
public class FullReportConverter {
    //TODO(Not finished, where is)
    public NaturalPersonGeneralDataDTO convert(OsFizycznaDaneOgolneRoot.OsFizycznaDaneOgolneData data) {
        return NaturalPersonGeneralDataDTO.builder()
                .regon(data.getFizRegon9())
                .nip(data.getFizNip())
                .status(data.getFizStatusNip())
                .lastName(data.getFizNazwisko())
                .firstName(data.getFizImie1())
                .secondName(data.getFizImie2())
                .dateOfEntryToRegon(data.getFizDataWpisuPodmiotuDoRegon())
                .dateOfOccurrenceChange(data.getFizDataZaistnieniaZmiany())
                .dateOfDeleteFromRegon(data.getFizDataSkresleniaPodmiotuZRegon())
                .basicLegalFormSymbol(data.getFizPodstawowaFormaPrawnaSymbol())
                .detailedLegalFormSymbol(data.getFizSzczegolnaFormaPrawnaSymbol())
                .financingFormSymbol(data.getFizFormaFinansowaniaSymbol())
                .ownFormSymbol(data.getFizFormaWlasnosciSymbol())
                .basicLegalFormName(data.getFizPodstawowaFormaPrawnaNazwa())
                .detailedLegalFormName(data.getFizSzczegolnaFormaPrawnaNazwa())
                .financingFormName(data.getFizFormaFinansowaniaNazwa())
                .ownFormName(data.getFizFormaWlasnosciNazwa())
                .ceidgActivity(data.getFizDzialalnoscCeidg())
                .agriculturalActivity(data.getFizDzialalnoscRolnicza())
                .remainingActivity(data.getFizDzialalnoscPozostala())
                .activityDeletedTo20141108(data.getFizDzialalnoscSkreslonaDo20141108())
                .numberOfLocalUnits(data.getFizLiczbaJednLokalnych())
                .build();
    }

    public NaturalPersonCeidgActivityDTO convert(OsFizycznaDzialalnoscCeidgRoot.OsFizycznaDzialalnoscCeidgData data) {
        return null;
    }

    public NaturalPersonAgriculturalActivityDTO convert(OsFizycznaDzialalnoscRolniczaRoot.OsFizycznaDzialalnoscRolniczaData data) {
        return null;
    }

    public NaturalPersonRemainingActivityDTO convert(OsFizycznaDzialalnoscPozostalaRoot.OsFizycznaDzialalnoscPozostalaData data) {
        return null;
    }

    public NaturalPersonActivityDeletedTo20141108DTO convert(OsFizycznaDzialalnoscSkreslonaDo20141108Root.OsFizycznaDzialalnoscSkreslonaDo20141108Data data) {
        return null;
    }

    public NaturalPersonPkdDTO convert(OsFizycznaPkdRoot.OsFizycznaPkdData data) {
        return NaturalPersonPkdDTO.builder()
                .pkdCode(data.getFizPkdKod())
                .pkdDominant(data.getFizPkdPrzewazajace())
                .pkdName(data.getFizPkdNazwa())
                .silosId(data.getFizSilosID())
                .silosSymbol(data.getFizSilosSymbol())
                .businessEndDate(data.getFizDataSkresleniaDzialalnosciZRegon())
                .build();
    }

    public NaturalPersonLocalUnitsDTO convert(OsFizycznaListaJednLokalnychRoot.OsFizycznaListaJednLokalnychData data) {
        return null;
    }

    public NaturalPersonLocalUnitDTO convert(JednLokalnaOsFizycznejRoot.JednLokalnaOsFizycznejData data) {
        return null;
    }

    public NaturalPersonLocalUnitPkdDTO convert(JednLokalnaOsFizycznejPkdRoot.JednLokalnaOsFizycznejPkdData data) {
        return NaturalPersonLocalUnitPkdDTO.builder()
                .pkdCode(data.getLokfizPkdKod())
                .pkdName(data.getLokfizPkdNazwa())
                .pkdDominant(data.getLokfizPkdPrzewazajace())
                .silosSymbol(data.getLokfizSilosSymbol())
                .build();
    }

    public LegalEntityDTO convert(OsPrawnaRoot.OsPrawnaData data) {
        return null;
    }

    public LegalEntityPkdDTO convert(OsPrawnaPkdRoot.OsPrawnaPkdData data) {
        return LegalEntityPkdDTO.builder()
                .pkdCode(data.getPrawPkdKod())
                .pkdDominant(data.getPrawPkdPrzewazajace())
                .pkdName(data.getPrawPkdNazwa())
                .build();
    }

    public LegalEntityLocalUnitsDTO convert(OsPrawnaListaJednLokalnychRoot.OsPrawnaListaJednLokalnychData data) {
        return null;
    }

    public LegalEntityLocalUnitDTO convert(JednLokalnaOsPrawnejRoot.JednLokalnaOsPrawnejData data) {
        return null;
    }

    public LegalEntityLocalUnitPkdDTO convert(JednLokalnaOsPrawnejPkdRoot.JednLokalnaOsPrawnejPkdData data) {
        return null;
    }

    public LegalEntityCivilPartnershipDTO convert(OsPrawnaSpCywilnaWspolnicyRoot.OsPrawnaSpCywilnaWspolnicyDane data) {
        return LegalEntityCivilPartnershipDTO.builder()
                .civilPartnerCompanyName(data.getWspolscFirmaNazwa())
                .civilPartnerFirstName(data.getWspolscImiePierwsze())
                .civilPartnerSecondName(data.getWspolscImieDrugie())
                .civilPartnerLastName(data.getWspolscNazwisko())
                .civilPartnerRegon(data.getWspolscRegonWspolnikSpolki()).build();
    }

    public SubjectTypeDTO convert(TypPodmiotuRoot.TypPodmiotuData data) {
        return SubjectTypeDTO.builder().type(data.getTyp()).build();
    }
}
