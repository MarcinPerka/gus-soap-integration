package com.archu.gussoapintegration.regon.dto;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class SubjectDTO {

    private String regon;
    private String nip;
    private String statusNip;
    private String name;
    private String voivodeship;
    private String district;
    private String municipality;
    private String city;
    private String postalCode;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String type;
    private Integer silosId;
    private String businessEndDate;
    private String postTown;
}