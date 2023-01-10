package HomeWork11;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        // Задание 1.
        // Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
        System.out.println(Task1.dif(10, 0));
        System.out.println((Task1.inputAge("20h")));
        System.out.println(Task1.getElementOfArray(8));

        // Задание 2.
        // Скрин не открывается

        // Задание 3.
        // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
        // и возвращающий новый массив, каждый элемент которого равен разности элементов
        // двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо
        // как-то оповестить пользователя.
        int[] ar1 = {1, 0, 3};
        int[] ar2 = {3, 0, 5, 4};
        System.out.println(Arrays.toString(Task3.diffTwoArrays(ar1, ar2)));

        // Задание 4.
        // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
        // и возвращающий новый массив, каждый элемент которого равен частному элементов
        // двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо
        // как-то оповестить пользователя. Важно: При выполнении метода единственное исключение,
        // которое пользователь может увидеть - RuntimeException, т.е. ваше

        int[] ar3 = {1, 3, 10, 9};
        int[] ar4 = {0, 3, 5, 3};
        System.out.println(Arrays.toString(Task4.diffTwoArrays(ar3, ar4)));

        // Задание 5.
        // Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
        // и возвращающий новый массив, каждый элемент которого равен сумме элементов двух
        // входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
        // оповестить пользователя.

        // Задание аналогично заданию 3 и 4.

        // Задание 6.
        // Реализуйте метод, принимающий в качестве аргументов двумерный массив.
        // Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
        // детализировать какие строки со столбцами не требуется. Как бы вы реализовали подобный метод.
        int[][] matrix = {{2, 2, 3}, {2, 5, 6}, {3, 2, 5}};
        System.out.println(Task6.equalSizeRowAndColumnOfMatrix(matrix));
    }


}

class Task1 {
    public static double dif(int number1, int number2) {
        if (number2 == 0) {
            System.out.println("Делить на 0 нельзя");
            return 0;
        }
        return number1 / number2;
    }

    public static int inputAge(String age) {
        char[] charArray = age.toCharArray();
        for (char ch : charArray) {
            if (!Character.isDigit(ch)) {
                System.out.println("Данные введены не корректно");
                return 0;
            }
        }
        return Integer.parseInt(age);
    }

    public static int getElementOfArray(int index) {
        int[] arrayNumber = {1, 5, 15, 36, 47, 46, 9, 10};
        if (index >= arrayNumber.length | index < 0) {
            System.out.println("Введеный индекс за пределами размерности масива");
            return -404;
        }
        return arrayNumber[index];
    }
}

class Task3 {
    public static int[] diffTwoArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            System.out.println("Входящие массивы разной длины");
            return new int[0];
        }

        int[] arrayDif = new int[array1.length];
        for (int i = 0; i < arrayDif.length; i++) {
            arrayDif[i] = array1[i] - array2[i];
        }
        return arrayDif;
    }
}

class Task4 {
    public static double[] diffTwoArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            System.out.println("Входящие массивы разной длины");
            return new double[0];
        }

        double[] arrayDif = new double[array1.length];

        for (int i = 0; i < arrayDif.length; i++) {
            if (array2[i] == 0) {
                System.out.println("Один из делителей соответствует нулю, действие не выполнено");
                return new double[0];
            }
            arrayDif[i] = array1[i] / array2[i];
        }
        return arrayDif;
    }
}

class Task6 {
    public static boolean equalSizeRowAndColumnOfMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j & matrix.length != matrix[i].length) {
                    return false;
                }
            }
        }
        return true;
    }
}