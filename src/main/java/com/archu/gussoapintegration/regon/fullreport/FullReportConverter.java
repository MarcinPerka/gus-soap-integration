package com.archu.gussoapintegration.regon.fullreport;

import com.archu.gussoapintegration.exception.NotImplementedException;
import com.archu.gussoapintegration.integration.regon.fullreport.model.*;
import com.archu.gussoapintegration.regon.fullreport.dto.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

//TODO remove blank strings in every converter
@Component
public class FullReportConverter {

    public NaturalPersonGeneralDataDTO convert(OsFizycznaDaneOgolneRoot.OsFizycznaDaneOgolneData data) {
        return NaturalPersonGeneralDataDTO.builder()
                .regon(StringUtils.hasText(data.getFizRegon9()) ? data.getFizRegon9() : null)
                .nip(StringUtils.hasText(data.getFizNip()) ? data.getFizNip() : null)
                .status(StringUtils.hasText(data.getFizStatusNip()) ? data.getFizStatusNip() : null)
                .lastName(StringUtils.hasText(data.getFizNazwisko()) ? data.getFizNazwisko() : null)
                .firstName(StringUtils.hasText(data.getFizImie1()) ? data.getFizImie1() : null)
                .secondName(StringUtils.hasText(data.getFizImie2()) ? data.getFizImie2() : null)
                .dateOfEntryToRegon(StringUtils.hasText(data.getFizDataWpisuPodmiotuDoRegon()) ? data.getFizDataWpisuPodmiotuDoRegon() : null)
                .dateOfOccurrenceChange(StringUtils.hasText(data.getFizDataZaistnieniaZmiany()) ? data.getFizDataZaistnieniaZmiany() : null)
                .dateOfDeleteFromRegon(StringUtils.hasText(data.getFizDataSkresleniaPodmiotuZRegon()) ? data.getFizDataSkresleniaPodmiotuZRegon() : null)
                .basicLegalFormSymbol(StringUtils.hasText(data.getFizPodstawowaFormaPrawnaSymbol()) ? data.getFizPodstawowaFormaPrawnaSymbol() : null)
                .detailedLegalFormSymbol(StringUtils.hasText(data.getFizSzczegolnaFormaPrawnaSymbol()) ? data.getFizSzczegolnaFormaPrawnaSymbol() : null)
                .financingFormSymbol(StringUtils.hasText(data.getFizFormaFinansowaniaSymbol()) ? data.getFizFormaFinansowaniaSymbol() : null)
                .ownFormSymbol(StringUtils.hasText(data.getFizFormaWlasnosciSymbol()) ? data.getFizFormaWlasnosciSymbol() : null)
                .basicLegalFormName(StringUtils.hasText(data.getFizPodstawowaFormaPrawnaNazwa()) ? data.getFizPodstawowaFormaPrawnaNazwa() : null)
                .detailedLegalFormName(StringUtils.hasText(data.getFizSzczegolnaFormaPrawnaNazwa()) ? data.getFizSzczegolnaFormaPrawnaNazwa() : null)
                .financingFormName(StringUtils.hasText(data.getFizFormaFinansowaniaNazwa()) ? data.getFizFormaFinansowaniaNazwa() : null)
                .ownFormName(StringUtils.hasText(data.getFizFormaWlasnosciNazwa()) ? data.getFizFormaWlasnosciNazwa() : null)
                .ceidgActivity(data.getFizDzialalnoscCeidg())
                .agriculturalActivity(data.getFizDzialalnoscRolnicza())
                .remainingActivity(data.getFizDzialalnoscPozostala())
                .activityDeletedTo20141108(data.getFizDzialalnoscSkreslonaDo20141108())
                .numberOfLocalUnits(data.getFizLiczbaJednLokalnych())
                .build();
    }

