package HomeWork9.vueController.vue;

import java.util.Scanner;

public class UserInterface {
    public void userMenu() {
        System.out.println();
        System.out.println("Блокнот");
        System.out.println("1 - посмотреть все заметки");
        System.out.println("2 - добавить заметку");
        System.out.println("3 - удалить заметку по id");
        System.out.println("4 - выйти из блокнота");
        System.out.println();
    }

    public String chooseAction() {
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        while (!(operation.equals("1") | operation.equals("2") | operation.equals("3") | operation.equals("4"))) {
            System.out.println("Введите цифру с соответствующей операцией и подтвердите действие");
            operation = scanner.next();
        }
        return operation;
    }

}
