package com.archu.gussoapintegration.regon.fullreport;

import com.archu.gussoapintegration.integration.regon.SoapRegonUtils;
import com.archu.gussoapintegration.integration.regon.model.fullreport.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FullReportUnmarshalVisitorImpl implements FullReportVisitor<Object, String> {

    public Object process(final FullReportName fullReportName, final String data) {
        return fullReportName.accept(this, data);
    }

    @Override
    public OsFizycznaDaneOgolneRoot.OsFizycznaDaneOgolneData visitOsFizycznaDaneOgolne(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaDaneOgolneRoot.class).getDane();
    }

    @Override
    public OsFizycznaDzialalnoscCeidgRoot.OsFizycznaDzialalnoscCeidgData visitOsFizycznaDzialalnoscCeidg(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaDzialalnoscCeidgRoot.class).getDane();
    }

    @Override
    public OsFizycznaDzialalnoscRolniczaRoot.OsFIzycznaDzialalnoscRolniczaData visitOsFizycznaDzialalnoscRolnicza(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaDzialalnoscRolniczaRoot.class).getDane();
    }

    @Override
    public OsFizycznaDzialalnoscPozostalaRoot.OsFizycznaDzialalnoscPozostalaData visitOsFizycznaDzialalnoscPozostala(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaDzialalnoscPozostalaRoot.class).getDane();
    }

    @Override
    public OsFizycznaDzialalnoscSkreslonaDo20141108Root.OsFizycznaDzialalnoscSkreslonaDo20141108Data visitOsFizycznaDzialalnoscSkreslonaDo20141108(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaDzialalnoscSkreslonaDo20141108Root.class).getDane();
    }

    @Override
    public List<OsFizycznaPkdRoot.OsFizycznaPkdData> visitOsFizycznaPkd(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaPkdRoot.class).getDane();
    }

    @Override
    public List<OsFizycznaListaJednLokalnychRoot.OsFizycznaListaJednLokalnychData> visitOsFizycznaListaJednLokalnych(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaListaJednLokalnychRoot.class).getDane();
    }

    @Override
    public JednLokalnaOsFizycznejRoot.JednLokalnaOsFizycznejData visitJednLokalnaOsFizycznej(String data) {
        return SoapRegonUtils.unmarshal(data, JednLokalnaOsFizycznejRoot.class).getDane();
    }

    @Override
    public List<JednLokalnaOsFizycznejPkdRoot.JednLokalnaOsFizycznejPkdData> visitJednLokalnaOsFizycznejPkd(String data) {
        return SoapRegonUtils.unmarshal(data, JednLokalnaOsFizycznejPkdRoot.class).getDane();
    }

    @Override
    public OsPrawnaRoot.OsPrawnaData visitOsPrawna(String data) {
        return SoapRegonUtils.unmarshal(data, OsPrawnaRoot.class).getDane();
    }

    @Override
    public List<OsPrawnaPkdRoot.OsPrawnaPkdData> visitOsPrawnaPkd(String data) {
        return SoapRegonUtils.unmarshal(data, OsPrawnaPkdRoot.class).getDane();
    }

    @Override
    public List<OsPrawnaListaJednLokalnychRoot.OsPrawnaListaJednLokalnychData> visitOsPrawnaListaJednLokalnych(String data) {
        return SoapRegonUtils.unmarshal(data, OsPrawnaListaJednLokalnychRoot.class).getDane();
    }

    @Override
    public JednLokalnaOsPrawnejRoot.JednLokalnaOsPrawnejData visitJednLokalnaOsPrawnej(String data) {
        return SoapRegonUtils.unmarshal(data, JednLokalnaOsPrawnejRoot.class).getDane();
    }

    @Override
    public List<JednLokalnaOsPrawnejPkdRoot.JednLokalnaOsPrawnejPkdData> visitJednLokalnaOsPrawnejPkd(String data) {
        return SoapRegonUtils.unmarshal(data, JednLokalnaOsPrawnejPkdRoot.class).getDane();
    }

    @Override
    public List<OsPrawnaSpCywilnaWspolnicyRoot.OsPrawnaSpCywilnaWspolnicyDane> visitOsPrawnaSpCywilnaWspolnicy(String data) {
        return SoapRegonUtils.unmarshal(data, OsPrawnaSpCywilnaWspolnicyRoot.class).getDane();
    }

    @Override
    public TypPodmiotuRoot.TypPodmiotuData visitTypPodmiotu(String data) {
        return SoapRegonUtils.unmarshal(data, TypPodmiotuRoot.class).getDane();
    }
}