    public NaturalPersonCeidgActivityDTO convert(OsFizycznaDzialalnoscCeidgRoot.OsFizycznaDzialalnoscCeidgData data) {
        return NaturalPersonCeidgActivityDTO.builder()
                .regon(StringUtils.hasText(data.getFizRegon9()) ? data.getFizRegon9() : null)
                .name(StringUtils.hasText(data.getFizNazwa()) ? data.getFizNazwa() : null)
                .shortName(StringUtils.hasText(data.getFizNazwaSkrocona()) ? data.getFizNazwaSkrocona() : null)
                .dateOfCreation(StringUtils.hasText(data.getFizDataPowstania()) ? data.getFizDataPowstania() : null)
                .dateOfStartActivity(StringUtils.hasText(data.getFizDataRozpoczeciaDzialalnosci()) ? data.getFizDataRozpoczeciaDzialalnosci() : null)
                .dateOfEntryToRegon(StringUtils.hasText(data.getFizDataWpisuDzialalnosciDoRegon()) ? data.getFizDataWpisuDzialalnosciDoRegon() : null)
                .dateOfSuspendActivity(StringUtils.hasText(data.getFizDataZawieszeniaDzialalnosci()) ? data.getFizDataZawieszeniaDzialalnosci() : null)
                .dateOfResumptionActivity(StringUtils.hasText(data.getFizDataWznowieniaDzialalnosci()) ? data.getFizDataWznowieniaDzialalnosci() : null)
                .dateOfOccurrenceChange(StringUtils.hasText(data.getFizDataZaistnieniaZmianyDzialalnosci()) ? data.getFizDataZaistnieniaZmianyDzialalnosci() : null)
                .dateOfEndActivity(StringUtils.hasText(data.getFizDataZakonczeniaDzialalnosci()) ? data.getFizDataZakonczeniaDzialalnosci() : null)
                .dateOfDeleteFromRegon(StringUtils.hasText(data.getFizDataSkresleniaDzialalnosciZRegon()) ? data.getFizDataSkresleniaDzialalnosciZRegon() : null)
                .dateOfBankruptcyDeclaration(StringUtils.hasText(data.getFizDataOrzeczeniaOUpadlosci()) ? data.getFizDataOrzeczeniaOUpadlosci() : null)
                .dateOfConclusionOfBankruptcyProceedings(StringUtils.hasText(data.getFizDataZakonczeniaPostepowaniaUpadlosciowego()) ? data.getFizDataZakonczeniaPostepowaniaUpadlosciowego() : null)
                .countrySymbol(StringUtils.hasText(data.getFizAdSiedzKrajSymbol()) ? data.getFizAdSiedzKrajSymbol() : null)
                .voivodeshipSymbol(StringUtils.hasText(data.getFizAdSiedzWojewodztwoSymbol()) ? data.getFizAdSiedzWojewodztwoSymbol() : null)
                .districtSymbol(StringUtils.hasText(data.getFizAdSiedzPowiatSymbol()) ? data.getFizAdSiedzPowiatSymbol() : null)
                .municipalitySymbol(StringUtils.hasText(data.getFizAdSiedzGminaSymbol()) ? data.getFizAdSiedzGminaSymbol() : null)
                .postalCode(StringUtils.hasText(data.getFizAdSiedzKodPocztowy()) ? data.getFizAdSiedzKodPocztowy() : null)
                .postTownSymbol(StringUtils.hasText(data.getFizAdSiedzMiejscowoscPocztySymbol()) ? data.getFizAdSiedzMiejscowoscPocztySymbol() : null)
                .citySymbol(StringUtils.hasText(data.getFizAdSiedzMiejscowoscSymbol()) ? data.getFizAdSiedzMiejscowoscSymbol() : null)
                .streetSymbol(StringUtils.hasText(data.getFizAdSiedzUlicaSymbol()) ? data.getFizAdSiedzUlicaSymbol() : null)
                .apartmentNumber(StringUtils.hasText(data.getFizAdSiedzNumerNieruchomosci()) ? data.getFizAdSiedzNumerNieruchomosci() : null)
                .houseNumber(StringUtils.hasText(data.getFizAdSiedzNumerLokalu()) ? data.getFizAdSiedzNumerLokalu() : null)
                .unusualLocation(StringUtils.hasText(data.getFizAdSiedzNietypoweMiejsceLokalizacji()) ? data.getFizAdSiedzNietypoweMiejsceLokalizacji() : null)
                .phoneNumber(StringUtils.hasText(data.getFizNumerTelefonu()) ? data.getFizNumerTelefonu() : null)
                .extensionNumber(StringUtils.hasText(data.getFizNumerWewnetrznyTelefonu()) ? data.getFizNumerWewnetrznyTelefonu() : null)
                .faxNumber(StringUtils.hasText(data.getFizNumerFaksu()) ? data.getFizNumerFaksu() : null)
                .email(StringUtils.hasText(data.getFizAdresEmail()) ? data.getFizAdresEmail() : null)
                .websiteAddress(StringUtils.hasText(data.getFizAdresStronyinternetowej()) ? data.getFizAdresStronyinternetowej() : null)
                .countryName(StringUtils.hasText(data.getFizAdSiedzKrajNazwa()) ? data.getFizAdSiedzKrajNazwa() : null)
                .voivodeshipName(StringUtils.hasText(data.getFizAdSiedzWojewodztwoNazwa()) ? data.getFizAdSiedzWojewodztwoNazwa() : null)
                .districtName(StringUtils.hasText(data.getFizAdSiedzPowiatNazwa()) ? data.getFizAdSiedzPowiatNazwa() : null)
                .muncipalityName(StringUtils.hasText(data.getFizAdSiedzGminaNazwa()) ? data.getFizAdSiedzGminaNazwa() : null)
                .cityName(StringUtils.hasText(data.getFizAdSiedzMiejscowoscNazwa()) ? data.getFizAdSiedzMiejscowoscNazwa() : null)
                .postTownName(StringUtils.hasText(data.getFizAdSiedzMiejscowoscPocztyNazwa()) ? data.getFizAdSiedzMiejscowoscPocztyNazwa() : null)
                .streetName(StringUtils.hasText(data.getFizAdSiedzUlicaNazwa()) ? data.getFizAdSiedzUlicaNazwa() : null)
                .dateOfRegisterInTheRegisterOfRecords(StringUtils.hasText(data.getFizCDataWpisuDoRejestruEwidencji()) ? data.getFizCDataWpisuDoRejestruEwidencji() : null)
                .dateOfDeleteFromTheRegisterOfRecords(StringUtils.hasText(data.getFizCDataSkresleniaZRejestruEwidencji()) ? data.getFizCDataSkresleniaZRejestruEwidencji() : null)
                .numberInTheRegisterOfRecords(StringUtils.hasText(data.getFizCNumerWRejestrzeEwidencji()) ? data.getFizCNumerWRejestrzeEwidencji() : null)
                .registrationAuthoritySymbol(StringUtils.hasText(data.getFizCOrganRejestrowySymbol()) ? data.getFizCOrganRejestrowySymbol() : null)
                .registrationAuthorityName(StringUtils.hasText(data.getFizCOrganRejestrowyNazwa()) ? data.getFizCOrganRejestrowyNazwa() : null)
                .typeOfRegisterSymbol(StringUtils.hasText(data.getFizCRodzajRejestruSymbol()) ? data.getFizCRodzajRejestruSymbol() : null)
                .typeOfRegisterName(StringUtils.hasText(data.getFizCRodzajRejestruNazwa()) ? data.getFizCRodzajRejestruNazwa() : null)
                .activityCommenced(data.isFizCNiePodjetoDzialalnosci())
                .build();
    }

