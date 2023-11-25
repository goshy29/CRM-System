package service;

import model.Client;

import java.util.HashMap;

public interface Service {
    void addClient(Client client);
    void updateClient(int id, Client client);
    void deleteClient(int id);
    HashMap<Integer, Client> getAllClients();
    void getClientById(int id);
    void getClientByName(String name);
    void getClientByIndustry(String industry);
    void getClientByContactPerson(String contactPerson);
}
