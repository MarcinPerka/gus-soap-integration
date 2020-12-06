package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class NaturalPersonGeneralDataDTO extends FullReportBaseDTO {

    private String regon;
    private String nip;
    private String nipStatus;
    private String lastName;
    private String firstName;
    private String secondName;
    private String dateOfEntryToRegon;
    private String dateOfOccurrenceChange;
    private String dateOfDeleteFromRegon;
    private String basicLegalFormSymbol;
    private String detailedLegalFormSymbol;
    private String financingFormSymbol;
    private String ownFormSymbol;
    private String basicLegalFormName;
    private String detailedLegalFormName;
    private String financingFormName;
    private String ownFormName;
    private Integer ceidgActivity;
    private Integer agriculturalActivity;
    private Integer remainingActivity;
    private Integer activityDeletedTo20141108;
    private Integer numberOfLocalUnits;
}
