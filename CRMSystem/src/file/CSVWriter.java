package file;

import model.Client;

import java.io.*;

public class CSVWriter {
    public static void write(String file, Client client) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            String line;
            writer.write(client.getId() +","+ client.getName() +","+ client.getIndustry() +","+
                    client.getContactPerson() +","+ client.getRevenue() +"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
