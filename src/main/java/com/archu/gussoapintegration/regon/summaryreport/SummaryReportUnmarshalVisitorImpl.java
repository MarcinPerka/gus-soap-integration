package com.archu.gussoapintegration.regon.summaryreport;

import com.archu.gussoapintegration.integration.regon.SoapRegonUtils;
import com.archu.gussoapintegration.integration.regon.model.summaryreport.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class SummaryReportUnmarshalVisitorImpl implements SummaryReportVisitor<List<Object>, String> {

    public List<Object> process(final SummaryReportName summaryReportName, final String data) {
        return summaryReportName.visit(this, data);
    }

    @Override
    public List<Object> visitNowePodmiotyPrawneOrazDzialalnosciOsFizycznych(String data) {
        return Collections.singletonList(SoapRegonUtils.unmarshal(data, NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane());
    }

    @Override
    public List<Object> visitAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych(String data) {
        return Collections.singletonList(SoapRegonUtils.unmarshal(data, AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane());
    }

    @Override
    public List<Object> visitSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych(String data) {
        return Collections.singletonList(SoapRegonUtils.unmarshal(data, SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.class).getDane());
    }

    @Override
    public List<Object> visitNoweJednostkiLokalne(String data) {
        return Collections.singletonList(SoapRegonUtils.unmarshal(data, NoweJednostkiLokalneRoot.class).getDane());
    }

    @Override
    public List<Object> visitAktualizowaneJednostkiLokalne(String data) {
        return Collections.singletonList(SoapRegonUtils.unmarshal(data, AktualizowaneJednostkiLokalneRoot.class).getDane());
    }

    @Override
    public List<Object> visitJednostkiLokalneSkreslone(String data) {
        return Collections.singletonList(SoapRegonUtils.unmarshal(data, SkresloneJednostkiLokalneRoot.class).getDane());
    }
}
