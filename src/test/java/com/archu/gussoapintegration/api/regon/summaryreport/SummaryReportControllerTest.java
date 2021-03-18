package com.archu.gussoapintegration.api.regon.summaryreport;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SummaryReportController.class)
public class SummaryReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SummaryReportService summaryReportService;

    private final String SUMMARY_REPORTS_API_PREFIX = "/regon/summary-reports";

    @Test
    @DisplayName("GET /legal-entities-and-activities-of-natural-people/new success when correct date is given")
    public void testGetNewLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsValid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/new?date=2020-11-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /legal-entities-and-activities-of-natural-people/new failure when incorrect date is given")
    public void testGetNewLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsInvalid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/new?date=10-11-2020"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /legal-entities-and-activities-of-natural-people/new failure when date is not given")
    public void testGetNewLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsNotGiven() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/new"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /legal-entities-and-activities-of-natural-people/updated success when correct date is given")
    public void testGetUpdatedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsValid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/updated?date=2020-11-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /legal-entities-and-activities-of-natural-people/updated failure when incorrect date is given")
    public void testGetUpdatedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsInvalid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/updated?date=10.11.2020"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /legal-entities-and-activities-of-natural-people/updated failure when date is not given")
    public void testGetUpdatedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsNotGiven() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/updated"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /legal-entities-and-activities-of-natural-people/deleted success when correct date is given")
    public void testGetDeletedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsValid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/deleted?date=2020-11-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /legal-entities-and-activities-of-natural-people/deleted failure when incorrect date is given")
    public void testGetDeletedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsInvalid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/deleted?date=2020-30-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /legal-entities-and-activities-of-natural-people/deleted failure when date is not given")
    public void testGetDeletedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsNotGiven() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/deleted"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /local-units/new success when correct date is given")
    public void testGetNewLocalUnitsWhenDateIsValid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/new?date=2020-11-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /local-units/new failure when incorrect date is given")
    public void testGetNewLocalUnitsWhenDateIsInvalid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/new?date=123123987"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /local-units/new failure when date is not given")
    public void testGetNewLocalUnitsWhenDateIsNotGiven() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/new"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /local-units/updated success when correct date is given")
    public void testGetUpdatedLocalUnitsWhenDateIsValid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/updated?date=2020-10-15"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /local-units/updated failure when incorrect date is given")
    public void testGetUpdatedLocalUnitsWhenDateIsInvalid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/updated?date=10-10-2020"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /local-units/updated failure when date is not given")
    public void testGetUpdatedLocalUnitsWhenDateIsNotGiven() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/updated"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /local-units/deleted success when correct date is given")
    public void testGetDeletedLocalUnitsWhenDateIsValid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/deleted?date=2020-10-11"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /local-units/deleted failure when incorrect date is given")
    public void testGetDeletedLocalUnitsWhenDateIsInvalid() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/deleted?date=10-10-9999"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /local-units/deleted failure when date is not given")
    public void testGetDeletedLocalUnitsWhenDateIsNotGiven() throws Exception {
        mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/deleted"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

}
