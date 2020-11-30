package com.archu.gussoapintegration.regon.summaryreport;

import com.archu.gussoapintegration.integration.regon.model.summaryreport.*;
import com.archu.gussoapintegration.regon.summaryreport.dto.SummaryReportBaseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SummaryReportConverterVisitorImpl implements SummaryReportVisitor<List<SummaryReportBaseDTO>, List<Object>> {

    private final SummaryReportConverter summaryReportConverter;

    public List<SummaryReportBaseDTO> process(final SummaryReportName summaryReportName, final List<Object> data) {
        return summaryReportName.visit(this, data);
    }

    @Override
    public List<SummaryReportBaseDTO> visitNowePodmiotyPrawneOrazDzialalnosciOsFizycznych(List<Object> data) {
        return data.stream().map(it -> summaryReportConverter.convertNowePodmiotyPrawneOrazDzialalnosciOsFizycznychData((NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData) it)).collect(Collectors.toList());
    }

    @Override
    public List<SummaryReportBaseDTO> visitAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych(List<Object> data) {
        return data.stream().map(it -> summaryReportConverter.convertAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych((AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData) it)).collect(Collectors.toList());
    }

    @Override
    public List<SummaryReportBaseDTO> visitSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych(List<Object> data) {
        return data.stream().map(it -> summaryReportConverter.convertSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych((SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData) it)).collect(Collectors.toList());
    }

    @Override
    public List<SummaryReportBaseDTO> visitNoweJednostkiLokalne(List<Object> data) {
        return data.stream().map(it -> summaryReportConverter.convertNoweJednostkiLokalne((NoweJednostkiLokalneRoot.NoweJednostkiLokalneData) it)).collect(Collectors.toList());
    }

    @Override
    public List<SummaryReportBaseDTO> visitAktualizowaneJednostkiLokalne(List<Object> data) {
        return data.stream().map(it -> summaryReportConverter.convertAktualizowaneJednostkiLokalne((AktualizowaneJednostkiLokalneRoot.AktualizowaneJednostkiLokalneData) it)).collect(Collectors.toList());
    }

    @Override
    public List<SummaryReportBaseDTO> visitJednostkiLokalneSkreslone(List<Object> data) {
        return data.stream().map(it -> summaryReportConverter.convertJednostkiLokalneSkreslone((SkresloneJednostkiLokalneRoot.SkresloneJednostkiLokalneData) it)).collect(Collectors.toList());
    }

}
