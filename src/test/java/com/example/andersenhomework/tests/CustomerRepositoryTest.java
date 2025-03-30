package com.example.andersenhomework.tests;

import com.example.andersenhomework.models.Customer;
import com.example.andersenhomework.controller.AdminMenuController;
import com.example.andersenhomework.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerRepositoryTest {
    private CustomerRepository customerRepository;

    @Before
    public void setUp() {
        AdminMenuController adminMenuController = new AdminMenuController();
        customerRepository = CustomerRepository.getInstance();
        customerRepository.clearCustomers();
    }

    @Test
    public void testAddCustomer() {
        Customer customer = new Customer(1, "Alex");
        customerRepository.addCustomer(customer);
        List<Customer> customers = customerRepository.getCustomers();
        assertEquals(1, customers.size());
        assertEquals("Alex", customers.get(0).getName());
    }

    @Test
    public void testRemoveCustomer() {
        Customer customer = new Customer(1, "Alex");
        customerRepository.addCustomer(customer);
        customerRepository.removeCustomer(1);
        List<Customer> customers = customerRepository.getCustomers();
        assertTrue(customers.isEmpty());
    }

    @Test
    public void testGetCustomers() {
        Customer customer1 = new Customer(1, "Alex");
        Customer customer2 = new Customer(2, "Max");
        customerRepository.addCustomer(customer1);
        customerRepository.addCustomer(customer2);
        List<Customer> customers = customerRepository.getCustomers();
        assertEquals(2, customers.size());
    }
}