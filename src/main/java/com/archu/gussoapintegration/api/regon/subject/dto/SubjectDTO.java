package com.archu.gussoapintegration.api.regon.subject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Builder
@ToString
@Getter
public class SubjectDTO {

    private final String regon;
    private final String nip;
    private final String statusNip;
    private final String name;
    private final String voivodeship;
    private final String district;
    private final String municipality;
    private final String city;
    private final String postalCode;
    private final String street;
    private final String houseNumber;
    private final String apartmentNumber;
    private final String type;
    private final Integer silosId;
    private final String businessEndDate;
    private final String postTown;
}