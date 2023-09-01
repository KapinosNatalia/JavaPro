import org.json.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
    private final String path;

    public FileParser(String path) {
        this.path = path;
    }

    public StockBalance parseFile() {
        if ("json".equals(path.substring(path.length()-4))) {
            return parsJSON();
        } else {
            return new StockBalance();
        }
    }

    private String readFile() {
        StringBuilder fileContent = new StringBuilder();
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileContent.toString();
    }

    private StockBalance parsJSON() {
        StockBalance stockBalance = new StockBalance();
        String jsonString = readFile() ;
        try {
            JSONArray arr = new JSONArray(jsonString);
            int id;
            String category;
            String name;
            String factory;
            int quantity;
            boolean isPacked;
            boolean isAdv;
            double price;
            double margin;
            boolean isDebt;
            for (int i = 0; i < arr.length(); i++)
            {
                String strWithID = arr.getJSONObject(i).getString("CATEGORY");
                id = Integer.parseInt(strWithID.substring(strWithID.indexOf('#') + 1));
                category = getSubstring(arr.getJSONObject(i).getString("CATEGORY"));
                name = getSubstring(arr.getJSONObject(i).getString("NAME"));
                factory = getSubstring(arr.getJSONObject(i).getString("FACTORY"));
                quantity = Integer.parseInt(arr.getJSONObject(i).getString("QUANTITY"));
                isPacked = Boolean.parseBoolean(arr.getJSONObject(i).getString("ISPACKED"));
                isAdv = Boolean.parseBoolean(arr.getJSONObject(i).getString("ISADV"));
                price = Double.parseDouble(arr.getJSONObject(i).getString("PRICE"));
                margin = Double.parseDouble(arr.getJSONObject(i).getString("MARGIN"));
                isDebt = Boolean.parseBoolean(arr.getJSONObject(i).getString("ISDEBT"));
                stockBalance.addProductInfo(new ProductInfo(id, category, name, factory, quantity, isPacked, isAdv, price, margin, isDebt));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return stockBalance;
    }

    private String getSubstring(String str) {
        return str.substring(0, str.indexOf('#'));
    }
}
