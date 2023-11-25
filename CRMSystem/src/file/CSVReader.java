package file;

import model.Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CSVReader {
    public static HashMap<Integer, Client> read(String file) {
        HashMap<Integer, Client> clientList = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitValues = line.trim().split(",");
                clientList.put(Integer.parseInt(splitValues[0]),
                        new Client(Integer.parseInt(splitValues[0]), splitValues[1], splitValues[2],
                                splitValues[3], Double.parseDouble(splitValues[4])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientList;

    }
}
