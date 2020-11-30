package com.archu.gussoapintegration.regon.summaryreport;

import com.archu.gussoapintegration.integration.regon.summaryreport.model.*;
import com.archu.gussoapintegration.regon.summaryreport.dto.SummaryReportBaseDTO;
import org.springframework.stereotype.Component;

@Component
public class SummaryReportConverter {

    public SummaryReportBaseDTO convertNowePodmiotyPrawneOrazDzialalnosciOsFizycznychDataToSummaryReportBaseDTO(NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convertAktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychToSummaryReportBaseDTO(AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convertSkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychToSummaryReportBaseDTO(SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convertNoweJednostkiLokalneToSummaryReportBaseDTO(NoweJednostkiLokalneRoot.NoweJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convertAktualizowaneJednostkiLokalneToSummaryReportBaseDTO(AktualizowaneJednostkiLokalneRoot.AktualizowaneJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convertJednostkiLokalneSkresloneToSummaryReportBaseDTO(SkresloneJednostkiLokalneRoot.SkresloneJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }
}
