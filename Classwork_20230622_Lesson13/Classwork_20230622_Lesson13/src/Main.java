import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        - У вас есть Map<String, Boolean>, представляющая студентов и их оценки
        (true - сдал экзамен, false - не сдал).
        Напишите функцию, которая находит и возвращает имена студентов, не сдавших экзамен.
        */
        Map<String, Boolean> students = new HashMap<>();
        students.put("Ivan", true);
        students.put("Petr", false);
        students.put("Anna", true);
        students.put("Elena", false);
        System.out.println(getStudents(students));


        /*
        - У вас есть Map<String, Boolean>, представляющая список продуктов в магазине и
        информацию о их наличии (true - продукт в наличии, false - продукта нет).
        Напишите функцию, которая подсчитывает количество продуктов, которых нет в наличии. */

        Map<String, Boolean> products = new HashMap<>();
        products.put("apple", false);
        products.put("milk", true);
        products.put("butter", true);
        products.put("bread", false);
        System.out.println(countProducts(products));


        /*- У вас есть список List<String>, содержащий имена людей.
        Напишите программу, которая выводит все имена, начинающиеся на определенную букву.
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");
        char targetLetter = 'C';*/
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");
        char targetLetter = 'C';
        printNames(names, 'A');
        printNames(List.of("Ivan", "Evgeniy", "Illya"), 'D');


        /*- У вас есть список List<String>, содержащий слова.
        Напишите программу, которая находит все пары слов, в которых первое слово является обратным написанию второго слова.
        List<String> words = Arrays.asList("lemon", "cat", "tac", "dog", "god", "man", "nam");*/
        List<String> words = Arrays.asList("lemon", "cat", "tac", "dog", "god", "man", "nam",  "tac");
        findPairs(words);

        //-Напишите программу, которая находит сумму всех элементов в заданном массиве arr и выводит ее значение.
        int[] array = {1, 2, 3, 4, 5, 2};
        System.out.println(sum(array));

        //-Напишите программу, которая находит среднее арифметическое значение элементов в заданном массиве arr и выводит его.
        System.out.println((double) sum(array)/array.length);

        /*
        -Напишите программу, которая принимает на вход двумерный
        массив int[][] и возвращает сумму всех элементов в массиве.*/
        int[][] array2D = {{1,2,3},{4,5,6},{7,8,9,10}};
        System.out.println("Sum 2D: " + sum2D(array2D));

        /*
        -Напишите программу, которая принимает на вход двумерный массив
        int[][] и возвращает максимальное значение среди всех элементов в массиве. */
        System.out.println("Max: " + max(array2D));

        /*
        -Напишите программу, которая принимает массив строк String[] и
        возвращает новый массив, содержащий только уникальные строки из исходного массива */
        String[] arrayStr = {"1", "2", "1", "3", "1"};
        System.out.println(Arrays.toString(deleteDup(arrayStr)));

        /*
        -Напишите программу, которая принимает массив строк String[]
        и возвращает новый массив строк, в котором все строки перевернуты задом наперёд. */
        String[] arrayStr1 = {"abc", "def", "ghi", "jkl", "mno"};
        System.out.println(Arrays.toString(reverseArrStr(arrayStr1)));

        /*
        -Напишите функцию, которая принимает на вход Set<String>
        и возвращает новый Set<String>, содержащий только те строки, которые начинаются с заглавной буквы.
        */
        Set<String> setStr1 = new HashSet<>();
        setStr1.add("Aaa");
        setStr1.add("aaa");
        setStr1.add("bbb");
        setStr1.add("BBB");
        setStr1.add("Ddd");
        System.out.println(findUpperCase(setStr1));

        /*
        -Напишите функцию, которая принимает на вход два Set<String> и
        возвращает новый Set<String>, содержащий только те строки, которые присутствуют в обоих наборах.
        */
        Set<String> setStr2 = new HashSet<>();
        setStr2.add("999");
        setStr2.add("aaa");
        setStr2.add("ccc");
        setStr2.add("BBB");
        setStr2.add("lll");
        System.out.println(findIntersection(setStr1, setStr2));

        /*
        - Напишите функцию, которая принимает на вход Set<String> и возвращает
        новый Set<String>, содержащий только уникальные строки, игнорируя регистр символов
        Set<String> stringSet = new HashSet<>();
        stringSet.add("Apple");
        stringSet.add("banana");
        stringSet.add("apple");
        stringSet.add("Banana");  */
        Set<String> stringSet = new HashSet<>();
        stringSet.add("Apple");
        stringSet.add("banana");
        stringSet.add("apple");
        stringSet.add("Banana");
        System.out.println(getUniqueStr(stringSet));
    }

    /*
        - У вас есть Map<String, Boolean>, представляющая студентов и их оценки
        (true - сдал экзамен, false - не сдал).
        Напишите функцию, которая находит и возвращает имена студентов, не сдавших экзамен.
        */
    public static ArrayList<String> getStudents(Map<String, Boolean> map) {
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry: map.entrySet()) {
            if (!entry.getValue()) {
                names.add(entry.getKey());
            }
        }
        return names;
    }

    /*
        - У вас есть Map<String, Boolean>, представляющая список продуктов в магазине и
        информацию о их наличии (true - продукт в наличии, false - продукта нет).
        Напишите функцию, которая подсчитывает количество продуктов, которых нет в наличии. */
    public static int countProducts(Map<String, Boolean> map) {
        int count = 0;
        for (Map.Entry<String, Boolean> entry: map.entrySet()) {
            if (!entry.getValue()) {
                count++;
            }
        }
        return count;
    }

    /*- У вас есть список List<String>, содержащий имена людей.
    Напишите программу, которая выводит все имена, начинающиеся на определенную букву.
    List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");
    char targetLetter = 'C';*/
    public static void printNames(List<String> names, char targetLetter) {
        for (String name : names) {
            if (name.startsWith(String.valueOf(targetLetter))) {
                System.out.println(name);
            }
        }
    }

    /*- У вас есть список List<String>, содержащий слова.
    Напишите программу, которая находит все пары слов, в которых первое слово является обратным написанию второго слова.
    List<String> words = Arrays.asList("lemon", "cat", "tac", "dog", "god", "man", "nam");*/
    // Метод для обращения строки
    private static String reverseString(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }

    /*- У вас есть список List<String>, содержащий слова.
    Напишите программу, которая находит все пары слов, в которых первое слово является обратным написанию второго слова.
    List<String> words = Arrays.asList("lemon", "cat", "tac", "dog", "god", "man", "nam");*/
    public static void findPairs(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String reverseWord = reverseString(words.get(i));
            for (int j = i; j < words.size(); j++) {
                if (reverseWord.equals(words.get(j))) {
                    System.out.println(words.get(i) + " : " + words.get(j));
                    //words.remove(words.get(i));
                    //words.remove(words.get(j));
                }
            }
        }
    }

    //-Напишите программу, которая находит сумму всех элементов в заданном массиве arr и выводит ее значение.
    static public int sum(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    /*
    -Напишите программу, которая принимает на вход двумерный
    массив int[][] и возвращает сумму всех элементов в массиве.*/
    public static int sum2D(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    /*
    -Напишите программу, которая принимает на вход двумерный массив
    int[][] и возвращает максимальное значение среди всех элементов в массиве. */
    public static int max(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                max = Math.max(max, array[i][j]);
            }
        }
        return max;
    }

    /*
    -Напишите программу, которая принимает массив строк String[] и
    возвращает новый массив, содержащий только уникальные строки из исходного массива */
    public static String[] deleteDup(String[] str) {
        //for (int i = 0; i < str.length; i++) {
        //    set.add(str[i]);
        //}
        Set<String> set = new HashSet<>(Arrays.asList(str));
        //String[] str2 = new String[set.size()];

        return set.toArray(new String[set.size()]);
    }

    /*
    -Напишите программу, которая принимает массив строк String[]
    и возвращает новый массив строк, в котором все строки перевернуты задом наперёд. */
    public static String[] reverseArrStr(String[] arrayStr) {
        String[] resultArr = new String[arrayStr.length];
        for (int i = 0; i < arrayStr.length; i++) {
            resultArr[i] = reverseString(arrayStr[i]);
        }
        return resultArr;
    }

    /*
    -Напишите функцию, которая принимает на вход Set<String>
    и возвращает новый Set<String>, содержащий только те строки, которые начинаются с заглавной буквы.
    */
    public static Set<String> findUpperCase(Set<String> setStr) {
        Set<String> result = new HashSet<>();
        for (String str: setStr) {
            if (str.length()> 0 && Character.isUpperCase(str.charAt(0))) {
                result.add(str);
            }
        }
        return result;
    }

    /*
    -Напишите функцию, которая принимает на вход два Set<String> и
    возвращает новый Set<String>, содержащий только те строки, которые присутствуют в обоих наборах.
    */
    public static Set<String> findIntersection(Set<String> set1, Set<String> set2) {
        Set<String> result = new HashSet<>();
        for (String str: set1) {
            if (set2.contains(str)) {
                result.add(str);
            }
        }
        return result;
    }


    /*
    - Напишите функцию, которая принимает на вход Set<String> и возвращает
    новый Set<String>, содержащий только уникальные строки, игнорируя регистр символов
    Set<String> stringSet = new HashSet<>();
    stringSet.add("Apple");
    stringSet.add("banana");
    stringSet.add("apple");
    stringSet.add("Banana");  */
    public static Set<String> getUniqueStr(Set<String> set) {
        Set<String> result = new HashSet<>();
        for(String str: set) {
            result.add(str.toLowerCase(Locale.ROOT));
        }
        return result;
    }

}
