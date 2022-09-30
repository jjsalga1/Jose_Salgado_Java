package com.company.Summative1AssessmentSalgadoJose.controllers;

import com.company.Summative1AssessmentSalgadoJose.models.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MagicController {
    List<Answer> answerList;
    private final List<String> yesList;
    private final List<String> maybeList;
    private final List<String> noList;
    private static int idCounter = 1;

    public MagicController() {
        answerList = new ArrayList<>();

        yesList = new ArrayList<>(Arrays.asList(
                "It is certain.",
                "It is decidedly so.",
                "Without a doubt.",
                "Yes definitely",
                "You may rely on it.",
                "As I see it, yes.",
                "Most likely.",
                "Outlook good.",
                "Yes.",
                "Signs point to yes."
        ));

        maybeList = new ArrayList<>(Arrays.asList(
                "Reply hazy, try again.",
                "Ask again later.",
                "Better not tell you now.",
                "Cannot predict now.",
                "Concentrate and ask again."
        ));

        noList = new ArrayList<>(Arrays.asList(
                "Don't count on it.",
                "My reply is no.",
                "My sources say no.",
                "Outlook not so good.",
                "Very doubtful"
        ));
    }

    @RequestMapping(value = "/magic/history", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Answer> getAnswerList() {
        // Return answerList which is history of POST calls
        return answerList;
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer createAnswer(@RequestBody(required = false) Answer question) {
        // Create final answer variable
        Answer finalAnswer = new Answer();

        // If request body exists, populate final answer with input question
        if (question != null) {
            finalAnswer.setQuestion(question.getQuestion());
        }

        // Generate answer even if request body is empty
        Random randomNum = new Random();

        // Generate random number for yes, maybe, or no list
        int listChoice = randomNum.nextInt(3);

        int answerChoice;
        String answer;
        // Depending on listChoice, get answer from yes, maybe, or no list
        if (listChoice == 0) { // YES
            answerChoice = randomNum.nextInt(yesList.size());
            answer = yesList.get(answerChoice);
        } else if (listChoice == 1) { // MAYBE
            answerChoice = randomNum.nextInt(maybeList.size());
            answer = maybeList.get(answerChoice);
        } else { // NO
            answerChoice = randomNum.nextInt(noList.size());
            answer = noList.get(answerChoice);
        }

        // Set answer and ID. Always return Answer object.
        finalAnswer.setAnswer(answer);
        finalAnswer.setId(idCounter++);
        answerList.add(finalAnswer);
        return finalAnswer;
    }
}
