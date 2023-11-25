package service;

import model.Client;

import java.util.HashMap;

public class ClientService implements Service {
    @Override
    public void addClient(Client client) {
        System.out.println("Add Client from ClientService.");
    }

    @Override
    public void updateClient(int id, Client client) {
        System.out.println("Update Client from ClientService.");
    }

    @Override
    public void deleteClient(int id) {
        System.out.println("Delete Client from ClientService.");
    }

    @Override
    public HashMap<Integer, Client> getAllClients() {
        return null;
    }

    @Override
    public void getClientById(int id) {
        System.out.println("Get Client Id from ClientService.");
    }

    @Override
    public void getClientByName(String name) {
        System.out.println("Get Client Name from ClientService.");
    }

    @Override
    public void getClientByIndustry(String industry) {
        System.out.println("Get Client Industry from ClientService.");
    }

    @Override
    public void getClientByContactPerson(String contactPerson) {
        System.out.println("Get Client Contact Person from ClientService.");
    }
}