    public NaturalPersonAgriculturalActivityDTO convert(OsFizycznaDzialalnoscRolniczaRoot.OsFizycznaDzialalnoscRolniczaData data) {
        return NaturalPersonAgriculturalActivityDTO.builder()
                .regon(StringUtils.hasText(data.getFizRegon9()) ? data.getFizRegon9() : null)
                .name(StringUtils.hasText(data.getFizNazwa()) ? data.getFizNazwa() : null)
                .shortName(StringUtils.hasText(data.getFizNazwaSkrocona()) ? data.getFizNazwaSkrocona() : null)
                .dateOfCreation(StringUtils.hasText(data.getFizDataPowstania()) ? data.getFizDataPowstania() : null)
                .dateOfStartActivity(StringUtils.hasText(data.getFizDataRozpoczeciaDzialalnosci()) ? data.getFizDataRozpoczeciaDzialalnosci() : null)
                .dateOfEntryToRegon(StringUtils.hasText(data.getFizDataWpisuDzialalnosciDoRegon()) ? data.getFizDataWpisuDzialalnosciDoRegon() : null)
                .dateOfSuspendActivity(StringUtils.hasText(data.getFizDataZawieszeniaDzialalnosci()) ? data.getFizDataZawieszeniaDzialalnosci() : null)
                .dateOfResumptionActivity(StringUtils.hasText(data.getFizDataWznowieniaDzialalnosci()) ? data.getFizDataWznowieniaDzialalnosci() : null)
                .dateOfOccurrenceChange(StringUtils.hasText(data.getFizDataZaistnieniaZmianyDzialalnosci()) ? data.getFizDataZaistnieniaZmianyDzialalnosci() : null)
                .dateOfEndActivity(StringUtils.hasText(data.getFizDataZakonczeniaDzialalnosci()) ? data.getFizDataZakonczeniaDzialalnosci() : null)
                .dateOfDeleteFromRegon(StringUtils.hasText(data.getFizDataSkresleniaDzialalanosciZRegon()) ? data.getFizDataSkresleniaDzialalanosciZRegon() : null)
                .dateOfBankruptcyDeclaration(StringUtils.hasText(data.getFizDataOrzeczeniaOUpadlosci()) ? data.getFizDataOrzeczeniaOUpadlosci() : null)
                .dateOfConclusionOfBankruptcyProceedings(StringUtils.hasText(data.getFizDataZakonczeniaPostepowaniaUpadlosciowego()) ? data.getFizDataZakonczeniaPostepowaniaUpadlosciowego() : null)
                .countrySymbol(StringUtils.hasText(data.getFizAdSiedzKrajSymbol()) ? data.getFizAdSiedzKrajSymbol() : null)
                .voivodeshipSymbol(StringUtils.hasText(data.getFizAdSiedzWojewodztwoSymbol()) ? data.getFizAdSiedzWojewodztwoSymbol() : null)
                .districtSymbol(StringUtils.hasText(data.getFizAdSiedzPowiatSymbol()) ? data.getFizAdSiedzPowiatSymbol() : null)
                .municipalitySymbol(StringUtils.hasText(data.getFizAdSiedzGminaSymbol()) ? data.getFizAdSiedzGminaSymbol() : null)
                .postalCode(StringUtils.hasText(data.getFizAdSiedzKodPocztowy()) ? data.getFizAdSiedzKodPocztowy() : null)
                .postTownSymbol(StringUtils.hasText(data.getFizAdSiedzMiejscowoscPocztySymbol()) ? data.getFizAdSiedzMiejscowoscPocztySymbol() : null)
                .citySymbol(StringUtils.hasText(data.getFizAdSiedzMiejscowoscSymbol()) ? data.getFizAdSiedzMiejscowoscSymbol() : null)
                .streetSymbol(StringUtils.hasText(data.getFizAdSiedzUlicaSymbol()) ? data.getFizAdSiedzUlicaSymbol() : null)
                .apartmentNumber(StringUtils.hasText(data.getFizAdSiedzNumerNieruchomosci()) ? data.getFizAdSiedzNumerNieruchomosci() : null)
                .houseNumber(StringUtils.hasText(data.getFizAdSiedzNumerLokalu()) ? data.getFizAdSiedzNumerLokalu() : null)
                .unusualLocation(StringUtils.hasText(data.getFizAdSiedzNietypoweMiejsceLokalizacji()) ? data.getFizAdSiedzNietypoweMiejsceLokalizacji() : null)
                .phoneNumber(StringUtils.hasText(data.getFizNumerTelefonu()) ? data.getFizNumerTelefonu() : null)
                .extensionNumber(StringUtils.hasText(data.getFizNumerWewnetrznyTelefonu()) ? data.getFizNumerWewnetrznyTelefonu() : null)
                .faxNumber(StringUtils.hasText(data.getFizNumerFaksu()) ? data.getFizNumerFaksu() : null)
                .email(StringUtils.hasText(data.getFizAdresEmail()) ? data.getFizAdresEmail() : null)
                .websiteAddress(StringUtils.hasText(data.getFizAdresStronyinternetowej()) ? data.getFizAdresStronyinternetowej() : null)
                .countryName(StringUtils.hasText(data.getFizAdSiedzKrajNazwa()) ? data.getFizAdSiedzKrajNazwa() : null)
                .voivodeshipName(StringUtils.hasText(data.getFizAdSiedzWojewodztwoNazwa()) ? data.getFizAdSiedzWojewodztwoNazwa() : null)
                .districtName(StringUtils.hasText(data.getFizAdSiedzPowiatNazwa()) ? data.getFizAdSiedzPowiatNazwa() : null)
                .muncipalityName(StringUtils.hasText(data.getFizAdSiedzGminaNazwa()) ? data.getFizAdSiedzGminaNazwa() : null)
                .cityName(StringUtils.hasText(data.getFizAdSiedzMiejscowoscNazwa()) ? data.getFizAdSiedzMiejscowoscNazwa() : null)
                .postTownName(StringUtils.hasText(data.getFizAdSiedzMiejscowoscPocztyNazwa()) ? data.getFizAdSiedzMiejscowoscPocztyNazwa() : null)
                .streetName(StringUtils.hasText(data.getFizAdSiedzUlicaNazwa()) ? data.getFizAdSiedzUlicaNazwa() : null)
                .build();
    }

