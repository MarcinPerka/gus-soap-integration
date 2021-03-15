package com.archu.gussoapintegration.api.regon.fullreport.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class NaturalPersonGeneralDataDTO extends FullReportBaseDTO {

    private final String regon;
    private final String nip;
    private final String nipStatus;
    private final String lastName;
    private final String firstName;
    private final String secondName;
    private final String dateOfEntryToRegon;
    private final String dateOfOccurrenceChange;
    private final String dateOfDeleteFromRegon;
    private final String basicLegalFormSymbol;
    private final String detailedLegalFormSymbol;
    private final String financingFormSymbol;
    private final String ownFormSymbol;
    private final String basicLegalFormName;
    private final String detailedLegalFormName;
    private final String financingFormName;
    private final String ownFormName;
    private final Integer ceidgActivity;
    private final Integer agriculturalActivity;
    private final Integer remainingActivity;
    private final Integer activityDeletedTo20141108;
    private final Integer numberOfLocalUnits;
}
