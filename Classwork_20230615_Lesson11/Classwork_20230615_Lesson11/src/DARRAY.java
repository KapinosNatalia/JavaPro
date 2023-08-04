import java.util.Arrays;
import java.util.Random;

public class DARRAY {
    public static void main(String[] args) {
        /*
         * 1. Найти сумму всех элементов в каждой
         * строке двумерного массива и вывести на экран.
         */
        //int[][] array = {{1,1,1},{2,2,2},{3,3,3}};
        int[][] array = generateArray();
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
            System.out.println("Sum row " + i + ": " + sum);
        }


        /*
         * 2. Найти наибольший элемент в
         * каждом столбце двумерного массива и вывести на экран.
         */
        for (int i = 0; i < array[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < array.length; j++) {
                max = Math.max(max, array[j][i]);
            }
            System.out.println("Max in column " + i + ": " + max);
        }


        /*
         * 3. Отсортировать каждую строку двумерного массива
         * в порядке возрастания и вывести отсортированный массив на экран.
         */
        for  (int[] ints : array) {
            Arrays.sort(ints);
        }
        System.out.println("Array after sorting:");
        printArray(array);

         /*
         * 4. Посчитать количество вхождений определенного
         * числа в каждом столбце двумерного массива и вывести на экран.
         */
        int value = new Random().nextInt(100);
        for (int j = 0; j < array[0].length; j++) {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i][j] == value) count++;
            }
            System.out.println("Column " + j + " contains " + value + " " + count + " times");
        }


        /*
         * СНАЧАЛА СОЗДАТЬ МЕТОД КОТОРЫЙ ВОЗВРАЩАЕТ СГЕНЕРИРОВАННЫЙ
         * ДВУМЕРНЫЙ МАССИВ РАНДОМНОЙ ДЛИНЫ И ВЫСОТЫ И С РАНДОМНЫМИ ЧИСЛАМИ
         * ДАЛЕЕ ПЕРЕДАВАТЬ РЕЗУЛЬТАТ РАБОТЫ ЭТОГО МЕТОДА В КАЧЕСТВЕ ПАРАМЕТРА
         */


    }

    public static int[][] generateArray() {
        Random random = new Random();
        int rows = random.nextInt(10);
        int columns = random.nextInt(10);
        int[][] array = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = random.nextInt(100);
            }
        }
        printArray(array);
        return array;
    }

    public static void printArray(int[][] array) {
        System.out.println("Array: ");
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

}