    public NaturalPersonRemainingActivityDTO convert(OsFizycznaDzialalnoscPozostalaRoot.OsFizycznaDzialalnoscPozostalaData data) {
        return NaturalPersonRemainingActivityDTO.builder()
                .regon(StringUtils.hasText(data.getFizRegon9()) ? data.getFizRegon9() : null)
                .name(StringUtils.hasText(data.getFizNazwa()) ? data.getFizNazwa() : null)
                .shortName(StringUtils.hasText(data.getFizNazwaSkrocona()) ? data.getFizNazwaSkrocona() : null)
                .dateOfCreation(StringUtils.hasText(data.getFizDataPowstania()) ? data.getFizDataPowstania() : null)
                .dateOfStartActivity(StringUtils.hasText(data.getFizDataRozpoczeciaDzialalnosci()) ? data.getFizDataRozpoczeciaDzialalnosci() : null)
                .dateOfEntryToRegon(StringUtils.hasText(data.getFizDataWpisuDzialalnosciDoRegon()) ? data.getFizDataWpisuDzialalnosciDoRegon() : null)
                .dateOfSuspendActivity(StringUtils.hasText(data.getFizDataZawieszeniaDzialalnosci()) ? data.getFizDataZawieszeniaDzialalnosci() : null)
                .dateOfResumptionActivity(StringUtils.hasText(data.getFizDataWznowieniaDzialalnosci()) ? data.getFizDataWznowieniaDzialalnosci() : null)
                .dateOfOccurrenceChange(StringUtils.hasText(data.getFizDataZaistnieniaZmianyDzialalnosci()) ? data.getFizDataZaistnieniaZmianyDzialalnosci() : null)
                .dateOfEndActivity(StringUtils.hasText(data.getFizDataZakonczeniaDzialalnosci()) ? data.getFizDataZakonczeniaDzialalnosci() : null)
                .dateOfDeleteFromRegon(StringUtils.hasText(data.getFizDataSkresleniaDzialalnosciZRegon()) ? data.getFizDataSkresleniaDzialalnosciZRegon() : null)
                .dateOfBankruptcyDeclaration(StringUtils.hasText(data.getFizDataOrzeczeniaOUpadlosci()) ? data.getFizDataOrzeczeniaOUpadlosci() : null)
                .dateOfConclusionOfBankruptcyProceedings(StringUtils.hasText(data.getFizDataZakonczeniaPostepowaniaUpadlosciowego()) ? data.getFizDataZakonczeniaPostepowaniaUpadlosciowego() : null)
                .countrySymbol(StringUtils.hasText(data.getFizAdSiedzKrajSymbol()) ? data.getFizAdSiedzKrajSymbol() : null)
                .voivodeshipSymbol(StringUtils.hasText(data.getFizAdSiedzWojewodztwoSymbol()) ? data.getFizAdSiedzWojewodztwoSymbol() : null)
                .districtSymbol(StringUtils.hasText(data.getFizAdSiedzPowiatSymbol()) ? data.getFizAdSiedzPowiatSymbol() : null)
                .municipalitySymbol(StringUtils.hasText(data.getFizAdSiedzGminaSymbol()) ? data.getFizAdSiedzGminaSymbol() : null)
                .postalCode(StringUtils.hasText(data.getFizAdSiedzKodPocztowy()) ? data.getFizAdSiedzKodPocztowy() : null)
                .postTownSymbol(StringUtils.hasText(data.getFizAdSiedzMiejscowoscPocztySymbol()) ? data.getFizAdSiedzMiejscowoscPocztySymbol() : null)
                .citySymbol(StringUtils.hasText(data.getFizAdSiedzMiejscowoscSymbol()) ? data.getFizAdSiedzMiejscowoscSymbol() : null)
                .streetSymbol(StringUtils.hasText(data.getFizAdSiedzUlicaSymbol()) ? data.getFizAdSiedzUlicaSymbol() : null)
                .apartmentNumber(StringUtils.hasText(data.getFizAdSiedzNumerNieruchomosci()) ? data.getFizAdSiedzNumerNieruchomosci() : null)
                .houseNumber(StringUtils.hasText(data.getFizAdSiedzNumerLokalu()) ? data.getFizAdSiedzNumerLokalu() : null)
                .unusualLocation(StringUtils.hasText(data.getFizAdSiedzNietypoweMiejsceLokalizacji()) ? data.getFizAdSiedzNietypoweMiejsceLokalizacji() : null)
                .phoneNumber(StringUtils.hasText(data.getFizNumerTelefonu()) ? data.getFizNumerTelefonu() : null)
                .extensionNumber(StringUtils.hasText(data.getFizNumerWewnetrznyTelefonu()) ? data.getFizNumerWewnetrznyTelefonu() : null)
                .faxNumber(StringUtils.hasText(data.getFizNumerFaksu()) ? data.getFizNumerFaksu() : null)
                .email(StringUtils.hasText(data.getFizAdresEmail()) ? data.getFizAdresEmail() : null)
                .websiteAddress(StringUtils.hasText(data.getFizAdresStronyinternetowej()) ? data.getFizAdresStronyinternetowej() : null)
                .countryName(StringUtils.hasText(data.getFizAdSiedzKrajNazwa()) ? data.getFizAdSiedzKrajNazwa() : null)
                .voivodeshipName(StringUtils.hasText(data.getFizAdSiedzWojewodztwoNazwa()) ? data.getFizAdSiedzWojewodztwoNazwa() : null)
                .districtName(StringUtils.hasText(data.getFizAdSiedzPowiatNazwa()) ? data.getFizAdSiedzPowiatNazwa() : null)
                .muncipalityName(StringUtils.hasText(data.getFizAdSiedzGminaNazwa()) ? data.getFizAdSiedzGminaNazwa() : null)
                .cityName(StringUtils.hasText(data.getFizAdSiedzMiejscowoscNazwa()) ? data.getFizAdSiedzMiejscowoscNazwa() : null)
                .postTownName(StringUtils.hasText(data.getFizAdSiedzMiejscowoscPocztyNazwa()) ? data.getFizAdSiedzMiejscowoscPocztyNazwa() : null)
                .streetName(StringUtils.hasText(data.getFizAdSiedzUlicaNazwa()) ? data.getFizAdSiedzUlicaNazwa() : null)
                .dateOfRegisterInTheRegisterOfRecords(StringUtils.hasText(data.getFizPDataWpisuDoRejestruEwidencji()) ? data.getFizPDataWpisuDoRejestruEwidencji() : null)
                .numberInTheRegisterOfRecords(StringUtils.hasText(data.getFizPNumerWRejestrzeEwidencji()) ? data.getFizPNumerWRejestrzeEwidencji() : null)
                .registrationAuthoritySymbol(StringUtils.hasText(data.getFizPOrganRejestrowySymbol()) ? data.getFizPOrganRejestrowySymbol() : null)
                .registrationAuthorityName(StringUtils.hasText(data.getFizPOrganRejestrowyNazwa()) ? data.getFizPOrganRejestrowyNazwa() : null)
                .typeOfRegisterSymbol(StringUtils.hasText(data.getFizPRodzajRejestruSymbol()) ? data.getFizPRodzajRejestruSymbol() : null)
                .typeOfRegisterName(StringUtils.hasText(data.getFizPRodzajRejestruNazwa()) ? data.getFizPRodzajRejestruNazwa() : null)
                .build();
    }

