public class Lesson_2 {

    public static void main(String[] args) {
        // ---------- Задание 1 ----------
        printThreeWords();
        System.out.println("----------");
        // ---------- Задание 2 ----------
        checkSumSign();
        System.out.println("----------");
        // ---------- Задание 3 ----------
        printColor();
        System.out.println("----------");
        // ---------- Задание 4 ----------
        compareNumbers();
        System.out.println("----------");
        // ---------- Задание 5 ----------
        System.out.println(isSumBetween10And20(5, 7));   // true
        System.out.println(isSumBetween10And20(1, 2));   // false
        System.out.println("----------");
        // ---------- Задание 6 ----------
        printPositiveOrNegative(10);
        printPositiveOrNegative(-5);
        printPositiveOrNegative(0);
        System.out.println("----------");
        // ---------- Задание 7 ----------
        System.out.println(isNegative(-3));  // true
        System.out.println(isNegative(7));   // false
        System.out.println(isNegative(0));   // false
        System.out.println("----------");
        // ---------- Задание 8 ----------
        printStringNTimes("Hello", 3);
        System.out.println("----------");
        // ---------- Задание 9 ----------
        System.out.println(isLeapYear(2000));  // true
        System.out.println(isLeapYear(1900));  // false
        System.out.println(isLeapYear(2024));  // true
        System.out.println(isLeapYear(2023));  // false
        System.out.println("----------");
        // ---------- Задание 10 ----------
        int[] array10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArray(array10);
        invertArray(array10);
        printArray(array10);
        System.out.println("----------");
        // ---------- Задание 11 ----------
        int[] array11 = fillArray100();
        printFirst10(array11);
        System.out.println("----------");
        // ---------- Задание 12 ----------
        int[] array12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(array12);
        multiplyLessThanSix(array12);
        printArray(array12);
        System.out.println("----------");
        // ---------- Задание 13 ----------
        int[][] diagonal = createDiagonalArray(5);
        print2DArray(diagonal);
        System.out.println("----------");
        // ---------- Задание 14 ----------
        int[] array14 = createArray(7, 42);
        printArray(array14);
        System.out.println("----------");
    }
    // 1. Печать трёх слов
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    // 2. Сумма двух чисел и вывод знака
    public static void checkSumSign() {
        int a = 15;
        int b = -8;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    // 3. Цвет по значению
    public static void printColor() {
        int value = 75;   // можно поменять для теста
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    // 4. Сравнение a и b
    public static void compareNumbers() {
        int a = 10;
        int b = 20;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    // 5. Сумма в пределах [10,20]
    public static boolean isSumBetween10And20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    // 6. Печать положительное/отрицательное
    public static void printPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println(x + " - положительное число");
        } else {
            System.out.println(x + " - отрицательное число");
        }
    }
    // 7. Вернуть true, если число отрицательное
    public static boolean isNegative(int x) {
        return x < 0;
    }
    // 8. Печать строки n раз
    public static void printStringNTimes(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }
    // 9. Определение високосного года
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    // 10. Инвертировать массив из 0 и 1
    public static void invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
    }
    // 11. Заполнить массив длиной 100 числами 1..100
    public static int[] fillArray100() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
    // 12. Умножить на 2 элементы меньше 6
    public static void multiplyLessThanSix(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }
    // 13. Создать квадратный массив с единицами на главной диагонали
    public static int[][] createDiagonalArray(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }
    // 14. Создать массив длины len, заполненный initialValue
    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
    // Вспомогательные методы для вывода массивов
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void printFirst10(int[] arr) {
        for (int i = 0; i < 10 && i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("...");
    }
    public static void print2DArray(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}