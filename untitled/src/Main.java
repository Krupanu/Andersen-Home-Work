import controller.AdminMenuController;
import controller.CustomerMenuController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the 'Coworking Space Reservation Application'!");
        Scanner scanner = new Scanner(System.in);
        AdminMenuController adminMenuController = new AdminMenuController();
        CustomerMenuController customerMenuController = new CustomerMenuController();
        while (true) {
        System.out.println("Who do you want to login with?:");
        System.out.println("1. Admin");
        System.out.println("2. Customer");
        int choice = scanner.nextInt();
           switch (choice) {
               case 1: {
                   System.out.println("choose an option:");
                   System.out.println("1. Add Customer");
                   System.out.println("2. Remove Customer");
                   System.out.println("3. View Customer");
                   System.out.println("4. View All Customers");
                   System.out.println("5. Add Work Space");
                   System.out.println("6. Remove Work Space");
                   System.out.println("7. View All Reservations");
                   System.out.println("8. View All Work Spaces");
                   System.out.println("9. Menu");
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
                          case  5:
                              adminMenuController.addWorkSpace();
                              break;
                          case 6:
                              adminMenuController.removeWorkSpace();
                              break;
                          case 7:
                              adminMenuController.viewAllReservations();
                              break;
                            case 8:
                              adminMenuController.viewAllWorkSpaces();
                              break;
                            case 9:
                              break;
                   }
                   break;
               }
               case 2:{
                     System.out.println("choose an option:");
                     System.out.println("1. Make Reservation");
                     System.out.println("2. Cancel Reservation");
                     System.out.println("3. View Work Space");
                     System.out.println("4. View All Reservations");
                     System.out.println("5. View All Work Spaces");
                     System.out.println("6. Menu");
                     choice = scanner.nextInt();
                     switch (choice) {
                          case 1:
                            customerMenuController.makeReservation();
                            break;
                          case 2:
                              customerMenuController.cancelReservation();
                            break;
                          case 3:
                              customerMenuController.viewWorkSpace();
                            break;
                          case 4:
                              customerMenuController.viewAllReservations();
                            break;
                            case 5:
                              customerMenuController.viewAllWorkSpaces();
                            case 6:
                                break;
                     }
                        break;
               }
           }
       }
    }
}