    public NaturalPersonActivityDeletedTo20141108DTO convert(OsFizycznaDzialalnoscSkreslonaDo20141108Root.OsFizycznaDzialalnoscSkreslonaDo20141108Data data) {
        return NaturalPersonActivityDeletedTo20141108DTO.builder()
                .regon(StringUtils.hasText(data.getFizRegon9()) ? data.getFizRegon9() : null)
                .name(StringUtils.hasText(data.getFizNazwa()) ? data.getFizNazwa() : null)
                .shortName(StringUtils.hasText(data.getFizNazwaSkrocona()) ? data.getFizNazwaSkrocona() : null)
                .dateOfCreation(StringUtils.hasText(data.getFizDataPowstania()) ? data.getFizDataPowstania() : null)
                .dateOfStartActivity(StringUtils.hasText(data.getFizDataRozpoczeciaDzialalnosci()) ? data.getFizDataRozpoczeciaDzialalnosci() : null)
                .dateOfEntryToRegon(StringUtils.hasText(data.getFizDataWpisuDzialalnosciDoRegon()) ? data.getFizDataWpisuDzialalnosciDoRegon() : null)
                .dateOfSuspendActivity(StringUtils.hasText(data.getFizDataZawieszeniaDzialalnosci()) ? data.getFizDataZawieszeniaDzialalnosci() : null)
                .dateOfResumptionActivity(StringUtils.hasText(data.getFizDataWznowieniaDzialalnosci()) ? data.getFizDataWznowieniaDzialalnosci() : null)
                .dateOfOccurrenceChange(StringUtils.hasText(data.getFizDataZaistnieniaZmianyDzialalnosci()) ? data.getFizDataZaistnieniaZmianyDzialalnosci() : null)
                .dateOfEndActivity(StringUtils.hasText(data.getFizDataZakonczeniaDzialalnosci()) ? data.getFizDataZakonczeniaDzialalnosci() : null)
                .dateOfDeleteFromRegon(StringUtils.hasText(data.getFizDataSkresleniaDzialalnosciZRegon()) ? data.getFizDataSkresleniaDzialalnosciZRegon() : null)
                .countrySymbol(StringUtils.hasText(data.getFizAdSiedzKrajSymbol()) ? data.getFizAdSiedzKrajSymbol() : null)
                .voivodeshipSymbol(StringUtils.hasText(data.getFizAdSiedzWojewodztwoSymbol()) ? data.getFizAdSiedzWojewodztwoSymbol() : null)
                .districtSymbol(StringUtils.hasText(data.getFizAdSiedzPowiatSymbol()) ? data.getFizAdSiedzPowiatSymbol() : null)
                .municipalitySymbol(StringUtils.hasText(data.getFizAdSiedzGminaSymbol()) ? data.getFizAdSiedzGminaSymbol() : null)
                .postalCode(StringUtils.hasText(data.getFizAdSiedzKodPocztowy()) ? data.getFizAdSiedzKodPocztowy() : null)
                .postTownSymbol(StringUtils.hasText(data.getFizAdSiedzMiejscowoscPocztySymbol()) ? data.getFizAdSiedzMiejscowoscPocztySymbol() : null)
                .citySymbol(StringUtils.hasText(data.getFizAdSiedzMiejscowoscSymbol()) ? data.getFizAdSiedzMiejscowoscSymbol() : null)
                .streetSymbol(StringUtils.hasText(data.getFizAdSiedzUlicaSymbol()) ? data.getFizAdSiedzUlicaSymbol() : null)
                .apartmentNumber(StringUtils.hasText(data.getFizAdSiedzNumerNieruchomosci()) ? data.getFizAdSiedzNumerNieruchomosci() : null)
                .houseNumber(StringUtils.hasText(data.getFizAdSiedzNumerLokalu()) ? data.getFizAdSiedzNumerLokalu() : null)
                .unusualLocation(StringUtils.hasText(data.getFizAdSiedzNietypoweMiejsceLokalizacji()) ? data.getFizAdSiedzNietypoweMiejsceLokalizacji() : null)
                .phoneNumber(StringUtils.hasText(data.getFizNumerTelefonu()) ? data.getFizNumerTelefonu() : null)
                .extensionNumber(StringUtils.hasText(data.getFizNumerWewnetrznyTelefonu()) ? data.getFizNumerWewnetrznyTelefonu() : null)
                .faxNumber(StringUtils.hasText(data.getFizNumerFaksu()) ? data.getFizNumerFaksu() : null)
                .email(StringUtils.hasText(data.getFizAdresEmail()) ? data.getFizAdresEmail() : null)
                .email2(StringUtils.hasText(data.getFizAdresEmail2()) ? data.getFizAdresEmail2() : null)
                .websiteAddress(StringUtils.hasText(data.getFizAdresStronyinternetowej()) ? data.getFizAdresStronyinternetowej() : null)
                .countryName(StringUtils.hasText(data.getFizAdSiedzKrajNazwa()) ? data.getFizAdSiedzKrajNazwa() : null)
                .voivodeshipName(StringUtils.hasText(data.getFizAdSiedzWojewodztwoNazwa()) ? data.getFizAdSiedzWojewodztwoNazwa() : null)
                .districtName(StringUtils.hasText(data.getFizAdSiedzPowiatNazwa()) ? data.getFizAdSiedzPowiatNazwa() : null)
                .muncipalityName(StringUtils.hasText(data.getFizAdSiedzGminaNazwa()) ? data.getFizAdSiedzGminaNazwa() : null)
                .cityName(StringUtils.hasText(data.getFizAdSiedzMiejscowoscNazwa()) ? data.getFizAdSiedzMiejscowoscNazwa() : null)
                .postTownName(StringUtils.hasText(data.getFizAdSiedzMiejscowoscPocztyNazwa()) ? data.getFizAdSiedzMiejscowoscPocztyNazwa() : null)
                .streetName(StringUtils.hasText(data.getFizAdSiedzUlicaNazwa()) ? data.getFizAdSiedzUlicaNazwa() : null)
                .build();
    }

