package service;

import file.CSVReader;
import file.CSVUpdate;
import file.CSVWriter;
import model.Client;

import java.util.HashMap;

public class ServiceImpl extends ClientService {
    private String file;

    public ServiceImpl(String file) {
        this.file = file;
    }

    @Override
    public void addClient(Client client) {
        CSVWriter.write(file, client);
    }

    @Override
    public void updateClient(int id, Client client) {
        HashMap<Integer, Client> map = getAllClients();
        map.put(id, client);
        CSVUpdate.update(file, map);
    }

    @Override
    public void deleteClient(int id) {
        HashMap<Integer, Client> map = getAllClients();
        map.remove(id);
        CSVUpdate.update(file, map);
    }

    @Override
    public HashMap<Integer, Client> getAllClients() {
        return CSVReader.read(file);
    }

    @Override
    public void getClientById(int id) {
        HashMap<Integer, Client> map = getAllClients();
        if (map.containsKey(id)) {
            System.out.printf("%d. Name: %s, Industry: %s, Contact Person: %s, Revenue: %.2f%n", map.get(id).getId(),
                    map.get(id).getName(), map.get(id).getIndustry(), map.get(id).getContactPerson(), map.get(id).getRevenue());
        } else {
            System.out.println("Invalid id. Record not found.");
        }
    }

    @Override
    public void getClientByName(String name) {
        HashMap<Integer, Client> map = getAllClients();
        boolean isEmptyByName = true;
        for (HashMap.Entry<Integer, Client> entry : map.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                isEmptyByName = false;
                System.out.printf("%d. Name: %s, Industry: %s, Contact Person: %s, Revenue: %.2f%n",
                        entry.getValue().getId(), entry.getValue().getName(), entry.getValue().getIndustry(),
                        entry.getValue().getContactPerson(), entry.getValue().getRevenue());
            }
        }
        searchResult(isEmptyByName, name);
    }

    @Override
    public void getClientByIndustry(String industry) {
        HashMap<Integer, Client> map = getAllClients();
        boolean isEmptyIndustry = true;
        for (HashMap.Entry<Integer, Client> entry : map.entrySet()) {
            if (entry.getValue().getIndustry().equals(industry)) {
                isEmptyIndustry = false;
                System.out.printf("%d. Name: %s, Industry: %s, Contact Person: %s, Revenue: %.2f%n",
                        entry.getValue().getId(), entry.getValue().getName(), entry.getValue().getIndustry(),
                        entry.getValue().getContactPerson(), entry.getValue().getRevenue());
            }
        }
        searchResult(isEmptyIndustry, industry);
    }

    @Override
    public void getClientByContactPerson(String contactPerson) {
        HashMap<Integer, Client> map = getAllClients();
        boolean isEmptyContactPerson = true;
        for (HashMap.Entry<Integer, Client> entry : map.entrySet()) {
            if (entry.getValue().getContactPerson().equals(contactPerson)) {
                isEmptyContactPerson = false;
                System.out.printf("%d. Name: %s, Industry: %s, Contact Person: %s, Revenue: %.2f%n",
                        entry.getValue().getId(), entry.getValue().getName(), entry.getValue().getIndustry(),
                        entry.getValue().getContactPerson(), entry.getValue().getRevenue());
            }
        }
        searchResult(isEmptyContactPerson, contactPerson);
    }

    public void searchResult(boolean isEmpty, String searchBy) {
        if (isEmpty) {
            System.out.printf("Empty list. There are no results for %s.%n", searchBy);
        }
    }
}
