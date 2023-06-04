public class ArraysMethods {
    //    Найти сумму всех элементов в массиве.
    public static int sum(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    //    Найти наибольшее значение в массиве.
    public static int max(int[] arr) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (result < arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }

    //    Посчитать количество четных чисел в массиве.
    public static int numOfEven(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]%2 == 0) {
                result++;
            }
        }
        return result;
    }

    //    Проверить, содержит ли массив заданное значение.
    public static boolean isContain(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    //    Отсортировать массив по возрастанию.
    public static int[] sort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    public static int firstIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int average(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum/arr.length;
    }

    public static int[] invert(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length/2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    public static boolean isPalindrome(int[] arr) {
        //boolean isPalinrome = true;
        for (int i = 0; i < arr.length/2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    //    Найти наибольшую сумму подряд идущих элементов в массиве.
    public static int maxSum(int[] arr) {
        int maxSum = 0;
        int curSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1] + 1) {
                curSum += arr[i];
            }
            else {
                if (maxSum < curSum) maxSum = curSum;
                curSum = arr[i];
            }
        }
        if (maxSum < curSum) maxSum = curSum;
        return maxSum;
    }

    //    Удалить все дубликаты из массива.
    public static int[] deleteDuplicates(int[] arr){
        int[] newArr = new int[arr.length];
        boolean isAdded = false;
        newArr[0] = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            isAdded = false;
            for (int j = 0; j < count; j++) {
                if (arr[i] == newArr[j]) {
                    isAdded = true;
                    break;
                }
            }
            if (!isAdded) {
                    newArr[count] = arr[i];
                    count++;
            }
        }
        //return newArr;
        int[] resultArray = new int[count];
        for (int i = 0; i < count; i++) {
            resultArray[i] = newArr[i];
        }
        return resultArray;
    }

    //    Найти два наименьших значения в массиве.
    public static int[] twoMinValues(int[] arr){
        int[] arrayMin = new int[2];
        if (arr.length <= 2) {
            return arr;
        }
        if (arr[0] <= arr[1]) {
            arrayMin[0] = arr[0];
            arrayMin[1] = arr[1];
        }
        else {
            arrayMin[0] = arr[1];
            arrayMin[1] = arr[0];
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] <  arrayMin[0]) {
                arrayMin[1] =  arrayMin[0];
                arrayMin[0] = arr[i];
            } else if (arr[i] <  arrayMin[1]) {
                arrayMin[1] = arr[i];
            }
        }
        return arrayMin;
    }

    public static String print(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] + " ";
        }
        return str + "]";
    }
}
