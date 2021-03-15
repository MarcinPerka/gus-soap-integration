package com.archu.gussoapintegration.api.regon.fullreport.dto;

import lombok.*;

@ToString
@Builder
@Getter
public class SubjectTypeDTO extends FullReportBaseDTO {
    private final String type;
}
