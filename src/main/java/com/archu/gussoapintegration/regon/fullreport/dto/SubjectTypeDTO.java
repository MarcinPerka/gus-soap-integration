package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class SubjectTypeDTO extends FullReportBaseDTO {
    private String type;
}
