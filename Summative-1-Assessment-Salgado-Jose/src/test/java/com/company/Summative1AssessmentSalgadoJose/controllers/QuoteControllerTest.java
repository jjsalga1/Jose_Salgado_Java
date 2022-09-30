package com.company.Summative1AssessmentSalgadoJose.controllers;

import com.company.Summative1AssessmentSalgadoJose.models.Quote;
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
@WebMvcTest(QuoteController.class)
public class QuoteControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // A Quote object for testing purposes
    private Quote quote;

    @Before
    public void setUp() {
    }

    // Testing GET /quote
    @Test
    public void shouldReturnRandomQuoteOfTheDay() throws Exception {
        // ARRANGE
        // Convert Java object to JSON
        String outputJSON = mapper.writeValueAsString(quote);

        // ACT
        mockMvc.perform(get("/quote"))    // Perform GET request
                .andDo(print())                     // Print results
                .andExpect(status().isOk());        // ASSERT (status code is 200)
    }
}