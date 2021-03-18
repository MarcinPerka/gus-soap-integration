package com.archu.gussoapintegration.api.regon.subject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SubjectController.class)
public class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubjectService subjectService;

    private final String SUBJECTS_API_PREFIX = "/regon/subjects";

    @Test
    @DisplayName("GET /subjects success when correct regon is given")
    public void testGetSubjectsWhenCorrectRegonIsGiven() throws Exception {
        mockMvc.perform(get(SUBJECTS_API_PREFIX + "?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET /subjects failure when wrong regon is given")
    public void testGetSubjectsWhenWrongRegonIsGiven() throws Exception {
        mockMvc.perform(get(SUBJECTS_API_PREFIX + "?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET /subjects failure when request params are not given")
    public void testGetSubjectsWhenRequestParamsAreNotGiven() throws Exception {
        mockMvc.perform(get(SUBJECTS_API_PREFIX))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

}