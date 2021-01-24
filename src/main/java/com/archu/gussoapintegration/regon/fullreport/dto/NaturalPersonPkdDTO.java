package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class NaturalPersonPkdDTO extends FullReportBaseDTO {
    private final String pkdCode;
    private final String pkdName;
    private final String pkdDominant;
    private final Integer silosId;
    private final String silosSymbol;
    private final String businessEndDate;
}