    public NaturalPersonPkdDTO convert(OsFizycznaPkdRoot.OsFizycznaPkdData data) {
        return NaturalPersonPkdDTO.builder()
                .pkdCode(StringUtils.hasText(data.getFizPkdKod()) ? data.getFizPkdKod() : null)
                .pkdDominant(StringUtils.hasText(data.getFizPkdPrzewazajace()) ? data.getFizPkdPrzewazajace() : null)
                .pkdName(StringUtils.hasText(data.getFizPkdNazwa()) ? data.getFizPkdNazwa() : null)
                .silosId(data.getFizSilosID())
                .silosSymbol(StringUtils.hasText(data.getFizSilosSymbol()) ? data.getFizSilosSymbol() : null)
                .businessEndDate(StringUtils.hasText(data.getFizDataSkresleniaDzialalnosciZRegon()) ? data.getFizDataSkresleniaDzialalnosciZRegon() : null)
                .build();
    }

    public NaturalPersonLocalUnitsDTO convert(OsFizycznaListaJednLokalnychRoot.OsFizycznaListaJednLokalnychData data) {
        return NaturalPersonLocalUnitsDTO.builder()
                .regon(StringUtils.hasText(data.getLokfizRegon14()) ? data.getLokfizRegon14() : null)
                .name(StringUtils.hasText(data.getLokfizNazwa()) ? data.getLokfizNazwa() : null)
                .silosId(data.getLokfizSilosID())
                .silosSymbol(StringUtils.hasText(data.getLokfizSilosSymbol()) ? data.getLokfizSilosSymbol() : null)
                .countrySymbol(StringUtils.hasText(data.getLokfizAdSiedzKrajSymbol()) ? data.getLokfizAdSiedzKrajSymbol() : null)
                .voivodeshipSymbol(StringUtils.hasText(data.getLokfizAdSiedzWojewodztwoSymbol()) ? data.getLokfizAdSiedzWojewodztwoSymbol() : null)
                .districtSymbol(StringUtils.hasText(data.getLokfizAdSiedzPowiatSymbol()) ? data.getLokfizAdSiedzPowiatSymbol() : null)
                .municipalitySymbol(StringUtils.hasText(data.getLokfizAdSiedzGminaSymbol()) ? data.getLokfizAdSiedzGminaSymbol() : null)
                .postalCode(StringUtils.hasText(data.getLokfizAdSiedzKodPocztowy()) ? data.getLokfizAdSiedzKodPocztowy() : null)
                .postTownSymbol(StringUtils.hasText(data.getLokfizAdSiedzMiejscowoscPocztySymbol()) ? data.getLokfizAdSiedzMiejscowoscPocztySymbol() : null)
                .citySymbol(StringUtils.hasText(data.getLokfizAdSiedzMiejscowoscSymbol()) ? data.getLokfizAdSiedzMiejscowoscSymbol() : null)
                .streetSymbol(StringUtils.hasText(data.getLokfizAdSiedzUlicaSymbol()) ? data.getLokfizAdSiedzUlicaSymbol() : null)
                .apartmentNumber(StringUtils.hasText(data.getLokfizAdSiedzNumerNieruchomosci()) ? data.getLokfizAdSiedzNumerNieruchomosci() : null)
                .houseNumber(StringUtils.hasText(data.getLokfizAdSiedzNumerLokalu()) ? data.getLokfizAdSiedzNumerLokalu() : null)
                .unusualLocation(StringUtils.hasText(data.getLokfizAdSiedzNietypoweMiejsceLokalizacji()) ? data.getLokfizAdSiedzNietypoweMiejsceLokalizacji() : null)
                .voivodeshipName(StringUtils.hasText(data.getLokfizAdSiedzWojewodztwoNazwa()) ? data.getLokfizAdSiedzWojewodztwoNazwa() : null)
                .districtName(StringUtils.hasText(data.getLokfizAdSiedzPowiatNazwa()) ? data.getLokfizAdSiedzPowiatNazwa() : null)
                .muncipalityName(StringUtils.hasText(data.getLokfizAdSiedzGminaNazwa()) ? data.getLokfizAdSiedzGminaNazwa() : null)
                .cityName(StringUtils.hasText(data.getLokfizAdSiedzMiejscowoscNazwa()) ? data.getLokfizAdSiedzMiejscowoscNazwa() : null)
                .postTownName(StringUtils.hasText(data.getLokfizAdSiedzMiejscowoscPocztyNazwa()) ? data.getLokfizAdSiedzMiejscowoscPocztyNazwa() : null)
                .streetName(StringUtils.hasText(data.getLokfizAdSiedzUlicaNazwa()) ? data.getLokfizAdSiedzUlicaNazwa() : null)
                .dateOfCreation(StringUtils.hasText(data.getLokfizDataPowstania()) ? data.getLokfizDataPowstania() : null)
                .dateOfStartActivity(StringUtils.hasText(data.getLokfizDataRozpoczeciaDzialalnosci()) ? data.getLokfizDataRozpoczeciaDzialalnosci() : null)
                .dateOfEntryToRegon(StringUtils.hasText(data.getLokfizDataWpisuDoRegon()) ? data.getLokfizDataWpisuDoRegon() : null)
                .dateOfSuspendActivity(StringUtils.hasText(data.getLokfizDataZawieszeniaDzialalnosci()) ? data.getLokfizDataZawieszeniaDzialalnosci() : null)
                .dateOfResumptionActivity(StringUtils.hasText(data.getLokfizDataWznowieniaDzialalnosci()) ? data.getLokfizDataWznowieniaDzialalnosci() : null)
                .dateOfEndActivity(StringUtils.hasText(data.getLokfizDataZakonczeniaDzialalnosci()) ? data.getLokfizDataZakonczeniaDzialalnosci() : null)
                .dateOfDeleteFromRegon(StringUtils.hasText(data.getLokfizDataSkresleniaZRegon()) ? data.getLokfizDataSkresleniaZRegon() : null)
                .build();
    }

