import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        /*
        Задача №1
        Вам дан текстовый файл, содержащий список email-адресов.
                Извлечь все уникальные домены электронной почты и подсчитать,
                сколько раз каждый домен встречается в списке.
        john.doe@example.com
        jane.smith@example.org
        james.bond@example.com
        jane.smith@example.org
        jane.smith@example.net
        */
        try {
            File file = new File("task1.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String regex = "@(.*)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher;
            String domain;
            Map<String, Integer> mapOfDomains = new HashMap<>();
            String line = reader.readLine();
            while (line != null) {
                matcher = pattern.matcher(line);
                while (matcher.find()) {
                    domain = matcher.group().substring(1);
                    if (mapOfDomains.containsKey(domain)) {
                        mapOfDomains.put(domain, mapOfDomains.get(domain) + 1);
                    } else {
                        mapOfDomains.put(domain, 1);
                    }
                }
                line = reader.readLine();
            }
            System.out.println("Task 1:");
            System.out.println(mapOfDomains);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        Задача №2
        Вам дан текстовый файл, содержащий список URL-адресов.
                Найти все URL, которые содержат протокол "https://" и заменить их на "http://"
        https://www.example.com
        http://www.example.org
        https://www.example.net
        https://www.example.com/about
        */
        try {
            File file = new File("task2.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            File fileResult = new File("task2_result.txt");
            FileWriter fw = new FileWriter(fileResult);
            BufferedWriter writer = new BufferedWriter(fw);
            String line = reader.readLine();
            while (line != null) {
                line = line.replace("https://", "http://") + "\n";
                writer.write(line);
                line = reader.readLine();
            }
            writer.flush();
            System.out.println("Task 2: \nFile written");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        Задача №3
        Вам дан текстовый файл, содержащий список кодов продуктов в формате: <product_code>:<quantity>.
        Найти все продукты с количеством больше 10 и вывести их коды и количество.
        ABC123:5
        XYZ789:12
        DEF456:8
        JKL012:15
        MNO345:6
        */
        try {
            File file = new File("task3.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String regexQuantity = ":([0-9]*)$";
            Pattern patternQuantity = Pattern.compile(regexQuantity);
            Matcher matcherQuantity;
            String regexCode = "^(.*):";
            Pattern patternCode = Pattern.compile(regexCode);
            Matcher matcherCode;
            Map<String, Integer> mapOfProducts = new HashMap<>();
            String line = reader.readLine();
            while (line != null) {
                matcherQuantity = patternQuantity.matcher(line);
                while (matcherQuantity.find()) {
                    int quantity = Integer.parseInt(matcherQuantity.group().substring(1));
                    if (quantity > 10) {
                        matcherCode = patternCode.matcher(line);
                        while (matcherCode.find()) {
                            mapOfProducts.put(matcherCode.group().substring(0, matcherCode.group().length() - 1), quantity);
                        }
                    }
                }
                line = reader.readLine();
            }
            System.out.println("Task 3:");
            System.out.println(mapOfProducts);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
