package com.archu.gussoapintegration.regon.fullreport;

import com.archu.gussoapintegration.integration.regon.SoapRegonUtils;
import com.archu.gussoapintegration.integration.regon.model.fullreport.*;
import org.springframework.stereotype.Component;

@Component
public class FullReportUnmarshalVisitorImpl implements FullReportVisitor<Object, String> {

    public Object process(final FullReportName fullReportName, final String data) {
        return fullReportName.accept(this, data);
    }

    @Override
    public Object visitOsFizycznaDaneOgolne(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaDaneOgolneRoot.class);
    }

    @Override
    public Object visitOsFizycznaDzialalnoscCeidg(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaDzialalnoscCeidgRoot.class);
    }

    @Override
    public Object visitOsFizycznaDzialalnoscRolnicza(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaDzialalnoscRolniczaRoot.class);
    }

    @Override
    public Object visitOsFizycznaDzialalnoscPozostala(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaDzialalnoscPozostalaRoot.class);
    }

    @Override
    public Object visitOsFizycznaDzialalnoscSkreslonaDo20141108(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaDzialalnoscSkreslonaDo20141108Root.class);
    }

    @Override
    public Object visitOsFizycznaPkd(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaPkdRoot.class);
    }

    @Override
    public Object visitOsFizycznaListaJednLokalnych(String data) {
        return SoapRegonUtils.unmarshal(data, OsFizycznaListaJednLokalnychRoot.class);
    }

    @Override
    public Object visitJednLokalnaOsFizycznej(String data) {
        return SoapRegonUtils.unmarshal(data, JednLokalnaOsFizycznejRoot.class);
    }

    @Override
    public Object visitJednLokalnaOsFizycznejPkd(String data) {
        return SoapRegonUtils.unmarshal(data, JednLokalnaOsFizycznejPkdRoot.class);
    }

    @Override
    public Object visitOsPrawna(String data) {
        return SoapRegonUtils.unmarshal(data, OsPrawnaRoot.class);
    }

    @Override
    public Object visitOsPrawnaPkd(String data) {
        return SoapRegonUtils.unmarshal(data, OsPrawnaPkdRoot.class);
    }

    @Override
    public Object visitOsPrawnaListaJednLokalnych(String data) {
        return SoapRegonUtils.unmarshal(data, OsPrawnaListaJednLokalnychRoot.class);
    }

    @Override
    public Object visitJednLokalnaOsPrawnej(String data) {
        return SoapRegonUtils.unmarshal(data, JednLokalnaOsPrawnejRoot.class);
    }

    @Override
    public Object visitJednLokalnaOsPrawnejPkd(String data) {
        return SoapRegonUtils.unmarshal(data, JednLokalnaOsPrawnejPkdRoot.class);
    }

    @Override
    public Object visitOsPrawnaSpCywilnaWspolnicy(String data) {
        return SoapRegonUtils.unmarshal(data, OsPrawnaSpCywilnaWspolnicyRoot.class);
    }

    @Override
    public Object visitTypPodmiotu(String data) {
        return SoapRegonUtils.unmarshal(data, TypPodmiotuRoot.class);
    }
}
