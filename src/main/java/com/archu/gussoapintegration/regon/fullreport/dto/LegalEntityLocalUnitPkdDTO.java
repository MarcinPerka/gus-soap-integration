package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class LegalEntityLocalUnitPkdDTO extends FullReportBaseDTO {
    private String pdkCode;
    private String pkdName;
    private String pkdDominant;
}
