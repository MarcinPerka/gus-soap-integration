package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class LegalEntityLocalUnitPkdDTO extends FullReportBaseDTO {
    private final String pdkCode;
    private final String pkdName;
    private final String pkdDominant;
}
