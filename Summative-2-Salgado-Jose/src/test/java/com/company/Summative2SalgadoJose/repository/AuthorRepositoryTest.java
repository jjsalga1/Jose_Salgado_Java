package com.company.Summative2SalgadoJose.repository;

import com.company.Summative2SalgadoJose.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;

    @Before
    public void setUp() throws Exception {
        authorRepository.deleteAll();
    }

    @Test
    public void addGetDeleteAuthor() {
        Author author = new Author();
        author.setFirstName("Jose");
        author.setLastName("Salgado");
        author.setStreet("123 Irvine Dr.");
        author.setCity("Irvine");
        author.setState("CA");
        author.setPostalCode("92617");
        author.setPhone("123-456-7890");
        author.setEmail("josesalgado@books.net");

        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());
        assertEquals(author1.get(), author);

        authorRepository.deleteById(author.getId());
        author1 = authorRepository.findById(author.getId());
        assertFalse(author1.isPresent());
    }

    @Test
    public void updateAuthor() {
        Author author = new Author();
        author.setFirstName("Jose");
        author.setLastName("Salgado");
        author.setStreet("123 Irvine Dr.");
        author.setCity("Irvine");
        author.setState("CA");
        author.setPostalCode("92617");
        author.setPhone("123-456-7890");
        author.setEmail("josesalgado@books.net");

        author = authorRepository.save(author);

        author.setLastName("Salgado Jr.");
        author.setPhone("661-758-1000");
        author.setEmail("jjsalga1@uci.edu");

        authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());
        assertEquals(author1.get(), author);
    }

    @Test
    public void getAllAuthors() {
        Author author = new Author();
        author.setFirstName("Jose");
        author.setLastName("Salgado");
        author.setStreet("123 Irvine Dr.");
        author.setCity("Irvine");
        author.setState("CA");
        author.setPostalCode("92617");
        author.setPhone("123-456-7890");
        author.setEmail("josesalgado@books.net");

        author = authorRepository.save(author);

        Author author2 = new Author();
        author2.setFirstName("Juan");
        author2.setLastName("Hernandez");
        author2.setStreet("12 Wasco Dr.");
        author2.setCity("Wasco");
        author2.setState("CA");
        author2.setPostalCode("93280");
        author2.setPhone("123-758-7895");
        author2.setEmail("juanh@books.net");

        author2 = authorRepository.save(author2);

        List<Author> authorList = authorRepository.findAll();
        assertEquals(authorList.size(), 2);
    }
}