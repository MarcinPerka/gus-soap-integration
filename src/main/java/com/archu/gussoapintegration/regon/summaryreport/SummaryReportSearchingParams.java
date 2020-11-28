package com.archu.gussoapintegration.regon.summaryreport;

import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@ToString
public final class SummaryReportSearchingParams {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate date;

    //    @ValueOfEnum(enumClass = SummaryReportName.class, message = "{validator.enum.searching-params.summary-report-name.message}")
    @NotNull
    private SummaryReportName reportName;
}