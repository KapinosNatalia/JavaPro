package Task2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVDataReader {
    public static Map<String, Map<String, Integer>> readCSVData(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String[] header = reader.readLine().split(",");
            Map<String, Map<String, Integer>> data = parseHeader(header);

            int index = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                String[] dataLine = line.split(",");

                for (int i = 0; i < header.length; i++) {
                    data.get(header[i]).put(dataLine[i], index);
                }
                index++;
            }
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Map<String, Integer>> parseHeader(String[] header) {
        Map<String, Map<String, Integer>> data = new HashMap<>();
        for (String part : header) {
            data.put(part, new HashMap<>());
        }
        return data;
    }
}
