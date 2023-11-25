package manager;

import model.Client;
import service.ClientService;
import validations.ValidDouble;
import validations.ValidInt;
import validations.ValidString;

import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    private ClientService service;

    public Manager(ClientService clientService) {
        this.service = clientService;
    }

    public int performAction(int menuIndex) {
        HashMap<Integer, Client> map;
        switch (menuIndex) {
            case 1:
                map = service.getAllClients();
                int id = ValidInt.validateIntegerInput("Enter id: ");
                if (map.containsKey(id)) {
                    System.out.printf("Id %d already exist!", id);
                } else {
                    String name = ValidString.validateStringInput("Enter Name: ");
                    String industry = ValidString.validateStringInput("Enter Department: ");
                    String contactPerson = ValidString.validateStringInput("Enter Contact Person: ");
                    double revenue = ValidDouble.validateDoubleInput("Enter Revenue: ");
                    Client client = new Client(id, name, industry, contactPerson, revenue);
                    service.addClient(client);
                    System.out.printf("Client %s was successfully created.%n", name);
                }
                menuIndex = backMenu();
                break;
            case 2:
                map = service.getAllClients();
                if (map.isEmpty()) {
                    System.out.println("Empty list. There are no added Clients yet.");
                    break;
                }
                int idToUpdate = ValidInt.validateIntegerInput("Enter id to update: ");
                if (map.containsKey(idToUpdate)) {
                    String name = ValidString.validateStringInput("Enter Name: ");
                    String industry = ValidString.validateStringInput("Enter Department: ");
                    String contactPerson = ValidString.validateStringInput("Enter Contact Person: ");
                    double revenue = ValidDouble.validateDoubleInput("Enter Revenue: ");
                    Client updatedClient = new Client(idToUpdate, name, industry, contactPerson, revenue);
                    service.updateClient(idToUpdate, updatedClient);
                    System.out.printf("Client %s was successfully updated.%n", name);
                } else {
                    System.out.println("Invalid id. Record not found.");
                }
                menuIndex = backMenu();
                break;
            case 3:
                map = service.getAllClients();
                if (map.isEmpty()) {
                    System.out.println("Empty list. There are no added Clients yet.");
                    break;
                }
                for (HashMap.Entry<Integer, Client> entry : map.entrySet()) {
                    System.out.printf("%d. Name: %s, Industry: %s, Contact Person: %s, Revenue: %.2f%n",
                            entry.getValue().getId(), entry.getValue().getName(), entry.getValue().getIndustry(),
                            entry.getValue().getContactPerson(), entry.getValue().getRevenue());
                }
                menuIndex = backMenu();
                break;
            case 4:
                int clientId = ValidInt.validateIntegerInput("Enter id: ");
                service.getClientById(clientId);
                menuIndex = backMenu();
                break;
            case 5:
                String name = ValidString.validateStringInput("Enter full name: ");
                service.getClientByName(name);
                menuIndex = backMenu();
                break;
            case 6:
                String industry = ValidString.validateStringInput("Enter industry: ");
                service.getClientByIndustry(industry);
                menuIndex = backMenu();
                break;
            case 7:
                String contactPerson = ValidString.validateStringInput("Enter contact person: ");
                service.getClientByContactPerson(contactPerson);
                menuIndex = backMenu();
                break;
            case 8:
                map = service.getAllClients();
                int idToDelete = ValidInt.validateIntegerInput("Enter id to delete: ");
                if (map.containsKey(idToDelete)) {
                    service.deleteClient(idToDelete);
                    System.out.printf("Client %s was successfully deleted.%n", map.get(idToDelete).getName());
                } else {
                    System.out.println("Invalid id. Record not found.");
                }
                menuIndex = backMenu();
                break;
            default:
                if (menuIndex < 1 || menuIndex > 9) {
                    System.out.println("Invalid action. Please try again.");
                    menuIndex = backMenu();
                }
        }
        return menuIndex;
    }

    private static int backMenu() {
        System.out.println("8. Back");
        System.out.println("9. Exit");
        Scanner sc = new Scanner(System.in);
        int menuIndex = Integer.parseInt(sc.nextLine());
        return menuIndex;
    }
}
