package HomeWork8.view;

import java.util.Scanner;

public class UserInterface {
    public static void userMenu() {
        System.out.println();
        System.out.println("МЕНЮ");
        System.out.println("1 - посмотреть весь список группы");
        System.out.println("2 - добавить студента");
        System.out.println("3 - добавить преподавателя");
        System.out.println("4 - удалить человека");
        System.out.println("5 - найти человека");
        System.out.println("6 - выйти из журнала");
        System.out.println();
    }

    /**
     * Метод позволяет выбрать действие в пользовательском меню автомата
     * @return Возвращает выбранное действие
     */
    public static String chooseAction() {
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        while (!(operation.equals("1") | operation.equals("2") | operation.equals("3")
                | operation.equals("4") | operation.equals("5") | operation.equals("6"))) {
            System.out.println("Введите цифру с соответствующей операцией и подтвердите действие");
            operation = scanner.next();
        }
        return operation;
    }

}
