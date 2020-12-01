package com.archu.gussoapintegration.regon.fullreport;

import com.archu.gussoapintegration.integration.regon.fullreport.model.*;
import com.archu.gussoapintegration.regon.fullreport.dto.*;
import org.springframework.stereotype.Component;

@Component
public class FullReportConverter {
    //TODO(Not finished)
    public NaturalPersonGeneralDataDTO convert(OsFizycznaDaneOgolneRoot.OsFizycznaDaneOgolneData data) {
        return null;
    }

    public FullReportBaseDTO convert(OsFizycznaDzialalnoscCeidgRoot.OsFizycznaDzialalnoscCeidgData data) {
        return null;
    }

    public FullReportBaseDTO convert(OsFizycznaDzialalnoscRolniczaRoot.OsFizycznaDzialalnoscRolniczaData data) {
        return null;
    }

    public FullReportBaseDTO convert(OsFizycznaDzialalnoscPozostalaRoot.OsFizycznaDzialalnoscPozostalaData data) {
        return null;
    }

    public FullReportBaseDTO convert(OsFizycznaDzialalnoscSkreslonaDo20141108Root.OsFizycznaDzialalnoscSkreslonaDo20141108Data data) {
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

    public FullReportBaseDTO convert(OsFizycznaListaJednLokalnychRoot.OsFizycznaListaJednLokalnychData data) {
        return null;
    }

    public FullReportBaseDTO convert(JednLokalnaOsFizycznejRoot.JednLokalnaOsFizycznejData data) {
        return null;
    }

    public FullReportBaseDTO convert(JednLokalnaOsFizycznejPkdRoot.JednLokalnaOsFizycznejPkdData data) {
        return null;
    }

    public FullReportBaseDTO convert(OsPrawnaRoot.OsPrawnaData data) {
        return null;
    }

    public LegalEntityPkdDTO convert(OsPrawnaPkdRoot.OsPrawnaPkdData data) {
        return LegalEntityPkdDTO.builder()
                .pkdCode(data.getPrawPkdKod())
                .pkdDominant(data.getPrawPkdPrzewazajace())
                .pkdName(data.getPrawPkdNazwa())
                .build();
    }

    public FullReportBaseDTO convert(OsPrawnaListaJednLokalnychRoot.OsPrawnaListaJednLokalnychData data) {
        return null;
    }

    public FullReportBaseDTO convert(JednLokalnaOsPrawnejRoot.JednLokalnaOsPrawnejData data) {
        return null;
    }

    public FullReportBaseDTO convert(JednLokalnaOsPrawnejPkdRoot.JednLokalnaOsPrawnejPkdData data) {
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
