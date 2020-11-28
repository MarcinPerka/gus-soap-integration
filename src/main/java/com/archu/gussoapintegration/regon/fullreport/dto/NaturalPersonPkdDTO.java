package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NaturalPersonPkdDTO extends FullReportBaseDTO {
    private String pkdCode;
    private String pkdName;
    private String pkdDominant;
    private Integer silosId;
    private String silosSymbol;
    private String businessEndDate;
}
