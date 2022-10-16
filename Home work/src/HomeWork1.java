import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {

        // Вычислить сумму чисел от 1 до n; произведение чисел от 1 до n
        System.out.println("\ntask 1");
        Summ(1, 10);
        Fact(3, 5);
        System.out.println("___________________________________________");

        // Вывести все простые числа от 1 до 1000
        System.out.println("\ntask 2");
        SimplNum(2, 1000);
        System.out.println("___________________________________________");

        // Реализовать простой калькулятор
        System.out.println("\ntask 3");
        Calc(10, 10);
        System.out.println("___________________________________________");



        // Задано уравнение вида q + w = e, причем q, w, e >= 0.
        // Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
        // Требуется восстановить выражение до верного равенства.
        // Предложить хотя бы одно решение или сообщить, что его нет.
        // System.out.println("\ntask 4");
        // ResultEquation();

    }

    public  static void Summ(int numStart, int numEnd) {
        int sum = 0;
        for (int i = numStart; i <= numEnd; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public  static void Fact(int start, int end) {
        int fact = 1;
        for (int i = start; i <= end; i++) {
            fact *= i;
        }
        System.out.println(fact);
    }

    public  static void SimplNum(int startNum, int endNum) {
        if (startNum == 1) {
            System.out.print(startNum + " ");
            System.out.print(startNum + 2 + " ");
            startNum = 5;
        }

        if (startNum == 2) {
            System.out.print(startNum + 1 + " ");
            startNum = 5;
        }

        if (startNum % 2 == 0) {
            startNum += 1;
        }

        while (startNum <= endNum) {
            if (startNum % 3 != 0) {
                System.out.print(startNum + " ");
            }
            startNum += 2;
        }
    }

    public  static void Calc(int num1, int num2) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                введите 1 - для умножения
                       2 - для деления
                       3 - для сложения
                       4 - для вычитания""");
        String act = scanner.next();

        switch (act) {
            case "1" -> System.out.println("result = " + (num1 * num2));
            case "2" -> System.out.println("result = " + (num1 / num2));
            case "3" -> System.out.println("result = " + (num1 + num2));
            case "4" -> System.out.println("result = " + (num1 - num2));
        }
    }

    private static String[] ParseInputScanEquation() {
        Scanner scanner = new Scanner(System.in);
        String[] equation = scanner.next().split("");

        for (int i = 0; i < equation.length; i++) {
            if (equation[i].equals("+") | equation[i].equals("-") | equation[i].equals("=")) {
                equation[i] = " " + equation[i] + " ";
            }
        }

        String equateStr = String.join("", equation);
        String[] equate = equateStr.split(" ");
        System.out.println(Arrays.toString(equate));
        return equate;
    }

    public static void ResultEquation() {
        String[] equate = ParseInputScanEquation();

        ArrayList<String> numberEquate = new ArrayList<String>();
        for (int i = 0; i < equate.length - 1; i++) {
            if (equate[i].equals("+") | equate[i].equals("-") | equate[i].equals("=")) {
            }
            else {
                numberEquate.add(equate[i]);
            }
        }

    }
}

// 1?+?5=25