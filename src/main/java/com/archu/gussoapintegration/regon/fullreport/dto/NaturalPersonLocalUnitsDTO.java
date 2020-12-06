package com.archu.gussoapintegration.regon.fullreport.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class NaturalPersonLocalUnitsDTO extends FullReportBaseDTO {
    private String regon;
    private String name;
    private Integer silosId;
    private String silosSymbol;
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
    private String voivodeshipName;
    private String districtName;
    private String municipalityName;
    private String cityName;
    private String postTownName;
    private String streetName;
    private String dateOfCreation;
    private String dateOfStartActivity;
    private String dateOfEntryToRegon;
    private String dateOfSuspendActivity;
    private String dateOfResumptionActivity;
    private String dateOfEndActivity;
    private String dateOfDeleteFromRegon;
}
