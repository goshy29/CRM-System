package file;

import model.Client;

import java.io.*;
import java.util.HashMap;

public class CSVUpdate {
    public static void update(String file, HashMap<Integer, Client> map) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String line;
            for (HashMap.Entry<Integer, Client> entry : map.entrySet()) {
                writer.write(entry.getValue().getId() +","+ entry.getValue().getName() +","+ entry.getValue().getIndustry() +","+
                        entry.getValue().getContactPerson() +","+ entry.getValue().getRevenue() +"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
