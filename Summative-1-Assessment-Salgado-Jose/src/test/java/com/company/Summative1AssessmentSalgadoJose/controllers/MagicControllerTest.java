package com.company.Summative1AssessmentSalgadoJose.controllers;

import com.company.Summative1AssessmentSalgadoJose.models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MagicController.class)
public class MagicControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    // An Answer object for testing purposes
    private Answer answer;

    @Before
    public void setUp() {}

    // Testing POST /magic
    @Test
    public void shouldReturnAnswerToAskedQuestion() throws Exception {
        // ARRANGE
        Answer question = new Answer();
        question.setQuestion("Will my MockMvc test work?");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(question);

        // ACT
        mockMvc.perform(
                post("/magic")                          // Perform the POST
                        .content(inputJson)                       // Set the request
                        .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
        )
                .andDo(print())                                   // Print results
                .andExpect(status().isCreated());                 // ASSERT (status code is 201)
    }

    // Testing POST /magic with JSON curly braces but no info
    @Test
    public void shouldReturnAnswerToEmptyRequestBodyJsonObject() throws Exception {
        // ARRANGE
        Answer question = new Answer();

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(question);

        // ACT
        mockMvc.perform(
                        post("/magic")                          // Perform the POST
                                .content(inputJson)                       // Set the request
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                           // Print results
                .andExpect(status().isCreated());                         // ASSERT (status code is 201)
    }

    // Testing POST /magic with no request body
    @Test
    public void shouldReturnAnswerToEmptyRequestBody() throws Exception {
        // ARRANGE
        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString("");

        // ACT
        mockMvc.perform(
                        post("/magic")                          // Perform the POST
                )
                .andDo(print())                                           // Print results
                .andExpect(status().isCreated());                         // ASSERT (status code is 201)
    }

    // Testing GET /magic/history
    @Test
    public void shouldReturnQuestionAnswerHistory() throws Exception {
        // ARRANGE
        Answer question1 = new Answer();
        Answer question2 = new Answer();
        question1.setQuestion("Will my MockMvc test work?");
        question2.setQuestion("Will you pass this test?");
        // Convert Java Object to JSON
        String inputJson1 = mapper.writeValueAsString(question1);
        String inputJson2 = mapper.writeValueAsString(question2);

        // ACT
        // Populate
        mockMvc.perform(
                post("/magic")                           // Perform the POST
                        .content(inputJson1)                       // Set the request
                        .contentType(MediaType.APPLICATION_JSON)); // Tell the server it's in JSON format

        mockMvc.perform(
                post("/magic")                           // Perform the POST
                        .content(inputJson2)                       // Set the request
                        .contentType(MediaType.APPLICATION_JSON)); // Tell the server it's in JSON format

        // Test
        mockMvc.perform(
                get("/magic/history")) // Perform the GET
                .andDo(print())                  // Print to console
                .andExpect(status().isOk());     // ASSERT (status code is 200)
    }
}