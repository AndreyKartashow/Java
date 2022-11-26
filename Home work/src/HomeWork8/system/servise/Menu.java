package HomeWork8.system.servise;

import java.util.Scanner;

public class Menu {
    private static void userMenu() {
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
    private static String chooseAction() {
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        while (!(operation.equals("1") | operation.equals("2") | operation.equals("3")
                | operation.equals("4") | operation.equals("5") | operation.equals("6"))) {
            System.out.println("Введите цифру с соответствующей операцией и подтвердите действие");
            operation = scanner.next();
        }
        return operation;
    }

    /**
     * Метод позволяет выбрать горячий напиток из автомата
     * @param machine Принимант инициализированный и заполненный напитками автомат горячих напитков
     */
    private static void chooseDrink(VendingMachineHotDrink machine) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Drink> enumDrink = ProductOunerTerminal.mapProducts(machine);
        String drinkPosition = "";
        boolean action = true;

        while (action) {
            System.out.println();
            System.out.println("Введите позицию напитка или введите <отмена> для выхода в главное меню");
            for (Map.Entry<String, Drink> set : enumDrink.entrySet()) {
                System.out.println(set.getKey() + ". " + set.getValue());
            }
            System.out.println();

            drinkPosition = scanner.next();
            if (drinkPosition.equals("отмена")) {
                action = false;
            } else if (! enumDrink.containsKey(drinkPosition)) {
                System.out.println("Значение не распознано");
            } else {
                String product = machine.getProduct(enumDrink.get(drinkPosition));
                System.out.println(product);
                action = false;
            }
        }
    }

    /**
     * Метод организует логику пользовательского меню в автомате горячих напитков
     * @param machine Принимает инициализированный и заполненный напитками автомат горячих напитков
     */
    protected static void runUserServer(VendingMachineHotDrink machine) {

        System.out.println();
        System.out.println("Добро пожаловать в наш терминал горячих напитков!");

        boolean terminalActive = true;
        while (terminalActive) {
            UsersTerminal.userMenu();
            String action = UsersTerminal.chooseAction();

            switch (action) {
                case "1" :
                    machine.printAllProducts();
                    System.out.println();
                    break;
                case "2" :
                    UsersTerminal.chooseDrink(machine);
                    System.out.println();
                    break;
                case "3" :
                    terminalActive = false;
                    break;
            }
        }
    }
}
