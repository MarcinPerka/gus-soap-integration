package com.archu.gussoapintegration.api.regon.summaryreport;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public final class SummaryReportSearchingParams {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{validator.not-null.searching-params.date.message}")
    private final LocalDate date;
}