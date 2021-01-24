package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class NaturalPersonLocalUnitPkdDTO extends FullReportBaseDTO {

    private final String pkdCode;
    private final String pkdName;
    private final String pkdDominant;
    private final String silosSymbol;

}