    public NaturalPersonLocalUnitDTO convert(JednLokalnaOsFizycznejRoot.JednLokalnaOsFizycznejData data) {
        return NaturalPersonLocalUnitDTO.builder()
                .regon(StringUtils.hasText(data.getLokfizRegon14()) ? data.getLokfizRegon14() : null)
                .name(StringUtils.hasText(data.getLokfizNazwa()) ? data.getLokfizNazwa() : null)
                .silosId(data.getLokfizSilosID())
                .silosName(StringUtils.hasText(data.getLokfizSilosNazwa()) ? data.getLokfizSilosNazwa() : null)
                .dateOfCreation(StringUtils.hasText(data.getLokfizDataPowstania()) ? data.getLokfizDataPowstania() : null)
                .dateOfStartActivity(StringUtils.hasText(data.getLokfizDataRozpoczeciaDzialalnosci()) ? data.getLokfizDataRozpoczeciaDzialalnosci() : null)
                .dateOfEntryToRegon(StringUtils.hasText(data.getLokfizDataWpisuDoRegon()) ? data.getLokfizDataWpisuDoRegon() : null)
                .dateOfSuspendActivity(StringUtils.hasText(data.getLokfizDataZawieszeniaDzialalnosci()) ? data.getLokfizDataZawieszeniaDzialalnosci() : null)
                .dateOfResumptionActivity(StringUtils.hasText(data.getLokfizDataWznowieniaDzialalnosci()) ? data.getLokfizDataWznowieniaDzialalnosci() : null)
                .dateOfOccurrenceChange(StringUtils.hasText(data.getLokfizDataZaistnieniaZmiany()) ? data.getLokfizDataZaistnieniaZmiany() : null)
                .dateOfEndActivity(StringUtils.hasText(data.getLokfizDataZakonczeniaDzialalnosci()) ? data.getLokfizDataZakonczeniaDzialalnosci() : null)
                .dateOfDeleteFromRegon(StringUtils.hasText(data.getLokfizDataSkresleniaZRegon()) ? data.getLokfizDataSkresleniaZRegon() : null)
                .countrySymbol(StringUtils.hasText(data.getLokfizAdSiedzKrajSymbol()) ? data.getLokfizAdSiedzKrajSymbol() : null)
                .voivodeshipSymbol(StringUtils.hasText(data.getLokfizAdSiedzWojewodztwoSymbol()) ? data.getLokfizAdSiedzWojewodztwoSymbol() : null)
                .districtSymbol(StringUtils.hasText(data.getLokfizAdSiedzPowiatSymbol()) ? data.getLokfizAdSiedzPowiatSymbol() : null)
                .municipalitySymbol(StringUtils.hasText(data.getLokfizAdSiedzGminaSymbol()) ? data.getLokfizAdSiedzGminaSymbol() : null)
                .postalCode(StringUtils.hasText(data.getLokfizAdSiedzKodPocztowy()) ? data.getLokfizAdSiedzKodPocztowy() : null)
                .postTownSymbol(StringUtils.hasText(data.getLokfizAdSiedzMiejscowoscPocztySymbol()) ? data.getLokfizAdSiedzMiejscowoscPocztySymbol() : null)
                .citySymbol(StringUtils.hasText(data.getLokfizAdSiedzMiejscowoscSymbol()) ? data.getLokfizAdSiedzMiejscowoscSymbol() : null)
                .streetSymbol(StringUtils.hasText(data.getLokfizAdSiedzUlicaSymbol()) ? data.getLokfizAdSiedzUlicaSymbol() : null)
                .apartmentNumber(StringUtils.hasText(data.getLokfizAdSiedzNumerNieruchomosci()) ? data.getLokfizAdSiedzNumerNieruchomosci() : null)
                .houseNumber(StringUtils.hasText(data.getLokfizAdSiedzNumerLokalu()) ? data.getLokfizAdSiedzNumerLokalu() : null)
                .unusualLocation(StringUtils.hasText(data.getLokfizAdSiedzNietypoweMiejsceLokalizacji()) ? data.getLokfizAdSiedzNietypoweMiejsceLokalizacji() : null)
                .coountryName(StringUtils.hasText(data.getLokfizAdSiedzKrajNazwa()) ? data.getLokfizAdSiedzKrajNazwa() : null)
                .voivodeshipName(StringUtils.hasText(data.getLokfizAdSiedzWojewodztwoNazwa()) ? data.getLokfizAdSiedzWojewodztwoNazwa() : null)
                .districtName(StringUtils.hasText(data.getLokfizAdSiedzPowiatNazwa()) ? data.getLokfizAdSiedzPowiatNazwa() : null)
                .muncipalityName(StringUtils.hasText(data.getLokfizAdSiedzGminaNazwa()) ? data.getLokfizAdSiedzGminaNazwa() : null)
                .cityName(StringUtils.hasText(data.getLokfizAdSiedzMiejscowoscNazwa()) ? data.getLokfizAdSiedzMiejscowoscNazwa() : null)
                .postTownName(StringUtils.hasText(data.getLokfizAdSiedzMiejscowoscPocztyNazwa()) ? data.getLokfizAdSiedzMiejscowoscPocztyNazwa() : null)
                .streetName(StringUtils.hasText(data.getLokfizAdSiedzUlicaNazwa()) ? data.getLokfizAdSiedzUlicaNazwa() : null)
                .financingFormSymbol(StringUtils.hasText(data.getLokfizFormaFinansowaniaSymbol()) ? data.getLokfizFormaFinansowaniaSymbol() : null)
                .financingFormName(StringUtils.hasText(data.getLokfizFormaFinansowaniaNazwa()) ? data.getLokfizFormaFinansowaniaNazwa() : null)
                .dateOfRegisterInTheRegisterOfRecords(StringUtils.hasText(data.getLokfizDataWpisuDoRejestruEwidencji()) ? data.getLokfizDataWpisuDoRejestruEwidencji() : null)
                .numberInTheRegisterOfRecords(StringUtils.hasText(data.getLokfizNumerwRejestrzeEwidencji()) ? data.getLokfizNumerwRejestrzeEwidencji() : null)
                .registrationAuthoritySymbol(StringUtils.hasText(data.getLokfizOrganRejestrowySymbol()) ? data.getLokfizOrganRejestrowySymbol() : null)
                .registrationAuthorityName(StringUtils.hasText(data.getLokfizOrganRejestrowyNazwa()) ? data.getLokfizOrganRejestrowyNazwa() : null)
                .typeOfRegisterSymbol(StringUtils.hasText(data.getLokfizRodzajRejestruSymbol()) ? data.getLokfizRodzajRejestruSymbol() : null)
                .typeOfRegisterName(StringUtils.hasText(data.getLokfizRodzajRejestruNazwa()) ? data.getLokfizRodzajRejestruNazwa() : null)
                .activityCommenced(data.isLokfizCNiePodjetoDzialalnosci())
                .build();
    }

