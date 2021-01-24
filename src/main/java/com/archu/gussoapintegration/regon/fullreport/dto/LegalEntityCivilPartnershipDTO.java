package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@ToString
@Getter
public class LegalEntityCivilPartnershipDTO extends FullReportBaseDTO {
    private final String civilPartnerRegon;
    private final String civilPartnerFirstName;
    private final String civilPartnerSecondName;
    private final String civilPartnerLastName;
    private final String civilPartnerCompanyName;
}
