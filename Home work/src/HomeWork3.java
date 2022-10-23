import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HomeWork3 {
    public static void main(String[] args) {
        /*
        Задание 1.
        Реализовать алгоритм сортировки слиянием.
        */

        int[] array = {2, 3, 7, 10, 1, 4, 5};
        System.out.println(Arrays.toString(array));

        sortMergeArray(array);
        System.out.println(Arrays.toString(array));

        /*
        Задание 2.
        Задан целочисленный список ArrayList.
        Удалить из него четные числа.
        */

        List<Integer> listNumber = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        System.out.println(listNumber);

        removeEvenNumbersFromList(listNumber);
        System.out.println(listNumber);

        /*
        Задание 3.
        Дан произвольный список целых чисел.
        Найти минимальное, максимальное и среднее из этого списка.
        */

        List<Integer> numberList = new ArrayList<>(Arrays.asList(67, 10, 2, 93, 44, 25, 6, 27, 58, 9));
        System.out.println(numberList);

        System.out.println(Collections.max(numberList));
        System.out.println(Collections.min(numberList));

        System.out.println(numberList.stream()
                .collect(Collectors.summarizingInt(Integer::intValue))
                .getAverage());

    }

    public static void sortMergeArray(int[] array) {
        Logger logger = Logger.getAnonymousLogger();

        if (array == null) {
            return;
        }
        if (array.length < 2) {
            return;
        }

        int[] arrayB = new int[array.length / 2];
        System.arraycopy(array, 0, arrayB, 0, array.length / 2);

        int[] arrayC = new int[array.length - arrayB.length];
        System.arraycopy(array, arrayB.length, arrayC, 0, array.length - arrayB.length);
        logger.info(Arrays.toString(arrayB) + Arrays.toString(arrayC));

        sortMergeArray(arrayB);
        sortMergeArray(arrayC);
        mergeArray(array, arrayB, arrayC);

    }

    private static void mergeArray(int[] array, int[] arrayB, int[] arrayC) {
        Logger logger = Logger.getAnonymousLogger();
        int positionB = 0;
        int positionC = 0;

        for (int c = 0; c < array.length; c++) {
            if (positionB == arrayB.length) {
                array[c] = arrayC[positionC];
                positionC++;
            } else if (positionC == arrayC.length) {
                array[c] = arrayB[positionB];
                positionB++;
            } else if (arrayB[positionB] < arrayC[positionC]) {
                array[c] = arrayB[positionB];
                positionB++;
            } else {
                array[c] = arrayC[positionC];
                positionC++;
            }
        }
        logger.info("слияние " + Arrays.toString(array));
    }

    public static void removeEvenNumbersFromList(List<Integer> list) {
        Logger logger = Logger.getAnonymousLogger();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                logger.info("Удален элемент " + list.get(i));
                list.remove(i);
            }
        }
    }
}