    public NaturalPersonLocalUnitPkdDTO convert(JednLokalnaOsFizycznejPkdRoot.JednLokalnaOsFizycznejPkdData data) {
        return NaturalPersonLocalUnitPkdDTO.builder()
                .pkdCode(StringUtils.hasText(data.getLokfizPkdKod()) ? data.getLokfizPkdKod() : null)
                .pkdName(StringUtils.hasText(data.getLokfizPkdNazwa()) ? data.getLokfizPkdNazwa() : null)
                .pkdDominant(StringUtils.hasText(data.getLokfizPkdPrzewazajace()) ? data.getLokfizPkdPrzewazajace() : null)
                .silosSymbol(StringUtils.hasText(data.getLokfizSilosSymbol()) ? data.getLokfizSilosSymbol() : null)
                .build();
    }

    public LegalEntityDTO convert(OsPrawnaRoot.OsPrawnaData data) {
        //TODO
        throw new NotImplementedException("Not implemented proper convert method.");
    }

    public LegalEntityPkdDTO convert(OsPrawnaPkdRoot.OsPrawnaPkdData data) {
        return LegalEntityPkdDTO.builder()
                .pkdCode(StringUtils.hasText(data.getPrawPkdKod()) ? data.getPrawPkdKod() : null)
                .pkdDominant(StringUtils.hasText(data.getPrawPkdPrzewazajace()) ? data.getPrawPkdPrzewazajace() : null)
                .pkdName(StringUtils.hasText(data.getPrawPkdNazwa()) ? data.getPrawPkdNazwa() : null)
                .build();
    }

    public LegalEntityLocalUnitsDTO convert(OsPrawnaListaJednLokalnychRoot.OsPrawnaListaJednLokalnychData data) {
        //TODO
        throw new NotImplementedException("Not implemented proper convert method.");
    }

    public LegalEntityLocalUnitDTO convert(JednLokalnaOsPrawnejRoot.JednLokalnaOsPrawnejData data) {
        //TODO
        throw new NotImplementedException("Not implemented proper convert method.");
    }

    public LegalEntityLocalUnitPkdDTO convert(JednLokalnaOsPrawnejPkdRoot.JednLokalnaOsPrawnejPkdData data) {
        return LegalEntityLocalUnitPkdDTO.builder()
                .pdkCode(StringUtils.hasText(data.getLokprawPkdKod()) ? data.getLokprawPkdKod() : null)
                .pkdName(StringUtils.hasText(data.getLokprawPkdNazwa()) ? data.getLokprawPkdNazwa() : null)
                .pkdDominant(StringUtils.hasText(data.getLokprawPkdPrzewazajace()) ? data.getLokprawPkdPrzewazajace() : null)
                .build();
    }

    public LegalEntityCivilPartnershipDTO convert(OsPrawnaSpCywilnaWspolnicyRoot.OsPrawnaSpCywilnaWspolnicyDane data) {
        return LegalEntityCivilPartnershipDTO.builder()
                .civilPartnerCompanyName(StringUtils.hasText(data.getWspolscFirmaNazwa()) ? data.getWspolscFirmaNazwa() : null)
                .civilPartnerFirstName(StringUtils.hasText(data.getWspolscImiePierwsze()) ? data.getWspolscImiePierwsze() : null)
                .civilPartnerSecondName(StringUtils.hasText(data.getWspolscImieDrugie()) ? data.getWspolscImieDrugie() : null)
                .civilPartnerLastName(StringUtils.hasText(data.getWspolscNazwisko()) ? data.getWspolscNazwisko() : null)
                .civilPartnerRegon(StringUtils.hasText(data.getWspolscRegonWspolnikSpolki()) ? data.getWspolscRegonWspolnikSpolki() : null)
                .build();
    }

    public SubjectTypeDTO convert(TypPodmiotuRoot.TypPodmiotuData data) {
        return SubjectTypeDTO.builder().type(data.getTyp()).build();
    }
}
