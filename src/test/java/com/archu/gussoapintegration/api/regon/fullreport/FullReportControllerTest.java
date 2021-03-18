package com.archu.gussoapintegration.api.regon.fullreport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FullReportController.class)
public class FullReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FullReportService fullReportService;

    private final String FULL_REPORTS_API_PREFIX = "/regon/full-reports";

    @Test
    public void testGetNaturalPersonGeneralDataWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/general-data?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNaturalPersonGeneralDataWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/general-data?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonGeneralDataWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/general-data"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonCeidgActivityWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/ceidg-activity?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNaturalPersonAgriculturalActivityWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/agricultural-activity?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNaturalPersonAgriculturalActivityWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/agricultural-activity?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonAgriculturalActivityWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/agricultural-activity"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonRemainingActivityWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/remaining-activity?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNaturalPersonRemainingActivityWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/remaining-activity?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonRemainingActivityWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/remaining-activity"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonActivityDeletedTo20141108WhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/activity-deleted-to-2014-11-08?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNaturalPersonActivityDeletedTo20141108WhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/activity-deleted-to-2014-11-08?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonActivityDeletedTo20141108WhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/activity-deleted-to-2014-11-08"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonPkdWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/pkd?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNaturalPersonPkdWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/pkd?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonPkdWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/pkd"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonLocalUnitsWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-units?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNaturalPersonLocalUnitsWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-units?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonLocalUnitsWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-units"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonLocalUnitWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNaturalPersonLocalUnitWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonLocalUnitWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonLocalUnitPkdWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit-pkd?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNaturalPersonLocalUnitPkdWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit-pkd?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetNaturalPersonLocalUnitPkdWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit-pkd"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetLegalEntityWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity?regon=kljas"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityPkdWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/pkd?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetLegalEntityPkdWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/pkd?regon=32139831231312938719"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityPkdWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/pkd?"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityLocalUnitsWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-units?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetLegalEntityLocalUnitsWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-units?regon="))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityLocalUnitsWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-units?nip=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityLocalUnitWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetLegalEntityLocalUnitWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit?regon=kjh"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityLocalUnitWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityLocalUnitPkdWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit-pkd?regon=47104376312345"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetLegalEntityLocalUnitPkdWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit-pkd?regon=0471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityLocalUnitPkdWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit-pkd"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityCivilPartnershipWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/civil-partnership?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetLegalEntityCivilPartnershipWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/civil-partnership?regon=471043763123"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetLegalEntityCivilPartnershipWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/civil-partnership"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetSubjectTypeWhenRegonIsValid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/subject-type?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetSubjectTypeWhenRegonIsInvalid() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/subject-type?regon=01471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetSubjectTypeWhenRegonIsNotGiven() throws Exception {
        mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/subject-type"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }
}
