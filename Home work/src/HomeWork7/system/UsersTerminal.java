package HomeWork7.system;
import HomeWork7.model.Drink;
import HomeWork7.model.VendingMachineHotDrink;

import java.util.Map;
import java.util.Scanner;

/**
 * Класс представляет абстракцию пользовательского интерфейса
 */
public class UsersTerminal {
    /**
     * Метод выводит в консоль автомата пользовательское меню
     */
    private static void userMenu () {
        System.out.println();
        System.out.println("МЕНЮ");
        System.out.println("1 - посмотреть весь ассортимент");
        System.out.println("2 - получить товар");
        System.out.println("3 - выйти из терминала");
        System.out.println();
    }

    /**
     * Метод позволяет выбрать действие в пользовательском меню автомата
     * @return Возвращает выбранное действие
     */
    private static String chooseAction() {
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        while (!(operation.equals("1") | operation.equals("2") | operation.equals("3"))) {
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
