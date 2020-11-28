package com.archu.gussoapintegration.regon.fullreport;

import com.archu.gussoapintegration.regon.fullreport.dto.FullReportBaseDTO;
import org.springframework.stereotype.Component;

@Component
public class FullReportConverterVisitorImpl implements FullReportVisitor<FullReportBaseDTO, Object> {
    @Override
    public FullReportBaseDTO visitOsFizycznaDaneOgolne(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitOsFizycznaDzialalnoscCeidg(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitOsFizycznaDzialalnoscRolnicza(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitOsFizycznaDzialalnoscPozostala(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitOsFizycznaDzialalnoscSkreslonaDo20141108(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitOsFizycznaPkd(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitOsFizycznaListaJednLokalnych(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitJednLokalnaOsFizycznej(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitJednLokalnaOsFizycznejPkd(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitOsPrawna(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitOsPrawnaPkd(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitOsPrawnaListaJednLokalnych(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitJednLokalnaOsPrawnej(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitJednLokalnaOsPrawnejPkd(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitOsPrawnaSpCywilnaWspolnicy(Object data) {
        return null;
    }

    @Override
    public FullReportBaseDTO visitTypPodmiotu(Object data) {
        return null;
    }
}
