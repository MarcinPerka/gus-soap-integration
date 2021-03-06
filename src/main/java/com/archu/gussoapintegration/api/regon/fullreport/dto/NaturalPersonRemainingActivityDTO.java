package com.archu.gussoapintegration.api.regon.fullreport.dto;

import lombok.*;

@ToString
@Builder
@Getter
public class NaturalPersonRemainingActivityDTO extends FullReportBaseDTO {
    private final String regon;
    private final String name;
    private final String shortName;
    private final String dateOfCreation;
    private final String dateOfStartActivity;
    private final String dateOfEntryToRegon;
    private final String dateOfSuspendActivity;
    private final String dateOfResumptionActivity;
    private final String dateOfOccurrenceChange;
    private final String dateOfEndActivity;
    private final String dateOfDeleteFromRegon;
    private final String dateOfBankruptcyDeclaration;
    private final String dateOfConclusionOfBankruptcyProceedings;
    private final String countrySymbol;
    private final String voivodeshipSymbol;
    private final String districtSymbol;
    private final String municipalitySymbol;
    private final String postalCode;
    private final String postTownSymbol;
    private final String citySymbol;
    private final String streetSymbol;
    private final String apartmentNumber;
    private final String houseNumber;
    private final String unusualLocation;
    private final String phoneNumber;
    private final String extensionNumber;
    private final String faxNumber;
    private final String email;
    private final String websiteAddress;
    private final String countryName;
    private final String voivodeshipName;
    private final String districtName;
    private final String municipalityName;
    private final String cityName;
    private final String postTownName;
    private final String streetName;
    private final String dateOfRegisterInTheRegisterOfRecords;
    private final String numberInTheRegisterOfRecords;
    private final String registrationAuthoritySymbol;
    private final String registrationAuthorityName;
    private final String typeOfRegisterSymbol;
    private final String typeOfRegisterName;
}
