import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {
        /*
        Задание 1 а
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
        Задание 1 б
        Написать метод(ы), который распарсит json и, используя StringBuilder,
        создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
        */

        String[] json = new String[]{"{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}", "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}", "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}"};
        System.out.println(Arrays.toString(json));

        System.out.println(getReportStudents(json));
    }

    public static StringBuilder createRequestSelect(String startRequestSelect, String textRequestSelect) {
        StringBuilder requestSelect = new StringBuilder(startRequestSelect);

        String[] arrayText = (textRequestSelect.replaceAll("[\\{}]", "").replaceAll("[:]", "=")).split(" ");

        for (int i = 0; i < arrayText.length; i++) {
            if (!arrayText[i].contains("null")) {
                requestSelect.append(arrayText[i]);
            }
        }

        return requestSelect;
    }

    public static StringBuilder getReportStudents(String[] jsonStringList) {
        StringBuilder reportStudents = new StringBuilder();
        for (int i = 0; i < jsonStringList.length; i++) {
            String[] arrayTemp = jsonStringList[i].replaceAll("[\\{}]", "").replaceAll("[\\:,]", " ").split(" ");
            System.out.println(Arrays.toString(arrayTemp));
            String[] studentReport = new String[] {"Студент " + arrayTemp[1] + " получил " + arrayTemp[3] + " по предмету " + arrayTemp[5]};
            reportStudents.append(Arrays.toString(studentReport));
        }
        return reportStudents;
    }
}




