package app;

import manager.Manager;
import service.ClientService;
import service.ServiceImpl;
import validations.ValidInt;

import java.util.Scanner;

public class CRMSystem {
    public static void main(String[] args) {
        // enter your file path to Client.csv
        String file = "C:\\Users\\G\\Desktop\\Sirma Java Course\\Client.csv";
        Scanner sc = new Scanner(System.in);
        ClientService service = new ServiceImpl(file);
        Manager manager = new Manager(service);
        System.out.println("Welcome to the Client Management System");
        boolean active = true;
        while (active) {
            displayOptions();
            int menuIndex = ValidInt.validateIntegerInput("Enter action: ");
            menuIndex = manager.performAction(menuIndex);
            if (menuIndex == 9) {
                active = false;
            }
        }
    }

    private static void displayOptions() {
        System.out.println("Menu:");
        System.out.println("1. Add Client");
        System.out.println("2. Update Client");
        System.out.println("3. List of Clients");
        System.out.println("4. Search by Id");
        System.out.println("5. Search by Name");
        System.out.println("6. Search by Industry");
        System.out.println("7. Search by ContactPerson");
        System.out.println("8. Delete Client");
        System.out.println("9. Exit");
    }
}
