package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class NaturalPersonRemainingActivityDTO extends FullReportBaseDTO {
    private String regon;
    private String name;
    private String shortName;
    private String dateOfCreation;
    private String dateOfStartActivity;
    private String dateOfEntryToRegon;
    private String dateOfSuspendActivity;
    private String dateOfResumptionActivity;
    private String dateOfOccurrenceChange;
    private String dateOfEndActivity;
    private String dateOfDeleteFromRegon;
    private String dateOfBankruptcyDeclaration;
    private String dateOfConclusionOfBankruptcyProceedings;
    private String countrySymbol;
    private String voivodeshipSymbol;
    private String districtSymbol;
    private String municipalitySymbol;
    private String postalCode;
    private String postTownSymbol;
    private String citySymbol;
    private String streetSymbol;
    private String apartmentNumber;
    private String houseNumber;
    private String unusualLocation;
    private String phoneNumber;
    private String extensionNumber;
    private String faxNumber;
    private String email;
    private String websiteAddress;
    private String countryName;
    private String voivodeshipName;
    private String districtName;
    private String muncipalityName;
    private String cityName;
    private String postTownName;
    private String streetName;
    private String dateOfRegisterInTheRegisterOfRecords;
    private String numberInTheRegisterOfRecords;
    private String registrationAuthoritySymbol;
    private String registrationAuthorityName;
    private String typeOfRegisterSymbol;
    private String typeOfRegisterName;
}
