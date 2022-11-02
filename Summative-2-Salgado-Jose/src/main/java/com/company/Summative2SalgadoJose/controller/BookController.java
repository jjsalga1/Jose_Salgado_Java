package com.company.Summative2SalgadoJose.controller;

import com.company.Summative2SalgadoJose.model.Book;
import com.company.Summative2SalgadoJose.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepository repo;

    // Create a new book.
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return repo.save(book);
    }

    // Find a book by id.
    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable int id) {
        Optional<Book> returnVal = repo.findById(id);
        return returnVal.orElse(null);
    }

    // Get all books.
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooks() {
        return repo.findAll();
    }

    // Update an existing book.
    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book) {
        repo.save(book);
    }

    // Delete an existing book.
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        repo.deleteById(id);
    }

    // Search books by Author
    @GetMapping("/books/author/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByAuthor(@PathVariable int authorId) {
        return repo.findAllBooksByAuthorId(authorId);
    }
}
