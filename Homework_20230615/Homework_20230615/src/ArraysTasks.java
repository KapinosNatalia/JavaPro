import java.util.Arrays;

public class ArraysTasks {
    public static void main(String[] args) {
        int[] array = {6, 9, 3, 4, 2, 8, 7, 11};

         // 16. Вычислить сумму всех элементов в массиве int[] и вывести результат.
        System.out.println("Task 16: array " + Arrays.toString(array) + ", sum = " + getSum(array));

         // 17. Найти наименьший и наибольший элементы в массиве int[] и вывести их.
        printMinMax(array);

         // 18. Подсчитать количество четных элементов в массиве int[] и вывести результат.
        countEven(array);

         // 19. Отсортировать массив int[] в порядке убывания и вывести отсортированный массив.
        System.out.println("Task 19: array before sorting " + Arrays.toString(array) + ", array after sorting: " + Arrays.toString(sortDesc(array)));

         // 20. Подсчитать сумму квадратов всех элементов в массиве int[] и вывести результат.
        System.out.println("Task 20: array " + Arrays.toString(array) + ", sum of squares of all elements: " + getSumOfSquares(array));

        int[][] twoDemArray =  {{1, 1, 1},
                                {2, 2, 2},
                                {3, 3, 3},
                                {4, 4, 4},
                                {5, 5, 5}};
        print2DArray(twoDemArray);

        // 21. Посчитать сумму всех элементов во всем массиве.[][]
        System.out.println("Task 21: sum of all elements: " + getSum2D(twoDemArray));

         // 22. Найти максимальное значение в каждой строке и вывести его.[][]
        int[][] twoDemArray1 =  {{1, 5, 1},
                                 {4, 2, 2},
                                 {3, 3, 6},
                                 {4, 4, 4},
                                 {5, 8, 5}};
        print2DArray(twoDemArray1);
        getMaxInRow(twoDemArray1);

         // 23. Найти среднее значение элементов в каждом столбце и вывести его.[][]
        getAvgInColumn(twoDemArray);
        getAvgInColumn(twoDemArray1);

         // 24. Посчитать количество элементов, кратных заданному числу, во всем массиве.[][]
        System.out.println(countElementsMultiplesOf(twoDemArray, 5));

         // 25. Найти сумму элементов только в нечетных строках массива.[][]
        getSumInOddRows(twoDemArray);
        getSumInOddRows(twoDemArray1);

    }

    // 16. Вычислить сумму всех элементов в массиве int[] и вывести результат.
    public static int getSum(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    // 17. Найти наименьший и наибольший элементы в массиве int[] и вывести их.
    public static void printMinMax(int[] array) {
        int min = array[0];
        int max = array[0];
        if (array.length != 1) {
            for (int i = 1; i < array.length; i++) {
                min = Math.min(min, array[i]);
                max = Math.max(max, array[i]);
            }
        }
        System.out.println("Task 17: array " + Arrays.toString(array) + ", min: " + min + ", max: " + max);

    }

    // 18. Подсчитать количество четных элементов в массиве int[] и вывести результат.
    public static void countEven(int[] array) {
        int count = 0;
        for (int arrayElement:array) {
            if (arrayElement % 2 == 0) {
                count++;
            }
        }
        System.out.println("Task 18: array " + Arrays.toString(array) + ", number of even elements: " + count);
    }

    // 19. Отсортировать массив int[] в порядке убывания и вывести отсортированный массив.
    public static int[] sortDesc(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }

    // 20. Подсчитать сумму квадратов всех элементов в массиве int[] и вывести результат.
    public static int getSumOfSquares(int[] array) {
        int sum = 0;
        for (int elem:array) {
            sum += Math.pow(elem, 2);
        }
        return sum;
    }

    public static void print2DArray(int[][] array) {
        System.out.println("Two-dimensional array:");
        for (int[] row: array) {
            System.out.println(Arrays.toString(row));
        }
    }

    // 21. Посчитать сумму всех элементов во всем массиве.[][]
    public static int getSum2D(int[][] array) {
        int sum = 0;
        for (int[] row:array) {
            for (int element:row) {
                sum += element;
            }
        }
        return sum;
    }

    // 22. Найти максимальное значение в каждой строке и вывести его.[][]
    public static void getMaxInRow(int[][] array) {
        System.out.println("Task 22");
        for (int i = 0; i < array.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < array[i].length; j++) {
                max = Math.max(max, array[i][j]);
            }
            System.out.println("Row " + i + ", max: " + max);
        }
    }

    // 23. Найти среднее значение элементов в каждом столбце и вывести его.[][]
    public static void getAvgInColumn(int[][] array) {
        System.out.println("Task 23");
        for (int i = 0; i < array[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < array.length; j++) {
                sum += array[j][i];
            }
            System.out.println("Column " + i + ", avg: " + sum/array.length);
        }
    }

    // 24. Посчитать количество элементов, кратных заданному числу, во всем массиве.[][]
    public static int countElementsMultiplesOf(int[][] array, int number){
        System.out.print("Task 24: ");
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % number == 0) count++;
            }
        }
        return count;
    }

    // 25. Найти сумму элементов только в нечетных строках массива.[][]
    public static void getSumInOddRows(int[][] array) {
        System.out.println("Task 25");
        for (int i = 1; i < array.length; i = i+2) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
            System.out.println("Row " + i + ", sum: " + sum);
        }
    }
}
