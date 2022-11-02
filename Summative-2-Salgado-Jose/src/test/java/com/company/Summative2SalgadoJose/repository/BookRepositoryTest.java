package com.company.Summative2SalgadoJose.repository;

import com.company.Summative2SalgadoJose.model.Author;
import com.company.Summative2SalgadoJose.model.Book;
import com.company.Summative2SalgadoJose.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
    }

    @Test
    public void addGetDeleteBook() {
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

        Publisher publisher = new Publisher();
        publisher.setName("Python Tutorials");
        publisher.setState("NY");
        publisher.setStreet("123 Python Way");
        publisher.setPostalCode("10001");
        publisher.setCity("New York");
        publisher.setPhone("555-123-4567");
        publisher.setEmail("publisher@pytuts.com");

        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setTitle("Python for Beginners");
        book.setIsbn("9783161484100");
        book.setPublishDate(LocalDate.of(2020, 6, 3));
        book.setPrice(new BigDecimal("1.00"));

        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());
        assertEquals(book1.get(), book);

        bookRepository.deleteById(book.getId());
        book1 = bookRepository.findById(book.getId());
        assertFalse(book1.isPresent());
    }

    @Test
    public void updateBook() {
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

        Publisher publisher = new Publisher();
        publisher.setName("Python Tutorials");
        publisher.setState("NY");
        publisher.setStreet("123 Python Way");
        publisher.setPostalCode("10001");
        publisher.setCity("New York");
        publisher.setPhone("555-123-4567");
        publisher.setEmail("publisher@pytuts.com");

        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setTitle("Python for Beginners");
        book.setIsbn("9783161484100");
        book.setPublishDate(LocalDate.of(2020, 6, 3));
        book.setPrice(new BigDecimal("1.00"));

        book = bookRepository.save(book);

        book.setTitle("Python for Beginners: Vol. I");
        book.setIsbn("9783161484101");
        book.setPrice(new BigDecimal("2.00"));

        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());
        assertEquals(book1.get(), book);
    }

    @Test
    public void getBooksByAuthorId() {
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

        Publisher publisher = new Publisher();
        publisher.setName("Python Tutorials");
        publisher.setState("NY");
        publisher.setStreet("123 Python Way");
        publisher.setPostalCode("10001");
        publisher.setCity("New York");
        publisher.setPhone("555-123-4567");
        publisher.setEmail("publisher@pytuts.com");

        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setTitle("Python for Beginners");
        book.setIsbn("9783161484100");
        book.setPublishDate(LocalDate.of(2020, 6, 3));
        book.setPrice(new BigDecimal(1.00));

        book = bookRepository.save(book);

        Book book2 = new Book();
        book2.setAuthorId(author.getId());
        book2.setPublisherId(publisher.getId());
        book2.setTitle("C++ for Beginners");
        book2.setIsbn("9783161484103");
        book2.setPublishDate(LocalDate.of(2021, 6, 3));
        book2.setPrice(new BigDecimal(1.00));

        book2 = bookRepository.save(book2);

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

        Book book3 = new Book();
        book3.setAuthorId(author2.getId());
        book3.setPublisherId(publisher.getId());
        book3.setTitle("Mechanics for Beginners");
        book3.setIsbn("9783161574103");
        book3.setPublishDate(LocalDate.of(2020, 6, 15));
        book3.setPrice(new BigDecimal(10.00));

        book3 = bookRepository.save(book3);

        int authorId = author.getId();
        List<Book> bookList = bookRepository.findAllBooksByAuthorId(authorId);

        assertEquals(bookList.size(), 2);

        int authorId2 = author2.getId();
        List<Book> bookList2 = bookRepository.findAllBooksByAuthorId(authorId2);
        assertEquals(bookList2.size(), 1);
    }

    @Test
    public void getAllBooks() {
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

        Publisher publisher = new Publisher();
        publisher.setName("Python Tutorials");
        publisher.setState("NY");
        publisher.setStreet("123 Python Way");
        publisher.setPostalCode("10001");
        publisher.setCity("New York");
        publisher.setPhone("555-123-4567");
        publisher.setEmail("publisher@pytuts.com");

        publisher = publisherRepository.save(publisher);

        Book book = new Book();
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setTitle("Python for Beginners");
        book.setIsbn("9783161484100");
        book.setPublishDate(LocalDate.of(2020, 6, 3));
        book.setPrice(new BigDecimal(1.00));

        book = bookRepository.save(book);

        Book book2 = new Book();
        book2.setAuthorId(author.getId());
        book2.setPublisherId(publisher.getId());
        book2.setTitle("C++ for Beginners");
        book2.setIsbn("9783161484103");
        book2.setPublishDate(LocalDate.of(2021, 6, 3));
        book2.setPrice(new BigDecimal(1.00));

        book2 = bookRepository.save(book2);

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

        Book book3 = new Book();
        book3.setAuthorId(author.getId());
        book3.setPublisherId(publisher.getId());
        book3.setTitle("Mechanics for Beginners");
        book3.setIsbn("9783161574103");
        book3.setPublishDate(LocalDate.of(2020, 6, 15));
        book3.setPrice(new BigDecimal(10.00));

        book3 = bookRepository.save(book3);

        List<Book> bookList = bookRepository.findAll();
        assertEquals(bookList.size(), 3);
    }
}