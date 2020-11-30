package com.archu.gussoapintegration.regon.fullreport;

import com.archu.gussoapintegration.integration.regon.model.fullreport.*;
import com.archu.gussoapintegration.regon.fullreport.dto.FullReportBaseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FullReportConverterVisitorImpl implements FullReportVisitor<FullReportBaseDTO, Object> {

    private final FullReportConverter fullReportConverter;

    public FullReportBaseDTO process(final FullReportName fullReportName, final Object data) {
        return fullReportName.accept(this, data);
    }

    @Override
    public FullReportBaseDTO visitOsFizycznaDaneOgolne(Object data) {
        return fullReportConverter.convertOsFizycznaDaneOgolne((OsFizycznaDaneOgolneRoot.OsFizycznaDaneOgolneData) data);
    }

    @Override
    public FullReportBaseDTO visitOsFizycznaDzialalnoscCeidg(Object data) {
        return fullReportConverter.convertOsFizycznaDzialalnoscCeidg((OsFizycznaDzialalnoscCeidgRoot.OsFizycznaDzialalnoscCeidgData) data);
    }

    @Override
    public FullReportBaseDTO visitOsFizycznaDzialalnoscRolnicza(Object data) {
        return fullReportConverter.convertOsFizycznaDzialalnoscRolnicza((OsFizycznaDzialalnoscRolniczaRoot.OsFIzycznaDzialalnoscRolniczaData) data);
    }

    @Override
    public FullReportBaseDTO visitOsFizycznaDzialalnoscPozostala(Object data) {
        return fullReportConverter.convertOsFizycznaDzialalnoscPozostala((OsFizycznaDzialalnoscPozostalaRoot.OsFizycznaDzialalnoscPozostalaData) data);
    }

    @Override
    public FullReportBaseDTO visitOsFizycznaDzialalnoscSkreslonaDo20141108(Object data) {
        return fullReportConverter.convertOsFizycznaDzialalnoscSkreslonaDo20141108((OsFizycznaDzialalnoscSkreslonaDo20141108Root.OsFizycznaDzialalnoscSkreslonaDo20141108Data) data);
    }

    @Override
    public List<FullReportBaseDTO> visitOsFizycznaPkd(Object data) {
        var upcast = (List<OsFizycznaPkdRoot.OsFizycznaPkdData>) data;
        return upcast.stream().map(fullReportConverter::convertOsFizycznaPkd).collect(Collectors.toList());
    }

    @Override
    public List<FullReportBaseDTO> visitOsFizycznaListaJednLokalnych(Object data) {
        var upcast = (List<OsFizycznaListaJednLokalnychRoot.OsFizycznaListaJednLokalnychData>) data;
        return upcast.stream().map(fullReportConverter::convertOsFizycznaListaJednLokalnych).collect(Collectors.toList());
    }

    @Override
    public FullReportBaseDTO visitJednLokalnaOsFizycznej(Object data) {
        return fullReportConverter.convertJednLokalnaOsFizycznej((JednLokalnaOsFizycznejRoot.JednLokalnaOsFizycznejData) data);
    }

    @Override
    public List<FullReportBaseDTO> visitJednLokalnaOsFizycznejPkd(Object data) {
        var upcast = (List<JednLokalnaOsFizycznejPkdRoot.JednLokalnaOsFizycznejPkdData>) data;
        return upcast.stream().map(fullReportConverter::convertJednLokalnaOsFizycznejPkd).collect(Collectors.toList());
    }

    @Override
    public FullReportBaseDTO visitOsPrawna(Object data) {
        return fullReportConverter.convertOsPrawna((OsPrawnaRoot.OsPrawnaData) data);
    }

    @Override
    public FullReportBaseDTO visitOsPrawnaPkd(Object data) {
        return fullReportConverter.convertOsPrawnaPkd((OsPrawnaPkdRoot.OsPrawnaPkdData) data);
    }

    @Override
    public List<FullReportBaseDTO> visitOsPrawnaListaJednLokalnych(Object data) {
        var upcast = (List<OsPrawnaListaJednLokalnychRoot.OsPrawnaListaJednLokalnychData>) data;
        return upcast.stream().map(fullReportConverter::convertOsPrawnaListaJednLokalnych).collect(Collectors.toList());
    }

    @Override
    public FullReportBaseDTO visitJednLokalnaOsPrawnej(Object data) {
        return fullReportConverter.convertJednLokalnaOsPrawnej((JednLokalnaOsPrawnejRoot.JednLokalnaOsPrawnejData) data);
    }

    @Override
    public List<FullReportBaseDTO> visitJednLokalnaOsPrawnejPkd(Object data) {
        var upcast = (List<JednLokalnaOsPrawnejPkdRoot.JednLokalnaOsPrawnejPkdData>) data;
        return upcast.stream().map(fullReportConverter::convertJednLokalnaOsPrawnejPkd).collect(Collectors.toList());
    }

    @Override
    public List<FullReportBaseDTO> visitOsPrawnaSpCywilnaWspolnicy(Object data) {
        var upcast = (List<OsPrawnaSpCywilnaWspolnicyRoot.OsPrawnaSpCywilnaWspolnicyDane>) data;
        return upcast.stream().map(fullReportConverter::convertOsPrawnaSpCywilnaWspolnicy).collect(Collectors.toList());
    }

    @Override
    public FullReportBaseDTO visitTypPodmiotu(Object data) {
        return fullReportConverter.convertTypPodmiotu((TypPodmiotuRoot.TypPodmiotuData) data);
    }
}
