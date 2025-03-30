package com.example.andersenhomework.abstractions;

import com.example.andersenhomework.models.Customer;
import com.example.andersenhomework.models.Space;

import java.util.List;

public interface  AdminService <D> {
    void removeCustomer(int userId);
    Customer getCustomerById(int userId);
    List<Customer> getAllCustomers();
    void addWorkSpace(Space space);
    void removeWorkSpace(int spaceId);
    void viewAllReservations();
    List<Space> getAllWorkSpaces();
}
