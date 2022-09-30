package com.company.Summative1AssessmentSalgadoJose.controllers;

import com.company.Summative1AssessmentSalgadoJose.models.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {
    private List<Definition> wordList;
    private static int idCounter = 1;

    public WordController() {
        wordList = new ArrayList<>();

        wordList.add(new Definition("haywire", "being out of order or having gone wrong.", idCounter++));
        wordList.add(new Definition("verdigris", "green or bluish deposit, usually of copper carbonates, that forms on copper, brass, or bronze surfaces.", idCounter++));
        wordList.add(new Definition("perspicacious", "possessing acute mental vision or discernment.", idCounter++));
        wordList.add(new Definition("defer", "to choose to do (something) at a later time.", idCounter++));
        wordList.add(new Definition("misnomer", "an incorrect name or designation.", idCounter++));
        wordList.add(new Definition("anthropomorphic", "described or thought of as being like human beings in appearance, behavior, etc.", idCounter++));
        wordList.add(new Definition("caucus", "a meeting of members of a political party for the purpose of choosing candidates for an election.", idCounter++));
        wordList.add(new Definition("sporadic", "occurs occasionally, irregularly, or randomly across time or space.", idCounter++));
        wordList.add(new Definition("fructify", "to make fruitful or productive” or “to bear fruit or profit.", idCounter++));
        wordList.add(new Definition("kerfuffle", "a disturbance or fuss typically caused by a dispute or conflict.", idCounter++));
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getWord() {
        // Create return variable
        Definition randomWord;

        // Generate random int to index wordList and return Definition
        Random randomIndex = new Random();
        randomWord = wordList.get(randomIndex.nextInt(wordList.size()));
        return randomWord;
    }
}

