public class Lesson_5 {

    // 1. Метод для обработки массива 4x4
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен иметь 4 строки, а не " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Строка " + i + " должна иметь 4 столбца, а не " + array[i].length);
            }
        }

        int sum = 0;
        // Проход по всем элементам
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: " + array[i][j], e);
                }
            }
        }
        return sum;
    }

    // Демонстрация в main()
    public static void main(String[] args) {
        // Корректный массив
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Массив с неправильным размером (3 строки)
        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        // Массив с нечисловыми данными
        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "одиннадцать", "12"},
                {"13", "14", "15", "16"}
        };

        // Тест корректного массива
        try {
            int result = sumArray(validArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        // Тест неправильного размера
        try {
            sumArray(wrongSizeArray);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage());
        }

        // Тест нечисловых данных
        try {
            sumArray(invalidDataArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        // 4. Генерация и поимка ArrayIndexOutOfBoundsException
        System.out.println("\n=== Демонстрация ArrayIndexOutOfBoundsException ===");
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]); // Попытка доступа за пределами массива
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Поймано исключение: " + e);
            System.err.println("Сообщение: " + e.getMessage());
        }

        // Можно также показать на двумерном массиве
        String[][] smallArray = new String[2][2];
        try {
            String element = smallArray[3][0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException при доступе к строке 3: " + e);
        }
    }
}

// Пользовательское исключение для неправильного размера
class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

// Пользовательское исключение для неверных данных
class MyArrayDataException extends Exception {
    public MyArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}