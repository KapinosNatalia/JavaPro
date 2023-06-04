public class Main {

    public static void main(String[] args) {
      int[] arr = {1, 25, 42, 18, 35};

//    Уровень сложности 1 из 10:
//    Найти сумму всех элементов в массиве.
      System.out.println("Sum: " + ArraysMethods.sum(arr));

//    Найти наибольшее значение в массиве.
      System.out.println("Max: " + ArraysMethods.max(arr));

//    Посчитать количество четных чисел в массиве.
      System.out.println("Number of even numbers: " + ArraysMethods.numOfEven(arr));

//    Уровень сложности 2 из 10:
//    Проверить, содержит ли массив заданное значение.
      int value = 5;
      System.out.println("Array contains " + value + ": " + ArraysMethods.isContain(arr, value));
      value = 25;
      System.out.println("Array contains " + value + ": " + ArraysMethods.isContain(arr, value));

//    Отсортировать массив по возрастанию.
      System.out.println("Array after sorting: " + ArraysMethods.print(ArraysMethods.sort(arr)));

//    Найти индекс первого вхождения заданного значения в массиве.
      value = 1;
      System.out.println("Index of " + value + ": " + ArraysMethods.firstIndex(arr, value));
      value = 25;
      System.out.println("Index of " + value + ": " + ArraysMethods.firstIndex(arr, value));
      value = 88;
      System.out.println("Index of " + value + ": " + ArraysMethods.firstIndex(arr, value));
//
//    Уровень сложности 3 из 10:
//    Найти среднее значение всех элементов в массиве.
      System.out.println("Average value is: " + ArraysMethods.average(arr));

//    Поменять порядок элементов массива на обратный.
      System.out.println("Inverted array is: " + ArraysMethods.print(ArraysMethods.invert(arr)));

//    Проверить, является ли массив палиндромом (элементы читаются одинаково с начала и с конца).
      System.out.println("Array " + ArraysMethods.print(arr) + " is palindrome: " + ArraysMethods.isPalindrome(arr));
      int [] arr1 = {1, 2, 5, 3, 5, 2, 1};
      System.out.println("Array " + ArraysMethods.print(arr1) + " is palindrome: " + ArraysMethods.isPalindrome(arr1));

//    Уровень сложности 4 из 10:
//    Найти наибольшую сумму подряд идущих элементов в массиве.
      arr1 = new int[] {1, 2, 1, 4, 5, 6, 8, 24, 25, 8, 8, 9};
      //System.out.println("Max sum is: " + ArraysMethods.maxSum(arr));
      System.out.println("Max sum is: " + ArraysMethods.maxSum(arr1));

//    Удалить все дубликаты из массива.
      System.out.println("Array " + ArraysMethods.print(arr1) + ", without duplicates: " + ArraysMethods.print(ArraysMethods.deleteDuplicates(arr1)));

//    Найти два наименьших значения в массиве.
      System.out.println("Array " + ArraysMethods.print(arr) + ", two min elements: " + ArraysMethods.print(ArraysMethods.twoMinValues(arr)));
      System.out.println("Array " + ArraysMethods.print(arr1) + ", two min elements: " + ArraysMethods.print(ArraysMethods.twoMinValues(arr1)));

//    Уровень сложности 5 из 10:
//    Найти наибольшую возрастающую последовательность в массиве (элементы идут по порядку).
//    Найти наибольшую сумму подмассива с нечетным количеством элементов.
    }
}
