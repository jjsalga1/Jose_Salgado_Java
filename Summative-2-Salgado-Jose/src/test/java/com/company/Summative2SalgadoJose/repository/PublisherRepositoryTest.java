package com.company.Summative2SalgadoJose.repository;

import com.company.Summative2SalgadoJose.model.Publisher;
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
public class PublisherRepositoryTest {
    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        publisherRepository.deleteAll();
    }

    @Test
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Python Tutorials");
        publisher.setState("NY");
        publisher.setStreet("123 Python Way");
        publisher.setPostalCode("10001");
        publisher.setCity("New York");
        publisher.setPhone("555-123-4567");
        publisher.setEmail("publisher@pytuts.com");

        publisher = publisherRepository.save(publisher);

        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());
        assertEquals(publisher1.get(), publisher);

        publisherRepository.deleteById(publisher.getId());
        publisher1 = publisherRepository.findById(publisher.getId());

        assertFalse(publisher1.isPresent());
    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Python Tutorials");
        publisher.setState("NY");
        publisher.setStreet("123 Python Way");
        publisher.setPostalCode("10001");
        publisher.setCity("New York");
        publisher.setPhone("555-123-4567");
        publisher.setEmail("publisher@pytuts.com");

        publisher = publisherRepository.save(publisher);

        publisher.setName("Coding Tutorials");
        publisher.setPhone("555-123-0000");
        publisher.setEmail("publisher@codetuts.org");

        publisherRepository.save(publisher);

        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());
        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void getAllPublishers() {
        Publisher publisher = new Publisher();
        publisher.setName("Python Tutorials");
        publisher.setState("NY");
        publisher.setStreet("123 Python Way");
        publisher.setPostalCode("10001");
        publisher.setCity("New York");
        publisher.setPhone("555-123-4567");
        publisher.setEmail("publisher@pytuts.com");

        publisher = publisherRepository.save(publisher);

        publisher = new Publisher();
        publisher.setName("C++ Tutorials");
        publisher.setState("CA");
        publisher.setStreet("1 Cpp Rd.");
        publisher.setPostalCode("92617");
        publisher.setCity("Irvine");
        publisher.setPhone("555-123-4000");
        publisher.setEmail("publisher@cpptuts.com");

        publisher = publisherRepository.save(publisher);

        List<Publisher> publisherList = publisherRepository.findAll();
        assertEquals(publisherList.size(), 2);
    }
}