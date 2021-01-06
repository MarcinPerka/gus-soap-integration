package com.archu.gussoapintegration.regon.summaryreport;


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

    private final String SUMMARY_REPORTS_API_PREFIX = "/api/regon/summary-reports";

    @Test
    public void getNewLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsValid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/new?date=2020-11-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNewLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsInvalid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/new?date=10-11-2020"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNewLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsNotGiven() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/new"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getUpdatedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsValid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/updated?date=2020-11-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getUpdatedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsInvalid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/updated?date=10.11.2020"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getUpdatedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsNotGiven() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/updated"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getDeletedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsValid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/deleted?date=2020-11-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getDeletedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsInvalid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/deleted?date=2020-30-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getDeletedLegalEntitiesAndActivitiesOfNaturalPeopleWhenDateIsNotGiven() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/legal-entities-and-activities-of-natural-people/deleted"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNewLocalUnitsWhenDateIsValid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/new?date=2020-11-10"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getNewLocalUnitsWhenDateIsInvalid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/new?date=123123987"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getNewLocalUnitsWhenDateIsNotGiven() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/new"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getUpdatedLocalUnitsWhenDateIsValid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/updated?date=2020-10-15"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getUpdatedLocalUnitsWhenDateIsInvalid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/updated?date=10-10-2020"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getUpdatedLocalUnitsWhenDateIsNotGiven() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/updated"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getDeletedLocalUnitsWhenDateIsValid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/deleted?date=2020-10-11"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getDeletedLocalUnitsWhenDateIsInvalid() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/deleted?date=10-10-9999"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getDeletedLocalUnitsWhenDateIsNotGiven() throws Exception {
        this.mockMvc.perform(get(SUMMARY_REPORTS_API_PREFIX + "/local-units/deleted"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

}
