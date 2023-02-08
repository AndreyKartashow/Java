package HomeWork13.vue;

import java.util.Scanner;
import java.util.logging.Logger;

public class UserInterface {
    public void userMenu() {
        System.out.println();
        System.out.println("Список сотрудников");
        System.out.println("1 - посмотреть всех сотрудников");
        System.out.println("2 - добавить нового сотрудника");
        System.out.println("3 - удалить сотрудника по id");
        System.out.println("4 - найти совпадения сотрудников по имени, или фамилии, или отчеству");
        System.out.println("5 - выйти из программы");
        System.out.println();
    }

    public String chooseAction() {
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        while (!(operation.equals("1") | operation.equals("2") | operation.equals("3") | operation.equals("4") | operation.equals("5"))) {
            System.out.println("Введите цифру с соответствующей операцией и подтвердите действие");
            operation = scanner.next();
        }
        Logger logger = Logger.getAnonymousLogger();
        logger.info("Code menu: " + operation);
        return operation;
    }
}
