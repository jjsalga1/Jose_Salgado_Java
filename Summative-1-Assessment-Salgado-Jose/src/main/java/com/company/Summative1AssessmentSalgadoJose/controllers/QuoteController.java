package com.company.Summative1AssessmentSalgadoJose.controllers;

import com.company.Summative1AssessmentSalgadoJose.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {
    private List<Quote> quoteList;
    private static int idCounter = 1;

    public QuoteController() {
        quoteList = new ArrayList<>();

        quoteList.add(new Quote("Ray Cummings", "Time is what keeps everything from happening at once.", idCounter++));
        quoteList.add(new Quote("Robert Louis Stevenson", "Don’t judge each day by the harvest you reap but by the seeds that you plant.", idCounter++));
        quoteList.add(new Quote("Billy Porter", "I don't in any way disparage any time I've had in the trenches, because it really has made me the artist I am today.", idCounter++));
        quoteList.add(new Quote("Charles W. Chesnutt", "There’s time enough, but none to spare.", idCounter++));
        quoteList.add(new Quote("Maya Angelou", "Into a daybreak that’s wondrously clear / I rise...", idCounter++));
        quoteList.add(new Quote("Fleet Foxes", "If you need to, keep time on me.", idCounter++));
        quoteList.add(new Quote("Eleanor Roosevelt", "With the new day comes new strength and new thoughts.", idCounter++));
        quoteList.add(new Quote("Lao Tzu", "Nature does not hurry, yet everything is accomplished.", idCounter++));
        quoteList.add(new Quote("Amy Winehouse", "Half time, time to think it through, consider the change, see it from a different view.", idCounter++));
        quoteList.add(new Quote("Dante Alighieri", "The wisest are the most annoyed at the loss of time.", idCounter++));
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() {
        // Create return variable
        Quote randomQuote;

        // Generate random int to index quoteList and return Quote
        Random randomIndex = new Random();
        randomQuote = quoteList.get(randomIndex.nextInt(quoteList.size()));
        return randomQuote;
    }
}
