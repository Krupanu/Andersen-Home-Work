package com.example.andersenhomework.tests;

import com.example.andersenhomework.controller.AdminMenuController;
import com.example.andersenhomework.models.Customer;
import com.example.andersenhomework.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class AdminMenuControllerTest {
    private AdminMenuController adminMenuController;
    private CustomerRepository customerRepository;

    @Before
    public void setUp() {
        adminMenuController = new AdminMenuController();
        customerRepository = CustomerRepository.getInstance();
        customerRepository.clearCustomers();
    }

    @Test
    public void testAddCustomer() {
        String input = "Alex\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        adminMenuController.addCustomer();
        Customer customer = customerRepository.getCustomers().get(0);
        assertEquals("Alex", customer.getName());
    }

    @Test
    public void testRemoveCustomer() {
        Customer customer = new Customer(1, "Alex");
        customerRepository.addCustomer(customer);
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        adminMenuController.removeCustomer();
        assertTrue(customerRepository.getCustomers().isEmpty());
    }

    @Test
    public void testViewCustomer() {
        Customer customer = new Customer(1, "Alex");
        customerRepository.addCustomer(customer);
        String input = "1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        adminMenuController.viewCustomer();
    }

    @Test
    public void testViewAllCustomers() {
        Customer customer1 = new Customer(1, "Alex");
        Customer customer2 = new Customer(2, "Max");
        customerRepository.addCustomer(customer1);
        customerRepository.addCustomer(customer2);
        adminMenuController.viewAllCustomers();
    }
}