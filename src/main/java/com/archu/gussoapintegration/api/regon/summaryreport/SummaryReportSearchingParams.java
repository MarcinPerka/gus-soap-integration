package com.archu.gussoapintegration.api.regon.summaryreport;

import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@ToString
public final class SummaryReportSearchingParams {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{validator.not-null.searching-params.date.message}")
    private LocalDate date;
}