package com.archu.gussoapintegration.regon.fullreport;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@ToString
public final class FullReportSearchingParams {

    @Pattern(regexp = "(?=[0-9]*$)(?:.{9}|.{14})$", message = "{validator.pattern.searching-params.regon.message}")
    @NotNull
    private String regon;

//    @ValueOfEnum(enumClass = FullReportName.class, message = "{validator.enum.searching-params.full-report-name.message}")
    @NotNull
    private FullReportName reportName;
}