package HomeWork13.vue;

import java.util.Scanner;

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

    public String inputForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в одну строку через пробел в формате:");
        System.out.println("<Фамилия> <Имя> <Отчество> <Дата Рождения(dd.mm.yyyy)> <Пол(f/m)> <Номер Телефона>");
        String form = scanner.nextLine();
        return form;
    }

}
