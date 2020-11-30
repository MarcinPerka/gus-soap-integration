package com.archu.gussoapintegration.regon.summaryreport;

import com.archu.gussoapintegration.integration.regon.model.summaryreport.*;
import com.archu.gussoapintegration.regon.summaryreport.dto.SummaryReportBaseDTO;
import org.springframework.stereotype.Component;

@Component
public class SummaryReportConverter {

    public SummaryReportBaseDTO convertNowePodmiotyPrawneOrazDzialalnosciOsFizycznychData(NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convertAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznych(AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convertSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznych(SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convertNoweJednostkiLokalne(NoweJednostkiLokalneRoot.NoweJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convertAktualizowaneJednostkiLokalne(AktualizowaneJednostkiLokalneRoot.AktualizowaneJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convertJednostkiLokalneSkreslone(SkresloneJednostkiLokalneRoot.SkresloneJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }
}
