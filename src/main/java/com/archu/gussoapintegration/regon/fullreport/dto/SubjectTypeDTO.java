package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.*;

@ToString
@Builder
@Getter
public class SubjectTypeDTO extends FullReportBaseDTO {
    private final String type;
}
