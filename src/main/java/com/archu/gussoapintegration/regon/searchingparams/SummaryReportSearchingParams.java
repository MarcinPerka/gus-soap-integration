package com.archu.gussoapintegration.regon.searchingparams;

import com.archu.gussoapintegration.regon.reportname.SummaryReportName;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@ToString
public final class SummaryReportSearchingParams {

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate date;

    //    @ValueOfEnum(enumClass = SummaryReportName.class, message = "{validator.enum.searching-params.summary-report-name.message}")
    private SummaryReportName reportName;
}