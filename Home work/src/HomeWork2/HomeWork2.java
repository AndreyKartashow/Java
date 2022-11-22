package HomeWork2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class HomeWork2 {
    public static void main(String[] args) {
        /*
        Задание 1а.
        Дана строка sql-запроса "select * from students where ".
        Сформируйте часть WHERE этого запроса, используя StringBuilder.
        Данные для фильтрации приведены ниже в виде json строки.
        Если значение null, то параметр не должен попадать в запрос.
        Параметры для фильтрации:
        {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
         */

        String startRequestSelect = "select * from students where ";
        String textRequestSelect = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        System.out.println(createRequestSelect(startRequestSelect, textRequestSelect));

        /*
        Задание 1б.
        Написать метод(ы), который распарсит json и, используя StringBuilder,
        создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
        */

        String[] json = new String[]{"{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}",
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}",
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}"};

        System.out.println(Arrays.toString(json));
        System.out.println(getReportStudents(json));

        /*
        Задание 2.
        Реализуйте алгоритм сортировки пузырьком числового массива,
        результат после каждой итерации запишите в лог-файл.
         */

        int[] arrayNumber = {1, 5, 15, 10, 7, 25, 3};
        sortBuble(arrayNumber);
        System.out.println(Arrays.toString(arrayNumber));

        /*
        Задание 3.
        Напишите метод, который определит тип (расширение) файлов
        из текущей папки и выведет в консоль результат вида
        1 Расширение файла: txt
        2 Расширение файла: pdf
        3 Расширение файла:
        4 Расширение файла: jpg
        */

        String dir = "C://Users//Андрей//Desktop//Практические по ВС//java//Java//Home work//src";
        getTypeFileFromDirectory(dir);

    }

    public static StringBuilder createRequestSelect(String startRequestSelect, String textRequestSelect) {
        StringBuilder requestSelect = new StringBuilder(startRequestSelect);

        String[] arrayText = (textRequestSelect.replaceAll("[\\{}]", "").
                replaceAll(":", "=")).
                split(" ");

        for (String s : arrayText) {
            if (!s.contains("null")) {
                requestSelect.append(s);
            }
        }

        return requestSelect;
    }

    public static StringBuilder getReportStudents(String[] jsonStringList) {
        StringBuilder reportStudents = new StringBuilder();

        for (String s : jsonStringList) {
            String[] arrayTemp = s.replaceAll("[\\{}]", "").
                    replaceAll("[:,]", " ").
                    split(" ");

            String[] studentReport = new String[]{"Студент " + arrayTemp[1] + " получил " + arrayTemp[3] + " по предмету " + arrayTemp[5]};
            reportStudents.append(Arrays.toString(studentReport));
        }

        return reportStudents;
    }

    public static void sortBuble(int[] array) {
        Logger logger = Logger.getAnonymousLogger();

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    logger.info("temp = " + array[j] + " array[j] = " + array[j + 1] + " array[j + 1] = " + temp);
                }
            }
        }
    }

    public static void getTypeFileFromDirectory(String directory) {
        File dir = new File(directory);
        if(dir.isDirectory())
        {
            for(File item : dir.listFiles()){
                if(item.isDirectory()){
                    System.out.println("Каталог: " + item.getName());
                }
                else{
                    System.out.println("Файл с расширением: " +  item.getName().substring(item.getName().indexOf(".")));
                }
            }
        }
    }


}




