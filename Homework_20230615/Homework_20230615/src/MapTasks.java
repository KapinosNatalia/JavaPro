import java.util.HashMap;
import java.util.Map;

public class MapTasks {
        public static void main(String[] args) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("aaa", 1);
            map.put("abab", 14);
            map.put("bbb", 8);
            map.put("cccc", 3);
            map.put("cabc", 6);

             // 01. Вывести все ключи из мапы на экран.
            printKeys(map);

             // 02. Проверить, содержит ли мапа определенное значение.
            System.out.println("Task 02 contains 3: " + map.containsValue(3));
            System.out.println("Task 02 contains 25: " + map.containsValue(25));

            // 03. Найти ключ, связанный с определенным значением.
            System.out.println("Task 03: key of 8 is " + getKeyByValue(map, 8));
            System.out.println("Task 03: key of 33 is " + getKeyByValue(map, 33));

            HashMap<String, String> mapStringString = new HashMap<>();
            mapStringString.put("1", "apple");
            mapStringString.put("2", "banana");
            mapStringString.put("6aa", "85789");
            mapStringString.put("3", "strawberry");
            mapStringString.put("4", "asia");
            mapStringString.put("5cc", "125");
            mapStringString.put("7", "anna");

            // 04. Вывести на экран все ключи, у которых значение начинается с определенной буквы.
            findKeysBeyValues(mapStringString, 'a');

             // 05. Проверить, содержит ли мапа определенный ключ.
            System.out.println("Task 05, keys contains 1: " + mapStringString.containsKey("1"));
            System.out.println("Task 05, keys contains 6: " + mapStringString.containsKey("6"));

             // 06. Найти ключ с максимальным значением.
            System.out.println("Task 06, key of max is " + findKeyOfMax(map));

             // 07. Подсчитать количество ключей, значение которых содержит определенное слово.
            System.out.println("Task 07, number of keys containing 'an': " + countKeysWithWord(mapStringString, "an"));

             // 08. Найти все ключи, значение которых состоит только из цифр.
            findKeysOfNumericValues(mapStringString);

             // 09. Подсчитать сумму числовых значений в мапе.
            System.out.println("Task 09: sum of elements is " + sum(map));

            // 10. Подсчитать количество ключей, у которых длина значения превышает определенную границу.
            System.out.println("Task 10: number of keys, whose value is longer than 4 is " + countKeysWithLength(mapStringString, 4));

             // 11. Создать новую мапу, где значениями будут ключи, а ключами - значения исходной мапы.
            HashMap<Integer, String> newMap = createMap(map);

             // 12. Очистить мапу и вывести сообщение о ее пустом состоянии.
            newMap.clear();
            System.out.println("Map is empty");

        }

        // 01. Вывести все ключи из мапы на экран.
        public static void printKeys(HashMap<String, Integer> map) {
            System.out.print("Task 01, map's keys: ");
            for (Map.Entry<String, Integer> entry: map.entrySet()) {
                System.out.print(entry.getKey() + " ");
            }
            System.out.println();
        }

        // 03. Найти ключ, связанный с определенным значением.
        public static String getKeyByValue(HashMap<String, Integer> map, Integer value) {
            if (map.containsValue(value)) {
                for (Map.Entry<String, Integer> entry: map.entrySet()) {
                    if (value.equals(entry.getValue())) return entry.getKey();
                }
            }
            return "";
        }

        // 04. Вывести на экран все ключи, у которых значение начинается с определенной буквы.
        public static void findKeysBeyValues(HashMap<String, String> map, char value) {
            System.out.print("Task 04: ");
            for (Map.Entry<String, String> entry: map.entrySet()) {
                if (entry.getValue().length() > 0 && entry.getValue().charAt(0) == value) {
                    System.out.print(entry.getKey() + " ");
                }
            }
            System.out.println();
        }

        // 06. Найти ключ с максимальным значением.
        public static String findKeyOfMax(HashMap<String, Integer> map) {
            Integer max = Integer.MIN_VALUE;
            String key = "";
            for (Map.Entry<String, Integer> entry: map.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    key = entry.getKey();
                }
            }
            return key;
        }

        // 07. Подсчитать количество ключей, значение которых содержит определенное слово.
        public static int countKeysWithWord(HashMap<String, String> map, String word) {
            int count = 0;
            for (Map.Entry<String, String> entry: map.entrySet()) {
                if (entry.getValue().contains(word)) {
                    count++;
                }
            }
            return count;
        }

        // 08. Найти все ключи, значение которых состоит только из цифр.
        public static void findKeysOfNumericValues(HashMap<String, String> map) {
            System.out.print("Task 08, keys of numeric values: ");
            for (Map.Entry<String,String> entry: map.entrySet()) {
                if (entry.getValue().matches("\\d+"))
                    System.out.print(entry.getKey() + " ");
            }
            System.out.println();
        }

        // 09. Подсчитать сумму числовых значений в мапе.
        public static int sum(HashMap<String, Integer> map){
            int sum = 0;
            for (Map.Entry<String,Integer> entry: map.entrySet()) {
                sum += entry.getValue();
            }
            return sum;
        }

        // 10. Подсчитать количество ключей, у которых длина значения превышает определенную границу.
        public static int countKeysWithLength(HashMap<String, String> map, int length){
            HashMap<Integer, String> newMap = new HashMap<>();
            int count = 0;
            for (Map.Entry<String, String> entry: map.entrySet()) {
                if (entry.getValue().length() > length) count++;
            }
            return count;
        }

        // 11. Создать новую мапу, где значениями будут ключи, а ключами - значения исходной мапы.
        public static HashMap<Integer, String> createMap(HashMap<String, Integer> map) {
            HashMap<Integer, String> newMap = new HashMap<>();
            for (Map.Entry<String, Integer> entry: map.entrySet()) {
                newMap.put(entry.getValue(), entry.getKey());
            }
            return newMap;
        }

}
