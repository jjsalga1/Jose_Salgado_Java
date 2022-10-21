package com.company.customerdata.repository;

import com.company.customerdata.model.Customer;
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
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        customerRepository.deleteAll();
    }

    @Test
    public void addGetDeleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Jalen");
        customer.setLastName("Hurts");
        customer.setEmail("jalenhurts@eagles.com");
        customer.setCompany("Philadelphia Eagles");
        customer.setPhone("555-123-2345");
        customer.setAddress1("123 Eagles Ave.");
        customer.setAddress2("");
        customer.setCity("Philadelphia");
        customer.setState("PA");
        customer.setPostalCode(56789);
        customer.setCountry("US");

        // Add
        customer = customerRepository.save(customer);

        // Get
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertEquals(customer1.get(), customer);

        // Delete
        customerRepository.deleteById(customer.getId());
        customer1 = customerRepository.findById(customer.getId());
        assertFalse(customer1.isPresent());
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Jalen");
        customer.setLastName("Hurts");
        customer.setEmail("jalenhurts@eagles.com");
        customer.setCompany("Philadelphia Eagles");
        customer.setPhone("555-123-2345");
        customer.setAddress1("123 Eagles Ave.");
        customer.setAddress2("");
        customer.setCity("Philadelphia");
        customer.setState("PA");
        customer.setPostalCode(56789);
        customer.setCountry("US");

        // Add
        customer = customerRepository.save(customer);

        // Update
        customer.setEmail("jhurts@nfl.com");
        customer.setPhone("900-345-9876");
        customer.setAddress1("55 Philly Dr.");

        customerRepository.save(customer);

        // Compare
        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void getCustomersByState() {
        Customer customer = new Customer();
        customer.setFirstName("Jalen");
        customer.setLastName("Hurts");
        customer.setEmail("jalenhurts@eagles.com");
        customer.setCompany("Philadelphia Eagles");
        customer.setPhone("555-123-2345");
        customer.setAddress1("123 Eagles Ave.");
        customer.setAddress2("");
        customer.setCity("Philadelphia");
        customer.setState("PA");
        customer.setPostalCode(56789);
        customer.setCountry("US");

        // Add 1
        customer = customerRepository.save(customer);

        customer = new Customer();
        customer.setFirstName("Brandon");
        customer.setLastName("Graham");
        customer.setEmail("bg@eagles.com");
        customer.setCompany("Philadelphia Eagles");
        customer.setPhone("555-123-2347");
        customer.setAddress1("123 Eagles Ave.");
        customer.setAddress2("");
        customer.setCity("Philadelphia");
        customer.setState("PA");
        customer.setPostalCode(56789);
        customer.setCountry("US");

        // Add 2
        customer = customerRepository.save(customer);

        customer = new Customer();
        customer.setFirstName("Jose");
        customer.setLastName("Salgado");
        customer.setEmail("jsalgado@eagles.com");
        customer.setCompany("Philadelphia Eagles");
        customer.setPhone("661-123-2347");
        customer.setAddress1("100 Eagles St.");
        customer.setAddress2("");
        customer.setCity("Irvine");
        customer.setState("CA");
        customer.setPostalCode(92617);
        customer.setCountry("US");

        // Add 3
        customer = customerRepository.save(customer);

        // Get
        List<Customer> customerList = customerRepository.findByState("PA");
        assertEquals(customerList.size(), 2);
    }

    @Test
    public void getAllCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("Jalen");
        customer.setLastName("Hurts");
        customer.setEmail("jalenhurts@eagles.com");
        customer.setCompany("Philadelphia Eagles");
        customer.setPhone("555-123-2345");
        customer.setAddress1("123 Eagles Ave.");
        customer.setAddress2("");
        customer.setCity("Philadelphia");
        customer.setState("PA");
        customer.setPostalCode(56789);
        customer.setCountry("US");

        // Add 1
        customer = customerRepository.save(customer);

        customer = new Customer();
        customer.setFirstName("Brandon");
        customer.setLastName("Graham");
        customer.setEmail("bg@eagles.com");
        customer.setCompany("Philadelphia Eagles");
        customer.setPhone("555-123-2347");
        customer.setAddress1("123 Eagles Ave.");
        customer.setAddress2("");
        customer.setCity("Philadelphia");
        customer.setState("PA");
        customer.setPostalCode(56789);
        customer.setCountry("US");

        // Add 2
        customer = customerRepository.save(customer);

        customer = new Customer();
        customer.setFirstName("Jose");
        customer.setLastName("Salgado");
        customer.setEmail("jsalgado@eagles.com");
        customer.setCompany("Philadelphia Eagles");
        customer.setPhone("661-123-2347");
        customer.setAddress1("100 Eagles St.");
        customer.setAddress2("");
        customer.setCity("Irvine");
        customer.setState("CA");
        customer.setPostalCode(92617);
        customer.setCountry("US");

        // Add 3
        customer = customerRepository.save(customer);

        // Get
        List<Customer> customerList = customerRepository.findAll();
        assertEquals(customerList.size(), 3);
    }
}