package repository;

import models.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRepository {
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

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    public void removeCustomer(int customerId) {
        customers.removeIf(customer -> customer.getId() == customerId);
    }

}