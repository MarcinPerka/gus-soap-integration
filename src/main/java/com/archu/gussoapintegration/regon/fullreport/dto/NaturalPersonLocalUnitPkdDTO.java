package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class NaturalPersonLocalUnitPkdDTO extends FullReportBaseDTO {

    private String pkdCode;
    private String pkdName;
    private String pkdDominant;
    private String silosSymbol;

}
