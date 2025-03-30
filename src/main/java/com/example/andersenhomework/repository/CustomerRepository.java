package com.example.andersenhomework.repository;

import com.example.andersenhomework.models.Customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CustomerRepository  implements Serializable {
    private static final long serialVersionUID = 1L;
    private static CustomerRepository instance;
    private final List<Customer> customers;

    private CustomerRepository() {
        this.customers = new ArrayList<>();
    }

    public static CustomerRepository getInstance() {
        if (instance == null) {
            instance = new CustomerRepository();
        }
        return instance;
    }

    public static void setInstance(CustomerRepository instance) {
        CustomerRepository.instance = instance;
    }


    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    public void removeCustomer(int customerId) {
        Optional<Customer> customerToRemove = customers.stream()
                .filter(customer -> customer.getId() == customerId)
                .findFirst();
        customerToRemove.ifPresent(customers::remove);
    }

    public void clearCustomers() {
        customers.clear();
    }

}