package com.archu.gussoapintegration.regon.summaryreport;

import com.archu.gussoapintegration.integration.regon.summaryreport.model.*;
import com.archu.gussoapintegration.regon.summaryreport.dto.SummaryReportBaseDTO;
import org.springframework.stereotype.Component;

@Component
public class SummaryReportConverter {

    public SummaryReportBaseDTO convert(NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convert(AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convert(SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convert(NoweJednostkiLokalneRoot.NoweJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convert(AktualizowaneJednostkiLokalneRoot.AktualizowaneJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }

    public SummaryReportBaseDTO convert(SkresloneJednostkiLokalneRoot.SkresloneJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(data.getRegon());
    }
}
