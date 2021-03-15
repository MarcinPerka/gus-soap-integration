package com.archu.gussoapintegration.regon.subject;

import com.archu.gussoapintegration.api.regon.subject.SubjectController;
import com.archu.gussoapintegration.api.regon.subject.SubjectService;
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
    public void getSubjectsWhenCorrectRegonIsGiven() throws Exception {
        this.mockMvc.perform(get(SUBJECTS_API_PREFIX + "?regon=471043763"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void getSubjectsWhenWrongRegonIsGiven() throws Exception {
        this.mockMvc.perform(get(SUBJECTS_API_PREFIX + "?regon=abcde"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getSubjectsWhenRequestParamsAreNotGiven() throws Exception {
        this.mockMvc.perform(get(SUBJECTS_API_PREFIX))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

}