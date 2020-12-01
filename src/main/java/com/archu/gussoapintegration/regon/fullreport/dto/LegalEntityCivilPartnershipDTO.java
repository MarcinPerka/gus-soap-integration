package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class LegalEntityCivilPartnershipDTO extends FullReportBaseDTO {
    protected String civilPartnerRegon;
    protected String civilPartnerFirstName;
    protected String civilPartnerSecondName;
    protected String civilPartnerLastName;
    protected String civilPartnerCompanyName;
}
