package com.company.Summative2SalgadoJose.controller;

import com.company.Summative2SalgadoJose.model.Author;
import com.company.Summative2SalgadoJose.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    @Autowired
    AuthorRepository repo;

    // Create a new author.
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return repo.save(author);
    }

    // Find an author by id.
    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable int id) {
        Optional<Author> returnVal = repo.findById(id);
        return returnVal.orElse(null);
    }

    // Get all authors.
    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAuthors() {
        return repo.findAll();
    }

    // Update an existing author.
    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody Author author) {
        repo.save(author);
    }

    // Delete an existing author.
    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        repo.deleteById(id);
    }
}
