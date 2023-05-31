import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Задачи на ArrayList:

        //1. Удаление дубликатов: Напишите метод, который принимает массив int и возвращает ArrayList, содержащий все уникальные
        // элементы исходного массива, сохраняя их порядок. Уровень сложности: 4.
        System.out.println("1. Array: [1, 5, 3, 6, 3, 9, 1, 8, 6], ArrayList: " + convertArrayToArrayListUniq(new int[]{1, 5, 3, 6, 3, 9, 1, 8, 6}));

        //2. Обратный порядок: Напишите метод, который принимает массив int и возвращает ArrayList, содержащий элементы исходного
        // массива в обратном порядке. Уровень сложности: 4.
        System.out.println("2. Array: [1, 5, 3, 6, 3, 9, 1, 8, 6], ArrayList: " + convertArrayToArrayListReverse(new int[]{1, 5, 3, 6, 3, 9, 1, 8, 6}));

        //Задачи на Set:

        //3. Поиск пересечения: Напишите метод, который принимает два массива int и возвращает Set, содержащий элементы, которые
        // присутствуют и в первом, и во втором массивах. Уровень сложности: 5.
        System.out.println("3. Array1: [1, 5, 3, 6], Array2: [3, 9, 1, 8, 6], common elements: " + convertArraysIntoSet(new int[]{1, 5, 3, 6}, new int[]{3, 9, 1, 8, 6}));
        System.out.println("3. Array1: [1, 3, 3], Array2: [3, 3, 5], common elements: " + convertArraysIntoSet(new int[]{1, 3, 3}, new int[]{3, 3, 5}));

        //4. Подсчет уникальных элементов: Напишите метод, который принимает массив int и возвращает количество уникальных элементов
        // в этом массиве, используя Set для хранения уникальных значений. Уровень сложности: 5.
        System.out.println("4. Array: [1, 5, 3, 6, 3, 9, 1, 8, 6], number of unique elements: " + countUniqueElements(new int[]{1, 5, 3, 6, 3, 9, 1, 8, 6}));
    }
    // Задачи на ArrayList:

    //1. Удаление дубликатов: Напишите метод, который принимает массив int и возвращает ArrayList, содержащий все уникальные
    // элементы исходного массива, сохраняя их порядок. Уровень сложности: 4.
    public static ArrayList<Integer> convertArrayToArrayListUniq(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int j : array) {
            if (!arrayList.contains(j)) {
            arrayList.add(j);
            }
        }
        return arrayList;
    }

    //2. Обратный порядок: Напишите метод, который принимает массив int и возвращает ArrayList, содержащий элементы исходного
    // массива в обратном порядке. Уровень сложности: 4.
    public static ArrayList<Integer> convertArrayToArrayListReverse(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = array.length -1 ; i >= 0 ; i--) {
            arrayList.add(array[i]);
        }
        return arrayList;
    }

    //Задачи на Set:

    //3. Поиск пересечения: Напишите метод, который принимает два массива int и возвращает Set, содержащий элементы, которые
    // присутствуют и в первом, и во втором массивах. Уровень сложности: 5.

    // при данном решении, если будут исходные массивы [1,3,3] и [3,3,5], то вернется [3]. Или должно быть [3,3]?
    public static Set<Integer> convertArraysIntoSet(int[] array1, int[] array2) {
        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i: array1) {
            set1.add(i);
        }
        for (int i: array2) {
            if (set1.contains(i)) resultSet.add(i);
        }
        return resultSet;
    }

    //4. Подсчет уникальных элементов: Напишите метод, который принимает массив int и возвращает количество уникальных элементов
    // в этом массиве, используя Set для хранения уникальных значений. Уровень сложности: 5.
    public static int countUniqueElements(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int i: array) {
            set.add(i);
        }
        return set.size();
    }
}
