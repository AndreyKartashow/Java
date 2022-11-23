package HomeWork7.system;

import HomeWork7.model.Drink;
import HomeWork7.model.HotDrink;
import HomeWork7.model.VendingMachineHotDrink;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Класс предназначен для инициализации автомата и его загрузки горячими напитками
 */
public class ProductOunerTerminal {
    /**
     * Метод возвращает экземпляр торгового автомата, загруженного горячими напитками
     * @return Возвращает инициализированный экземпляр <b>VendingMachineHotDrink</b>
     */
    protected static VendingMachineHotDrink runVendingMachine() {
        Logger log = Logger.getAnonymousLogger();

        HotDrink tea1 = new HotDrink("чай черный", 0.25, 80);
        HotDrink tea2 = new HotDrink("чай зеленый", 0.25, 80);
        HotDrink tea3 = new HotDrink("чай красный", 0.25, 80);

        HotDrink late1 = new HotDrink("Лате маленькое", 0.2, 75);
        HotDrink late2 = new HotDrink("Лате среднее", 0.3, 75);
        HotDrink late3 = new HotDrink("Лате большое", 0.4, 75);

        HotDrink amerikano1 = new HotDrink("Американо маленькое", 0.2, 80);
        HotDrink amerikano2 = new HotDrink("Американо среднее", 0.3, 80);

        HotDrink cappuccino1 = new HotDrink("Капучино маленькое", 0.2, 75);
        HotDrink cappuccino2 = new HotDrink("Капучино среднее", 0.3, 75);
        HotDrink cappuccino3 = new HotDrink("Капучино большое", 0.4, 75);


        VendingMachineHotDrink machine = new VendingMachineHotDrink();
        machine.addProduct(tea1, 10);
        machine.addProduct(tea2, 10);
        machine.addProduct(tea3, 10);

        machine.addProduct(late1, 10);
        machine.addProduct(late2, 15);
        machine.addProduct(late3, 10);

        machine.addProduct(amerikano1, 5);
        machine.addProduct(amerikano2, 10);

        machine.addProduct(cappuccino1, 15);
        machine.addProduct(cappuccino2, 15);
        machine.addProduct(cappuccino3, 15);

        log.info("Автомат загружен напитками");
        return machine;
    }

    /**
     * Метод создает упорядоченную карту продуктов с уникальными номерами позиций (ключами)
     * @param machine Инициализированные и заполненый напитками кземпляр автомата горячих напитков
     * @return Возвращает упорядоченную карту напитков с уникальными ключами
     */
    protected static Map<String, Drink> mapProducts(VendingMachineHotDrink machine) {
        Map<String, Drink> enumProducts = new LinkedHashMap<>();
        Integer i = 1;

        for (Map.Entry<Drink, Integer> set : machine.getMapHotDrink().entrySet()) {
            enumProducts.put(i.toString(), set.getKey());
            i++;
        }

        return enumProducts;
    }
}
