package com.archu.gussoapintegration.api.regon.summaryreport;

import com.archu.gussoapintegration.api.regon.summaryreport.dto.SummaryReportBaseDTO;
import com.archu.gussoapintegration.integration.regon.summaryreport.model.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class SummaryReportConverter {

    public SummaryReportBaseDTO convert(NowePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.NowePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(StringUtils.hasText(data.getRegon()) ? data.getRegon() : null);
    }

    public SummaryReportBaseDTO convert(AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.AktualizowanePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(StringUtils.hasText(data.getRegon()) ? data.getRegon() : null);
    }

    public SummaryReportBaseDTO convert(SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychRoot.SkreslonePodmiotyPrawneOrazDzialalnosciOsFizycznychData data) {
        return new SummaryReportBaseDTO(StringUtils.hasText(data.getRegon()) ? data.getRegon() : null);
    }

    public SummaryReportBaseDTO convert(NoweJednostkiLokalneRoot.NoweJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(StringUtils.hasText(data.getRegon()) ? data.getRegon() : null);
    }

    public SummaryReportBaseDTO convert(AktualizowaneJednostkiLokalneRoot.AktualizowaneJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(StringUtils.hasText(data.getRegon()) ? data.getRegon() : null);
    }

    public SummaryReportBaseDTO convert(SkresloneJednostkiLokalneRoot.SkresloneJednostkiLokalneData data) {
        return new SummaryReportBaseDTO(StringUtils.hasText(data.getRegon()) ? data.getRegon() : null);
    }
}
