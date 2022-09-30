package com.company.Summative1AssessmentSalgadoJose.controllers;

import com.company.Summative1AssessmentSalgadoJose.models.Definition;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WordController.class)
public class WordControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A Definition object for testing purposes
    private Definition word;

    @Before
    public void setUp() {
    }

    // Testing GET /word
    @Test
    public void shouldReturnRandomWordOfTheDay() throws Exception {
        // ARRANGE
        // Convert Java object to JSON
        String outputJson = mapper.writeValueAsString(word);

        // ACT
        mockMvc.perform(get("/word"))   // Perform GET request
                .andDo(print())                   // Print results to console
                .andExpect(status().isOk());      // ASSERT (status code is 200)
    }
}