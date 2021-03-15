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
    public void getNaturalPersonGeneralDataWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/general-data?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNaturalPersonGeneralDataWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/general-data?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonGeneralDataWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/general-data"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonCeidgActivityWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/ceidg-activity?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNaturalPersonAgriculturalActivityWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/agricultural-activity?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNaturalPersonAgriculturalActivityWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/agricultural-activity?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonAgriculturalActivityWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/agricultural-activity"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonRemainingActivityWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/remaining-activity?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNaturalPersonRemainingActivityWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/remaining-activity?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonRemainingActivityWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/remaining-activity"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonActivityDeletedTo20141108WhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/activity-deleted-to-2014-11-08?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNaturalPersonActivityDeletedTo20141108WhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/activity-deleted-to-2014-11-08?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonActivityDeletedTo20141108WhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/activity-deleted-to-2014-11-08"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonPkdWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/pkd?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNaturalPersonPkdWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/pkd?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonPkdWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/pkd"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonLocalUnitsWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-units?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNaturalPersonLocalUnitsWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-units?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonLocalUnitsWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-units"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonLocalUnitWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNaturalPersonLocalUnitWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonLocalUnitWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonLocalUnitPkdWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit-pkd?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNaturalPersonLocalUnitPkdWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit-pkd?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNaturalPersonLocalUnitPkdWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/natural-person/local-unit-pkd"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getLegalEntityWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity?regon=kljas"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityPkdWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/pkd?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getLegalEntityPkdWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/pkd?regon=32139831231312938719"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityPkdWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/pkd?"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityLocalUnitsWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-units?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getLegalEntityLocalUnitsWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-units?regon="))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityLocalUnitsWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-units?nip=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityLocalUnitWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getLegalEntityLocalUnitWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit?regon=kjh"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityLocalUnitWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityLocalUnitPkdWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit-pkd?regon=47104376312345"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getLegalEntityLocalUnitPkdWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit-pkd?regon=0471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityLocalUnitPkdWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/local-unit-pkd"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityCivilPartnershipWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/civil-partnership?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getLegalEntityCivilPartnershipWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/civil-partnership?regon=471043763123"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getLegalEntityCivilPartnershipWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/legal-entity/civil-partnership"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getSubjectTypeWhenRegonIsValid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/subject-type?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getSubjectTypeWhenRegonIsInvalid() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/subject-type?regon=01471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getSubjectTypeWhenRegonIsNotGiven() throws Exception {
        this.mockMvc.perform(get(FULL_REPORTS_API_PREFIX + "/subject-type"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }
}
