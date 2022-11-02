package com.company.Summative2SalgadoJose.controller;

import com.company.Summative2SalgadoJose.model.Publisher;
import com.company.Summative2SalgadoJose.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {
    @Autowired
    PublisherRepository repo;

    // Create a new publisher.
    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return repo.save(publisher);
    }

    // Find a publisher by id.
    @GetMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisherById(@PathVariable int id) {
        Optional<Publisher> returnVal = repo.findById(id);
        return returnVal.orElse(null);
    }

    // Get all publishers.
    @GetMapping("/publishers")
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getPublishers() {
        return repo.findAll();
    }

    // Update an existing publisher.
    @PutMapping("/publishers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher) {
        repo.save(publisher);
    }

    // Delete an existing publisher.
    @DeleteMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) {
        repo.deleteById(id);
    }
}
