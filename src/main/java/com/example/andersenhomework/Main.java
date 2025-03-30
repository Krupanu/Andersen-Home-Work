package com.example.andersenhomework;

import com.example.andersenhomework.controller.AdminMenuController;
import com.example.andersenhomework.controller.CustomerMenuController;
import com.example.andersenhomework.models.Customer;
import com.example.andersenhomework.models.Reservation;
import com.example.andersenhomework.models.Space;
import com.example.andersenhomework.models.User;
import com.example.andersenhomework.repository.CustomerRepository;
import com.example.andersenhomework.repository.ReservationRepository;
import com.example.andersenhomework.repository.SpaceRepository;
import com.example.andersenhomework.state.StateLoader;
import com.example.andersenhomework.state.StateSaver;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String SPACES_STATUS_FILE_PATH = "src/main/java/com/example/andersenhomework/spaces_state.json";
    private static final String RESERVATIONS_STATUS_FILE_PATH = "src/main/java/com/example/andersenhomework/reservations_state.json";
    private static final String CUSTOMERS_STATUS_FILE_PATH = "src/main/java/com/example/andersenhomework/customers_state.json";
    static SpaceRepository spaceRepository = SpaceRepository.getInstance();
    static ReservationRepository reservationRepository = ReservationRepository.getInstance();
    static CustomerRepository customerRepository = CustomerRepository.getInstance();
    public static void main(String[] args) throws IOException {

        Type customerListType = new TypeToken<List<Customer>>(){}.getType();
        Type spaceListType = new TypeToken<List<Space>>(){}.getType();
        Type reservationListType = new TypeToken<List<Reservation>>(){}.getType();

        List<Customer> customers = StateLoader.loadCustomerStatus(CUSTOMERS_STATUS_FILE_PATH, customerListType);
        List<Space> spaces = StateLoader.loadSpaceStatus(SPACES_STATUS_FILE_PATH, spaceListType);
        List<Reservation> reservations = StateLoader.loadReservationStatus(RESERVATIONS_STATUS_FILE_PATH, reservationListType);
        try {
            for (Customer customer : customers) {
                customerRepository.addCustomer(customer);
            }

            for (Space space : spaces) {
                spaceRepository.addSpace(space);
            }

            for (Reservation reservation : reservations) {
                reservationRepository.addReservation(reservation);
            }
        }catch (NullPointerException e){
            System.out.println("Failed to load app status:" + e.getMessage());
        }

        System.out.println("Welcome to the 'Coworking Space Reservation Application'!");

        Scanner scanner = new Scanner(System.in);
        AdminMenuController adminMenuController = new AdminMenuController();
        CustomerMenuController customerMenuController = new CustomerMenuController();

        while (true) {
            System.out.println("Who do you want to login with?:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit and save status");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("Choose an option:");
                        System.out.println("1. Add Customer");
                        System.out.println("2. Remove Customer");
                        System.out.println("3. View Customer");
                        System.out.println("4. View All Customers");
                        System.out.println("5. Add Work Space");
                        System.out.println("6. Remove Work Space");
                        System.out.println("7. View All Work Spaces");
                        System.out.println("8. Menu");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                adminMenuController.addCustomer();
                                break;
                            case 2:
                                adminMenuController.removeCustomer();
                                break;
                            case 3:
                                adminMenuController.viewCustomer();
                                break;
                            case 4:
                                adminMenuController.viewAllCustomers();
                                break;
                            case 5:
                                adminMenuController.addWorkSpace();
                                break;
                            case 6:
                                adminMenuController.removeWorkSpace();
                                break;
                            case 7:
                                adminMenuController.viewAllWorkSpaces();
                                break;
                            case 8:
                                break;
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Choose an option:");
                        System.out.println("1. Make Reservation");
                        System.out.println("2. Cancel Reservation");
                        System.out.println("3. View My All Reservations");
                        System.out.println("4. View All Work Spaces");
                        System.out.println("5. Menu");
                        choice = scanner.nextInt();
                        switch (choice) {
                            case 1:
                                customerMenuController.makeReservation();
                                break;
                            case 2:
                                customerMenuController.cancelReservation();
                                break;
                            case 3:
                                customerMenuController.viewAllReservations();
                                break;
                            case 4:
                                customerMenuController.viewAllWorkSpaces();
                                break;
                            case 5:
                                break;
                        }
                        break;
                    }
                    case 3:
                        saveState();
                        System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            saveState();
        }
    }

    public static void saveState() throws IOException {
            Type customerListType = new TypeToken<List<Customer>>(){}.getType();
            List<Customer> customers = customerRepository.getCustomers();
            StateSaver.saveCustomerStatus(customers,CUSTOMERS_STATUS_FILE_PATH);

            Type spaceListType = new TypeToken<List<Space>>(){}.getType();
            List<Space> spaces = spaceRepository.getSpaces();
            StateSaver.saveSpaceStatus(spaces,SPACES_STATUS_FILE_PATH);

            Type reservationListType = new TypeToken<List<Reservation>>(){}.getType();
            List<Reservation> reservations = reservationRepository.getReservations();
            StateSaver.saveReservationStatus(reservations,RESERVATIONS_STATUS_FILE_PATH);


    }
}
