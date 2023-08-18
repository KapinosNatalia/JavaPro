package Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataStorage {
    private final Map<String, Map<String, Integer>> data;

    public DataStorage(String path) {
        this.data = CSVDataReader.readCSVData(path);
    }

    public int findIndexByFieldName(String fieldName, String value) {
        return data.get(fieldName).get(value);
    }

}
