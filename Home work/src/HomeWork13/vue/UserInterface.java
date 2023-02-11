package HomeWork13.vue;

import java.util.Scanner;

public class UserInterface {
    public void initInterface() {
        System.out.println();
        System.out.println("Добро пожаловать в \"Список Сотрудников\"");
    }

    public void initDataBase(String status) {
        System.out.println();
        System.out.println(status);
    }

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

    public String inputIndexForRemove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для удаления сотрудника из списка, введите его ID");
        String id = scanner.nextLine();
        return id;
    }

    public void printAll(String workerList) {
        System.out.println(workerList);
    }

    public void printWorker(String worker) {
        System.out.println(worker);
    }

    public String inputSearchName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для поиска сотрудников по ФИО, введите его имя, фамилию или отчество");
        String name = scanner.nextLine();
        return name;
    }

}
