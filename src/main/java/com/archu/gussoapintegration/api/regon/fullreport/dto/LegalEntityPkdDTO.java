package com.archu.gussoapintegration.api.regon.fullreport.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class LegalEntityPkdDTO extends FullReportBaseDTO {
    private final String pkdCode;
    private final String pkdName;
    private final String pkdDominant;
}
